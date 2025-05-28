package hibernate_1_1_noincrement_unidir_joincolumn.pojos;

import javax.persistence.*;

@Entity(name = "DIRECCION")
@Table(name = "DIRECCION")
public class Direccion {
	@Id
	@Column(name = "ID_DIRECCION")
	private int id_dir;

	@Column(name = "CALLE")
	private String calle;

	public Direccion(int id_dir, String calle) {
		super();
		this.id_dir = id_dir;
		this.calle = calle;
	}

	public Direccion() {

	}

	public int getId_dir() {
		return id_dir;
	}

	public void setId_dir(int id_dir) {
		this.id_dir = id_dir;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@OneToOne(mappedBy = "direccion", optional = false)
	private Vivienda vivienda;

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}
}