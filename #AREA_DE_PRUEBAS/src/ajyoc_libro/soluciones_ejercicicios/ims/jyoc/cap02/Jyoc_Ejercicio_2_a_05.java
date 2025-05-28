package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio a_5
 * Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien...
 */
public class Jyoc_Ejercicio_2_a_05 {

    public static void main(String[] args) {

        System.out.println("\n\n Ejercicio 1.20\n\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba una nota:");
        int nota = sc.nextInt();
        if (nota < 5) {
            System.out.println("Suspenso");
        } else if (nota >= 5 && nota < 7) {
            System.out.println("Bien");
        } else if (nota >= 7 && nota < 9) {
            System.out.println("Notable");
        } else if (nota >= 9) {
            System.out.println("Sobresaliente");
        }

        // PROPUESTA: hacerlo ahora con Switch
    }
}
