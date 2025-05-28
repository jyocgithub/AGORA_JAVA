package cap03;

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
 * @author Iñaki Martin
 */

/**
 * Programa que pide a usuario 6 números positivos comprendidos entre el 10 y 50,
 * ambos inclusive. En el caso en el que algún número introducido
 * no se encontrara dentro del rango de 10 a 50,
 * se mostrará un mensaje de error y seguirá pidiendo números.
 * El programa finalizará cuando se hayan introducido 6 números
 * válidos y mostrará el número máximo introducido de los 6 válidos.
 * Además indicará cuántos números de los introducidos no han sido válidos.
 */

public class Jyoc_Ejercicio_3_b_06 {

     public static void main(String[] args) {
          final int CANTIDADDENUMEROS=6;
          Scanner sc = new Scanner(System.in);
          int n, totalNumeros = 0, sumaNoValidos = 0, maximo = 0;
          while (totalNumeros < CANTIDADDENUMEROS) {
               System.out.println("Indique un numero:");
               n = sc.nextInt();
               if (n < 10 || n > 50) {
                    sumaNoValidos++;
                    System.out.println("Numero no valido");
               } else {
                    totalNumeros++;
                    if (n > maximo) {
                         maximo = n;
                    }
               }
          }
          System.out.println("El mayor numero elegido ha sido:" + maximo);
     }
}
