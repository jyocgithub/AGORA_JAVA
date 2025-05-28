package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.IOException;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio c_13
 * Crear un programa que pide por teclado números enteros y rellena un vector
 * (no necesariamente ordenado)
 * (el tamaño se le solicita al usuario anteriormente, tambien por teclado)
 * y luego pide otro entero, que llamaremos límite.
 * A partir de ahí, el programa tiene que:
 * - Crear y mostrar un nuevo vector a partir del anterior,
 * sustituyendo los valores menores que el límite por el propio límite.
 * - Mostrar el número de valores sustituidos y la suma de los mismos.
 * - Calcular y mostrar el mayor de los números sustituidos.
 * - Si no hay ningún número por debajo del límite no hace ninguno de
 * los pasos  anteriores y muestra un mensaje informando de esta circunstancia.
 */
public class Jyoc_Ejercicio_4_c_13 {
    public static void main(String[] args) {

        System.out.println("\nIndique el tamaños del vector a crear");
        int tamano = new Scanner(System.in).nextInt();
        int[] numeros = new int[tamano];
        int num = 0;
        for (int j = 0; j < tamano; j++) {
            System.out.println("\nIntroduzca numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }

        int totsustituidos = 0;
        int sumasustituidos = 0;
        int mayorsustituidos = 0;
        boolean haysustituidos = false;
        System.out.println("\nIndique el numero limite:");
        int limite = new Scanner(System.in).nextInt();
        for (int i = 0; i < tamano - 1; i++) {
            if (numeros[i] < limite) {
                totsustituidos++;
                sumasustituidos += numeros[i];
                if (numeros[i] > mayorsustituidos) {
                    mayorsustituidos = numeros[i];
                    haysustituidos = true;
                }
                numeros[i] = limite;
            }
        }

        if (haysustituidos) {
            System.out.print("\nTOTAL SUSTITUCIONES: " + totsustituidos);
            System.out.print("\nSUMA SUSTITUCIONES: " + sumasustituidos);
            System.out.print("\nNUMERO MAYOR SUSTITUIDO: " + mayorsustituidos);
            System.out.print("\nVECTOR NUEVO: ");
            for (int j = 0; j < 10; j++) {
                System.out.print(numeros[j] + " ");
            }
        } else {
            System.out.print("\nNo se efectuó ninguna sustiticion");
        }
    }
}
