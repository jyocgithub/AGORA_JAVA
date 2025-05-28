package ioc.dam.m9.uf2.eac1.b4;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
// - Crea un proyecto usando ForkJoinPool que busque el valor mayor de un array de 10000 numeros 
// que se crea al principio de proyecto. 
// el rango m叩ximo de la tarea ForkJoinPool es de 200.
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }

        ForkJoinPool pool = new ForkJoinPool();
        BuscaMaximo tarea = new BuscaMaximo(array, 0, array.length);

        int maximo = pool.invoke(tarea);
        System.out.println("El valor máximo es: " + maximo);
    }
}
