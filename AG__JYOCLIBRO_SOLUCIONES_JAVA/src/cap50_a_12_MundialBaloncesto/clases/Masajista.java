package cap50_a_12_MundialBaloncesto.clases;

public class Masajista extends Componente {

	private int anosExperiencia;
	private 	String titulacion;
	public Masajista(int identificador, String nombre, String apellidos, int edad, Seleccion seleccion,
			int anosExperiencia, String titulacion) {
		super(identificador, nombre, apellidos, edad, seleccion);
		this.anosExperiencia = anosExperiencia;
		this.titulacion = titulacion;
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


	public int getAnosExperiencia() {
		return anosExperiencia;
	}


	public void setAnosExperiencia(int anosExperiencia) {
		this.anosExperiencia = anosExperiencia;
	}


	public String getTitulacion() {
		return titulacion;
	}


	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	
	
	
}
