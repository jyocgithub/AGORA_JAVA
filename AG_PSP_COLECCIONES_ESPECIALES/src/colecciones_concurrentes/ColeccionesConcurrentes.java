package colecciones_concurrentes;
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
/*
No bloquean toda la colección/cola, sino hay mililocks por elemento
Pueden acceder múltiples hilos simultáneamente a leer, pero sólo se permiten escrituras simultáneas en posiciones diferentes.
Una colección concurrente no usa el lock completo del objeto, sino que usa un grupo de "minilocks" que crea ella misma.
Cada hilo que accede puede tomar un "minilock" y accede simultáneamente a la colección (los métodos son thread-safe (atómicos),
pero si hay más de un procesador, pueden ejecutarse varios a la vez).
Por defecto se crean 16 "segmentos" con sus correspondientes "minilocks",
aunque se puede modificar el numero en el constructor de la colección

Dependen de una buena implementacion del metodo hashValue()

Sus métodos son Thread-safe
Cuidado, que no quiere decir que puedan usarse en consumidores y productores alegremente,
ni en otras operaciones donde se contemplen más de una llamada a métodos o acciones en la colección:
acciones mas complejas como "comprobar y actualizar" deben incluirse en métodos sincronizados,
pues se atomiza cada método, pero no lo que ocurra durante las llamadas entre ellos


 */
import java.util.concurrent.*;

public class ColeccionesConcurrentes {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> miList = new CopyOnWriteArrayList<>();
        ConcurrentSkipListSet<String> miList2 = new ConcurrentSkipListSet<>();

        CopyOnWriteArraySet<String> miSet = new CopyOnWriteArraySet<>();

        ConcurrentHashMap<Integer,String> mimap = new ConcurrentHashMap<>();
        ConcurrentSkipListMap<Integer,String> mimap2 = new ConcurrentSkipListMap<>();

        ConcurrentLinkedQueue<String> miQueue = new ConcurrentLinkedQueue<>();

    }


}
