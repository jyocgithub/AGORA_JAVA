package soluciones_ejercicicios.ims.jyoc.cap01;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 1 Ejercicio c_1
 * Pedir un número de 4 cifras y mostrarlo con las cifras al revés.
 */
public class Jyoc_Ejercicio_1_c_01 {
    public static void main(String[] args) {
        System.out.println("\n\n Ejercicio 1.12\n\n");

        Scanner objetoScanner = new Scanner(System.in);
        System.out.println("Indíque un numero de 4 cifras: ");
        int numero = objetoScanner.nextInt();

        int cifra4 = numero % 10;
        numero = (int) numero / 10;
        int cifra3 = numero % 10;
        numero = (int) numero / 10;
        int cifra2 = numero % 10;
        numero = (int) numero / 10;
        int cifra1 = numero;
        System.out.println("Numero al reves: " + cifra4 + cifra3 + cifra2 + cifra1);
    }
}
