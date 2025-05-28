package hibernate_N_M_increment_bidir.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "VIVIENDA")
@Table(name = "VIVIENDA")
public class Vivienda {
	@Id
	@Column(name = "ID_VIVIENDA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vivienda = 0;

	@Column(name = "TIPO")
	private String tipo;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="ViviendaPersona", joinColumns={@JoinColumn(name="id_vivienda_join")}, inverseJoinColumns={@JoinColumn(name="id_persona_join")})
	private Set<Persona> mListaPersonas = new HashSet<Persona>();

	public void agregarPersona(Persona c) {
		mListaPersonas.add(c);
		c.getmListaViviendas().add(this);
	}

	public void quitarPersona(Persona c) {
		mListaPersonas.remove(c);
		c.getmListaViviendas().remove(this);
	}

	public Vivienda() {
	}

	public Vivienda(String tipo) {
		super();
		this.tipo = tipo;
	}

	public int getId_vivienda() {
		return id_vivienda;
	}

	public void setId_vivienda(int id_vivienda) {
		this.id_vivienda = id_vivienda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Vivienda [" + id_vivienda + ", " + tipo + ", " + mListaPersonas + "]";
	}

	public Set<Persona> getmListaPersonas() {
		return mListaPersonas;
	}

	public void setmListaPersonas(Set<Persona> mListaPersonas) {
		this.mListaPersonas = mListaPersonas;
	}

	
	
	
}