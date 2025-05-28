package colas_dinamicas;

/**
 * PILAS  
 * Una Pila es un grupo de elementos que se puede imaginar puestos en forma de 
 * pila, como una pila de libros desde el suelo. 
 * En estas estructuras, los elementos se van añadiendo por encima, y solo se 
 * conoce realmente el elemento que esta en la cima de la pila, que tambien 
 * es el unico que se puede extraer de la pila.
 * 
 * Los elementos de la pila cumplen el formato LIFO de actualizacion, esto es,
 * Last In First Out, el ultimo elemento añadido es el primero que se extrae
 * 
 */

 /** 
 * PILA ESTATICA 
 * Una pila estática es una pila que se almacena en una coleccion de elementos, 
 * que puede ser un array estatico 
 * La informacion que necesitamos es :
 * (A) cuantos elementos hay en el array
 * 
 * Para trabajar con pials estaticas solo usamos una clase, la de la propia 
 * pila, que contiene como atributo el array
 * 
 * Al ser el array una estructura estatica, hay que tener cuidado de no
 * sobrepasar el limite del tamaño del array al aincorporar elementos. En este
 * ejemplo, cuando un array se llena, se "duplica" su espacio para que pueda
 * almacenar mas elementos. 
 * 
 * En referencia a qué información se almacena en el array, se podria haber 
 * optado por hacer una clase PilaEstatica que almacenara String, otra para Int,
 * otra para otra cosa... o hacer una clase que almacene cualquier tipo de 
 * objeto, usando la funcionalidad de clases genericas, 
 * que es la opcion que se ha tomado en el ejercicio
 *
 */
public class TAD_PilaEstatica<T> {

    /**
     * Se crea un contenedor (pilaDeElementos), donde meter los elementos 
     * El contenedor no es de un tipo definido, sino que se deja como tipo genérico
     * T, de modo que cuando se cree luego un objeto de PilaEstática, se decida
     * qué tipo de dato va a ser T y por lo tanto, que se va a almacenar en la
     * pila. Un ejemplo de como se tendria que declarar la clase en el futuro si
     * quisieramos almacenar numeros enteros; 
     *          PilaEstatica<Ingeger> miPila = new PilaEstatica<>(); 
     * Observar que NO se pueden almacenar tipos primitivos, solo objetos...
     */
    private T[] pilaDeElementos;
    /**
     * Numero de elementos que contiene en cada momento la pila
     */
    private int numElementosEnLaPila;

    /**
     * Constructor de PilaEstatica sencillo, solo lleva como parametro el tamaño
     * con el que se contruye la pila Solo construye la Pila. La anotacion
     * SuppressWarnings("unchecked") (esta y siguientes) es opcional, no se
     * analiza en este ejercicio.
     */
    @SuppressWarnings("unchecked")
    public TAD_PilaEstatica(int tamano) {
        /**
         * Antes se ha declarado el contenedor, solo declarado, ahora se
         * construye Como no se sabe qué va a contener, se crea con un array de
         * la clase Object (que es la madre de todas las clases de java) y se
         * hace un casting al tipo T, que es el genérico que luego se sustituye
         * por uno definido. Observar que el casting es a un array de T, no
         * simplemente a T, pues lo que estamos creando es un array...
         */
        pilaDeElementos = (T[]) new Object[tamano];
        numElementosEnLaPila = 0;
    }

    /**
     * Constructor de PilaEstatica con un parametro de tipo pila, para copiar
     * esta pila que se le pasa en la pila que se esta creando
     */
    @SuppressWarnings("unchecked")
    public TAD_PilaEstatica(colas_dinamicas.TAD_PilaEstatica<T> pilaOrigen) {
        /**
         * Igual que en el otro constructor, se crea aqui la pila con el mismo
         * tamaño que tiene la pila que se recibe como parametro Luego con un
         * for se recorre esta pila y se copia elemento a elemento en la nueva
         * pila que estamos construyendo
         */
        pilaDeElementos = (T[]) new Object[pilaOrigen.pilaDeElementos.length];
        for (int i = 0; i < pilaOrigen.pilaDeElementos.length; i++) {
            pilaDeElementos[i] = pilaOrigen.pilaDeElementos[i];
        }

        // actualizamos el numero de elementos de la pila nueva con el 
        // numero de elementos de la pila parametro
        numElementosEnLaPila = pilaOrigen.numElementosEnLaPila;
    }

    /**
     * esVacia() Metodo que devuelve un boolean, true si la pila esta vacia,
     */
    public boolean esVacia() {

        // la pila esta vacia si el numero de elementos es 0
        return numElementosEnLaPila == 0;
    }

    /**
     * anadir() Meodo para añadir un elemento a la pila, elemento que se pasa
     * como parametro
     */
    public void anadir(T elem) {
        // Comprobamos si la pila esta llena, si lo esta, la ampliamos
        if (numElementosEnLaPila == pilaDeElementos.length) {
            ampliarPila();
        }
        // metemos en la posicion numElementosEnLaPila el elemento que añadimos
        // pues esta variable nos vale tambien 
        pilaDeElementos[numElementosEnLaPila] = elem;
        // ahora debemos tener un elemento mas en la pila
        numElementosEnLaPila++;
    }

    /**
     * extraer() Metodo que quita un elemento de la pila y devuelve dicho
     * elemento
     */
    public T extraer() {
        numElementosEnLaPila--;
        return pilaDeElementos[numElementosEnLaPila];
    }

    /**
     * cima() Metodo que devuelve el ultimo elemento de la pila, pero no lo
     * quita
     */
    public T cima() {
        return pilaDeElementos[numElementosEnLaPila - 1];
    }

    /**
     * cuantosElementosHay() Metodo que indica cuantos elementos hay en la pila
     */
    public int cuantosElementosHay() {
        return numElementosEnLaPila;
    }

    /**
     * tamanoDeLaPila() Metodo que indica el tamaño de la pila, esto es, el
     * numero máximo de elemtnos que se pueden almacenar, antes de que la pila
     * tenga que ampliarse
     */
    public int tamanoDeLaPila() {
        return pilaDeElementos.length;
    }

    /**
     * vaciar() Elimina los elementos de la pila. Lo que hace realemtne es
     * indicar que no hay elementos en la pila, de modo que cuando se añadan
     * elementos en el futuro iran sustituyendo a los antiguos
     */
    public void vaciar() {
        numElementosEnLaPila = 0;
    }

    /**
     * ampliar() Duplica el tamaño de la pila actual.
     */
    public void ampliarPila() {
        @SuppressWarnings("unchecked")
        // Como la pila esta llena, creo un nuevo array del tipo T (el que se 
        // define en el futuro) con un tamaño del doble del array actual
        T[] aux = (T[]) new Object[pilaDeElementos.length * 2];

        // recorro el bucle actual lo y copio elemento a elemento en el 
        // nuevo array que me he creado
        for (int i = 0; i < pilaDeElementos.length; i++) {
            aux[i] = pilaDeElementos[i];
        }
        // mi array sera, finalmente, el nuevo array creado, que tendra el 
        // doble de tamaño y añadidos los elementos que ya tenia 
        pilaDeElementos = aux;
    }
}
