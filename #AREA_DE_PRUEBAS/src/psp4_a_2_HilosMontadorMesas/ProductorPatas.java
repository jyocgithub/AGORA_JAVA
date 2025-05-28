package psp4_a_2_HilosMontadorMesas;

public class ProductorPatas extends Thread{

	private String nombreFabricante;
	private Almacen almacen;
	
	
	public String getNombreFabricante() {
		return nombreFabricante;
	}
	public void setNombreFabricante(String nombreFabricante) {
		this.nombreFabricante = nombreFabricante;
	}
	public Almacen getAlmacen() {
		return almacen;
	}
	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	
	public ProductorPatas(String nombreFabricante, Almacen almacen) {
		super();
		this.nombreFabricante = nombreFabricante;
		this.almacen = almacen;
	}
	
	public void run() {
		int cont= 0;
		while(true) {
			almacen.producirPata(nombreFabricante);
			cont++;
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
