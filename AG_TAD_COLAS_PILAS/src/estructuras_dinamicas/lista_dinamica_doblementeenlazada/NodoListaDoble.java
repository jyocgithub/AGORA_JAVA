package estructuras_dinamicas.lista_dinamica_doblementeenlazada;

public class NodoListaDoble<T>  {
	T info;
	NodoListaDoble ant,sig;

	public NodoListaDoble(T info) {
		this.info = info;
	}
	public String toString() {
		if (info != null) {
			return info.toString();
		} else {
			return null;
		}
	}

}