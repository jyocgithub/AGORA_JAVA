package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio c_1
 * Pedir un número y calcular su factorial.
 */
public class Jyoc_Ejercicio_3_c_01 {

    public static void main(String[] args) {
        int num;
        int factorial = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Ecribe un numero: ");
        num = input.nextInt();
        for (int i = 2; i <= num; i++) {
            factorial = factorial * i;
        }

        System.out.println("Factorial de " + num + " es " + factorial);
    }
}
