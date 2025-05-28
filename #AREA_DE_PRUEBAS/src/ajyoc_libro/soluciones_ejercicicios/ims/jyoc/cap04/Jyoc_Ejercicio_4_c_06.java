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
 * Capitulo 4 Ejercicio c_6
 * Realiza un programa que gestione un array de hasta 8 cadenas.
 * No se permitirán cadenas repetidas.
 * Menú:
 * 1.­ Introducir cadena.
 * 2.­ Listar cadenas.
 * 3.­ Eliminar cadena.
 * 3.­ Eliminar todas las cadenas.
 * 4.­ Salir.
 */
public class Jyoc_Ejercicio_4_c_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int op = 0;
        String cadenas[] = new String[10];  // solo podremos meter 10 numeros
        int ultimaCadenaIntroducida = -1;
        do {
            System.out.println("Menu de opciones");
            System.out.println("================");
            System.out.println("1.- Introducir cadena");
            System.out.println("2.- Listar cadenas");
            System.out.println("3.- Eliminiar cadena");
            System.out.println("4.- Eliminar todos las cadenas");
            System.out.println("0.- Salir");

            op = Integer.parseInt(br.readLine());

            switch (op) {
                case 1:
                    if (ultimaCadenaIntroducida == 9) {
                        System.out.println("No se pueden introducir mas numeros");
                    } else {
                        System.out.println("Introduzca cadena:");
                        String cad = br.readLine();
                        // Ver si existe ya la cadena
                        boolean existe = false;
                        for (int i = 0; i <= ultimaCadenaIntroducida && !existe; i++) {
                            if (cad.equals(cadenas[i])) {
                                existe = true;
                            }
                        }
                        if (existe) {
                            System.out.println("Cadena no añadida, ya existia en la lista");
                        } else {
                            ultimaCadenaIntroducida++;
                            cadenas[ultimaCadenaIntroducida] = cad;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i <= ultimaCadenaIntroducida; i++) {
                        System.out.println("La cadena " + i + " es " + cadenas[i]);
                    }
                    break;
                case 3:
                    System.out.println("Introduzca ordinal de la cadena a eliminar:");
                    int ord = Integer.parseInt(br.readLine());
                    if (ord < 0 || ord > ultimaCadenaIntroducida) {
                        System.out.println("Ese ordinal de cadena no existe");
                    } else {
                        for (int i = ord; i < ultimaCadenaIntroducida; i++) {
                            cadenas[i] = cadenas[i + 1];
                        }
                        ultimaCadenaIntroducida--;
                    }
                    break;
                case 4:
                    cadenas = new String[10];  // al re-crear el array, se elimina su contenido
                    ultimaCadenaIntroducida = -1;
                    break;
            }

        } while (op != 0);

    }
}
