package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio b_01
 * Pedir un número entre 0 y 9.999 y decir cuantas cifras tiene.
 */
public class Jyoc_Ejercicio_2_b_01 {

    public static void main(String[] args) {
        Scanner objetoScanner1 = new Scanner(System.in);
        System.out.println("Indíque un numero (entre 0 y 9999): ");
        int numero1 = objetoScanner1.nextInt();
        int res = 0;
        if (numero1 > 999) {
            res = 4;
        } else if (numero1 > 99) {
            res = 3;
        } else if (numero1 > 9) {
            res = 4;
        } else {
            res = 1;
        }
        System.out.println("El numero tiene " + res + "cifras");

    }
}
