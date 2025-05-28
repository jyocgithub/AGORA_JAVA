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
 * Escribe un programa que pide un número entero mayor de  100 y nos diga cuál es la última cifra de dicho número,
 * y nos diga también dicho número sin la ultima cifra
 * <p>
 */
public class Jyoc_Ejercicio_1_a_08 {

     public static void main(String[] args) {


          Scanner objetoScanner10 = new Scanner(System.in);
          System.out.println("Indíque un numero mayor de 100");
          int numero = objetoScanner10.nextInt();
          int ultimodigito = numero % 10;
          int numsinultimodigito = numero / 10;

          System.out.println("El ultimo digito es " + ultimodigito);
          System.out.println("El numoer sin el ultimo digito es " + numsinultimodigito);
     }
}
