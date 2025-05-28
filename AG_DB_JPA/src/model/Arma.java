package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Arma.findAll", query = "SELECT a FROM Arma a")
public class Arma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idarma;
	private String numserie;
	private int peso;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idpiloto")
private Piloto piloto;

	public Arma() {
	}

	public Arma(String numserie, int peso, Piloto piloto) {
		super();
		this.numserie = numserie;
		this.peso = peso;
		this.piloto = piloto;
		piloto.setArmas(this);
	}

	public int getIdarma() {
		return this.idarma;
	}

	public void setIdarma(int idarma) {
		this.idarma = idarma;
	}

	public String getNumserie() {
		return this.numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Piloto getPiloto() {
		return this.piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
		return "Arma [idarma=" + idarma + ", numserie=" + numserie + ", peso=" + peso + ", piloto=" + piloto.getNombre()
				+ "]";
	}

}