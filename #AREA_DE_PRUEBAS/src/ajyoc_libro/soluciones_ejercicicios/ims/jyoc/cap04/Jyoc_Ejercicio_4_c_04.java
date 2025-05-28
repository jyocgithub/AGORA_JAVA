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
 * Capitulo 4 Ejercicio c:_4
 * Hacer un programa que muestre un menú de este tipo:
 * "1.- Introducir nota"
 * "2.- Mostrar nota media"
 * "3.- Mostrar notas extremas"
 * "4.- Mostrar notas"
 * "0.- Salir"
 * <p>
 * De modo que si se opta por:
 * la opción 1, se pide una nota, y se guarda en un array
 * la opción 2 muestra la nota media de todas las introducidas
 * la opción 3 muestra la menor y la mayor de todas las notas introducidas
 * la opción 4 muestra todas las notas introducidas
 * la opción 0 acaba el programa
 * <p>
 * MEJORA 1: Al ejercicio anterior, añadirle una opción "5.- Eliminar nota” que nos pedirá un numero, y eliminara la nota que tenga en el array ese numero como índice
 */
public class Jyoc_Ejercicio_4_c_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada13 = new BufferedReader(new InputStreamReader(System.in));

        int opcion13 = 0, suma13 = 0, notamaxima = 0, notaminima = 10;
        double notamedia = 0;
        int notas13[] = new int[10];  // solo podremos meter 10 notas
        int ultimaNotaIntroducida = -1;
        do {
            System.out.println("Menu de opciones");

            System.out.println("================");
            System.out.println("1.- Introducir nota");
            System.out.println("2.- Mostrar nota media");
            System.out.println("3.- Mostrar notas extremas");
            System.out.println("4.- Mostrar notas");
            System.out.println("5.- Eliminar nota");
            System.out.println("0.- Fin");

            opcion13 = Integer.parseInt(entrada13.readLine());

            switch (opcion13) {
                case 1:
                    if (ultimaNotaIntroducida == 9) {
                        System.out.println("No se pueden introducir mas notas");
                    } else {
                        System.out.println("Introduzca nota:");
                        int nota = Integer.parseInt(entrada13.readLine());
                        ultimaNotaIntroducida++;
                        notas13[ultimaNotaIntroducida] = nota;
                        suma13 += nota;
                        notamedia = suma13 / (ultimaNotaIntroducida + 1);
                        notamaxima = Math.max(notamaxima, nota);
                        notaminima = Math.min(notaminima, nota);
                    }
                    break;
                case 2:
                    System.out.println("La nota media hasta ahora es " + notamedia);

                    break;
                case 3:
                    System.out.println("La nota maxima hasta ahora es " + notamaxima);
                    System.out.println("La nota minima hasta ahora es " + notaminima);
                    break;
                case 4:
                    for (int i = 0; i <= ultimaNotaIntroducida; i++) {
                        System.out.println("La nota " + i + " es " + notas13[i]);
                    }
                    break;
                case 5:
                    System.out.println("Introduzca ordinal de la nota a eliminar:");
                    int ord = Integer.parseInt(entrada13.readLine());
                    if (ord < 0 || ord > ultimaNotaIntroducida) {
                        System.out.println("Ese ordinal de nota no existe");
                    } else {
                        for (int i = ord; i < ultimaNotaIntroducida; i++) {
                            notas13[i] = notas13[i + 1];
                        }
                        ultimaNotaIntroducida--;
                        suma13 = 0;
                        notamaxima = 0;
                        notaminima = 10;

                        for (int i = 0; i <= ultimaNotaIntroducida; i++) {
                            System.out.println("La nota " + i + " es " + notas13[i]);
                            suma13 += notas13[i];
                            notamedia = suma13 / (ultimaNotaIntroducida + 1);
                            notamaxima = Math.max(notamaxima, notas13[i]);
                            notaminima = Math.min(notaminima, notas13[i]);
                        }

                    }
                    break;
            }


        } while (opcion13 != 0);
    }
}