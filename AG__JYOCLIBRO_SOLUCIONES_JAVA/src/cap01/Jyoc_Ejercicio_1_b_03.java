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
 *
 * @author Iñaki Martin
 */

/**
 * Un alumno tiene dos exámenes para hacer media en una asignatura.
 * Pedir un número por teclado correspondiente a la nota del primer examen de un alumno.
 * Calcular y mostrar qué nota minima ha de sacar en el segundo examen para alcanzar una media de 5
 * <p>
 * MEJORA; Hay que tener en cuenta que la nota del primer examen cuenta
 * el 40% y la del segundo examen un 60%
 * <p>
 */
public class Jyoc_Ejercicio_1_b_03 {

    public static void main(String[] args) {
        Scanner objetoScanner8 = new Scanner(System.in);

        System.out.println("Indíque un numero de la primera nota: ");
        int nota = objetoScanner8.nextInt();

        int segundoexamen = 10 - nota;

        System.out.println("La nota minima es " + segundoexamen);

        // MEJORA
        int segundoexamen2 = 500 - (nota*60) / 40;
        System.out.println("La nota minima del segundo examen si vale un 40% ha de ser de " + segundoexamen2);

    }

}
