package server;
import java.io.IOException;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import service.Monitorizacion;
import service.PrecioService;
import service.ActualizarPrecios;



public class HelloServer {
	
public static void main(String args[]) throws IOException, InterruptedException {
		
	System.out.println("Starting GRPC monitorizacion Server");
		
	Server server = Grpc
.newServerBuilderForPort(9002, InsecureServerCredentials.create())
		.addService(new Monitorizacion())
		.build();
		
		 server.start();
		
		 System.out.println("Helloserver (monitorizacion) started at "+ server.getPort());
		

		 
		 
		 System.out.println("Starting GRPC precio Server");
			
			Server server2 = Grpc
		.newServerBuilderForPort(9004, InsecureServerCredentials.create())
				.addService(new PrecioService())
				.build();
				
				 server2.start();
				
				 System.out.println("Helloserver (precio) started at "+ server2.getPort());

				 
				 
				 System.out.println("Starting GRPC ActualizarPrecios Server");
					
					Server server3 = Grpc
				.newServerBuilderForPort(9999, InsecureServerCredentials.create())
						.addService(new ActualizarPrecios())
						.build();
						
						 server3.start();
						
						 System.out.println("Helloserver (ActualizarPrecios) started at "+ server3.getPort());
						 
						 
						 server.awaitTermination();
							
						 server2.awaitTermination();
						 
						 server3.awaitTermination();

						 
						 
		 
	 }
}
