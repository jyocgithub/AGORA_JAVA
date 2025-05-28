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
 * Capitulo 4 Ejercicio b_2
 * Hacer un programa que calcule un boleto de bonoloto, esto es,
 * que muestre por pantalla 6 números del 1 al 47.
 * Pero sin números repetidos.
 * <p>
 * MEJORA 1: Devuelve la lista de los 6 números ordenada.
 */
public class Jyoc_Ejercicio_4_b_02 {
    public static void main(String[] args) {
        int[] numeros = new int[6];
        int generados = 0;
        boolean estabaAntesElNumero = false;
        do {
            int n = (int) (Math.random () * 49 + 1);
            for (int i = 0; i < generados; i++) {
                if (n == numeros[i]) {
                    estabaAntesElNumero = true;
                    break;
                }
            }
            if (!estabaAntesElNumero) {
                numeros[generados] = n;
                generados++;
            }
        } while (generados < 6);

        System.out.println ("Los numeros de la primitiva son: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print (numeros[i] + " ");
        }


        //MEJORA 1, los devuelve odenados

        // ordenamos ahora
        int aux = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int k = i + 1; k < numeros.length; k++) {
                if (numeros[k] < numeros[i]) {
                    //intercambio entre dos posiciones del array
                    aux = numeros[k];
                    numeros[k] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }

        System.out.println ("\nLos numeros de la primitiva ordenados son: ");
        for (int i : numeros) {
            System.out.print (i + " ");
        }
    }
}