package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_8
 * Programa que lee 9 números,
 * y en el caso en el que el primero introducido sea igual al último,
 * nos muestra la media. En caso contrario, no se mostrará nada.
 */
public class Jyoc_Ejercicio_3_a_08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, primero = 0;
        for (int i = 0; i < 9; i++) {
            System.out.println("Indique un numero:");
            n = sc.nextInt();
            if (i == 0) {
                primero = n;
            }
        }

        if (primero == n) {
            System.out.println("primero y ultimo iguales, y la media es: " + ((primero + n) / 2));
        }

    }
}
