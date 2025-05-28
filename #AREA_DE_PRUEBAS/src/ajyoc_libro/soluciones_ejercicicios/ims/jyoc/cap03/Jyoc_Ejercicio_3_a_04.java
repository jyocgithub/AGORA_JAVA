package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio 6
 * Hacer un programa que muestre el producto de los 10 primeros números impares.
 */
public class Jyoc_Ejercicio_3_a_04 {

    public static void main(String[] args) {
        int producto = 1;
        int contadorDeImpares = 0;
        int indice = 0;
        while (contadorDeImpares < 10) {
            if (indice % 2 != 0) {
                // es un numero impar
                producto = producto * indice;
                contadorDeImpares++;
            }
            indice++;
        }
        System.out.println("El producto es " + producto);
    }
}
