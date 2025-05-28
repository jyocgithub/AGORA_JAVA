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
 * Realiza un programa que pida una hora por teclado y que muestre
 * luego buenos días, buenas tardes o buenas noches según la hora.
 * Se utilizarán los tramos de 6 a 12, de 13 a 20 y de 21 a 5.
 * respectivamente. Sólo se tienen en cuenta las horas,
 * los minutos no se deben introducir por teclado.
 */
public class Jyoc_Ejercicio_2_a_06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el valor de la hora (solo al hora, sin minutos):");
        int hora = sc.nextInt();

        if (hora < 0 || hora > 24) {

            System.out.println("Hora incorrecta");

        } else {
            if (hora >= 6 && hora <= 12) {
                System.out.println("Buenos dias");
            } else if (hora >= 13 && hora <= 20) {
                System.out.println("Buenas tardes");
            }
            // este ultimo else no necesita el if necesariamente...
            // puede ser un else simplemente
            else if (hora >= 21 && hora <= 5) {
                System.out.println("Buenas noches");
            }
        }
    }

}
