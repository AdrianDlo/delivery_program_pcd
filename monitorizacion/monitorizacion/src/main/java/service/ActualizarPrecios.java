package service;

import grpc.ActualizarPreciosGrpc.ActualizarPreciosImplBase;
import grpc.ActualizarPreciosProto.ActualizarReply;
import grpc.ActualizarPreciosProto.ActualizarRequest;
import io.grpc.stub.StreamObserver;



public class ActualizarPrecios extends ActualizarPreciosImplBase {
	
	public void actualizarPrecios(ActualizarRequest request, StreamObserver<ActualizarReply> responseObserver) {

		double precio=0.01; 
		String tipoDemanda= "SOLAR";
		ActualizarReply reply1=ActualizarReply.newBuilder().setPrecio(precio).setTipoDemanda(tipoDemanda).build();
		responseObserver.onNext(reply1);
			
		double precio2=0.02; 
		String tipoDemanda2= "EÓLICA";
		ActualizarReply reply2=ActualizarReply.newBuilder().setPrecio(precio2).setTipoDemanda(tipoDemanda2).build();
		responseObserver.onNext(reply2);
				
		double precio3=0.2; 
		String tipoDemanda3= "RAPIDA";
		ActualizarReply reply3=ActualizarReply.newBuilder().setPrecio(precio3).setTipoDemanda(tipoDemanda3).build();
		responseObserver.onNext(reply3);
					
				
		responseObserver.onCompleted();
					
		 }
            
        
   }



