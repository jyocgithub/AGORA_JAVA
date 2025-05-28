package colecciones_sincronizadas;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */


import java.util.*;

/*
COLECCIONES SINCRONIZADAS  (WRAPPING COLLECTIONS o SYNCHRONIZED WRAPPERS)

Bloquean toda la coleccion al hacer una lectura o escritura.
Cuando un hilo accede a hacer una operación, ningún otro hilo puede acceder a ninguna otra operación sobre la colección, hasta que el primero termine
Sus métodos no tienen por qué ser Thread-safe, pues al bloquear la colección, garantizan atomicidad.
Proporcionan mucha seguridad, pero con muchos hilos provocan mucha ineficiciencia
Lo que se crea realmente son List o Map O Set, pero "envueltos" con procedimientos de bloqueo.
Se programan los método normales del List, Map o Set elegido, sabiendo que ahora están sincronizados (y por lo tanto, son Thread-safe)

NOTAS:
El uso de colecciones sincronizadas es muy criticado por muchos programadores.
Estas colecciones lo que hacen es sincronizar cada uno de sus métodos, esto es, operaciones individuales.
Pero siendo sensatos, no es lo que normalmente se busca al asegurar la concurrencia
Normalmente, lo que se desea es sincronizar una secuencia de varias operaciones.
Sincronizar sólo una operación es muy poco seguro: imaginemos que estamos recorriendo un synchronizedList. En tal caso, necesitaremos de todos modos algún tipo de bloqueo para evitar que, mientras recorremos la colección, alguien la esté modificando por otro lado (lo que, si lo hacemos ademas con un iterator, nos va a dar un precioso ConcurrentModificationException)
Además, estas colecciones son bastante ineficientes, por lentas. Usándolas para lectura o inserción de varios elementos, estamos continuamente tomando y soltando el lock del objeto, cuando sería mucho mas eficiente (segun los casos, claro) tomar un único bloqueo y liberarlo tambien una sola vez
Para todos ellos, el uso de colecciones sincronizadas se debe realizar con mucho cuidado, y estrictamente en situaciones en las que sus desventajas se puedan convertir en beneficios, pero nunca por uso de una estructura simplemente mas cómoda de programar
Por otro lado, junto a la clases comentadas en este capitulo, existe ya desde hace mucho la clase Vector, que no es mas que un List sincronizado, al estilo de synchronizedList. No hemos hecho mucho hincapié en esta clase por que es comúnmente (aun que aún no oficialmente) considerada como "deprecated" (obsoleta). Casi todo el mundo cree que sólo se mantiene activa por compatibilidad con desarrollos antiguos de Java, pues synchronizedList (aun con sus defectos) es mucho mas recomendable.


 */
public class ColeccionesSincronizadas {

    public static void main(String[] args) {

        List L = Collections.synchronizedList(new ArrayList());

        Set s = Collections.synchronizedSet(new HashSet());

        Map m = Collections.synchronizedMap(new HashMap());

        Set ss = Collections.synchronizedSortedSet(new TreeSet());

        Map sm = Collections.synchronizedSortedMap(new TreeMap());


    }


}
