package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_1
 * Leer un número e indicar si es positivo o negativo y si es par o impar..
 * El proceso se repetirá hasta que se introduzca un 0.
 */
public class Jyoc_Ejercicio_3_a_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba un numero y pulse INTRO");
        int num = sc.nextInt();
        while (num != 0) {

            if (num % 2 == 0) {
                System.out.print("El numero es par");

            } else {
                System.out.print("El numero es impar");

            }
            if (num > 0) {
                System.out.println(" y positivo");

            } else {
                System.out.println(" y negativo");

            }
            System.out.println("\nEscriba un numero y pulse INTRO");
            num = sc.nextInt();
        }
    }
}
