package energy;

import java.util.List;
import java.util.concurrent.Callable;

public class ConsumoMaxCallable implements Callable<Consumo> {

    private final List<Consumo> consumos;

    public ConsumoMaxCallable(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    @Override
    public Consumo call() {
        return consumos.stream()
                .max((a, b) -> Double.compare(
                        a.getTotalKWh(), b.getTotalKWh()))
                .orElse(null);
    }
}

