package cap02;

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
 * Capitulo 2
 * <p>
 * @author Iñaki Martin
 */

/**
 * Usando Switch, escribir un programa que pida por teclado un numero de 1 a 10,
 * y nos diga si es par o impar.
 * Si el numero no esta comprendido entre 1 y 10, debe decir “Numero no válido”.
 */
public class Jyoc_Ejercicio_2_a_07 {

     public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          System.out.println("Escriba un numero del 1 al 10:");
          int num = sc.nextInt();

          switch (num){
               case 1:
               case 3:
               case 5:
               case 7:
               case 9: 
               System.out.println("Es ImPar");
                    break;
               case 2:
               case 4:
               case 6:
               case 8:
               case 10: 
               System.out.println("Es Par");
                    break;
               default:
               System.out.println("Número no válido, no es un numero entre 1 y 10");
                    
          }
     }
}
