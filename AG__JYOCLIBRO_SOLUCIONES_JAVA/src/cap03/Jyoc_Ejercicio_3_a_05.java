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
 * Capitulo 3 Ejercicio a_9
 * Programa que pide por teclado dos números, numNotas y numMinima.
 * numNotas es el número de calificaciones que van posteriormente a pedir, y
 * numMinima una nota mínima que se va a controlar luego.
 * Hacer un bucle que le pida a los usuarios todas la calificaciones,
 * e indicar finalmente cuántas calificaciones han igualado o superado la nota mínima antes mencionada.
 */
public class Jyoc_Ejercicio_3_a_05 {

     public static void main(String[] args) {
          double numnotas = 0, notacorte = 0, nota;
          int contador = 0;

          Scanner sc = new Scanner(System.in);

          System.out.println("Indique un numero de notas:");
          numnotas = sc.nextDouble();
          System.out.println("Indique nota de corte:");
          notacorte = sc.nextDouble();

          for (int i = 0; i < numnotas; i++) {
               System.out.println("Indique la nota numero :" + (i + 1));
               nota = sc.nextInt();
               if (nota >= notacorte) {
                    contador++;
               }
          }

          System.out.println(contador + "  notas han igualado o superado el corte");
     }
}
