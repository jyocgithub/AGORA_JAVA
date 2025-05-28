package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_2
 * Pedir por teclado un número (llamémosle num1),
 * y mostrar todos los números desde el 1 hasta num1
 */
public class Jyoc_Ejercicio_3_a_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un numero y pulse INTRO");
        int num1 = sc.nextInt();
        for (int i = 1; i <= num1; i++) {
            System.out.println(i);
        }
    }
}
