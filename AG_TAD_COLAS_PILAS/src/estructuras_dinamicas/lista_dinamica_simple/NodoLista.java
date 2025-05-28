package estructuras_dinamicas.lista_dinamica_simple;

public class NodoLista<T>  {
	T valor;
	NodoLista nodoSiguiente;
	public NodoLista(T x){
		valor = x;
		nodoSiguiente = null;
	}



	@Override
	public String toString() {

		String res = "Nodo{	numero=" + valor + 	", nodoSiguiente=";
		if(nodoSiguiente==null){
			res +=	"null}";
		}else{
			res +=	nodoSiguiente.valor.toString() + "}";
		}
		return res;
	}
}