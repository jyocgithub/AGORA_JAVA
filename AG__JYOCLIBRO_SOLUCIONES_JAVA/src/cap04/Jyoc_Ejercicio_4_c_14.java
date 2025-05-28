package cap04;
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
/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio c_13
 * Si se tiene un conjunto de valores positivos ordenados, se define la mediana
 * como “el valor que ocupa la posición central de los datos dados”. Por ejemplo, en la serie:
 * 1  3  4  6  7  9  12
 * la mediana corresponde al numero 6
 * En el caso de tener un número impar de valores, la mediana esta clara: será aquel valor que tenga
 * el mismo numero de valores mas pequeños y mas grandes que él en la serie.
 * En el caso de tener un número par de valores, habrá dos candidatos a ser mediana.
 * En este caso vamos a considerar que la mediana viene dada por la suma de esos
 * dos valores que ocupan las posiciones centrales.
 * El programa a realizar pedirá al usuario inicialmente cuantos números va a tener una serie,
 * y luego, preguntara por cada número de la serie (todos han de ser números enteros positivos).
 * Posteriormente, calculara y mostrará la mediana de la serie.
 * No se puede hacer la mediana si el array tiene menos de dos elementos
 * Recordar que la serie ha de estar ordenada para el calculo de la mediana, hay que ordenarlos
 */
public class Jyoc_Ejercicio_4_c_14 {
    public static void main(String[] args)  {

        System.out.println("\nIndique el tamaños del vector a crear");
        int tamano = new Scanner(System.in).nextInt();
        if (tamano<2){
            System.out.println("\nNo se puede hacer la mediana con menos de 2 elementos");
            System.exit(0);  // esta instruccion acaba el programa actual
        }
        int[] numeros = new int[tamano];
        int num = 0;
        for (int j = 0; j < tamano; j++) {
            System.out.println("\nIntroduzca numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }

        // ordenamos la serie. Podemos hacerlo por metodo como la burbuja,
        // pero aprovechamnos aqui para incluir una opcion que ofrece java.
        // No es del gusto de profesores, pero la incluimos para conocer su existencia.
        Arrays.sort(numeros);

        int mediana;
        // vemos si la serie tiene tamaño par o impar
        if (numeros.length % 2 == 0) {
            // tiene tamaño par
            mediana = ((numeros[numeros.length / 2]) + (numeros[numeros.length / 2 -1] )) ;
        } else {
            mediana = numeros[numeros.length / 2];
        }
        System.out.print("\nMediana: " + mediana);

    }
}
