
package estructuras_dinamicas.pila_dinamica;

/**
 * La clase Nodo se puede usar tanto en una pila dinamica como en una
 * cola dinamica.
 * Contiene el elemento que se almacena, y ademas, una referencia al elemento
 * que esta "debajo" o "detras" de él mismo (le llamamos "anterior")
 *
 * @param <T>
 * @author iniaski
 */

public class NodoPila<T> {

    // En el nodo almacenamos alguna informacion, de la que no definimos el
    // tipo, lo hacemos generico
    T informacion;
    // Guardamos tambien el nodo anterior a este, en la cola o la pila
    NodoPila anterior;

    /**
     * Constructor normal de un nodo
     */
    public NodoPila(T elemento, NodoPila anterior) {
        informacion = elemento;
        this.anterior = anterior;
    }

    public String toString() {
        if (informacion != null) {
            return informacion.toString();
        } else {
            return null;
        }
    }


}