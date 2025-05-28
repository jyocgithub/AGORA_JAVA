package estructuras_dinamicas.pila_dinamica;

/**
 * PILA DINAMICA 
 * Una pila dinámica, al contrario que una estática, no se
 * almacena en una coleccion de elementos, si no que simplemente es un grupo de
 * elementos (que llamaremos nodos).
 * Se sabe qué elemento es el ultimo de la pila, y cada elemento sabra quien
 * es el elemento que esta "debajo" de el. 
 * 
 * La informacion que necesitamos es : 
 * (A) saber que nodo es el que esta encima de la pila. 
 * (B) saber de cada nodo que otro nodo tiene debajo. 
 * 
 * Para trabajar con pilas dinamicas tenemos que usar: 
 * (1) una clase Nodo, que tiene la informacion a guardar y la referencia del 
 *     nodo que esta debajo, y 
 * (2) una clase PilaDinamica, que contiene los metodos y atributos para
 *     crear una pila de nodos
 * 
 * En el nodo almacenamos alguna informacion, de la que no definimos
 * el tipo, por lo que hacemos la clase generica, que tenga el patron T que
 * sustituiremos en el futuro al crear la clase.
 */
public class TAD_PilaDinamica<T> {

    /**
     * Atributo nodoCima. es el nodo que esta en la nodoCima de la pila
     */
    private NodoPila nodoCima;

    /**
     * Constructor que crea la pila, y como no hay aun nodos, el nodoCima lo
     * pone como null. Este nodo null sera el de mas abajo de la pila, y
     * existira como la "base" de la pila, aunque no tendra informacion
     */
    public TAD_PilaDinamica() {
        nodoCima = null;
    }

    /**
     * esvacia() Metodo que indica si la pila esta vacia, lo que obtiene
     * preguntando si el nodoCima es null
     */
    public boolean esVacia() {
        return nodoCima == null;
    }

    /**
     * cuantosElementosHay() Metodo que devuelve el numero de elementos que
     * tiene la pila Para ello, parte del nodoCima, y mira si tiene algun nodo
     * anterior, y si lo tiene, mira si este tiene tambien a su vez un anterior,
     * y si lo hay, si hay otro anterior, y asi sucesivamente, y contando cada
     * nodo para saber cuantos hay
     */
    public int cuantosElementosHay() {
        // inicialmente pensamos que no hay nodos
        int numeroDeNodos = 0;

        // Creamos un nodo ficticio, al que asignamos el nodoCima
        NodoPila ptr = nodoCima;

        // Si el nodo ficticio no es null, entramos a mirar en el bucle
        while (ptr != null) {
            // como el nodo no es null, es que tiene informacion, aumentamos
            // el contados de nodos
            numeroDeNodos++;
            // hacemos que el nodo ficticio ahora sea el anterior del que 
            // estamos analizando, y asi en la siguiente vuelta veremos si este 
            // a su vez tiene alguno anterior. 
            // Si no (si no tiene anterior, es que es el nodo base, el nodo
            // null del principio de la pila), acabamos el bucle
            ptr = ptr.anterior;
        }
        // devolvemos el contador calculado
        return numeroDeNodos;
    }

    /**
     * top() Metodo que nos devuelve la informacion del nodo que
     * esta en la cima, pero sin eliminar el nodo de la pila El return necesita
     * un casting, pues el metodo devuelve un objeto de tipo T
     */
    public T top() {

        return (T) nodoCima.informacion;

    }

    /**
     * push() Metodo que añade un elemento a la pila. El metodo recibe como
     * parametro la informacion que se va a almacenar en el elemento de la pila
     */
    public void push(T nuevaInformacion) {
        // se crea un objeto nuevo, y al constructor se le pasa:
        // 1.la nueva informacion que ha de almacenar
        // 2.como segundo parametro (que en un nodo es "el nodo anterior a mi")
        //   el pasamos el que hasta ahora era el nodo cima, que ya no lo sera, 
        //   sino que sera el "anterior" al nuevoCima
        NodoPila nuevoNodo = new NodoPila(nuevaInformacion, nodoCima);
        // Ahora el nuevoCima es el nuevo nodo creado
        nodoCima = nuevoNodo;
    }


    /**
     * pop() Metodo q elimina el nodo de la cima y
     * ademas devuelve su informacion
     */
    public T pop() {
        T resultado = null;
        if (! esVacia()) {                                    // si esta vacia devolvera null, simplemente
            resultado = (T) nodoCima.informacion;         //cojo la informacion del ultimo nodo
            nodoCima = nodoCima.anterior;         //el nuevo ultimoNodo es el nodoAnterior del que era ultimoNodo
        }
        return resultado;                                       // deveulvo el resultado
    }

    /**
     * vaciar() Metodo que vacia una pila. Para ello, simplemente indica que el
     * nodoCima nuevamente sea null. Los nodos existentes no se eliminan de
     * memoria, pero la pila no puede volver a recuperarlos, por lo que es como
     * si no existieran
     */
    public void vaciar() {
        nodoCima = null;
    }

    /**
     * toString() Pinta toda la pila desde el ultimo elemento al primero
     */
    public String toString () {
        String resultado = "[";
        NodoPila unNodo = nodoCima;
        while (unNodo != null) {
            resultado = resultado + unNodo.informacion.toString ();
            if (unNodo.anterior != null) {
                resultado = resultado + " -> ";
            }
            unNodo = unNodo.anterior;
        }
        return resultado+"]";
    }



}
