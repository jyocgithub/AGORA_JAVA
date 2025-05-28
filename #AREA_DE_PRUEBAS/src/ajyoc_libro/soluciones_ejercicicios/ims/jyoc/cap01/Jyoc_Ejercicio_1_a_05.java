package soluciones_ejercicicios.ims.jyoc.cap01;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 1 Ejercicio a_5
 * ¿Cuál es el resultado de evaluar cada una de las
 * siguientes expresiones que usan h? ¿Qué valor tiene x al final de
 * todas las acciones? (Suponemos que se ejecutan todas seguidas)
 * <p>
 * boolean h;
 * int x=1;
 * h = (x > 1) & (x++ < 10)   //caso a
 * h = (1 >= x) && ( 1 < x++) //caso b
 * h = (1 == x) | (10 > x++) //caso c
 * h = (2 == x) || (10 > x++) //caso d
 * x = (++x) + x; //caso e
 * x = x + (++x) //caso f
 *
 */
public class Jyoc_Ejercicio_1_a_05 {

    public static void main(String[] args) {

        System.out.println("\n\n Ejercicio 1.6\n\n");
        boolean h;
        int x = 1;
        h = (x > 1) & (x++ < 10); // caso a
        h = (1 >= x) && (1 < x++); // caso b
        h = (1 == x) | (10 > x++); // caso c
        h = (2 == x) || (10 > x++); // caso d
        x = (++x) + x; // caso e
        x = x + (++x); // caso f

        System.out.println("En el caso (a), la variable h es :" + false);
        System.out.println("En el caso (b), la variable h es :" + false);
        System.out.println("En el caso (c), la variable h es :" + false);
        System.out.println("En el caso (d), la variable h es :" + false);
        System.out.println("En el caso (e), la variable x es :" + 10);
        System.out.println("En el caso (f), la variable x es :" + 21);
    }
}
