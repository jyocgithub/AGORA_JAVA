package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio d_06
 * Crear dos vectores bidimensionales de 3 x 3 y rellenarlos con números enteros solicitados al usuario por teclado.
 * (la suma se obtiene sumando los elementos de las dos matrices que ocupan la misma misma posición)
 * Crear un nuevo vector que sea la suma de los dos anteriores. Mostrar el resultado
 */
public class Jyoc_Ejercicio_4_d_06 {
    public static void main(String[] args) {

        int numFilas = 3;
        int numCol = 3;
        int[][] numeros1 = new int[numFilas][numCol];
        int[][] numeros2 = new int[numFilas][numCol];
        int[][] suma = new int[numFilas][numCol];

        System.out.println("\nSolicitud de numeros para rellenar el vector matriz 1");
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print("Escriba un numero para fila " + f + " y columna " + c + " : ");
                numeros1[f][c] = new Scanner(System.in).nextInt();
            }
        }
        System.out.println("\nSolicitud de numeros para rellenar el vector matriz 2");
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print("Escriba un numero para fila " + f + " y columna " + c + " : ");
                numeros2[f][c] = new Scanner(System.in).nextInt();
            }
        }

        // rellenamos la matriz suma
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                suma[f][c] = numeros1[f][c] + numeros2[f][c];
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(suma[f][c] + "\t");
            }
            System.out.println();
        }
    }
}
