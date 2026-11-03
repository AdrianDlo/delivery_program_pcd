package energy;

public class OperadorCarga implements Runnable {

    private final ZonaEnergetica zona;

    public OperadorCarga(ZonaEnergetica z) {
        this.zona = z;
    }

    @Override
    public void run() {
       
		try {
		    zona.getLatchInicio().await(); // espera a que TODOS los operadores de red hayan arrancado
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		    return;
		}

		 while (true) { 
        	zona.esperarPeticionDeCarga(); // bloqueado hasta que se pida carga
        	zona.traza("[Carga Z" + zona.getIdZona() + "] Iniciando recarga...");
        	zona.getBateria().carga(10);   // estrategia simple de recarga
        	zona.traza("[Carga Z" + zona.getIdZona() + "] Energía recargada. Nivel actual: "
                + String.format(java.util.Locale.ROOT, "%.2f", zona.getBateria().getNivelActualKWh()) + " kWh");
        	zona.notificarEnergiaDisponible(); // despierta a operadores esperando energía

        }
    }
}
