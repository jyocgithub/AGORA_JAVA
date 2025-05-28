package estructuras_dinamicas.lista_dinamica_doble_centinelas;

public class NodoListaCentinelas<T>  {
	T info;
	NodoListaCentinelas prev,next;

	public NodoListaCentinelas(T info) {
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