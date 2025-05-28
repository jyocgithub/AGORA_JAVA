package hibernate_0_1_incremental.inicio;

import javax.persistence.*;

@Entity
@Table(name = "tablapeliculas")
public class Tablapeliculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@Column(name = "titulo")
	String titulo;

	@Column(name = "genero")
	String genero;

	@Column(name = "duracion")
	int duracion;

	@Column(name = "actorprincipal")
	String actorprincipal;

	public Tablapeliculas() {

	}

	public Tablapeliculas(int id, String titulo, String genero, int duracion, String actorprincipal) {
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.actorprincipal = actorprincipal;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getActorprincipal() {
		return actorprincipal;
	}

	public void setActorprincipal(String actorprincipal) {
		this.actorprincipal = actorprincipal;
	}
}
