package estructuras_estaticas;

/**
 * COLAS
 * Una cola es un grupo de elementos que se puede imaginar puestos en forma de
 * la fila de un cine, uno tras otro, teniendo conocimiento de quien es el
 * primero y el ultimo.
 * En estas estructuras,los elementos se van añadiendo uno a uno por el final
 * de la misma, mientras que se van extrayendo (saliendo) uno a uno por el
 * principio de la cola
 *
 * Los elementos de la cola cumplen el formato FIFO de actualizacion, esto es,
 * First In First Out, el primer elemento añadido es el primero que se extrae
 *
 */
/**
 * COLA ESTATICA
 * Una cola estática es una cola que se almacena en una coleccion de elementos,
 * que puede ser un array estatico
 * La informacion que necesitamos es :
 * (A) cuantos elementos hay en el array
 *
 * Para trabajar con colas estaticas solo usamos una clase, la de la propia
 * cola, que contiene como atributo el array de elementos
 *
 * Al ser el array una estructura estatica, hay que tener cuidado de no
 * sobrepasar el limite del tamaño del array al aincorporar elementos. En este
 * ejemplo, cuando un array se llena, se "duplica" su espacio para que puedan
 * almacenar mas elementos.
 *
 * En referencia a qué información se almacena en el array, se podria haber
 * optado por hacer una clase ColaEstatica que almacenara String, otra para Int,
 * otra para otra cosa... o hacer una clase que almacene cualquier tipo de
 * objeto, usando la funcionalidad de clases genericas,
 * que es la opcion que se ha tomado en el ejercicio
 *
 */
public class TAD_ColaEstatica<T> {

    /**
     * Se crea un contenedor (colaDeElementos), donde meter los elementos
     * El contenedor no es de un tipo definido, sino que se deja como tipo genérico
     * T, de modo que cuando se cree luego un objeto de ColaEstática, se decida
     * qué tipo de dato va a ser T y por lo tanto, que se va a almacenar en la
     * cola. Un ejemplo de como se tendria que declarar la clase en el futuro si
     * quisieramos almacenar numeros enteros;
     * ColaEstatica<Ingeger> miCola = new ColaEstatica<>();
     * Observar que NO se pueden almacenar tipos primitivos, solo objetos...
     */
    private T[] colaDeElementos;
    /**
     * Numero de elementos que contiene en cada momento la cola
     */
    int numElementosEnLaCola;

    /**
     * Constructor de ColaEstatica sencillo, solo lleva como parametro el tamaño
     * con el que se contruye la cola. Solo construye la Cola. La anotacion
     * SuppressWarnings("unchecked") (esta y siguientes) es opcional, no se
     * analiza en este ejercicio.
     */
    @SuppressWarnings("unchecked")
    public TAD_ColaEstatica() {
        colaDeElementos = (T[]) new Object[4];
        numElementosEnLaCola = 0;
    }

    /**
     * Constructor de ColaEstatica con un parametro de tipo cola, para copiar
     * esta cola que se le pasa en la cola que se esta creando
     */
    @SuppressWarnings("unchecked")
    public TAD_ColaEstatica(TAD_ColaEstatica<T> cola) {
        /**
         * Igual que en el otro constructor, se crea aqui la cola con el mismo
         * tamaño que tiene la cola que se recibe como parametro Luego con un
         * for se recorre esta cola y se copia elemento a elemento en la nueva
         * cola que estamos construyendo
         */
        colaDeElementos = (T[]) new Object[cola.colaDeElementos.length];
        for (int i = 0; i < cola.colaDeElementos.length; i++) {
            colaDeElementos[i] = cola.colaDeElementos[i];
        }
        // actualizamos el numero de elementos de la cola nueva con el 
        // numero de elementos de la cola parametro

        numElementosEnLaCola = cola.numElementosEnLaCola;

    }
    /**
     * cuantosElementosHay() Metodo que indica cuantos elementos hay en la cola
     */
    public int cuantosElementosHay() {
        return numElementosEnLaCola;
    }

    /**
     * esVacia() Metodo que devuelve un boolean, true si la cola esta vacia,
     */
    public boolean esVacia() {
        // la cola esta vacia si el numero de elementos es 0
        return numElementosEnLaCola == 0;

    }

    /**
     * primero() Metodo que devuelve el primer elemento de la cola, pero NO lo 
     * elimina
     */
    public T primero() {
        if (esVacia()) {
            return null;
        }
        return colaDeElementos[0];
    }

    /**
     * anadir() Meodo para añadir un elemento a la cola, elemento que se pasa
     * como parametro
     */
    public void anadir(T elem) {
        // Comprobamos si la cola esta llena, si lo esta, la ampliamos
        if (numElementosEnLaCola == colaDeElementos.length) {
            ampliarCola();
        }
        // metemos en la posicion numElementosEnLaCola el elemento que añadimos
        // pues esta variable nos vale tambien 
        colaDeElementos[numElementosEnLaCola] = elem;
        // ahora debemos tener un elemento mas en la cola
        numElementosEnLaCola++;
    }
    
    /**
     * extraer() Metodo que quita el primer elemento de la cola y devuelve dicho
     * elemento
     */
    public T extraer() {
        // guardamos el primer elemento de la cola
        T elementoASacar = colaDeElementos[numElementosEnLaCola - 1];
        // Con un bucle recolocamos la cola, haciendo que el segundo elemento de
        // la misma pase a ser ahora el primero, que el tercero pase a ser 
        // segundo, etc
        for (int i = 0; i < numElementosEnLaCola - 1; i++) {
            colaDeElementos[i] = colaDeElementos[i + 1];
        }
        // descontamos el numero de elementos de la cola
        numElementosEnLaCola--;
        // el metodo devuelve el que era el primer elemento de la cola
        return elementoASacar;

    }
    /**
     * vaciar() Elimina los elementos de la cola. Lo que hace realemtne es
     * indicar que no hay elementos en la cola, de modo que cuando se añadan
     * elementos en el futuro iran sustituyendo a los antiguos
     */
    public void vaciar() {
        numElementosEnLaCola = 0;
    }

    /**
     * ampliar() Duplica el tamaño de la cola actual.
     */
    public void ampliarCola() {
        @SuppressWarnings("unchecked")
        // Como la cola esta llena, creo un nuevo array del tipo T (el que se 
        // define en el futuro) con un tamaño del doble del array actual
        T[] aux = (T[]) new Object[colaDeElementos.length * 2];

        // recorro el bucle actual lo y copio elemento a elemento en el 
        // nuevo array que me he creado
        for (int i = 0; i < colaDeElementos.length; i++) {
            aux[i] = colaDeElementos[i];
        }
        // mi array sera, finalmente, el nuevo array creado, que tendra el 
        // doble de tamaño y añadidos los elementos que ya tenia 
        colaDeElementos = aux;
    }
}

// VERSION QUE TIENE FRENTE Y FIN COMO REFERENCIAS DE LA COLA    
//    public void extraer() {     
//        if (numElementosEnLaCola == 1) {
//            numElementosEnLaCola--;
//            frente = 0;
//            fin = 0;
//        } else {
//            frente = (frente + 1) % colaDeElementos.length;
//            numElementosEnLaCola--;
//        }
//    }
