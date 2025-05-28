
package estructuras_estaticas;

/**
 * La clase Nodo se puede usar tanto en una pila dinamica como en una 
 * cola dinamica.
 * Contiene el elemento que se almacena, y ademas, una referencia al elemento 
 * que esta "debajo" o "detras" de él mismo (le llamamos "anterior")
 * @author iniaski
 * @param <T> 
 */

public class NodoListaDoble<T> {

        // En el nodo almacenamos alguna informacion, de la que no definimos el
        // tipo, lo hacemos generico
        T informacion;
        // Guardamos tambien el nodo anterior a este, en la cola o la pila 
        NodoListaDoble anterior;

        /**
         * Constructor normal de un nodo
         */
        public NodoListaDoble(T elemento, NodoListaDoble anterior) {
            informacion = elemento;
            anterior = anterior;
        }
    }