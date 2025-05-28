package cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

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
 * Capitulo 4 Ejercicio a_03
 * Temperaturas. Se piden por teclado la temperatura de cada uno
 * de los 7 días de una semana.
 * Se pide por teclado luego una nueva temperatura,
 * y se compara con las leídas anteriormente para decir
 * si tal nueva temperatura se dio en algún día de la semana
 */
public class Jyoc_Ejercicio_4_a_03 {
    public static void main(String[] args) {
        Scanner objetoScanner = new Scanner(System.in);
        int[] temperaturas = new int[7];
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println("Indíque una temperatura para el dia " + (i+1));
            int t = objetoScanner.nextInt();
            temperaturas[i] = t;
        }
        System.out.println("Indíque una temperatura a buscar entre los dias de la semana ");
        int tempabuscar = objetoScanner.nextInt();
        for (int i = 0; i < temperaturas.length; i++) {
            if (tempabuscar == temperaturas[i]) {
                System.out.println("El dia " + i + " tambien hubo " + tempabuscar + " grados!");
            }
        }
    }
}
