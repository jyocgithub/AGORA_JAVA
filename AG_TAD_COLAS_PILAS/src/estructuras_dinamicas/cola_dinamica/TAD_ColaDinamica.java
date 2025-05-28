package estructuras_dinamicas.cola_dinamica;

/**
 * COLA DINAMICA
 * Una cola dinámica, al contrario que una estática, no se
 * almacena en una coleccion de elementos, si no que simplemente es un grupo de
 * elementos (que llamaremos nodos).
 * Se sabe qué elemento es el primero de la cola, y cada elemento sabra quien
 * es el elemento que esta "detras" de el en la cola.
 *
 * La informacion que necesitamos es :
 * (A) saber que nodo es el que esta el primero de la cola.
 * (B) saber de cada nodo que otro nodo tiene detras.
 *
 * Para trabajar con colas dinamicas tenemos que usar:
 * (1) una clase Nodo, que tiene la informacion a guardar y la referencia del
 * nodo que esta debajo, y
 * (2) una clase ColaDinamica, que contiene los metodos y atributos para
 * crear una cola de nodos
 *
 * En el nodo almacenamos alguna informacion, de la que no definimos
 * el tipo, por lo que hacemos la clase generica, que tenga el patron T que
 * sustituiremos en el futuro al crear la clase.
 */
public class TAD_ColaDinamica<T> {

    /**
     * Atributo primerNodo. es el nodo que esta el primero de la cola
     */
    private NodoCola primerNodo;

    /**
     * Constructor que crea la cola, y como no hay aun nodos, el primerNodo lo
     * pone como null. Este nodo null sera el "primero" de la cola, y
     * existira como la "cabeza" de la cola, aunque no tendra informacion, ni se
     * extraera nunca
     */
    public TAD_ColaDinamica() {
        primerNodo = null;
    }

    /**
     * size() Metodo que devuelve el numero de elementos que
     * tiene la cola
     * Para ello, parte del primerNodo, y mira si tiene algun nodo
     * detras, y si lo tiene, mira si este tiene tambien a su vez un anterior,
     * y si lo hay, si hay otro anterior, y asi sucesivamente, y contando cada
     * nodo para saber cuantos hay
     */
    public int size() {

        int res = 0;
        NodoCola aux = primerNodo;

        while (aux != null) {
            aux = aux.siguiente;
            res++;
        }
        return res;
    }

    /**
     * esvacia() Metodo que indica si la cola esta vacia, lo que obtiene
     * preguntando si el primerNodo es null
     */
    public boolean isEmpty() {
        return primerNodo == null;
    }

    /**
     * enqueue() Metodo que añade un elemento a la cola. El metodo recibe como
     * parametro la informacion que se va a almacenaren el elemento nuevo
     */

    public void enqueue(T elem) {
        if (primerNodo == null) {
            primerNodo = new NodoCola(elem, null);
        } else {
            // creamos un nuevo nodo con la informacion que se pasa al metodo
            // que sera el que se vaya a añadir a la cola
            NodoCola nuevoNodo = new NodoCola(elem, null);
            // cogemos el primer nodo y lo guardamos en un nodo que llamamos
            // "analizar" precisamente para analizarlo despues
            NodoCola analizar = primerNodo;
            // vamos viendo si este nodo "analizar" tiene algun nodo antes en
            // la cola, y si lo tiene, analizar pasa a ser ese nodo anterior
            while (analizar.siguiente != null) {
                analizar = analizar.siguiente;
            }
            // cuando el nodo analizar ya no tiene nadie detras, entonces le
            // decimos a ese nodo que el que tiene detras ahroa es el nuevo
            // nodo que queremos añadir
            analizar.siguiente = nuevoNodo;
        }

    }

    /**
     * extraer() Metodo que devuelve el primer nodo de la cola, y lo elimina
     * de esta
     */
    public NodoCola dequeue() {
        if(primerNodo==null) {
            return null;
        }
        // guardamos cual es el primer nodo
        NodoCola elPrimero = primerNodo;
        // indicamos que ahora el primer nodo es el siguiente al que era
        // anterior al primer nodo
        primerNodo = primerNodo.siguiente;
        // devolvemos el que guardamos que era el primer nodo
        return elPrimero;

    }
    /**
     * front() Metodo que nos devuelve la informacion del nodo que
     * esta primero en la cola, pero SIN eliminar el nodo. El return necesita
     * un casting, pues el metodo devuelve un objeto de tipo T
     */
    public T front() {
        if(primerNodo==null) {
            return null ;
        }
        return (T) primerNodo.informacion;

    }



    /**
     * vaciar() Metodo que vacia una cola. Para ello, simplemente indica que el
     * primerNoxdo nuevamente sea null. Los nodos existentes no se eliminan de
     * memoria, pero la cola no puede volver a recuperarlos, por lo que es como
     * si no existieran
     */
    public void empty() {
        primerNodo = null;
    }


    /**
     * toString() Pinta toda la cola desde el primer elemento al ultimo
     */
    public String toString () {
        String resultado = "[";
        NodoCola unNodo = primerNodo;
        while (unNodo != null) {
            resultado = resultado + unNodo.informacion.toString ();
            if (unNodo.siguiente != null) {
                resultado = resultado + " -> ";
            }
            unNodo = unNodo.siguiente;
        }
        return resultado+"]";
    }


}
