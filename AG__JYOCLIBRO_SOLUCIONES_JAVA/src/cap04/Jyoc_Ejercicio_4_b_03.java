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
 * Capitulo 4 Ejercicio b_3
 * Rellenar aleatoriamente un array de 10 números enteros.
 * Indicar si todos los números son iguales.
 */
public class Jyoc_Ejercicio_4_b_03 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        boolean iguales = true;

        for (int i = 0; i < nums.length; i++) {
            int t = (int) (Math.random() * 10);
            nums[i] = t;
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.println("Evaluando " + nums[j]);
            for (int i = 0; i < nums.length; i++) {
                if (nums[j] != nums[i] && j != i) {
                    iguales = false;
                }
            }
        }
        if (iguales) {
            System.out.println("Son todos iguales");
        } else {
            System.out.println("No son todos iguales");

        }

        // Metodo 2
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[j + 1]) {
                iguales = false;
            }
        }
        if (iguales) {
            System.out.println("Son todos iguales");
        } else {
            System.out.println("No son todos iguales");

        }

    }
}