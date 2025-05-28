package xStrem.escribir_xml_con_xStream;

import java.io.Serializable;

public class Jugador implements Serializable {
	
	
	private String nombre;
	private String nacionalidad;
	private int edad;
	private int posicion;
	private int puntos;
	private Entrenador entrenador;
	
	
	
	
	public Jugador(String nombre, String nacionalidad, int edad, int posicion, int puntos, Entrenador entrenador) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.posicion = posicion;
		this.puntos = puntos;
		this.entrenador = entrenador;
	}




	public String getNombre() {
		return nombre;
	}




	public String getNacionalidad() {
		return nacionalidad;
	}




	public int getEdad() {
		return edad;
	}




	public int getPosicion() {
		return posicion;
	}




	public int getPuntos() {
		return puntos;
	}




	public Entrenador getEntrenador() {
		return entrenador;
	}




	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad + ", posicion="
				+ posicion + ", puntos=" + puntos + ", entrenador=" + entrenador + "]";
	}
	
	
	

}
