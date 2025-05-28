package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio a_4
 * Realiza un programa que lea desde teclado 11 números enteros,
 * para posteriormente mostrarlos en el orden inverso al que fueron introducidos
 */
public class Jyoc_Ejercicio_4_a_04 {
    public static void main(String[] args) {
        Scanner objetoScanner = new Scanner(System.in);
        int[] numeros = new int[11];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Indíque un numero ");
            int t = objetoScanner.nextInt();
            numeros[i] = t;
        }

        System.out.println("Mostrandose en orden inverso: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }
}
