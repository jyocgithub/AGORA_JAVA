package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Nave.findAll", query = "SELECT n FROM Nave n")
public class Nave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idnave;
	private String modelo;
	private String sobrenombre;
	private int velocidad;

	@ManyToMany(mappedBy = "naves", cascade = CascadeType.ALL)
	private List<Piloto> pilotos;

	public Nave() {
	}

	public Nave(String modelo, String sobrenombre, int velocidad) {
		super();
		this.modelo = modelo;
		this.sobrenombre = sobrenombre;
		this.velocidad = velocidad;
		pilotos = new ArrayList<>();
	}

	public int getIdnave() {
		return this.idnave;
	}

	public void setIdnave(int idnave) {
		this.idnave = idnave;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSobrenombre() {
		return this.sobrenombre;
	}

	public void setSobrenombre(String sobrenombre) {
		this.sobrenombre = sobrenombre;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public List<Piloto> getPilotos() {
		return this.pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
		for (Piloto p : pilotos) {
			p.getNaves().add(this);
		}
	}

	@Override
	public String toString() {
		return "Nave [idnave=" + idnave + ", modelo=" + modelo + ", sobrenombre=" + sobrenombre + ", velocidad="
				+ velocidad + ", pilotos=" + pilotos + "]";
	}

}