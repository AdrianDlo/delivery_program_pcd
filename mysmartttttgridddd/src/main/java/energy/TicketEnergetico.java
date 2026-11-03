package energy;

public final class TicketEnergetico {
    private static int contador = 0;

    private TicketEnergetico() {}

    public static synchronized int next() {
        return ++contador;
    }
}
