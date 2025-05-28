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
 * Capitulo 1 Ejercicio b_2
 * Pide un número por teclado y muestra el carácter que le
 * corresponde en la tabla ASCII, p.e., si le doy 65, me muestra :"es una A”
 * <p>
 */
public class Jyoc_Ejercicio_1_b_02 {

    public static void main(String[] args) {
        Scanner objetoScanner8 = new Scanner(System.in);
        System.out.println("Indíque un numero ascii para un caracter: ");
        int numeroAscii = objetoScanner8.nextInt();
        char caracterAscii = (char) numeroAscii;
        System.out.println("El numero ASCII " + numeroAscii + " corresponde al caracter " + caracterAscii);
    }

}
