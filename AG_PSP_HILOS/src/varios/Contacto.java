package varios;

/**
 *
 * @author IMS
 */
public class Contacto {
	String nombre;
	String direccion;
	int edad;

	public Contacto(String nombre, String direccion, int edad) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
