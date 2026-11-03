package service;

import java.util.Iterator;

import grpc.ActualizarPreciosGrpc;
import grpc.ActualizarPreciosGrpc.ActualizarPreciosBlockingStub;
import grpc.ActualizarPreciosProto.ActualizarReply;
import grpc.ActualizarPreciosProto.ActualizarRequest;

import grpc.PreciosGrpc.PreciosImplBase;


import grpc.PreciosProto.DemandaRequest;
import grpc.PreciosProto.PreciosReply;
import grpc.PreciosProto.PreciosRequest;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import main.GreeterGrpc;
import main.GreeterGrpc.GreeterBlockingStub;
import main.GreeterGrpc.GreeterStub;

public class PrecioService extends PreciosImplBase {
	static ManagedChannel channel2;
	static ActualizarPreciosBlockingStub greeterStubBlocking;
	
 	double precioSolar;
		double precioEolica;
		double precioRapida;

    @Override
    public StreamObserver<PreciosRequest> calcularPrecios(StreamObserver<PreciosReply> responseObserver) {
    	



        return new StreamObserver<PreciosRequest>() {
        	
            @Override
            public void onNext(PreciosRequest value) {

                double total = 0.0;

                for (DemandaRequest d : value.getDemandasList()) {

                    String tipo = d.getIdTipo();
                    double kwh = d.getKWh();

                    if ("SOLAR".equals(tipo)) {
                        total += kwh * 0.08; //precioSolar;
                    } else if ("EOLICA".equals(tipo)) {
                        total += kwh * 0.1;//precioEolica;
                    } else {
                        total += kwh * 0.15; //precioRapida;
                    }
                }

                responseObserver.onNext(
                        PreciosReply.newBuilder()
                                .setIdConsumo(value.getIdConsumo())
                                .setPrecio(total)
                                .build());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }
        };
    }
}
