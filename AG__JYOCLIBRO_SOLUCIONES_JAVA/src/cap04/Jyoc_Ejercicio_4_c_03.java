package cap04;
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
 * Capitulo 4 Ejercicio c_3
 * Programa que lee 87 números aleatorios positivos.
 * Al finalizar mostrará el máximo introducido,
 * y cuántas veces se repite dicho máximo.
 */
public class Jyoc_Ejercicio_4_c_03 {
    public static void main(String[] args) {
        int[] nums = new int[87];
        int mayor = -1;
        for (int i = 0; i < nums.length; i++) {
            int t = (int) (Math.random() * 10);
            nums[i] = t;
            if (t > mayor) {
                mayor = t;
            }
            System.out.println("Añadiendo " + nums[i]);
        }

        int cuantasveces = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == mayor) {
                cuantasveces++;
            }
        }
        System.out.println("El mayor fue el " + mayor + " y salio " + cuantasveces + " veces");
    }
}