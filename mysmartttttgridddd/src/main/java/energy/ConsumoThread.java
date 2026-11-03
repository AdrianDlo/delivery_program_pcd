package energy;
import energy.ConsumoThread;

public class ConsumoThread implements Runnable{
	private final Consumo con;
	private final RedEnergetica r;
	
	
	public ConsumoThread(Consumo _con, RedEnergetica _r) {
		this.con=_con;
		this.r=_r;
	}
	
	public void run() {
//		String resultado;
//		resultado=r.getZona(con.getZona()).tramitarConsumo(con);
//		r.getZona(con.getZona()).getVentana().traza (con.getIdConsumo()+ " - Tramitado: "+resultado);


		String resultado = r.getZona(con.getZona()).tramitarConsumo(con);	////
        r.getZona(con.getZona()).getVentana().traza(con.getIdConsumo() + " - Tramitado: " + resultado); ////
    }
}
