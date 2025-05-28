package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio b_9
 * Programa que pide por teclado cantidades y precios de varios productos.
 * Se van a pedir estos datos hasta que en la cantidad de un producto se indique 0.
 * Al final indicar el total de la factura.
 * Si el importe supera los 1000€ se aplicará un descuento del 5%
 */
public class Jyoc_Ejercicio_3_b_09 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double suma = 0;
        do {
            System.out.println("Indique un importe:");
            n = sc.nextInt();
            suma += n;
        } while (n != 0);

        if (suma > 1000) {
            suma = suma * 0.95;
        }

        System.out.println("la suma es :" + suma);
    }
}
