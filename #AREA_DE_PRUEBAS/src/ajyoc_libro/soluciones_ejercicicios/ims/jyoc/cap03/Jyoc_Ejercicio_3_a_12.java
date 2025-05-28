package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_12
 * Realizar un programa que pida al usuario dos números,
 * correspondientes a un numero de mes (del 1 al 12) y de un numero de día
 * (del 1 al 30). Calcular el numero de días completos que faltan hasta
 * el día de Nochevieja (suponer que todos los meses del año tienen 30 días)
 */
public class Jyoc_Ejercicio_3_a_12 {

    public static void main(String[] args) {
        int mes, dia;
        int contador = 0;

        System.out.println("Indique un numero de mes :");
        mes = new Scanner(System.in).nextInt();
        System.out.println("Indique un numero de dia");
        dia = new Scanner(System.in).nextInt();
        int diasQueFaltan = 0;
        int mesesQueFaltan = 0;
        if (mes == 12) {
            diasQueFaltan = 25 - dia;

        } else {
            diasQueFaltan = 30 - dia;
            mesesQueFaltan = 11 - mes;
            diasQueFaltan = diasQueFaltan + (mesesQueFaltan * 30) + 25;
        }
        System.out.println(diasQueFaltan);

    }
}

