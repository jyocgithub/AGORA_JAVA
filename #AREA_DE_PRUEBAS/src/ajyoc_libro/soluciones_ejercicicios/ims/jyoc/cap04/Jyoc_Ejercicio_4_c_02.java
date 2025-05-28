package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio c_2
 * Realiza un programa que lea 8 números y muestre al final los repetidos.
 * Cada número repetido será mostrado una sola vez
 */
public class Jyoc_Ejercicio_4_c_02 {
    public static void main(String[] args) {
        int[] nums = new int[8];
        int[] repes = new int[8];
        int cuantasveces = 0;
        int punteroRepetidos = 0;
        boolean estaYa = false;

        Scanner objetoScanner = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Indíque una numero ");
            int t = objetoScanner.nextInt();
            nums[i] = t;
        }

        for (int j = 0; j < nums.length; j++) {
            cuantasveces = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[j] == nums[i]) {
                    cuantasveces++;
                }
            }
            estaYa = false;
            if (cuantasveces > 1) {
                for (int i = 0; i < repes.length; i++) {
                    if (nums[j] == repes[i]) {
                        estaYa = true;
                    }
                }
                if (!estaYa) {
                    System.out.println(nums[j] + " esta repetido");
                    repes[punteroRepetidos] = nums[j];
                    punteroRepetidos++;
                }
            }
        }


    }
}