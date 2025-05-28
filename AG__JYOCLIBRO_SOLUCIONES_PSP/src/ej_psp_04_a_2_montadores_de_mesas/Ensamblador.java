package ej_psp_4_a_2_montadores_de_mesas;

public class Ensamblador extends Thread{

	private String nombreEnsamblador;
	private Almacen almacen;

	public Ensamblador(String nombreEnsamblador, Almacen almacen) {
		super();
		this.nombreEnsamblador = nombreEnsamblador;
		this.almacen = almacen;
	}

	public void run() {
		
		while(true) {
			almacen.producirMesa(nombreEnsamblador);
		}
	}
}
