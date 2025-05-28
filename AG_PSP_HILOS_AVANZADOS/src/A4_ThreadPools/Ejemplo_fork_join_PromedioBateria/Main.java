package ioc.dam.m9.uf2.eac1.b4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
// Se dispone de una lista de 1000 de objetos de la clase Dispositivo (cada dispositivo con atributos batería, modelo y marca). 
// Nuestro objetivo es calcular el porcentaje de batería promedio de todos los dispositivos registrados en la lista, 
// usando hilos bajo el patron "divide y venceras", con un rango máximo de 100 para hacer suma de un bloque. 
// Usa ForkJoinPool y RecursiveTask. 

public class Main {
    public static void main(String[] args) {
        List<Dispositivo> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int bateria = random.nextInt(101); // 0 a 100
            lista.add(new Dispositivo(bateria, "Modelo" + i, "Marca" + i));
        }

        ForkJoinPool pool = new ForkJoinPool();
        PromedioBateria tarea = new PromedioBateria(lista, 0, lista.size());

        double promedio = pool.invoke(tarea);
        System.out.printf("Promedio de batería: %.2f%%\n", promedio);
    }
}
