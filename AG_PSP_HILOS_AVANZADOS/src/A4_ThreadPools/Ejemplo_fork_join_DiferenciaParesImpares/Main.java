package A4_ThreadPools.Ejemplo_fork_join_DiferenciaParesImpares;
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

// Crea un proyecto usando ForkJoinPool que calcule la suma de los números pares y la suma de los
// números impares del 1 al 1000000.
// El proyecto debe tener una clase que extienda RecursiveTask y otra clase que contenga el main.
// Debes usar el método fork y join para dividir el trabajo.
// El rango máximo de la tarea ForkJoinPool debe ser 1000.
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        SumaParImpar tarea = new SumaParImpar(1, 1_000_000);

        ResultadoSuma resultado = pool.invoke(tarea);

        System.out.println("La suma de los números pares del 1 al 1.000.000 es: " + resultado.getSumaPares());
        System.out.println("La suma de los números impares del 1 al 1.000.000 es: " + resultado.getSumaImpares());
    }
}

// Clase para almacenar el resultado de la suma de pares e impares
class ResultadoSuma {
    private final long sumaPares;
    private final long sumaImpares;

    public ResultadoSuma(long sumaPares, long sumaImpares) {
        this.sumaPares = sumaPares;
        this.sumaImpares = sumaImpares;
    }

    public ResultadoSuma combinar(ResultadoSuma otro) {
        return new ResultadoSuma(
                this.sumaPares + otro.sumaPares,
                this.sumaImpares + otro.sumaImpares
        );
    }

    public long getSumaPares() {
        return sumaPares;
    }

    public long getSumaImpares() {
        return sumaImpares;
    }
}

class SumaParImpar extends RecursiveTask<ResultadoSuma> {
    private static final int UMBRAL = 1000;
    private long inicio, fin;

    public SumaParImpar(long inicio, long fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected ResultadoSuma compute() {
        if (fin - inicio <= UMBRAL) {
            return calcularSumaDirecta();
        }

        long mitad = (inicio + fin) / 2;

        SumaParImpar tarea1 = new SumaParImpar(inicio, mitad);
        SumaParImpar tarea2 = new SumaParImpar(mitad + 1, fin);

        tarea1.fork();
        ResultadoSuma resultado2 = tarea2.compute();
        ResultadoSuma resultado1 = tarea1.join();

        return resultado1.combinar(resultado2);
    }

    private ResultadoSuma calcularSumaDirecta() {
        long sumaPares = 0;
        long sumaImpares = 0;

        for (long i = inicio; i <= fin; i++) {
            if (i % 2 == 0) {
                sumaPares += i;
            } else {
                sumaImpares += i;
            }
        }

        return new ResultadoSuma(sumaPares, sumaImpares);
    }
}