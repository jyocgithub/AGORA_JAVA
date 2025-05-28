package A4_ThreadPools.Ejemplo_fork_join_SumaRango;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// - Crea un proyecto usanfo ForkJoinPool que calcule la suma de los números del 1 al 1000000.
// El proyecto debe tener una clase que extienda RecursiveTask y otra clase que contenga el main. 
// Debes usar el método invokeAll para invocar la tarea ForkJoinPool. 
// El rango máximo de la tarea ForkJoinPool debe ser 1000.
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        SumaRango tarea = new SumaRango(1, 1_000_000);

        long resultado = pool.invoke(tarea);

        System.out.println("La suma del 1 al 1.000.000 es: " + resultado);
    }
}


class SumaRango extends RecursiveTask<Long> {
    private static final int UMBRAL = 1000;
    private long inicio, fin;

    public SumaRango(long inicio, long fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Long compute() {
        if (fin - inicio <= UMBRAL) {
            return calcularSumaDirecta();
        }

        long mitad = (inicio + fin) / 2;

        SumaRango tarea1 = new SumaRango(inicio, mitad);
        SumaRango tarea2 = new SumaRango(mitad + 1, fin);

        tarea1.fork();
        long resultado2 = tarea2.compute();
        long resultado1 = tarea1.join();

        return resultado1 + resultado2;
    }

    private long calcularSumaDirecta() {
        long suma = 0;
        for (long i = inicio; i <= fin; i++) {
            suma += i;
        }
        return suma;
    }
}
