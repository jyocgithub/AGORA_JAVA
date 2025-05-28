package cap03;

import java.util.Scanner;
/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */


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
 * Programa que genera los N primeros números de la serie de Fibonacci.
 * El valor N deberá ser leído por el teclado.
 * NOTA: Los dos primeros números son 1, y el resto se obtiene sumando
 * los dos anteriores: 1,1,2,3,5,8,13,21
 */
public class Jyoc_Ejercicio_3_b_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print("Introduzca un numero: ");
        numero = sc.nextInt();

        //        Variante 1
        int n1 = 1;
        int n2 = 0;
        int aux = 0;
        System.out.println("1");
        for (int i = 2; i <= numero; i++) {
            System.out.println(n1 + n2);
            aux = n1;
            n1 = n1 + n2;
            n2 = aux;
        }

        //        Variante 2
        n1 = 1;
        n2 = 0;
        for (int i = 2; i <= numero + 1; i++) {
            System.out.println(n1 + n2);
            n2 = n1 + n2;
            n1 = n2 - n1;
        }

    }
}
