package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Capitulo 4 Ejercicio a_9
 * Escribir en un papel el resultado del siguiente programa:
 * int[] cifras15 = { 4, 5, 6, 7, 8, 9 };
 * int[] numeros15 = { 12, 9, 11, 20, 40, 22, 44, 53, 2, 88, 23 };
 * <p>
 * System.out.println ("- parte 1 -----------------");
 * for (int x = 2; x <= 4; x++){
 * System.out.println (numeros15[x]);
 * }
 * <p>
 * System.out.println ("- parte 2 -----------------");
 * for (int k = 5; k >= 1; k—) {
 * System.out.println (numeros15[k]);
 * }
 * System.out.println ("- parte 3 -----------------");
 * for (int x = 3; x <= 5; x++) {
 * System.out.println ("///");
 * for (int k = 4; k >= 1; k—){
 * System.out.println (numeros15[k] + cifras15[x]);
 * }
 * }
 * System.out.println ("- parte 4 -----------------");
 * for (int x = 1; x <= 3; x++){
 * System.out.println (numeros15[cifras15[x]]);
 * }
 * System.out.println ("- parte 5 -----------------");
 * for (int x = 1; x <= 4; x++) {
 * for (int k = 1; k <= x; k++) {
 * System.out.print ("o");
 * }
 * System.out.println ("");
 * }
 */
public class Jyoc_Ejercicio_4_a_09 {
    public static void main(String[] args) throws IOException {
        int[] cifras15 = {4, 5, 6, 7, 8, 9};
        int[] numeros15 = {12, 9, 11, 20, 40, 22, 44, 53, 2, 88, 23};

        System.out.println("- parte 1 -----------------");
        for (int x = 2; x <= 4; x++) {
            System.out.println(numeros15[x]);
        }

        System.out.println("- parte 2 -----------------");
        for (int k = 5; k >= 1; k--) {
            System.out.println(numeros15[k]);
        }
        System.out.println("- parte 3 -----------------");
        for (int x = 3; x <= 5; x++) {
            System.out.println("---");
            for (int k = 4; k >= 1; k--) {
                System.out.println(numeros15[k] + cifras15[x]);
            }
        }
        System.out.println("- parte 4 -----------------");
        for (int x = 1; x <= 3; x++) {
            System.out.println(numeros15[cifras15[x]]);
        }
        System.out.println("- parte 5 -----------------");
        for (int x = 1; x <= 4; x++) {
            for (int k = 1; k <= x; k++) {
                System.out.print("o");
            }
            System.out.println("");
        }
//        - parte 1 -----------------
//        11
//        20
//        40
//        - parte 2 -----------------
//        22
//        40
//        20
//        11
//        9
//        - parte 3 -----------------
//        ---
//        47
//        27
//        18
//        16
//        ---
//        48
//        28
//        19
//        17
//        ---
//        49
//        29
//        20
//        18
//        - parte 4 -----------------
//        22
//        44
//        53
//        - parte 5 -----------------
//        o
//        oo
//        ooo
//        oooo
//

    }
}