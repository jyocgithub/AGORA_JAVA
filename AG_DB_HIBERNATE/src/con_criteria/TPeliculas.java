package con_criteria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tpeliculas")
public class TPeliculas {

	@Id
	@Column(name = "titulo")
	String titulo;
	@Column(name = "genero")
	String genero;
	@Column(name = "duracion")
	int duracion;
	@Column(name = "actorprincipal")
	String actorprincipal;

	public TPeliculas() {

	}

	public TPeliculas(String titulo, String genero, int duracion, String actorprincipal) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.actorprincipal = actorprincipal;
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
