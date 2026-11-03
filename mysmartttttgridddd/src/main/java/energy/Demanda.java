package energy;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Demanda implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String idTipo;
    private final double kWh;
    private final int prioridad;

    public Demanda(String idTipo, double kWh, int prioridad) {
        this.idTipo = Objects.requireNonNull(idTipo);
        this.kWh = kWh;
        this.prioridad = prioridad;
    }

    public String getIdTipo() { return idTipo; }
    public double getKWh() { return kWh; }
    public int getPrioridad() { return prioridad; }

    public static Demanda generaDemanda(Random rnd) {
        String[] tipos = {"SOLAR", "EOLICA", "RAPIDA"};
        String tipo = tipos[rnd.nextInt(tipos.length)];
        double kWh = 1.0 + rnd.nextInt(10); // 1..10
        int prio = rnd.nextInt(3);          // 0..2
        return new Demanda(tipo, kWh, prio);
    }

    @Override
    public String toString() {
        return "Demanda{idTipo='" + idTipo + "', kWh=" + kWh + ", prioridad=" + prioridad + "}";
    }
}
