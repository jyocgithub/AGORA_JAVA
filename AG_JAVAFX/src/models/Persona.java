package models;

//El propósito de usar Properties y ObservableLists es que estos son elementos escuchables.Cuando se usan propiedades,si cambia el valor de un atributo de propiedad en el modelo de datos,la vista del elemento en TableView se actualiza automáticamente para coincidir con el valor del modelo de datos actualizado.Por ejemplo,si el valor de la propiedad de correo electrónico de una persona se establece en un nuevo valor,esa actualización se reflejará en TableView porque escucha el cambio de propiedad.Si,en cambio,se hubiera utilizado una cadena simple para representar el correo electrónico,TableView no se actualizaría,ya que no estaría al tanto de los cambios en el valor del correo electrónico.

public class Persona {
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	public Persona(String nombre, String apellidos, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
	}
	
	
	public Persona(String nombre, String apellidos, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", password=" + password
				+ "]";
	}

	
}
