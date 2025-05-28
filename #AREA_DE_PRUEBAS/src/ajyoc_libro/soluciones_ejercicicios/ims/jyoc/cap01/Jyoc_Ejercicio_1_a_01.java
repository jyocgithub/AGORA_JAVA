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
 * Capitulo 1 Ejercicio a_1
 * Solicitar por teclado el radio de un círculo,
 * guardarlo en un int, y calcular el área del círculo.
 * El numero Pi se usa como una constante.
 */
public class Jyoc_Ejercicio_1_a_01 {


    public static void main(String[] args) {
        System.out.println("\n\n Ejercicio 1.1\n\n");

        final double PI = 3.14;

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el valor del radio y pulse INTRO:");
        int radio = sc.nextInt();

        double area = radio * radio + PI;
        System.out.println("El area del circulo es " + area);
    }
}
