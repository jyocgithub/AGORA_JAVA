package xStrem.escribir_xml_con_xStream;

import java.io.Serializable;

public class Entrenador  implements Serializable {
	
	
	private String nom_entrenador;
	private String nac_entrenador;
	private int edad;
	
	
	
	
	
	
	
	
	public Entrenador(String nom_entrenador, String nac_entrenador, int edad) {
		this.nom_entrenador = nom_entrenador;
		this.nac_entrenador = nac_entrenador;
		this.edad = edad;
	}
	public String getNom_entrenador() {
		return nom_entrenador;
	}
	public String getNac_entrenador() {
		return nac_entrenador;
	}
	public int getEdad() {
		return edad;
	}
	@Override
	public String toString() {
		return "Entrenador [nom_entrenador=" + nom_entrenador + ", nac_entrenador=" + nac_entrenador + ", edad=" + edad
				+ "]";
	}
	
	
	
	

}
