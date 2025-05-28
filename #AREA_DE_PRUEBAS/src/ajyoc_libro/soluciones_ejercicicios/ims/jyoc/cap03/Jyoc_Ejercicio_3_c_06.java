package soluciones_ejercicicios.ims.jyoc.cap03;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Scanner;

/**
 * Capitulo 3 Ejercicio c_6
 * Realizar un programa que pida la altura y la anchura de un rectángulo y lo dibuje con *.
 * Por ejemplo, si se da anchura 5 ya altura 4 se mostrará:
 * <p>
 * ****
 * *
 * *
 * ****
 */
public class Jyoc_Ejercicio_3_c_06 {

    public static void main(String[] args) {
        System.out.println("Alto del rectangulo: ");
        int alto = new Scanner(System.in).nextInt();
        System.out.println("Ancho del rectangulo: ");
        int ancho = new Scanner(System.in).nextInt();


        for (int i = 0; i < ancho; i++) {
            System.out.print("*");
        }
        System.out.println();


        for (int i = 0; i < alto - 2; i++) {
            System.out.print("*");
            for (int k = 0; k < ancho - 2; k++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }

        for (int i = 0; i < ancho; i++) {
            System.out.print("*");
        }
        System.out.println();


    }

}







