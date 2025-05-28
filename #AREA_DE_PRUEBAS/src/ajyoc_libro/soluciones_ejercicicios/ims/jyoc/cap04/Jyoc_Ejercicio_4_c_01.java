package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio c_1
 * Realiza un programa que lea 8 números y muestre los no repetidos.
 */
public class Jyoc_Ejercicio_4_c_01 {
    public static void main(String[] args) {
        int[] nums = new int[8];
        Scanner objetoScanner = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Indíque una numero ");
            int t = objetoScanner.nextInt();
            nums[i] = t;
        }

        int cuantasveces = 0;

        for (int j = 0; j < nums.length; j++) {
            cuantasveces = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[j] == nums[i]) {
                    cuantasveces++;
                }
            }
            if (cuantasveces == 1) {
                System.out.println(nums[j] + " no esta repetido");
            }
        }
    }
}