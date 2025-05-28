package cap01;

import java.util.Scanner;

/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */


/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 * @author Iñaki Martin
 */

/**
 * Realizar un programa que pida al usuario dos números, correspondientes a un número de mes (del 1 al 12)
 * y de un número de día (del 1 al 30). Calcular el número de días completos que faltan hasta el día de
 * Nochevieja (suponer que vivimos en un remoto planeta donde todos los meses del año tienen 30 días)
 */
public class Jyoc_Ejercicio_1_c_03 {
     public static void main(String[] args) {

          
          Scanner objetoScanner = new Scanner(System.in);
          System.out.println("Indíque un numero de dia: ");
          int dia = objetoScanner.nextInt();
          System.out.println("Indíque un numero de mes: ");
          int mes = objetoScanner.nextInt();

          int diasfaltan =  30-dia;
          int mesfaltan =  12-mes;
          diasfaltan = mesfaltan*30 + diasfaltan;


          System.out.println("Dias que faltan a fin de año: "+diasfaltan);
     }
}
