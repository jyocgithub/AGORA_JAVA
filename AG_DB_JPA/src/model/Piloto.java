package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Piloto.findAll", query = "SELECT p FROM Piloto p")
public class Piloto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idpiloto;

	private String apodo;

	private int edad;

	private String nombre;

	@OneToOne(mappedBy = "piloto", cascade = CascadeType.ALL)
	private Arma arma;

	@ManyToOne
	@JoinColumn(name = "idplaneta")
	private Planeta planeta;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "piloto_nave", joinColumns = { @JoinColumn(name = "idpiloto") }, 
							 inverseJoinColumns = {	@JoinColumn(name = "idnave") })
	private List<Nave> naves;

	public Piloto() {
	}

	public Piloto(String apodo, int edad, String nombre, Planeta planeta) {
		super();
		this.apodo = apodo;
		this.edad = edad;
		this.nombre = nombre;
		this.planeta = planeta;
		this.naves = new ArrayList<Nave>();
	}

	public int getIdpiloto() {
		return this.idpiloto;
	}

	public void setIdpiloto(int idpiloto) {
		this.idpiloto = idpiloto;
	}

	public String getApodo() {
		return this.apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArmas() {
		return this.arma;
	}

	public void setArmas(Arma armas) {
		this.arma = armas;
		armas.setPiloto(this);
	}

	public Planeta getPlaneta() {
		return this.planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public List<Nave> getNaves() {
		return this.naves;
	}

	public void setNaves(List<Nave> naves) {
		this.naves = naves;
	}

	@Override
	public String toString() {
		String s = "Piloto [idpiloto=" + idpiloto + ", apodo=" + apodo + ", edad=" + edad + ", nombre=" + nombre
				+ ", arma=" + arma + ", planeta=" + planeta.getNombre() + ".  Naves: ";
		if (naves != null) {
			for (Nave n : naves) {
				s = s + n.getSobrenombre() + " ";
			}
		}
		return s;

	}

}