package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio c_03
 * Pedir un número entre 30 y 90, y mostrarlo escrito. Por ejemplo, para 56 mostrar: cincuenta y seis.
 */
public class Jyoc_Ejercicio_2_c_03 {

    public static void main(String[] args) {

        System.out.println("\n\n Ejercicio 1.25\n\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba un numero de 2 cifras:");
        int num = sc.nextInt();


        if (num == 90) {
            System.out.print("Noventa");

        } else {

            int cifra1 = (int) num / 10;
            int cifra2 = num % 10;

            if (cifra1 == 3) {
                System.out.print("Treinta");
            }
            if (cifra1 == 4) {
                System.out.print("Cuarenta");
            }
            if (cifra1 == 5) {
                System.out.print("Cincuenta");
            }
            if (cifra1 == 6) {
                System.out.print("Sesenta");
            }
            if (cifra1 == 7) {
                System.out.print("Setenta");
            }
            if (cifra1 == 8) {
                System.out.print("Ochenta");
            }

            if (cifra2 == 1) {
                System.out.println(" y uno");
            }
            if (cifra2 == 2) {
                System.out.println(" y dos");
            }
            if (cifra2 == 3) {
                System.out.println(" y tres");
            }
            if (cifra2 == 4) {
                System.out.println(" y cuatro");
            }
            if (cifra2 == 5) {
                System.out.println(" y cinco");
            }
            if (cifra2 == 6) {
                System.out.println(" y seis");
            }
            if (cifra2 == 7) {
                System.out.println(" y siete");
            }
            if (cifra2 == 8) {
                System.out.println(" y ocho");
            }
            if (cifra2 == 9) {
                System.out.println(" y nueve");
            }
        }
    }
}
