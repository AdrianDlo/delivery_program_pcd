package main;

public final class Config {
    private Config() {}

    // --- Configuracion general ---
    public static final int NUM_OPERADORES_POR_ZONA = 3;
    public static final int NUM_ZONAS = 3;
    
    // Núm. máximo de consumos tramitándose en paralelo por zona
    public static final int MAX_TRAMITES_SIMULTANEOS_POR_ZONA = 2;
    
    // --- Ventanas ---
    public static final int TAMAÑO_VENTANA = 250;

    // Baterias (kWh)
    public static final double CAPACIDAD_BATERIA = 200.0;
    public static final double NIVEL_INICIAL_BATERIA = 120.0;

    // Ficheros
    public static final String FICHERO_CONSUMOS = "consumos3.bin";

    // Generacion de consumos
    public static final int NUM_CONSUMOS_A_GENERAR = 50;

    // Semilla para generacion reproducible
    public static final long SEED = 12345L;
    

 // --- Versión 7 ---
     // 0 ->s forma tradicional
     // 1 -> rxjava (Observable + flatMap)
    // 2 -> executor
     public static final int tipoLanzamientoPedidos = 0;
     
     public static final boolean usarCyclicBarrier = true;
  // false -> semáforos 
  // true  -> CyclicBarrier 


    

}
