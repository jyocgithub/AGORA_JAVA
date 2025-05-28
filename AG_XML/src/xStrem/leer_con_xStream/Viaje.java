package xStrem.leer_con_xStream;

import java.io.Serializable;

public class Viaje implements Serializable {
	
	
	private int id;
	private String nombre;
	private Ciudad ciudad;
	private int dias;
	private double precio;
	
	
	/// contructor con parametro, get y los String 
	
	public Viaje(int id, String nombre, Ciudad ciudad, int dias, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.dias = dias;
		this.precio = precio;
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public int getDias() {
		return dias;
	}


	public double getPrecio() {
		return precio;
	}


	@Override
	public String toString() {
		return "Viaje [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", dias=" + dias + ", precio=" + precio
				+ "]";
	}
	
	
	
	
	
	
	

}
