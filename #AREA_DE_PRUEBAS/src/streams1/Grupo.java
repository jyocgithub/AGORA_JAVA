package streams1;

import java.util.List;

public class Grupo {

	private String nombre;
	private List<Alumnos> alumnos;
	
	public Grupo() {
		
	}

	public Grupo(String nombre,List<Alumnos>alumnos) {
		this.nombre=nombre;
		this.alumnos=alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumnos> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumnos> alumnos) {
		this.alumnos = alumnos;
	}

	public String toString() {
		String res= "Nombre: "+nombre+"Alumnos: "+alumnos;
		
		return res;
	}

}
