package energy;

import operators.CentroControl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import pcd.util.Ventana;
import storage.Bateria;
import storage.BateriaRenovable;

import java.awt.Color;
import java.util.Objects;

import main.Config;

public class ZonaEnergetica {
    private final int idZona;
    private final CuentaEnergetica cuenta;
    private final Bateria bateria;
    private final BateriaRenovable bateriaSolar;
    private final BateriaRenovable bateriaEolica;

    private final CentroControl centroControl;
    private Ventana v;
    
    private boolean solicitarCarga = false; 
    

    public final Semaphore semaforoArranque = new Semaphore(0, true);
    public final Semaphore aforo = new Semaphore(Config.MAX_TRAMITES_SIMULTANEOS_POR_ZONA, true);
    

	public CyclicBarrier barrera;
	public CountDownLatch latchInicio;



    public ZonaEnergetica(int idZona, CuentaEnergetica cuenta, Bateria bateria,  CentroControl centroControl, Ventana _v) {
        this.idZona = idZona;
        this.cuenta = Objects.requireNonNull(cuenta);
        this.bateria = Objects.requireNonNull(bateria);
        this.centroControl = Objects.requireNonNull(centroControl);
        this.v = _v;
        
        // BATERIAS RENOVABLES
        this.bateriaSolar = new BateriaRenovable(Config.CAPACIDAD_BATERIA);
        this.bateriaEolica = new BateriaRenovable(Config.CAPACIDAD_BATERIA);
       

        // ROBOTS PRODUCTORES
        new Thread(new RobotProductor(bateriaSolar, "SOLAR")).start();
        new Thread(new RobotProductor(bateriaEolica, "EOLICA")).start();
  
    }
    
    

		public void setBarrera(CyclicBarrier b) { this.barrera = b; }
		public CyclicBarrier getBarrera() { return barrera; }
		
		public void setLatchInicio(CountDownLatch l) { this.latchInicio = l; }
		public CountDownLatch getLatchInicio() { return latchInicio; }


    public synchronized void solicitarCarga() {
    	solicitarCarga = true;
        notifyAll();
    }

    public synchronized void esperarPeticionDeCarga() {
        while (!solicitarCarga) {
            try { wait(); } catch (InterruptedException e) {}
        }
        solicitarCarga = false;
    }
    

    public synchronized void esperarEnergia() {
        try {
            wait();
        } catch (InterruptedException e) {}
    }
    

    public synchronized void notificarEnergiaDisponible() {
        notifyAll();
    }


    public int getIdZona() { return idZona; }
    public CuentaEnergetica getCuenta() { return cuenta; }
    public Bateria getBateria() { return bateria; }
    public CentroControl getCentroControl() { return centroControl; }

    public BateriaRenovable getBateriaSolar() { return bateriaSolar; }
    public BateriaRenovable getBateriaEolica() { return bateriaEolica; }




    public String tramitarConsumo(Consumo c) {
        if (c.getZona() != idZona) {
            return "ERROR: consumo dirigido a zona " + c.getZona() + " pero tramitado en zona " + idZona;
        }
        // MANTENEMOS tu mensaje de solicitud en AZUL
        traza (c.getIdConsumo()+" solicita: "+c.getTotalKWh(), Color.BLUE);

        // Versión 3: el trabajo lo hace un operario; el productor espera aquí
        TrabajoConsumo t = new TrabajoConsumo(c);
        centroControl.enviarTrabajo(t);
        return t.getResultado(); // lo imprime el productor como antes
    }
    


   
    @Override
    public String toString() {
        return "ZonaEnergetica{idZona=" + idZona + ", cuenta=" + cuenta + ", bateria=" + bateria + "}";
    }
    
    public Ventana getVentana () {
    	return v;
    }
    
    public synchronized void traza (String s) {
    	v.traza(s);
    }
    
    public synchronized void traza (String s, Color color) {
    	v.traza(s,color);
    }

}
