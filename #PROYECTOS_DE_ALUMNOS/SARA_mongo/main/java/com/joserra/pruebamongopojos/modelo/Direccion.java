package com.joserra.pruebamongopojos.modelo;

//package com.joserra.pruebamongopojos.modelo;

/**
 *
 * @author joserra
 */
public final class Direccion {
	private String calle;
	private String ciudad;
	private String cp;

	public Direccion() {
	}

	public Direccion(String calle, String ciudad, String cp) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.cp = cp;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	// Resto del codigo

	@Override
	public String toString() {
		return "Direccion{" + "calle=" + calle + ", ciudad=" + ciudad + ", cp=" + cp + '}';
	}

}
