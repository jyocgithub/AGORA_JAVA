package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 2
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio a_10
 * Escribir un programa que lea tres enteros y que emita un mensaje que indique
 * si están o no en orden numérico creciente.
 */
public class Jyoc_Ejercicio_2_a_10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un 1er numero :");
        int num1 = sc.nextInt();
        System.out.println("Escriba un 2do numero :");
        int num2 = sc.nextInt();
        System.out.println("Escriba un 3er numero :");
        int num3 = sc.nextInt();

        if (num1 > num2 && num2 > num3) {
            System.out.print("Estan en orden creciente");
        } else {
            System.out.print("NO estan en orden creciente");
        }
    }
}
