package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Random;

/**
 * Capitulo 4 Ejercicio d_04
 * Crear un vector bidimensional de tamaño 7x7
 * y rellenarla de forma que los elementos de la diagonal principal sean 1 y el resto 0.
 */
public class Jyoc_Ejercicio_4_d_04 {
    public static void main(String[] args) {

        int numFilas = 7;
        int numCol = 7;
        int[][] numeros = new int[numFilas][numCol];
        // rellenamos la matriz
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                if (f == c) {
                    numeros[f][c] = 1;

                } else {

                    numeros[f][c] = 0;
                }
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }
    }
}
