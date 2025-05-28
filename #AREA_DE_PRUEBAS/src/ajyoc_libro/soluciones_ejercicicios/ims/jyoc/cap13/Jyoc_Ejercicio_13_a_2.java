package soluciones_ejercicicios.ims.jyoc.cap13;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 * <p>
 * Capitulo 13 Ejercicio a_2
 * Pedir dos números y decir si uno es múltiplo del otro,
 * y decir cual es el mayor o si son iguales.
 */

/**
 * Capitulo 13 Ejercicio a_2
 * Pedir dos números y decir si uno es múltiplo del otro,
 * y decir cual es el mayor o si son iguales.
 */

/**
 Realizar un método leerInt() que, utilizando la clase Scanner,
 permita repetir la petición de datos por teclado de un número hasta que
 lo introducido por el usuario sea realmente un número entero válido.
 Guardar el método como estático en una clase de Utilidades.
 Crear una clase Prueba con un main que llame y compruebe el funcionamiento del método anterior.
 */

public class Jyoc_Ejercicio_13_a_2 {

    public static int leerInt() {

        Scanner entrada = new Scanner(System.in);
        boolean seguir = true;
        int resultado = 0;
        do {
            try {
                resultado = entrada.nextInt();
                seguir = false;
            } catch (InputMismatchException ex) {
                System.out.println("Indique solo dígitos por favor");
                entrada.nextLine();  // para limpiar lo que haya en el buffer del scanner
            } catch (Exception ex) {
                System.out.println("Error inesperado, repita la introduccion por favor");
                entrada.nextLine();  // para limpiar lo que haya en el buffer del scanner
            }

        } while (seguir);
        return resultado;
    }

    public static void main(String[] args) {
        int h = leerInt();

    }
}
