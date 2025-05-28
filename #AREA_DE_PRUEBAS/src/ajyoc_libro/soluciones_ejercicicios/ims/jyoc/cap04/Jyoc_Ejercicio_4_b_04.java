package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 4 Ejercicio b_4
 * Rellenar aleatoriamente un array de 10 números enteros.
 * Debemos mostrarlos en el siguiente orden: el primero,
 * el último, el segundo, el penúltimo, el tercero, etc.
 */
public class Jyoc_Ejercicio_4_b_04 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        boolean iguales = true;
        for (int i = 0; i < nums.length; i++) {
            int t = (int) (Math.random() * 10);
            System.out.println("Añadiendo " + nums[i]);
            nums[i] = t;
        }

        for (int j = 0; j < nums.length / 2; j++) {
            System.out.println(nums[j]);
            System.out.println(nums[nums.length - j - 1]);
        }
    }
}