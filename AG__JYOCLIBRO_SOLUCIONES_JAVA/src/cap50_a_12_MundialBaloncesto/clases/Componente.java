package cap50_a_12_MundialBaloncesto.clases;

import cap50_a_12_MundialBaloncesto.interfaces.InterfazComponentes;

abstract public class Componente implements InterfazComponentes {

	private int Identificador;
	private String Nombre;
	private String Apellidos;
	private int Edad;
	private Seleccion seleccion;
	
	
	public Componente(int identificador, String nombre, String apellidos, int edad, Seleccion seleccion) {
		super();
		Identificador = identificador;
		Nombre = nombre;
		Apellidos = apellidos;
		Edad = edad;
		this.seleccion = seleccion;
	}
	
	
	public int getIdentificador() {
		return Identificador;
	}
	public void setIdentificador(int identificador) {
		Identificador = identificador;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public Seleccion getSeleccion() {
		return seleccion;
	}
	public void setSeleccion(Seleccion seleccion) {
		this.seleccion = seleccion;
	}


	@Override
	public String toString() {
		return "cap50_a_12_MundialBaloncesto.clases.Componente [Identificador=" + Identificador + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos
				+ ", Edad=" + Edad + "]";
	}

}
