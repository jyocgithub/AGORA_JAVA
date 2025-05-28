package colas_concurrentes_bloqueantes;
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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
BlockingQueue es una cola concurrente bloqueante
Son colas que, además de ser concurrentes, tienen métodos que bloquean el hilo ejecutor cuando están llenas (al intentar escribir) o vacías (al intentar extraer). Idóneas para problemas de tipo productor-consumidor.
En colas no bloqueantes, estas acciones o bien devuelven null o arrojan una exception, y no dejan el hilo en espera

Hay varias clases que implementan BlockingQueue con métodos muy parecidos a ConcurrentLinkedQueue.

LinkedBlockingQueue  y  LinkedBlockingDeQue
--------------------------------------------
Capacidad limitada opcionalmente.
Se provocan bloqueos por cola llena (si hay un máximo) y cola vacía
Basadas en nodos enlazados. L
inkedBlockingDeQue permite además sacar y poner por ambos lados de la cola"

ArrayBlockingQueue
--------------------------------------------
Capacidad limitada (una vez creada, no se puede cambiar).
Se provocan bloqueos por cola llena y cola vacía
Están construidas sobre arrays

SynchronousQueue
--------------------------------------------
Sin capacidad (cero elementos) Cada inserción espera por una extracción, y viceversa
Hay operaciones habituales que no se pueden hacer: peek(), no se puede iterar, no se puede ver si existe un elemento en la cola (contains), etc. "

PriorityBlockingQueue
--------------------------------------------
No tiene límite de elementos (capacidad ilimitada).
Se provocan bloqueos por cola vacía (por cola llena no, porque no hay límite)
Ordena los elementos en su orden natural (comparación)

DelayQueue
--------------------------------------------
No tiene límite de elementos.
Se provocan bloqueos por cola vacía o cuando no hay elementos extraibles
(es decir, aquellos para los cuales haya expirado el tiempo de retardo).
Por cola llena no hay bloqueos, porque no hay límite de tamaño
Los elementos que contiene deben extender la clase Delayed
Cada elemento sólo puede ser extraído después de transcurrido su tiempo de retardo


 */

// EJEMPLO DE PRODUCTOR CONSUMIDOR USANDO UNA BLOCKINGQUEUE

public class BlockingQueue_ProdCons_Ejemplo {

    public static void main(String args[]) {
        BlockingQueue q = new LinkedBlockingQueue(10); //Se puede usar otro tipo de cola
        Productor p = new Productor(q);
        Consumidor c1 = new Consumidor(q);
        Consumidor c2 = new Consumidor(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Productor implements Runnable {
    private BlockingQueue cola;
    private int i = 0;
    public Productor(BlockingQueue c) {
        cola = c;
    }
    public void run() {
        try {
            while (true) {
                String ficha = "Ficha " + (i++);
                System.out.println("Meto la " + ficha);
                cola.put(ficha); // Si cola llena, bloquea al hilo hasta que haya hueco
            }
        } catch (InterruptedException ex) {}
    }
}

class Consumidor implements Runnable {
    private final BlockingQueue cola;
    public Consumidor(BlockingQueue c) {
        cola = c;
    }
    public void run() {
        try {
            while (true) {
                System.out.println("Extraída: " + cola.take()); // Si cola vacía, bloquea al hilo hasta que haya algo
            }
        } catch (InterruptedException ex) {}
    }
}