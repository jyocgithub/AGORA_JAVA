/*
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar esta licencia
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar esta clase
 */
package ioc.dam.m9.uf2.eac1.b4;

/**
 * Clase que implementa un algoritmo paralelo para contar números primos
 * utilizando el framework Fork/Join de Java.
 * 
 * @author nel
 * 
 */
import java.util.concurrent.RecursiveTask;

public class BuscaNumerosPrimos extends RecursiveTask<Integer> {
    // Constante que determina cuándo un intervalo es lo suficientemente pequeño para procesarlo directamente
    private static final int UMBRAL = 1000;
    // Variables que definen el intervalo de números a analizar
    private int inicio, fin;

    public BuscaNumerosPrimos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Integer compute() {
        // Si el intervalo es pequeño, procesa directamente
        if (fin - inicio <= UMBRAL) {
            return cuentaNumerosPrimos();
        }

        // Si el intervalo es grande, lo divide en dos partes
        int mitad = (inicio + fin) / 2;

        // Crea dos subtareas, una para cada mitad del intervalo
        BuscaNumerosPrimos tarea1 = new BuscaNumerosPrimos(inicio, mitad);
        BuscaNumerosPrimos tarea2 = new BuscaNumerosPrimos(mitad, fin);

        // Ejecuta las subtareas
        tarea1.fork();
        tarea2.fork();

        // Combina resultados
        return tarea1.join() + tarea2.join();
    }

    /**
     * Cuenta el número de números primos en el intervalo especificado
     * 
     * @return Número de primos encontrados en el intervalo
     */
    private int cuentaNumerosPrimos() {
        int contador = 0;
        for (int num = inicio; num < fin; num++) {
            if (esPrimo(num)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Verifica si un número es primo
     * 
     * @param n Número a verificar
     * @return true si el número es primo, false en caso contrario
     */
    private boolean esPrimo(int n) {
        // Los números menores o iguales a 1 no son primos
        if (n <= 1) return false;
        // Comprueba divisores hasta la raíz cuadrada del número
        // Si no encuentra ningún divisor hasta este punto, el número es primo
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }  
}
