package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import grpc.MonitorizacionGrpc.MonitorizacionImplBase;
import grpc.MonitorizacionProto.ConsumoReply;
import grpc.MonitorizacionProto.ConsumoRequest;
import grpc.MonitorizacionProto.DemandaReply;
import grpc.MonitorizacionProto.DemandaRequest;
import grpc.MonitorizacionProto.DireccionReply;
import grpc.MonitorizacionProto.DireccionRequest;
import io.grpc.stub.StreamObserver;

public class Monitorizacion extends MonitorizacionImplBase {

    // Total acumulado por zona
    private final Map<Integer, Double> totalPorZona = new ConcurrentHashMap<>();

    // Total global
    private double totalRed = 0.0;

    // Consumos solares por zona
    private final Map<Integer, List<String>> consumosSolarZona = new ConcurrentHashMap<>();

    // Dirección por consumo
    private final Map<String, String> direccionPorConsumo = new ConcurrentHashMap<>();

    // Indica si un consumo es solar
    private final Map<String, Boolean> esSolar = new ConcurrentHashMap<>();

    // ================= UNARY =================
    @Override
    public synchronized void anotarConsumo(ConsumoRequest request, StreamObserver<ConsumoReply> responseObserver) {
    	

	System.out.println(
	    "Registrado consumo " + request.getIdConsumo()
	    + " | zona=" + request.getIdZona()
	    + " | solar=" + request.getSolar()
	    + " | direccion=" + request.getDireccion()
	);


        int zona = request.getIdZona();
        double kwh = request.getKWh();

        // Total por zona
        totalPorZona.put(zona,totalPorZona.getOrDefault(zona, 0.0) + kwh
        );

        // Total global
        totalRed += kwh;

        // Guardar dirección
        direccionPorConsumo.put(request.getIdConsumo(), request.getDireccion());

        // Guardar si es solar
        esSolar.put(request.getIdConsumo(), request.getSolar());

        // Guardar consumo solar por zona
        if (request.getSolar()) {
            consumosSolarZona
                    .computeIfAbsent(zona, z -> new ArrayList<>())
                    .add(request.getIdConsumo());
        }

        ConsumoReply reply = ConsumoReply.newBuilder()
                .setIdZona(zona)
                .setTotalZona(totalPorZona.get(zona))
                .setTotalRed(totalRed)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    // ================= SERVER STREAMING =================
    @Override
    public void demandaSolar(DemandaRequest request, StreamObserver<DemandaReply> responseObserver) {

        int zona = request.getIdZona();

        List<String> lista = consumosSolarZona.get(zona);
        if (lista != null) {
            for (String id : lista) {
                responseObserver.onNext(
                        DemandaReply.newBuilder()
                                .setIdConsumo(id)
                                .build());
            }
        }
        responseObserver.onCompleted();
    }

    // ================= CLIENT STREAMING =================
    @Override
    public StreamObserver<DireccionRequest> consumosDireccion(StreamObserver<DireccionReply> responseObserver) {

        Set<String> direcciones = new HashSet<>();

        return new StreamObserver<DireccionRequest>() {

            @Override
            public void onNext(DireccionRequest request) {
                direcciones.add(request.getDireccion());
            }

            @Override
            public void onCompleted() {
                int contador = 0;

                for (String idConsumo : direccionPorConsumo.keySet()) {
                    if (Boolean.TRUE.equals(esSolar.get(idConsumo))
                            && direcciones.contains(direccionPorConsumo.get(idConsumo))) {
                        contador++;
                    }
                }

                responseObserver.onNext(
                        DireccionReply.newBuilder()
                                .setTotal(contador)
                                .build());
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }
        };
    }
}
