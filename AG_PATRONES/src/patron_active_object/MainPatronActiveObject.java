package patron_active_object;
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
Ejemplo
Un monstruo es un hilo que come o pasea.
En el main se crean varios monstruos y se les pide que coman o paseen
Pero la ejecucion del comer o pasear solo se pide, no se ejecuta en el propio hilo directamente
En cambio, se guardan las peticiones en una cola, y sera otro hiulo quien se encargue de
sacar las peticiones y ejecutarlas cuando le venga en gana.

Aqui se separa cuando se crea la peticion
(cuando un monstruo intenta comer o pasear)
de cuando se ejecuta realmente la peticion
(que se hace cuando se saca de la cola de peticiones,
que en este caso es incondicional,
pero podria gestionarse con muchas mas condiciones)
 */
public class MainPatronActiveObject {

    public static void main(String[] args) {
        Monstruo monstruo;
        try {
            for (int i = 0;i < 10;i++) {
                monstruo = new Monstruo("Troll "+i);
                monstruo.comer();
                monstruo.pasear();
            }
        } catch (InterruptedException e) {
           e.printStackTrace();
        }

    }
}

class Monstruo {
    // cola que va a contener los hilos (peticiones) que pueda hacer un monstruo
    private BlockingQueue<Runnable> colaDePeticiones;
    private String nombre;

    public void comer() throws InterruptedException {
        // pone en la cola de peticiones un hilo para que coma
        colaDePeticiones.put(new Runnable() {
                         @Override
                         public void run() {
                             System.out.println(nombre + " esta comiendo!");
                             System.out.println(nombre + " acaba de comer");
                         }
                     }
        );
    }

    public void pasear() throws InterruptedException {
        // pone en la cola de peticiones un hilo para que pasee
        colaDePeticiones.put(new Runnable() {
                         @Override
                         public void run() {
                             System.out.println(nombre + " esta paseando!");
                         }
                     }
        );
    }

    // constructor
    public Monstruo(String name) {
        this.nombre = name;
        this.colaDePeticiones = new LinkedBlockingQueue<Runnable>();

        // crea un hilo que simplemente, va a ir mirando si hay peticiones
        // pendientes, y ejecutandolas si es el caso.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // take() intenta coger algo, si existe en la cola, si no, espera
                        colaDePeticiones.take().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        );
        thread.start();
        // CIUDADO QUE ESTE HILO NO ACABA NUNCA, tal y como esta !!!
    }
}





