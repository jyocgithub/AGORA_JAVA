package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio c_2
 * Pedir un número de 4 cifras y decir si es capicúa.
 */
public class Jyoc_Ejercicio_2_c_02 {

    public static void main(String[] args) {

        Scanner objetoScanner = new Scanner(System.in);
        System.out.println("Indíque un numero de 4 cifras: ");
        int numero = objetoScanner.nextInt();

        int cifra4 = numero % 10;
        numero = (int) numero / 10;
        int cifra3 = numero % 10;
        numero = (int) numero / 10;
        int cifra2 = numero % 10;
        numero = (int) numero / 10;
        int cifra1 = numero;
        boolean escapicua = true;


        System.out.println(cifra4);
        System.out.println(cifra3);
        System.out.println(cifra2);
        System.out.println(cifra1);
        if (cifra4 != cifra1) escapicua = false;
        if (cifra3 != cifra2) escapicua = false;
        System.out.println("¿El numero es capicua? Respuesta:  " + escapicua);
    }
}
