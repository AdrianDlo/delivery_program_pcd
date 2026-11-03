package energy;

import storage.BateriaRenovable;

public class RobotProductor implements Runnable {

    private final BateriaRenovable bateria;
    private final String tipo;  // "SOLAR" o "EOLICA"

    public RobotProductor(BateriaRenovable b, String tipo) {
        this.bateria = b;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        while (true) {
            bateria.depositar();
            // pequeña pausa opcional para verlo mejor
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        }
    }
}
