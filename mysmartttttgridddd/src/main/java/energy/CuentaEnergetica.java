package energy;

public class CuentaEnergetica {
    private double balanceKWh;

    public CuentaEnergetica(double balanceInicialKWh) {
        this.balanceKWh = balanceInicialKWh;
    }

    public synchronized void  anotaConsumo(double kWh) {
        this.balanceKWh += kWh;
    }

    public synchronized double getBalanceKWh() {
        return balanceKWh;
    }

    @Override
    public String toString() {
        return "CuentaEnergetica{balanceKWh=" + balanceKWh + "}";
    }
}
