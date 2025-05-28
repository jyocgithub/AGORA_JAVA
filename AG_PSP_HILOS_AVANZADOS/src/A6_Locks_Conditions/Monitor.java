package A6_Locks_Conditions;
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

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor<E> {

    Lock lock = new ReentrantLock();
    Condition estaLLeno = lock.newCondition();
    Condition estaVacio = lock.newCondition();

    ArrayList<E> listaElementos = new ArrayList<>();
    int tamanomaximo = 3;

    public void poner(E x, String quien) throws InterruptedException {
        System.out.println(quien + " intento lock");
        lock.lock();
        System.out.println(quien + " lock agarrado");
        try {
            while (listaElementos.size()==tamanomaximo) {
                estaLLeno.await();
                System.out.println(quien + " esta lleno, a esperar...");
            }
            listaElementos.add(x);
            System.out.println("   Puesto en Monitor el mensaje " + x);
            System.out.println("   monitor queda :  " + listaElementos);

            estaVacio.signal();
        } finally {
            lock.unlock();
            System.out.println(quien + " lock soltado");
        }
    }

    public E sacar(String quien) throws InterruptedException {
        System.out.println(quien + " intento lock");
        lock.lock();
        System.out.println(quien + " lock agarrado");
        try {
            while (listaElementos.size() == 0) {
                estaVacio.await();
                System.out.println(quien + " esta vacio, a esperar...");
            }
            E x = (E) listaElementos.get(0);
            System.out.println("Saco del Monitor el mensaje " + x);
            listaElementos.remove(0);
            System.out.println("   monitor queda :  " + listaElementos);
            estaLLeno.signal();
            return x;
        } finally {
            lock.unlock();
            System.out.println(quien + " lock soltado");
        }
    }
}