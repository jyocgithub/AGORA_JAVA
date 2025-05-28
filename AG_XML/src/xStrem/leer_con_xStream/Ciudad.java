package xStrem.leer_con_xStream;

import java.io.Serializable;

public class Ciudad implements Serializable{
	
	private String codigo;
	private String nombreCiudad;
	private String pais;
	
	
	
	
	public Ciudad(String codigo, String nombreCiudad, String pais) {
		this.codigo = codigo;
		this.nombreCiudad = nombreCiudad;
		this.pais = pais;
	}
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public String getPais() {
		return pais;
	}
	@Override
	public String toString() {
		return "Ciudad [codigo=" + codigo + ", nombreCiudad=" + nombreCiudad + ", pais=" + pais + "]";
	}
	
	
	
	

}
