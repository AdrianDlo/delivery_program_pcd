package main;

import energy.*;
import energy.ConsumoThread;
import energy.RedEnergetica;
import grpc.PreciosProto.DemandaRequest;
import grpc.PreciosGrpc;
import grpc.PreciosProto.PreciosRequest;
import grpc.PreciosProto.PreciosReply;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import operators.CentroControl;

public class mysmartttttgridddd {

    public static void main(String[] args) {

        RedEnergetica red = new RedEnergetica(
                Config.NUM_ZONAS,
                Config.CAPACIDAD_BATERIA,
                Config.NIVEL_INICIAL_BATERIA
        );


         //LECTURA DEL FICHERO

        List<Consumo> consumos =
                Consumo.consumosDesdeFichero(Config.FICHERO_CONSUMOS);

        System.out.println("Leidos " + consumos.size()
                + " consumos desde " + Config.FICHERO_CONSUMOS);


         // VERSIÓN 4 – STREAMS PARALELOS

        System.out.println();
        System.out.println("Consumos con kwh < 5 para " + Config.FICHERO_CONSUMOS);
        consumos.parallelStream()
                .filter(c -> c.getTotalKWh() < 5.0)
                .forEachOrdered(c -> System.out.println(c.getIdConsumo()));

        double maxKwh = consumos.parallelStream()
                .mapToDouble(Consumo::getTotalKWh)
                .max()
                .orElse(0.0);

        System.out.println();
        System.out.println(maxKwh);

        System.out.println(
                consumos.parallelStream()
                        .anyMatch(c -> c.getDireccion().equals("Sagitario, 24"))
                        ? "Encontrado Sagitario, 24"
                        : "NO Encontrado Sagitario, 24"
        );

        System.out.println(
                consumos.parallelStream()
                        .anyMatch(c -> c.getDireccion().equals("Berna, 11"))
                        ? "Encontrado Berna, 11"
                        : "NO Encontrado Berna, 11"
        );

        System.out.println();


         // INICIALIZACIÓN BARRERA / LATCH (VERSIÓN 8)

        for (ZonaEnergetica zona : red.getZonas()) {
            if (Config.usarCyclicBarrier) {
                zona.setBarrera(new CyclicBarrier(Config.NUM_OPERADORES_POR_ZONA));
            }
            zona.setLatchInicio(new CountDownLatch(Config.NUM_OPERADORES_POR_ZONA));
        }


         // CREACIÓN DE OPERADORES 

        List<Thread> operadores = new ArrayList<>();

        for (ZonaEnergetica zona : red.getZonas()) {
            for (int i = 0; i < Config.NUM_OPERADORES_POR_ZONA; i++) {
                Thread t = new Thread(new OperadorDeRed(zona));
                t.start();
                operadores.add(t);
            }

            // Barrera clásica de arranque (compatibilidad)
            zona.semaforoArranque.release(Config.NUM_OPERADORES_POR_ZONA);

            new Thread(new OperadorCarga(zona)).start();
        }


         // LANZAMIENTO DE PRODUCTORES (CAMBIA SEGÚN EL MODO)

        List<Thread> productoresClasicos = new ArrayList<>();

        /* -------- MODO 0: THREADS TRADICIONALES -------- */
        if (Config.tipoLanzamientoPedidos == 0) {
            for (Consumo c : consumos) {
                Thread t = new Thread(new ConsumoThread(c, red));
                productoresClasicos.add(t);
                t.start();
            }
        }

        /* -------- MODO 1: RXJAVA -------- */
        if (Config.tipoLanzamientoPedidos == 1) {
            Observable.fromIterable(consumos)
                    .flatMap(c ->
                            Observable.fromRunnable(() ->
                                    new ConsumoThread(c, red).run()
                            ).subscribeOn(Schedulers.computation())
                    )
                    .blockingSubscribe();
        }

        /* -------- MODO 2: EXECUTOR -------- */
        if (Config.tipoLanzamientoPedidos == 2) {
            int nThreads = Runtime.getRuntime().availableProcessors();
            ExecutorService executor = Executors.newFixedThreadPool(nThreads);

            System.out.println("Lanzando consumos con Executor (" + nThreads + " threads)");

            for (Consumo c : consumos) {
                executor.submit(new ConsumoThread(c, red));
            }

            executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


         // ESPERA DE PRODUCTORES 

        if (Config.tipoLanzamientoPedidos == 0) {
            for (Thread t : productoresClasicos) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }


         // PARADA DE OPERADORES
        for (ZonaEnergetica zona : red.getZonas()) {
            CentroControl cc = zona.getCentroControl();
            for (int i = 0; i < Config.NUM_OPERADORES_POR_ZONA; i++) {
                cc.enviarTrabajo(TrabajoConsumo.trabajoFin());
            }
        }

         // VERSIÓN 8 – CALLABLE: CONSUMO MÁXIMO
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Consumo max = null;
        try {
            max = exec.submit(new ConsumoMaxCallable(consumos)).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        exec.shutdown();

        if (max != null) {
            System.out.println("Consumo máximo: "
                    + max.getIdConsumo()
                    + " -> " + max.getTotalKWh() + " kWh");
        }

         // VERSIÓN 8 – FORKJOIN: CONSUMOS > 10 kWh
        ForkJoinPool fjPool = new ForkJoinPool();
        List<Consumo> mayores10 =
                fjPool.submit(() ->
                        consumos.parallelStream()
                                .filter(c -> c.getTotalKWh() > 10)
                                .toList()
                ).join();

        System.out.println("Consumos > 10 kWh:");
        mayores10.forEach(c ->
                System.out.println(c.getIdConsumo()
                        + " -> " + c.getTotalKWh()));


        red.imprimeAuditoria();
    
        
        
      /*
      * AÑADIDO VERSIÓN 9 
      * Cliente gRPC del servicio PRECIOS (Bidirectional )
      * Se ejecuta JUSTO DESPUÉS de las auditorías
      */

     System.out.println("\n=== CALCULO DE PRECIOS (gRPC) ===");

     // Canal al servicio Precios (máquina B, puerto 9004)
     ManagedChannel canalPrecios = Grpc.newChannelBuilder(
             "localhost:9004",
             InsecureChannelCredentials.create()
     ).build();

     PreciosGrpc.PreciosStub preciosStub =
             PreciosGrpc.newStub(canalPrecios);

     // Observador de respuestas del servidor
     StreamObserver<PreciosReply> respuestas =
             new StreamObserver<PreciosReply>() {

                 @Override
                 public void onNext(PreciosReply reply) {
                     System.out.println(
                             "Consumo " + reply.getIdConsumo()
                             + " -> Precio = "
                             + reply.getPrecio() + " €"
                     );
                 }

                 @Override
                 public void onCompleted() {
                     System.out.println("Calculo de precios finalizado.");
                     canalPrecios.shutdown();
                 }

                 @Override
                 public void onError(Throwable t) {
                     t.printStackTrace();
                 }
             };

     // Stream para enviar peticiones
     StreamObserver<PreciosRequest> peticiones =
             preciosStub.calcularPrecios(respuestas);

     // Enviamos todos los consumos al servidor de Precios
     for (Consumo c : consumos) {
         PreciosRequest.Builder req =
                 PreciosRequest.newBuilder()
                         .setIdConsumo(c.getIdConsumo())
                         .setIdZona(c.getZona());



	for (Demanda d : c.getDemandas()) {
	    req.addDemandas(
	        DemandaRequest.newBuilder()
	            .setIdTipo(d.getIdTipo())     //  string → string
	            .setKWh(d.getKWh())           //  coincide con KWh del proto
	            .setPrioridad(d.getPrioridad())
	            .build()
	    );
	}



         peticiones.onNext(req.build());
     }

     // Fin del stream
     peticiones.onCompleted();

        
    }
}