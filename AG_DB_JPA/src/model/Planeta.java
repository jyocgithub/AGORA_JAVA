package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "planeta")
@NamedQuery(name = "Planeta.findAll", query = "SELECT p FROM Planeta p")
public class Planeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idplaneta;

	@Override
	public String toString() {
		return "Planeta [idplaneta=" + idplaneta + ", nombre=" + nombre + ", reino=" + reino + ", diametro=" + diametro
				+ ", pilotos=" + pilotos + "]";
	}

	private String nombre;
	private String reino;
	private int diametro;

	@OneToMany(mappedBy = "planeta", cascade = CascadeType.ALL)
	private List<Piloto> pilotos;

	public Planeta() {
	}

	public Planeta(String nombre, String reino, int diametro) {
		super();
		this.nombre = nombre;
		this.reino = reino;
		this.diametro = diametro;
		pilotos = new ArrayList<>();
	}

	public int getIdplaneta() {
		return this.idplaneta;
	}

	public void setIdplaneta(int idplaneta) {
		this.idplaneta = idplaneta;
	}

	public int getDiametro() {
		return this.diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReino() {
		return this.reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public List<Piloto> getPilotos() {
		return this.pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	public Piloto addPiloto(Piloto piloto) {
		getPilotos().add(piloto);
		piloto.setPlaneta(this);

		return piloto;
	}

	public Piloto removePiloto(Piloto piloto) {
		getPilotos().remove(piloto);
		piloto.setPlaneta(null);

		return piloto;
	}

}