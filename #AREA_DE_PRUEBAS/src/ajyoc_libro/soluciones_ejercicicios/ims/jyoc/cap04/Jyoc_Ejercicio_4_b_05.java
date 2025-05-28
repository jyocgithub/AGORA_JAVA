package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 4 Ejercicio b_5
 * Rellenar aleatoriamente un array de 10 números enteros,
 * y posteriormente indicar si los números están ordenados de forma creciente,
 * decreciente, o si están desordenados.
 */
public class Jyoc_Ejercicio_4_b_05 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        boolean creciente = true;
        boolean decreciente = true;
        boolean iguales = true;
        for (int i = 0; i < nums.length; i++) {
            int t = (int) (Math.random() * 10);
            nums[i] = t;
            System.out.println("Añadiendo " + nums[i]);
        }

        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] >= nums[j + 1]) {
                decreciente = false;
            }
            if (nums[j] <= nums[j + 1]) {
                creciente = false;
            }
            if (nums[j] != nums[j + 1]) {
                iguales = false;
            }
        }
        if (creciente) System.out.println("Son crecientes ");
        if (decreciente) System.out.println("Son decrecientes ");
        if (iguales) System.out.println("Son iguales ");


    }
}