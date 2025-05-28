package A4_ThreadPools.Ejemplo_fork_join_ContadorNegativos;

import java.util.concurrent.RecursiveTask;

public class ContadorNegativos extends RecursiveTask<Integer> {
    private static final int UMBRAL = 200;
    private final int[] array;
    private final int inicio, fin;

    public ContadorNegativos(int[] array, int inicio, int fin) {
        this.array = array;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Integer compute() {
        if (fin - inicio <= UMBRAL) {
            return contarNegativosDirectamente();
        }

        int mitad = (inicio + fin) / 2;

        ContadorNegativos tarea1 = new ContadorNegativos(array, inicio, mitad);
        ContadorNegativos tarea2 = new ContadorNegativos(array, mitad, fin);

        tarea1.fork();
        int resultado2 = tarea2.compute();
        int resultado1 = tarea1.join();

        return resultado1 + resultado2;
    }

    private int contarNegativosDirectamente() {
        int contador = 0;
        for (int i = inicio; i < fin; i++) {
            if (array[i] < 0) {
                contador++;
            }
        }
        return contador;
    }
}
