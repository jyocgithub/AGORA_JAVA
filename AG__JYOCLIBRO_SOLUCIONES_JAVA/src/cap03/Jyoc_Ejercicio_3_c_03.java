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
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio b_05
 * Hacer un nuevo programa que pida un numero, y nos diga el primer
 * numero primo mas grande que el numero introducido.
 */
public class Jyoc_Ejercicio_3_c_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, sig;
        System.out.println("Indique un numero:");
        n = sc.nextInt();
        sig = n;
        boolean seguir = true;
        boolean esprimo;
        while (seguir) {
            esprimo = true;
            sig++;
            for (i = 2; i < sig; i++) {
                if (sig % i == 0) {
                    esprimo = false;
                }
            }
            if (esprimo) {
                seguir = false;
            }
        }
        System.out.println("El primo siguiente es:" + sig);


        // version 2 de la solucion
        System.out.println("Indique un numero:");
        n = sc.nextInt();
        int contador = n + 1;
        boolean hayDivisores = true;
        for (; hayDivisores; contador++) {
            hayDivisores = false;
            for (int j = 2; j < contador && !hayDivisores; j++) {
                if ((contador % j) == 0) {
                    hayDivisores = true;
                }
            }
        }
        contador--;
        System.out.println(" El primer número primo tras " + n + " es " + contador);

    }
}
