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
 * Capitulo 4 Ejercicio a_2
 * Hacer un bucle que pida por teclado 10 números enteros y los almacene
 * en un array, y que se calcule posteriormente la suma de los números
 * que sean pares y la suma de los números que sean impares,
 * y que diga por pantalla cual de las dos sumas es mayor
 */
public class Jyoc_Ejercicio_4_a_02 {
    public static void main(String[] args) {
        int[] arrayDeDatos = {8, 2, 5, 4, 9, 1, 0, 8, 9, 3};
        int sumapares = 0, sumaimpares = 0;
        for (int i = 0; i < arrayDeDatos.length; i++) {
            if (arrayDeDatos[i] % 2 == 0) {
                sumapares = sumapares + arrayDeDatos[i];
            } else {
                sumaimpares = sumaimpares + arrayDeDatos[i];
            }
        }

        if (sumaimpares > sumapares) {
            System.out.println("Hay mas suma de impares (" + sumaimpares + ") que de pares (" + sumapares + ")");
        } else {
            System.out.println("Hay mas suma de pares (" + sumapares + ") que de impares (" + sumaimpares + ")");
        }
    }
}
