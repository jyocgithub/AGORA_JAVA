import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Libro.buscarLibrosCaros", query="SELECT c FROM Libro c WHERE c.precio > :preciominimo")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String titulo;
	private String autor;
	private int precio;

	public Libro(long id, String titulo, String autor, int precio) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public Libro() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "AddressBook{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", autor='" + autor + '\'' +
				", precio=" + precio +
				'}';
	}
}