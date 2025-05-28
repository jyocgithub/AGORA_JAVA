package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio b_1
 * Realiza un programa que lea desde teclado 11 números enteros,
 * para posteriormente mostrarlos ordenados. Usar el método de la
 * Burbuja u otro similar, no los métodos nativos de Java.
 */
public class Jyoc_Ejercicio_4_b_01 {
    public static void main(String[] args) {
        Scanner objetoScanner = new Scanner(System.in);
        int[] nums = new int[11];
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Indíque una numero ");
            int t = objetoScanner.nextInt();
            nums[i] = t;
        }

        int aux;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    aux = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = aux;
                }
            }

        }
        System.out.print("\nArray Ordenado: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}