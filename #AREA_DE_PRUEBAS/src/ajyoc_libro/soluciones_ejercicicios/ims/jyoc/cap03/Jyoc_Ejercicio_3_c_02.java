package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio c_02
 * Escribir un programa que encuentre el primer número perfecto tras uno
 * inicial indicado por teclado. Un número perfecto es un entero positivo
 * que es igual a la suma de todos los ente­ros positivos (excluido él mismo)
 * que son sus divisores. El primer número perfecto es 6,
 * ya que sus divisores son 1, 2, 3 y 1 + 2 + 3 = 6.
 * <p>
 */
public class Jyoc_Ejercicio_3_c_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, sig, suma;
        System.out.println("Indique un numero:");
        n = sc.nextInt();
        sig = n;
        boolean seguir = true;
        while (seguir) {
            sig++;
            suma = 0;
            for (i = 1; i < sig; i++) {  // i son los divisores. Se divide desde 1 hasta sig-1
                if (sig % i == 0) {
                    suma = suma + i;     // si es divisor se suma
                }
            }
            if (suma == sig) {  // si el numero es igual a la suma de sus divisores es perfecto
                seguir = false;
            }
        }
        System.out.println("El perfecto siguiente es:" + sig);
    }
}
