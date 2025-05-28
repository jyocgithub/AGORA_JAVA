package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.IOException;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio d_02
 * Realiza un programa que pida números enteros desde teclado para
 * rellenar un vector bidimensional de tamaño 3x2 .
 * Posteriormente el programa mostrará el vector introducido en formato
 * de filas y columnas y pedirá un número a buscar.
 * En caso de encontrarlo indicará el número de fila y columna
 * donde se ha encontrado por primera vez.
 * <p>
 * MEJORA 1: El programa nos preguntará si queremos seguir
 * buscando más números o no: “¿Desea seguir buscando números?(s/n)”.
 */
public class Jyoc_Ejercicio_4_d_02 {
    public static void main(String[] args) {

        int numFilas = 3;
        int numCol = 2;
        boolean seguir = true;
        int[][] numeros = new int[numFilas][numCol];

        do {
            System.out.println("\nSolicitud de numeros para rellenar el vector matriz");
            for (int f = 0; f < numFilas; f++) {
                for (int c = 0; c < numCol; c++) {
                    System.out.print("Escriba un numero para fila " + f + " y columna " + c + " : ");
                    numeros[f][c] = new Scanner(System.in).nextInt();
                }
            }

            // escribir el vector matriz resultante
            for (int f = 0; f < numFilas; f++) {
                for (int c = 0; c < numCol; c++) {
                    System.out.print(numeros[f][c] + "\t");
                }
                System.out.println();
            }

            System.out.print("Escriba un numero a buscar: ");
            int buscar = new Scanner(System.in).nextInt();
            for (int f = 0; f < numFilas; f++) {
                for (int c = 0; c < numCol; c++) {
                    if (numeros[f][c] == buscar) {
                        System.out.println("El numero se encuentra en la posicion fila: " + f + " y columna:" + c);
                    }
                }
            }

            System.out.print("¿ Desea seguir (1:si 0:no) ? ");
            int res = new Scanner(System.in).nextInt();
            if (res == 0) {
                seguir = false;
            }
        } while (seguir);

        System.out.print("Fin del programa");

    }
}
