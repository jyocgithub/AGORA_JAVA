package hibernate_N_M_increment_bidir.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "PERSONA")
@Table(name = "PERSONA")
public class Persona implements Serializable {

	private static final long serialVersionUID = 424111L;

	@Id
	@Column(name = "ID_PERSONA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mIdPlaza=0;
	
	@Column(name = "DNI")
	private String mDni;

	@Column(name = "NOMBRE")
	private String mNombre;

	@ManyToMany(mappedBy = "mListaPersonas", cascade = CascadeType.PERSIST)
	private Set<Vivienda> mListaViviendas = new HashSet<Vivienda>();

	public void agregarVivienda(Vivienda c) {
		mListaViviendas.add(c);
		c.getmListaPersonas().add(this);
	}

	public void quitarVivienda(Vivienda c) {
		mListaViviendas.remove(c);
		c.getmListaPersonas().remove(this);
	}
	
	@Override
	public int hashCode() {
		return  mDni.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Persona other = (Persona) obj;
		return mDni.equals(other.mDni);
	}

	public Persona() {
		super();
	}
	public Persona(String mDni, String mNombre) {
		super();
		this.mDni = mDni;
		this.mNombre = mNombre;
	}

	public int getmIdPlaza() {
		return mIdPlaza;
	}

	public void setmIdPlaza(int mIdPlaza) {
		this.mIdPlaza = mIdPlaza;
	}

	public String getmDni() {
		return mDni;
	}

	public void setmDni(String mDni) {
		this.mDni = mDni;
	}

	public String getmNombre() {
		return mNombre;
	}

	public void setmNombre(String mNombre) {
		this.mNombre = mNombre;
	}

	public Set<Vivienda> getmListaViviendas() {
		return mListaViviendas;
	}

	public void setmListaViviendas(Set<Vivienda> mListaViviendas) {
		this.mListaViviendas = mListaViviendas;
	}

	@Override
	public String toString() {
		return "Persona [mIdPlaza=" + mIdPlaza + ", mDni=" + mDni + ", mNombre=" + mNombre + "]";
	}

	

	

}
