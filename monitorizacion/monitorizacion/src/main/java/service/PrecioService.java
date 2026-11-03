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
    	
    	 String target="172.27.36.25";
    	 String target2="172.27.36.25:9999";
    	 String target3="localhost:9999";
    	 channel2 =  Grpc.newChannelBuilder(target3, InsecureChannelCredentials.create())
    				.build();
    		 greeterStubBlocking = ActualizarPreciosGrpc.newBlockingStub(channel2);
    		 
    		 
    		String apellidos = "DelaOsaGarcia";
         	String NIF = "78115673Z";
         	String Ip = "172.27.56.81";
         	Iterator<ActualizarReply> reply = greeterStubBlocking.actualizarPrecios(
                     ActualizarRequest.newBuilder().setApellidos(apellidos).setIP(Ip).setNIF(NIF).build());

         	
         	while (reply.hasNext()) {
         		ActualizarReply r= reply.next();
         		if("EOLICA".equals(r.getTipoDemanda())) {
         			precioEolica=r.getPrecio();
         		}else if("SOLAR".equals(r.getTipoDemanda())){
         			precioSolar=r.getPrecio();
         		}else {
         			precioRapida=r.getPrecio();
         		}
	
         	}


        return new StreamObserver<PreciosRequest>() {
        	
            @Override
            public void onNext(PreciosRequest value) {

                double total = 0.0;

                for (DemandaRequest d : value.getDemandasList()) {

                    String tipo = d.getIdTipo();
                    double kwh = d.getKWh();

                    if ("SOLAR".equals(tipo)) {
                        total += kwh * precioSolar;
                    } else if ("EOLICA".equals(tipo)) {
                        total += kwh * precioEolica;
                    } else {
                        total += kwh * precioRapida;
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
