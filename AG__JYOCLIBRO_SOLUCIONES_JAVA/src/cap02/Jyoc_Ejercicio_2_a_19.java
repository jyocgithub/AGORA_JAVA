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
 * @author Iñaki Martin
 */
/**
 * Capitulo 2 Ejercicio a_12
 * Pedir los coeficientes de una ecuación de 2o grado
 * y muestre sus soluciones reales. Si no existen, debe indicarlo.
 */
public class Jyoc_Ejercicio_2_a_19 {

     public static void main(String[] args) {

          Scanner objetoScanner3 = new Scanner(System.in);
          System.out.println("Indíque un valor para el coeficiente a : ");
          int a = objetoScanner3.nextInt();
          System.out.println("Indíque un valor para el coeficiente b : ");
          int b = objetoScanner3.nextInt();
          System.out.println("Indíque un valor para el coeficiente c : ");
          int c = objetoScanner3.nextInt();

          double discriminante = (b * b) - (4 * a * c);
          
          if (a == 0) {
               System.out.println("No existen soluciones");
          } else if (discriminante <0){
               System.out.println("No existen soluciones reales");
          }else{
               double numerador1 = -b + Math.sqrt(discriminante);
               double numerador2 = -b - Math.sqrt(discriminante);
               double denominador = 2 * a;
               double solu1 = numerador1 / denominador;
               double solu2 = numerador2 / denominador;
               System.out.println("Solucion 1: "+ solu1);
               System.out.println("Solucion 2: "+ solu2);
               
          }
     }
}
