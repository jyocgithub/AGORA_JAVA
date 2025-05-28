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

import java.io.IOException;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio a_15
 * Escribe un programa que pida al usuario rellenar un vector de enteros.
 * Después le pide por teclado dos números, el límite y el valor de
 * sustitución. El programa debe sustituir,  por el valor de sustitución,
 * todos los valores del vector que estén por encima del límite.
 * Finalmente debe mostrar el vector resultado. Ejemplo:
 * Vector: 2 5 34 53 2 -2
 * Límite: 3 Sustitución: 0
 * Resultado: 2 0 0 0 2 -2
 * … … …
 */

public class Jyoc_Ejercicio_4_a_11 {
    public static void main(String[] args) throws IOException {
        int[] numeros = new int[10];

        int num = 0;
        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 10; j++) {
            System.out.println("\nIntroduzca un numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }
        System.out.println("\nIntroduzca un numero limite:");
        int numlimite = new Scanner(System.in).nextInt();
        System.out.println("\nIntroduzca un numero de sustitucion:");
        int numsustitucion = new Scanner(System.in).nextInt();

        System.out.print("\n ARRAY ORIGINAL: ");
        for (int j = 0; j < 10; j++)
            System.out.print(numeros[j] + " ");

        // rellenamos array con valoresde sustitucion
        for (int j = 0; j < 10; j++) {
            if (numeros[j] > numlimite) {
                numeros[j] = numsustitucion;
            }
        }
        System.out.print("\n ARRAY CAMBIADO: ");
        for (int j = 0; j < 10; j++)
            System.out.print(numeros[j] + " ");
    }
}
