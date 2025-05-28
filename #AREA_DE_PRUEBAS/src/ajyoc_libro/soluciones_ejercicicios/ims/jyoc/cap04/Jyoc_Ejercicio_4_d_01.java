package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio d_01
 * Crear un vector bidimensional de tamaño 5x5 y rellenarlo de la siguiente forma:
 * la posición T[n,m] debe contener el valor de la suma n+m.
 * Después se debe mostrar el contenido del vector.
 */
public class Jyoc_Ejercicio_4_d_01 {
    public static void main(String[] args) {

        int[][] numeros = new int[5][5];
        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 5; c++) {
                numeros[f][c] = f + c;
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 5; c++) {
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }

    }
}
