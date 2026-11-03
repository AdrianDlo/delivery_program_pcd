package energy;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import io.reactivex.rxjava3.core.Observable;


public class Consumo implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String idConsumo;
    private final String direccion;
    private final int zona;
    private final CanalConsumo canal;
    private final List<Demanda> demandas;


    public Consumo(String idConsumo, String direccion, int zona, CanalConsumo canal, List<Demanda> demandas) {
        this.idConsumo = Objects.requireNonNull(idConsumo);
        this.direccion = Objects.requireNonNull(direccion);
        this.zona = zona;
        this.canal = Objects.requireNonNull(canal);
        this.demandas = List.copyOf(Objects.requireNonNull(demandas));
        if (this.demandas.isEmpty()) throw new IllegalArgumentException("Un consumo debe tener al menos una demanda.");
    }

    public String getIdConsumo() { return idConsumo; }
    public String getDireccion() { return direccion; }
    public int getZona() { return zona; }
    public CanalConsumo getCanal() { return canal; }
    public List<Demanda> getDemandas() { return demandas; }

    public double getTotalKWh() {
        double sum = 0.0;
        for (Demanda d : demandas) sum += d.getKWh();
        return sum;
    }

    public static Consumo generaConsumo(int numZonas, int contador, Random rnd) {
        CanalConsumo[] canales = CanalConsumo.values();
        CanalConsumo canal = canales[rnd.nextInt(canales.length)];
        int zona = rnd.nextInt(Math.max(1, numZonas));

        String id = canal.name().substring(0, 3) + "_Z" + zona + "_" + contador;
        String direccion = generaDireccion(rnd);

        int numDemandas = 1 + rnd.nextInt(3); // 1..3
        List<Demanda> demandas = new ArrayList<>();
        for (int i = 0; i < numDemandas; i++) demandas.add(Demanda.generaDemanda(rnd));

        return new Consumo(id, direccion, zona, canal, demandas);
    }

    private static String generaDireccion(Random rnd) {
        String[] calles = {"Avenida de la Universidad", "Berna, 11", "Gran Via, 22", "Caceres, 5", "Ruta de la Plata, 9"};
        return calles[rnd.nextInt(calles.length)];
    }

    @Override
    public String toString() {
        return "Consumo{idConsumo='" + idConsumo + "', direccion='" + direccion + "', zona=" + zona +
                ", canal=" + canal + ", demandas=" + demandas + "}";
    }
    
    public static List<Consumo> consumosDesdeFichero(String path) {
        List<Consumo> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            while (true) {
                Object obj = ois.readObject();
                if (!(obj instanceof Consumo)) throw new IllegalStateException("Objeto inesperado: " + obj.getClass());
                lista.add((Consumo) obj);
            }
        } catch (EOFException eof) {
            // fin normal
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error leyendo fichero '" + path + "': " + e.getMessage());
        }
        return lista;
    }
    

// AÑADIDO VERSIÓN RXJAVA: Observable de consumos


public static Observable<Consumo> consumosDesdeFicheroObservable(String path) {

    return Observable.create((emitter) -> {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(path))) {

            while (true) {
                try {
                    Object obj = ois.readObject();

                    if (!(obj instanceof Consumo)) {
                        emitter.onError(
                                new IllegalStateException("Objeto inesperado"));
                        return;
                    }

                    // Emitimos un evento por cada consumo leído
                    emitter.onNext((Consumo) obj);

                } catch (EOFException eof) {
                    // Fin normal del fichero
                    break;
                }
            }

            // Fin de la emisión
            emitter.onComplete();

        } catch (IOException | ClassNotFoundException e) {
            emitter.onError(e);
        }
    
    });


}

}

