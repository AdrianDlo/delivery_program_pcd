package operators;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import energy.Consumo;
import energy.TrabajoConsumo;
import energy.ZonaEnergetica;

public class CentroControl {
    private ZonaEnergetica zona;
   // private final Queue<TrabajoConsumo> colaConsDisp = new LinkedList<>();
    

    private final LinkedBlockingQueue<TrabajoConsumo> colaConsDisp =
        new LinkedBlockingQueue<>();


    public CentroControl() {
    }
    
    public void setZona(ZonaEnergetica zona) {
    	this.zona=zona;
    }

    public int getIdZona() { return zona.getIdZona(); }


    public void enviarTrabajo(TrabajoConsumo t) {


    	if (!t.esFin()) {
	        Consumo c = t.getConsumo();
	        zona.traza("[CentroControl Z" + getIdZona()
	                   + "] Recibido consumo " + c.getIdConsumo());
	    }
	
	    try {
	        colaConsDisp.put(t); // BLOQUEANTE
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	
	    if (!t.esFin()) {
	        t.esperarResultado();
	    }
}


    
    public TrabajoConsumo cogerTrabajo() {     ////

		try {
		        return colaConsDisp.take(); // BLOQUEANTE
		    } catch (InterruptedException e) {
		        Thread.currentThread().interrupt();
		        return null;
		    }

    	
    }

    public void traza(String msg) {
        System.out.println("[CentroControl Z" + zona.getIdZona() + "] " + msg);
    }
}
