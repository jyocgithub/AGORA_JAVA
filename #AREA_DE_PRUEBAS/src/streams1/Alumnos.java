package streams1;

public class Alumnos {

	private String nombre;
	private int edad;
	private float nota;
	
	public Alumnos() {
		
	}
	
	public Alumnos(String nombre,int edad,float nota) {
		this.nombre=nombre;
		this.edad=edad;
		this.nota=nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	public String toString() {
		String res= "Nombre: "+nombre+" Edad: "+edad+" Nota: "+nota;
		
		return res;
	}
}
