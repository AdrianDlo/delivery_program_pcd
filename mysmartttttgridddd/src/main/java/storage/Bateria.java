package storage;

import pcd.util.Ventana;

public class Bateria {
    private final double capacidadMaxKWh;
    private double nivelActualKWh;
    Ventana v;

    public Bateria(double capacidadMaxKWh, double nivelInicialKWh) {
        if (capacidadMaxKWh <= 0) throw new IllegalArgumentException("capacidadMaxKWh debe ser > 0");
        if (nivelInicialKWh < 0) throw new IllegalArgumentException("nivelInicialKWh debe ser >= 0");
        this.capacidadMaxKWh = capacidadMaxKWh;
        this.nivelActualKWh = Math.min(nivelInicialKWh, capacidadMaxKWh);
    }

    public double getCapacidadMaxKWh() { return capacidadMaxKWh; }
    public synchronized double getNivelActualKWh() { return nivelActualKWh; }

    public synchronized boolean puedeSuministrar(double kWh) {
        return kWh <= nivelActualKWh;
    }

    public synchronized double suministra(double kWh) {
        if (kWh <= 0) return 0.0;
        double suministrado = Math.min(kWh, nivelActualKWh);
        nivelActualKWh -= suministrado;
        return suministrado;
    }

    public synchronized void carga(double kWh) {
        if (kWh <= 0) return;
        nivelActualKWh = Math.min(capacidadMaxKWh, nivelActualKWh + kWh);
    }
    
    public void setVentana (Ventana _v) {
    	v=_v;
    }

    @Override
    public synchronized String toString() {
        return "Bateria{capacidadMaxKWh=" + capacidadMaxKWh + ", nivelActualKWh=" + nivelActualKWh + "}";
    }
}
