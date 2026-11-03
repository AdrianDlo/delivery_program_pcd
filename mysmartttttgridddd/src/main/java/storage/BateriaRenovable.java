package storage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BateriaRenovable {

    private final double capacidadMaxKWh;
    private double nivelActualKWh = 0;

    private final Lock lock = new ReentrantLock(true);  // fair = true opcional
    private final Condition noLleno = lock.newCondition();
    private final Condition noVacio = lock.newCondition();

    public BateriaRenovable(double capacidadMaxKWh) {
        this.capacidadMaxKWh = capacidadMaxKWh;
    }

    /** PRODUCTOR: deposita 1 kWh */
    public void depositar() {
        lock.lock();
        try {
            while (nivelActualKWh >= capacidadMaxKWh) {
                noLleno.await(); // batería llena → productor espera
            }
            nivelActualKWh += 1;
            noVacio.signal();  // despertar a consumidores
        } catch (InterruptedException ignored) {
        } finally {
            lock.unlock();
        }
    }

    /** CONSUMIDOR: retira n kWh */
    public void retirar(double kWh) {
        lock.lock();
        try {
            while (nivelActualKWh < kWh) {
                noVacio.await(); // no hay suficiente energía
            }
            nivelActualKWh -= kWh;
            noLleno.signal(); // despertar productores
        } catch (InterruptedException ignored) {
        } finally {
            lock.unlock();
        }
    }

    public double getNivelActual() {
        lock.lock();
        try {
            return nivelActualKWh;
        } finally {
            lock.unlock();
        }
    }
}
