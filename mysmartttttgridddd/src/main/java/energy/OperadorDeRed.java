package energy;

import java.util.Locale;

import operators.CentroControl;

/* ===========================
 * AÑADIDO VERSIÓN 9 (IMPORTS gRPC MONITORIZACIÓN)
 * =========================== */
import grpc.MonitorizacionGrpc;
import grpc.MonitorizacionProto.ConsumoRequest;
import grpc.MonitorizacionProto.ConsumoReply;

import io.grpc.Grpc;
import io.grpc.ManagedChannel;
import main.Config;
import io.grpc.InsecureChannelCredentials;

public class OperadorDeRed implements Runnable {   ////

    private ZonaEnergetica zona;

    /* ===========================
     * AÑADIDO VERSIÓN 9 (CANAL y STUB gRPC)
     * =========================== */
    private static final ManagedChannel canalMonitorizacion =
            Grpc.newChannelBuilder(
                    "localhost:9002",
                    InsecureChannelCredentials.create()
            ).build();

    private static final MonitorizacionGrpc.MonitorizacionBlockingStub monitorStub =
            MonitorizacionGrpc.newBlockingStub(canalMonitorizacion);

    public OperadorDeRed(ZonaEnergetica _z) {
        this.zona = _z;
    }

    @Override
    public void run() {

		try {
		    if (Config.usarCyclicBarrier) {
		        zona.getBarrera().await();   // espera a que TODOS los operadores estén listos -> CyclicBarrier 
		    } else {
		        zona.semaforoArranque.acquire(); // versión anterior con semáforos
		    }
		} catch (Exception e) {
		    return;
		}
		
		// indicar que ESTE operario ya ha empezado
		zona.getLatchInicio().countDown();


        while (true) {
            TrabajoConsumo t = zona.getCentroControl().cogerTrabajo();

            if (t.esFin()) {
                zona.traza("Operador finaliza en zona " + zona.getIdZona());
                break;
            }

            try {
                zona.aforo.acquire();
                procesar(t);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                zona.aforo.release();
            }
        }
    }

    private void procesar(TrabajoConsumo t) {

        Consumo c = t.getConsumo();


         // CONSUMO BLOQUEANTE TODO-O-NADA


        // Primero: batería principal (bloqueante)
        for (Demanda d : c.getDemandas()) {
            if (d.getIdTipo().equals("PRINCIPAL")) {
                while (!zona.getBateria().puedeSuministrar(d.getKWh())) {
                    zona.solicitarCarga();
                    zona.esperarEnergia();
                }
            }
        }

        // Segundo: renovables (bloqueo interno del monitor)
        for (Demanda d : c.getDemandas()) {
            switch (d.getIdTipo()) {

                case "SOLAR":
                    zona.getBateriaSolar().retirar(d.getKWh()); // bloquea si no hay
                    break;

                case "EOLICA":
                    zona.getBateriaEolica().retirar(d.getKWh()); // bloquea si no hay
                    break;
            }
        }

        // Tercero: ahora sí consumimos todo
        for (Demanda d : c.getDemandas()) {
            if (d.getIdTipo().equals("PRINCIPAL")) {
                zona.getBateria().suministra(d.getKWh());
            }
        }

        // Registro contable
        zona.getCuenta().anotaConsumo(c.getTotalKWh());
        
        
        // AÑADIDO VERSIÓN 9
         
        boolean esSolar = false;
        for (Demanda d : c.getDemandas()) {
            if ("SOLAR".equals(d.getIdTipo())) {
                esSolar = true;
                break;
            }
        }

        

		System.out.println(
		    "[OperadorDeRed] Enviando consumo " + c.getIdConsumo()
		    + " solar=" + esSolar
		);

        ConsumoReply reply = monitorStub.anotarConsumo(
                ConsumoRequest.newBuilder()
                        .setIdConsumo(c.getIdConsumo())
                        .setIdZona(zona.getIdZona())
                        .setKWh(c.getTotalKWh())
                        .setDireccion(c.getDireccion())
                        .setSolar(esSolar)
                        .build());

        zona.getCentroControl().traza(
            "Trabajo completado para: " + c.getIdConsumo());

        t.marcarTerminado("OK");
    
    }


    private String fmt(double x) {
        return String.format(Locale.ROOT, "%.2f", x);
    }
}
