package energy;

public class TrabajoConsumo{
	private Consumo consumo;
	private boolean terminado = false; ///
	private String resultado = "";    ////
	private boolean fin = false;
	
	public TrabajoConsumo(Consumo _consumo) {
		this.consumo = _consumo;
	}
	

	public static TrabajoConsumo trabajoFin() {
        TrabajoConsumo t = new TrabajoConsumo(null);
        t.fin = true;
        return t;
    }

    public boolean esFin() {
        return fin;
    }

	public Consumo getConsumo() {
		return consumo;
	}
	
	public synchronized void esperarResultado(){   ////
		while (!terminado) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
		
	}
	

	public synchronized void marcarTerminado(String resultado) {  ////
        this.terminado = true;
        this.resultado = resultado;
        notify();   // despierta SOLO al productor correspondiente
    }
	

	public synchronized String getResultado() {
        return resultado;
    }

}
