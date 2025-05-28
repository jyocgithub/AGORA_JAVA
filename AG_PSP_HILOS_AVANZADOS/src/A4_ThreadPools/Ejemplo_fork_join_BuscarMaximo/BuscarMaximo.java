package ioc.dam.m9.uf2.eac1.b4;

import java.util.concurrent.RecursiveTask;

public class BuscaMaximo extends RecursiveTask<Integer> {
    private static final int UMBRAL = 200;
    private final int[] array;
    private final int inicio, fin;

    public BuscaMaximo(int[] array, int inicio, int fin) {
        this.array = array;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Integer compute() {
        if (fin - inicio <= UMBRAL) {
            int max = Integer.MIN_VALUE;
            for (int i = inicio; i < fin; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }

        int mitad = (inicio + fin) / 2;
        BuscaMaximo tarea1 = new BuscaMaximo(array, inicio, mitad);
        BuscaMaximo tarea2 = new BuscaMaximo(array, mitad, fin);

        tarea1.fork();
        int max2 = tarea2.compute();
        int max1 = tarea1.join();

        return Math.max(max1, max2);
    }
}
