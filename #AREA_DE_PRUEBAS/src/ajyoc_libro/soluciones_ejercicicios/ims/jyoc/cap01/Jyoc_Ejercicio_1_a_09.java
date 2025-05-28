package soluciones_ejercicicios.ims.jyoc.cap01;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 1 Ejercicio a_9
 * Leer el precio de un producto por teclado, y decir el precio
 * con IVA añadido (suponer un IVA único del 21% )
 * <p>
 */
public class Jyoc_Ejercicio_1_a_09 {

    public static void main(String[] args) {

        final int IVA = 21;
        Scanner objetoScanner10 = new Scanner(System.in);
        System.out.println("Indíque el precio del producto: ");
        int importeProducto = objetoScanner10.nextInt();
        double importeConIva = (importeProducto) + (importeProducto / 100 * IVA);
        System.out.println("El precio del producto con IVA del 21% incluido es de " + importeConIva);
    }
}
