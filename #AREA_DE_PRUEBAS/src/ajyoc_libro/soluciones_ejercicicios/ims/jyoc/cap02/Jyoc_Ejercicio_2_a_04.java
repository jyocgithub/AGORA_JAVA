package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio a_4
 * Pedir dos números y mostrarlos ordenados de mayor a menor.
 */
public class Jyoc_Ejercicio_2_a_04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un numero y pulse INTRO:");
        int numero1 = sc.nextInt();
        System.out.println("Escriba un numero y pulse INTRO:");
        int numero2 = sc.nextInt();

        System.out.print("Numeros ordenados; ");
        if ((numero1 > numero2)) {
            System.out.println(numero1 + " " + numero2);
        } else {
            System.out.println(numero2 + " " + numero1);
        }
    }
}
