package ioc.dam.m9.uf2.eac1.b4;

import java.util.concurrent.RecursiveTask;
import java.util.List;

public class PromedioBateria extends RecursiveTask<Double> {
    private static final int UMBRAL = 100;
    private final List<Dispositivo> dispositivos;
    private final int inicio, fin;

    public PromedioBateria(List<Dispositivo> dispositivos, int inicio, int fin) {
        this.dispositivos = dispositivos;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Double compute() {
        if (fin - inicio <= UMBRAL) {
            double suma = 0;
            for (int i = inicio; i < fin; i++) {
                suma += dispositivos.get(i).getBateria();
            }
            return suma / (fin - inicio);
        }

        int mitad = (inicio + fin) / 2;
        PromedioBateria tarea1 = new PromedioBateria(dispositivos, inicio, mitad);
        PromedioBateria tarea2 = new PromedioBateria(dispositivos, mitad, fin);

        tarea1.fork();
        double prom2 = tarea2.compute();
        double prom1 = tarea1.join();

        return (prom1 + prom2) / 2;
    }
}
