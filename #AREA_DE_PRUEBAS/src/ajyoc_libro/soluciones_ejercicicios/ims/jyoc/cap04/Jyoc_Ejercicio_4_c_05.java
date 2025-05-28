package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Capitulo 4 Ejercicio c_5
 * Realiza un programa que gestione un array ordenado ascendentemente y
 * con un máximo de 10 elementos. Se permiten repetidos:
 * Menú:
 * 1.­ Introducir número entero.
 * 2.­ Listar números.
 * 3.­ Eliminar número (por su posición).
 * 3.­ Eliminar todos los números.
 * 4.­ Salir.
 */
public class Jyoc_Ejercicio_4_c_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int op = 0;
        int numeros[] = new int[10];  // solo podremos meter 10 numeros
        int ultimoNumeroIntroducido = -1;
        do {
            System.out.println("Menu de opciones");
            System.out.println("================");
            System.out.println("1.- Introducir numero");
            System.out.println("2.- Listar numeros");
            System.out.println("3.- Eliminiar numero");
            System.out.println("4.- Eliminar todos los numeros");
            System.out.println("0.- Salir");

            op = Integer.parseInt(br.readLine());

            switch (op) {
                case 1:
                    if (ultimoNumeroIntroducido == 9) {
                        System.out.println("No se pueden introducir mas numeros");
                    } else {
                        System.out.println("Introduzca numero:");
                        int num = Integer.parseInt(br.readLine());
                        ultimoNumeroIntroducido++;
                        numeros[ultimoNumeroIntroducido] = num;
                    }
                    break;
                case 2:
                    for (int i = 0; i <= ultimoNumeroIntroducido; i++) {
                        System.out.println("El numero " + i + " es " + numeros[i]);
                    }
                    break;
                case 3:
                    System.out.println("Introduzca ordinal del numero a eliminar:");
                    int ord = Integer.parseInt(br.readLine());
                    if (ord < 0 || ord > ultimoNumeroIntroducido) {
                        System.out.println("Ese ordinal de numero no existe");
                    } else {
                        for (int i = ord; i < ultimoNumeroIntroducido; i++) {
                            numeros[i] = numeros[i + 1];
                        }
                        ultimoNumeroIntroducido--;
                    }
                    break;
                case 4:
                    numeros = new int[10];  // al re-crear el array, se elimina su contenido
                    ultimoNumeroIntroducido = -1;
                    break;
            }

        } while (op != 0);

    }
}
