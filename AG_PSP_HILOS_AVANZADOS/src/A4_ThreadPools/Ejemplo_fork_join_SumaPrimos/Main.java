package A4_ThreadPools.Ejemplo_fork_join_SumaPrimos;
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

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Crea un proyecto usando ForkJoinPool que calcule la suma de los números primos del 1 al 1000000.
// El proyecto debe tener una clase que extienda RecursiveTask y otra clase que contenga el main.
// Debes usar el método fork y join para dividir el trabajo.
// El rango máximo de la tarea ForkJoinPool debe ser 1000.
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        SumaPrimos tarea = new SumaPrimos(1, 1_000_000);

        long resultado = pool.invoke(tarea);

        System.out.println("La suma de los números primos del 1 al 1.000.000 es: " + resultado);
    }
}

class SumaPrimos extends RecursiveTask<Long> {
    private static final int UMBRAL = 1000;
    private long inicio, fin;

    public SumaPrimos(long inicio, long fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Long compute() {
        if (fin - inicio <= UMBRAL) {
            return calcularSumaPrimosDirecta();
        }

        long mitad = (inicio + fin) / 2;

        SumaPrimos tarea1 = new SumaPrimos(inicio, mitad);
        SumaPrimos tarea2 = new SumaPrimos(mitad + 1, fin);

        tarea1.fork();
        long resultado2 = tarea2.compute();
        long resultado1 = tarea1.join();

        return resultado1 + resultado2;
    }

    private long calcularSumaPrimosDirecta() {
        long suma = 0;
        for (long i = Math.max(2, inicio); i <= fin; i++) {
            if (esPrimo(i)) {
                suma += i;
            }
        }
        return suma;
    }

    private boolean esPrimo(long numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }

        long limite = (long) Math.sqrt(numero);
        for (long i = 5; i <= limite; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}