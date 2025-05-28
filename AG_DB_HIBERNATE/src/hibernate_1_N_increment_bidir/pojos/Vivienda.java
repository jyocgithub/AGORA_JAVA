package hibernate_1_N_increment_bidir.pojos;

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
	
	@OneToMany(mappedBy = "mVivienda", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<PlazaGarage> mListaPlazas = new HashSet<PlazaGarage>();

	public void agregarPlazaGarage(PlazaGarage c) {
		mListaPlazas.add(c);
		c.setmVivienda(this);
	}

	public void quitarPlazaGarage(PlazaGarage c) {
		mListaPlazas.remove(c);
		c.setmVivienda(null);
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
		return "Vivienda [" + id_vivienda + ", " + tipo + ", " + mListaPlazas + "]";
	}

	
	
	
}