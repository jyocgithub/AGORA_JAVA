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
 * Capitulo 3 Ejercicio b_12
 * Realizar un programa que pida por teclado al usuario dos números,
 * que serán el numerador y el denominador de una fracción.
 * Reducir luego la fracción a su mínima expresión,
 * y escribir la fracción resultante.
 * Por ejemplo, si se escriben 24 y 30, debe escribir “Fracción reducida: 4/5”
 */
public class Jyoc_Ejercicio_3_b_09 {

     public static void main(String[] args) {
          System.out.println("Indique un numero:");
          int n = new Scanner(System.in).nextInt();
          System.out.println("Indique otro numero:");
          int m = new Scanner(System.in).nextInt();

          System.out.println("Fraccion antigua: "+n+"/"+m);
          for (int i = 2; i < n; i++) {
               if(n%i==0 && m%i==0){
                    n=n/i;
                    m=m/i;
               }
          }
          System.out.println("Fraccion nueva: "+n+"/"+m);

     }
}
