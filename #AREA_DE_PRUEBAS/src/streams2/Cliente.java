package streams2;

public class Cliente {

	private String dni;
	private String nombre;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente() {

	}

	public Cliente(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public String toString() {
		String res = "";
		
		res="Nombre: "+nombre+" Dni: "+dni;
		
		return res;
	}
	
}
