package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio d_03
 * Realiza un programa que cree un vector bidimensional de 6 x 4
 * y lo rellene con números enteros aleatorios de entre el 1 y el 10,
 * ambos inclusive.
 * Mostrar la matriz
 * Además se ha de mostrar el número de fila cuya
 * suma de sus elementos es la mayor. En caso de empate se mostrará
 * la primera fila
 */
public class Jyoc_Ejercicio_4_d_03 {
    public static void main(String[] args) {

        int numFilas = 6;
        int numCol = 4;
        int[][] numeros = new int[numFilas][numCol];
        int filamayor = 0;
        int sumamayor = 0;
        int sumaDeEstaFila = 0;
        Random r = new Random();
        // rellenamos la matriz
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                numeros[f][c] = r.nextInt(10) + 1;
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }

        // vemos que fila tiene la suma de elementos mayor
        for (int f = 0; f < numFilas; f++) {
            sumaDeEstaFila = 0;
            for (int c = 0; c < numCol; c++) {
                sumaDeEstaFila = sumaDeEstaFila + numeros[f][c];
            }
            // acabada de sumar una fila, comprobamos si es la mayor
            if (sumaDeEstaFila > sumamayor) {
                sumamayor = sumaDeEstaFila;
                filamayor = f;
            }
        }
        System.out.println("la fila con suma mayor es :" + filamayor + " que suma " + sumamayor);
    }
}
