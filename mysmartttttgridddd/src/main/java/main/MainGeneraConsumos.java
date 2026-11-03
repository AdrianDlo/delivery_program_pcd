package main;

import energy.Consumo;
import energy.TicketEnergetico;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGeneraConsumos {

    public static void main(String[] args) {
        String out = Config.FICHERO_CONSUMOS;
        int n = Config.NUM_CONSUMOS_A_GENERAR;

        List<Consumo> consumos = generaListaConsumos(n, Config.NUM_ZONAS, Config.SEED);

        boolean ok = consumosAFichero(consumos, out);
        if (ok) System.out.println("Generado fichero '" + out + "' con " + consumos.size() + " consumos.");
    }

    public static List<Consumo> generaListaConsumos(int n, int numZonas, long seed) {
        Random rnd = new Random(seed);
        List<Consumo> lista = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) lista.add(Consumo.generaConsumo(numZonas, TicketEnergetico.next(), rnd));
        return lista;
    }

    public static boolean consumosAFichero(List<Consumo> consumos, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            for (Consumo c : consumos) oos.writeObject(c);
            return true;
        } catch (IOException e) {
            System.err.println("Error escribiendo fichero '" + path + "': " + e.getMessage());
            return false;
        }
    }
}
