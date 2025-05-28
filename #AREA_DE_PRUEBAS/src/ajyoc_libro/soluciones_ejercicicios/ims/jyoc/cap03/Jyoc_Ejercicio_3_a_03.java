package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_3
 * Escribir todos los números del 100 al 0 de 7 en 7. 
 */
public class Jyoc_Ejercicio_3_a_03 {

    public static void main(String[] args) {
        for (int i = 100; i > 0; i = i - 7) {
            System.out.println(i);
        }
    }
}
