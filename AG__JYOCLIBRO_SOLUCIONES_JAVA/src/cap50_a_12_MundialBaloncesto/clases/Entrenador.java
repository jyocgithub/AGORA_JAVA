package cap50_a_12_MundialBaloncesto.clases;

public class Entrenador extends Componente {

	private int numfederacion;
	private 	String puesto;
	public Entrenador(int identificador, String nombre, String apellidos, int edad, Seleccion seleccion,
			int numfederacion, String puesto) {
		super(identificador, nombre, apellidos, edad, seleccion);
		this.numfederacion = numfederacion;
		this.puesto = puesto;
	}

	@Override
	public void concentrarse() {
	}

	@Override
	public void entrenar() {
	}

	@Override
	public void viajar() {
	}

	@Override
	public void jugarPartido() {
	}

	public int getNumfederacion() {
		return numfederacion;
	}

	public void setNumfederacion(int numfederacion) {
		this.numfederacion = numfederacion;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
		
	
	
	
}
