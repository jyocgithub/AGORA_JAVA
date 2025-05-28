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
 * Capitulo 1 Ejercicio a_2
 * Pedir el radio de una circunferencia y calcular su longitud. L=2*PI*r.
 */
public class Jyoc_Ejercicio_1_a_02 {

    public static void main(String[] args) {
        System.out.println("\n\n Ejercicio 1.2\n\n");

        final double PI = 3.14;

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el valor del radio y pulse INTRO:");
        int radio = sc.nextInt();

        System.out.println("La circunferencia del circulo es " + (2 * PI * radio));
    }

}
