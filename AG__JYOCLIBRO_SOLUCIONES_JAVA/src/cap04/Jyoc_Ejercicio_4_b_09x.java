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

import java.io.IOException;

/**
 * Capitulo 4 Ejercicio b_09
 * Suma de array de char :  dados 2 números en forma de array
 * de caracteres, necesitamos un programa que genere el array suma.
 * Ejemplo:
 * char A = { ‘2’, ‘3’, ‘1’, ‘2’ }
 * char B = { ‘1’, ‘9’ , '7', '2'}
 *  sumar A y  B debe devolver { ‘4’, ‘2’, ‘8’, ‘4’ } , pues 2312 + 1972 son 4284
 * <p>
 * El programa parte de tener 2 arrays de char de igual tamaño,
 * y muestra como resultado un array de char.
 * El array resultado tendrá el mismo tamaño.
 * Si ha de ser mas grande, se emite un mensaje de error y no se da resultado
 * <p>
 * MEJORA 1: los arrays originales no tienen por que ser del mismo tamaño
 * MEJORA 2: Si hay desbordamiento por la izquierda, no da error y devuelve el resultado correcto, en un array con mas elementos
 */
public class Jyoc_Ejercicio_4_b_09x {
    public static void main(String[] args) throws IOException {
        char[] arr1 = {'9', '8', '4', '5', '6', '7'};
        char[] arr2 = {'2', '3', '5', '3', '8', '1'};
        char[] arr3 = new char[4];
        int acarreo = 0;

        // CASO NORMAL, arrays de igual tamaño
        // recorremos el array al reves
//        for (int i = arr1.length - 1; i >= 0; i--) {
//            int a = arr1[i] - '0';
//            int b = arr2[i] - '0';
//            int r = a + b + acarreo;
//            acarreo = 0;
//            if (r > 10) {
//                r = r % 10;
//                acarreo = 1;
//            }
//            arr3[i] = (char) (r + '0');
//        }
//        if (acarreo==1) {
//            System.out.println("hay desbordamiento");
//        } else {
//            for (int i = 0; i < arr1.length; i++) {
//                System.out.print(arr3[i]);
//            }
//        }


        // MEJORAS 1 y 2

        // Veamos que tamaño tiene el array mas largo
        int mayor = arr1.length;
        if (arr2.length > mayor) {
            mayor = arr2.length;
        }
        // Otra manera de hacerlo:
        mayor = (arr1.length > arr2.length) ? arr1.length : arr2.length;
        // El tamaño maximo sera

        // Copiamos los arrays originales en otros con tamaño maximo
        // al copiar nos aseguramos en el array destino quede relleno de ceros por la izquierda
        char[] cop1 = new char[mayor];
        char[] cop2 = new char[mayor];
        char[] cop3 = new char[mayor];

        int difenciaDeTamaño1 = mayor - arr1.length;
        int difenciaDeTamaño2 = mayor - arr2.length;

        for (int i = 0; i < mayor; i++) {
            // copia del array1
            if (i < difenciaDeTamaño1) {
                cop1[i] = '0';
            } else {
                cop1[i] = arr1[i - difenciaDeTamaño1];
            }

            // copia del array2
            if (i < difenciaDeTamaño2) {
                cop2[i] = '0';
            } else {
                cop2[i] = arr2[i - difenciaDeTamaño2];
            }

            // rellenamos con '0' el array resultado, por si acaso....
            cop3[i] = '0';
        }

        // recorremos el array al reves y sumamos
        for (int i = mayor - 1; i >= 0; i--) {
            int a = cop1[i] - '0';
            int b = cop2[i] - '0';
            int r = a + b + acarreo;
            acarreo = 0;
            if (r > 10) {
                r = r % 10;
                acarreo = 1;
            }
            cop3[i] = (char) (r + '0');
        }
        if (acarreo == 1) {  // hay acarreo al sumar los dos digitos con mas peso
            // creamos el un nuevo array 4 con un tamaño de una posicion mas
            // y copiamos el cop3 en el empezando por un 1 (el del desbordamiento)
            char[] cop4 = new char[mayor + 1];
            cop4[0] = '1';
            for (int i = 1; i < mayor + 1; i++) {
                cop4[i] = cop3[i - 1];
            }
            // pintamos resultado cuando hay acarreo
            for (int i = 0; i < mayor+1; i++) {
                System.out.print(cop4[i]);
            }
        }else{
            // pintamos resultado sin acarreo
            for (int i = 0; i < mayor; i++) {
                System.out.print(cop3[i]);
            }
        }
    }
}
