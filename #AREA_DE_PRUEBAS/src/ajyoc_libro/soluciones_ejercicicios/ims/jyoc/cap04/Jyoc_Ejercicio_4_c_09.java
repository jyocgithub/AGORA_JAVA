package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio c_9
 * Pedir 5 enteros por teclado (se supone que se introducen ordenados de forma creciente).
 * Los números los guardaremos en un vector de tamaño 6.
 * Imprimir el vector.
 * Pedir un nuevo número (que debe estar entre los numeros antes introducidos)
 * e insertarlo en el lugar adecuado para que el vector continúe ordenado.
 * Imprimir el nuevo vector resultante.
 */
public class Jyoc_Ejercicio_4_c_09 {
    public static void main(String[] args) throws IOException {

        int[] numeros = new int[6];

        int num = 0;
        System.out.println("\nIntroduzca varios numeros en ORDEN ASCENDENTE");

        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 5; j++) {
            System.out.println("\nIntroduzca numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }
        System.out.print("\nVECTOR ORIGINAL: ");
        for (int j = 0; j < 5; j++) {
            System.out.print(numeros[j] + " ");
        }

        int este = 0, oldeste = 0;
        System.out.println("\nIntroduzca un numero más a insertar en la serie:");
        int numinsertar = new Scanner(System.in).nextInt();
        boolean anadir = false;
        for (int j = 0; j < 6; j++) {
            if (!anadir) {
                if (numinsertar < numeros[j]) {
                    anadir = true;
                    este = numeros[j];
                    numeros[j] = numinsertar;
                }
            } else {
                oldeste = este;
                este = numeros[j];
                numeros[j] = oldeste;

            }
        }

        System.out.print("\nNUEVO ARRAY: ");
        for (int j = 0; j < 6; j++)
            System.out.print(numeros[j] + " ");

    }
}
