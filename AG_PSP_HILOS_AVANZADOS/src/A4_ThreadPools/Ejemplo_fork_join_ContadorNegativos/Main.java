package A4_ThreadPools.Ejemplo_fork_join_ContadorNegativos;


import java.util.Random;
import java.util.concurrent.ForkJoinPool;
// - Crea un proyecto usando ForkJoinPool que cuente cuantos valores negativos en un array
// de 5000 numeros entre -100 y 100 que se crea al principio de proyecto.
// el rango máximo de la tarea ForkJoinPool es de 200.
public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[5000];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(201) - 100; // valores entre -100 y 100
        }

        ForkJoinPool pool = new ForkJoinPool();
        ContadorNegativos tarea = new ContadorNegativos(numeros, 0, numeros.length);

        int resultado = pool.invoke(tarea);

        System.out.println("Cantidad de números negativos: " + resultado);
    }
}
