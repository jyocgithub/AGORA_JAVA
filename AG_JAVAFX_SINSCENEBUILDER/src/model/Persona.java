package model;

import javafx.beans.property.SimpleStringProperty;

public class Persona {
	private SimpleStringProperty nombre;
	private SimpleStringProperty apellidos;
	private SimpleStringProperty email;

	public Persona(String pNombre, String pApellidos, String pEmail) {
		this.nombre = new SimpleStringProperty(pNombre);
		this.apellidos = new SimpleStringProperty(pApellidos);
		this.email = new SimpleStringProperty(pEmail);
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String pNombre) {
		nombre.set(pNombre);
	}

	public String getApellidos() {
		return apellidos.get();
	}

	public void setApellidos(String pApellidos) {
		apellidos.set(pApellidos);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String pEmail) {
		email.set(pEmail);
	}

	@Override
	public String toString() {
		return "Persona{" + "nombre=" + nombre.get() + ", apellidos=" + apellidos.get() + ", email=" + email.get()
				+ '}';
	}
}
