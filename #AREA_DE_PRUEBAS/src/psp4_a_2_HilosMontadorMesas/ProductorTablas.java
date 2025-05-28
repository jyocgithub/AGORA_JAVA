package psp4_a_2_HilosMontadorMesas;

public class ProductorTablas extends Thread{

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
	
	public ProductorTablas(String nombreFabricante, Almacen almacen) {
		super();
		this.nombreFabricante = nombreFabricante;
		this.almacen = almacen;
	}
	
	public void run() {
		int cont = 0;
		
		while(true) {
			almacen.producirTabla(nombreFabricante);
			cont++;
		}
	}
	
}
