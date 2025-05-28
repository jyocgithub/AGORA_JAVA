package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio e_01
 * Realiza un programa que pida números enteros desde teclado para rellenar un vector bidimensional de  tamaño 5x5,
 * y mostrar la matriz creada y la suma de cada fila y de cada columna
 */
public class Jyoc_Ejercicio_4_e_01 {
    public static void main(String[] args) {

        int numFilas = 5;
        int numCol = 5;
        int sumafilas = 0, sumacolumnas = 0;
        int[][] numeros1 = new int[numFilas][numCol];

        System.out.println("\nSolicitud de numeros para rellenar el vector matriz 1");
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print("Escriba un numero para fila " + f + " y columna " + c + " : ");
                numeros1[f][c] = new Scanner(System.in).nextInt();
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(numeros1[f][c] + "\t");
            }
            System.out.println();
        }

        // sumamos las filas
        for (int f = 0; f < numFilas; f++) {
            sumafilas = 0;
            for (int c = 0; c < numCol; c++) {
                sumafilas = sumafilas + numeros1[f][c];
            }
            System.out.println("la suma de la fila " + f + " es " + sumafilas);
        }
        // sumamos las columna, invirtiendo el orden de los for (primero col y luego filas)
        for (int c = 0; c < numCol; c++) {
            sumacolumnas = 0;
            for (int f = 0; f < numFilas; f++) {
                sumacolumnas = sumacolumnas + numeros1[f][c];
            }
            System.out.println("la suma de la columna " + c + " es " + sumacolumnas);
        }


    }
}
