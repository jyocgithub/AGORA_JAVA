
public class PruebaNodo {

	public static void main(String[] args) {
		Nodo<String, Double> objconstring = new Nodo<>("popiop", 234.0);
		// objconstring.contenido = "ñlkkjhfc ";
		//
		// Integer ij = 1234;
		// int k = ij;
		// ij = 23423;
		//
		// Nodo<Integer, String> objconint = new Nodo<>();
		// objconint.contenido = 23254;
	}
}

class Nodo<T, W> {

	private T contenido;
	private W copia;

	public Nodo(T contenido, W copia) {
		this.contenido = contenido;
		this.copia = copia;
		System.out.println(contenido.getClass());

	}

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}

	public T getContenido() {
		return contenido;
	}

	public void setCopia(W copia) {
		this.copia = copia;
	}

	public W getCopia() {
		return copia;
	}

	/**
	 * el método public void intercambiaAB() Que intercambia los valores de los atributos contenido y copia.
	 */

	public void intercambiaAB() {

		T aux = contenido;
		contenido = (T) copia;
		copia = (W) aux;

	}
}
