package hibernate_1_N_increment_bidir.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "PLAZAGARAGE")
@Table(name = "PLAZAGARAGE")
public class PlazaGarage implements Serializable {

	private static final long serialVersionUID = 424111L;

	@Id
	@Column(name = "ID_PLAZAGARAGE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mIdPlaza=0;
	
	@Column(name = "NUMERO")
	private String mNumero;

	@Column(name = "PRECIO")
	private int mPrecio;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ID_VIVIENDA")
	private Vivienda mVivienda;

	public PlazaGarage(String mNumero, int mPrecio) {
		super();
		this.mNumero = mNumero;
		this.mPrecio = mPrecio;
	}
	public PlazaGarage() {
		super();
	}

	public int getmIdPlaza() {
		return mIdPlaza;
	}

	public void setmIdPlaza(int mIdPlaza) {
		this.mIdPlaza = mIdPlaza;
	}

	public String getmNumero() {
		return mNumero;
	}

	public void setmNumero(String mNumero) {
		this.mNumero = mNumero;
	}

	public int getmPrecio() {
		return mPrecio;
	}

	public void setmPrecio(int mPrecio) {
		this.mPrecio = mPrecio;
	}

	public Vivienda getmVivienda() {
		return mVivienda;
	}

	public void setmVivienda(Vivienda mVivienda) {
		this.mVivienda = mVivienda;
	}
	@Override
	public String toString() {
		return "PlazaGarage [" + mIdPlaza + ", " + mNumero + ", " + mPrecio + "]";
	}
	@Override
	public int hashCode() {
		return  mNumero.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		PlazaGarage other = (PlazaGarage) obj;
		return mNumero.equals(other.mNumero);
	}


	

}
