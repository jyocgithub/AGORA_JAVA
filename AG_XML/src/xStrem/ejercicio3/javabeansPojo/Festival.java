package ejercicio3.javabeansPojo;

import java.io.Serializable;

public class Festival implements Serializable {
	
	
	
	
	private String nombre;
	private Fecha fecha;
	private String ciudad;
	private String pais;
	private String cartel;
	
	
	
	public Festival(String nombre, Fecha fecha, String ciudad, String pais, String cartel) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.pais = pais;
		this.cartel = cartel;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Fecha getFecha() {
		return fecha;
	}



	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getCartel() {
		return cartel;
	}



	public void setCartel(String cartel) {
		this.cartel = cartel;
	}



	@Override
	public String toString() {
		return "Festival  nombre : " + nombre + " fecha : " + fecha + " ciudad : " + ciudad + " pais : " + pais + ", cartel="
				+ cartel + "]";
	}
	
	
	
	
	
	

}
