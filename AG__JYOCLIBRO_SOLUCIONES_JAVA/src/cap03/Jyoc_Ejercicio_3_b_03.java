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
 * Capitulo 3 Ejercicio b_04
 * Se solicita una numero por teclado, y nos dice si es primo o no lo es
 * (un primo se puede definir como un numero que tiene algún divisor además de 1 y de si mismo)
 * <p>
 */
public class Jyoc_Ejercicio_3_b_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, n;
        System.out.println("Indique un numero:");
        int miNumero = sc.nextInt();

        // Antes de empezar el bucle, pongo un contador a 0
        // Este contador va a contar los divisores que tenga el numero miNumero
        // incluidos el mismo y la unidad (1)
        int contadorDeDivisores = 0;

        // Este bucle va a ir dando a j los valores desde 1 hasta miNumero
        // mirando si cada valor de j es un divisor de miNumero
        for (int j = 0; j < miNumero; j++) {
            if (miNumero % j == 0) {
                // en este caso, j es divisor de miNumero, aumento el contador
                contadorDeDivisores++;
            }
        }

        // Al acabar de mirar todos los divisores, si es primo, debe haber
        // encontrado solo 2 divisores (1 y él mismo). Si hay mas, no es primo
        if (contadorDeDivisores == 2) {
            System.out.println(miNumero + " es un numero primo");
        } else {
            System.out.println(miNumero + " no es primo");
        }
    }
}
