package soluciones_ejercicicios.ims.jyoc.OLD;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 4: BUCLES
 *
 * @author Iñaki Martin
 */

public class JyocCap4 {

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n************ MENU DE EJERCICIOS ****************");
            System.out.println("Elija un ejercicio a realizar (\"0\" para acabar)");
            Scanner objetoScanner0 = new Scanner(System.in);
            opcion = objetoScanner0.nextInt();

            switch (opcion) {

                case 1:

                    /**
                     * 	Ejercicio 4.1 (dif 2)
                     *  Suponiendo una variable  String cadenaDeLetras = "melon",
                     *  hacer un programa que saque por pantalla:
                     *	"m"
                     *	"e"
                     *	"l"
                     *	"o"
                     *	"n"
                     */
                    System.out.println("\n\n Ejercicio 4.1\n");
                    String cad1 = "melon";
                    for (int i = 0; i < cad1.length(); i++) {
                        System.out.println(cad1.substring(i, i + 1));
                    }


                    break;
                //*********************************************************************
                case 2:
                    /**
                     * 	Ejercicio 4.2 (dif 3)
                     *  Dado el ejemplo anterior, se desea que la salida
                     *  por pantalla sea "nolem"
                     *
                     */
                    System.out.println("\n\n Ejercicio 4.2\n");
                    String cad2 = "melon";
                    for (int i = cad2.length(); i > 0; i--) {
                        System.out.print(cad2.substring(i - 1, i));
                    }

                    break;
                //*********************************************************************
                case 3:
                    /**
                     * 	Ejercicio 3.3 (dif 2)
                     *  (dif 2) Dado el ejemplo 4.1, se desea que la salida por pantalla sea:
                     * "m"
                     * "me"
                     * "mel"
                     * "melo"
                     * "melon"
                     */
                    System.out.println("\n\n Ejercicio 4.3\n");
                    String cad3 = "melon";
                    for (int i = 0; i < cad3.length(); i++) {
                        System.out.println(cad3.substring(0, i + 1));
                    }


                    break;
                //*********************************************************************
                //*********************************************************************


                //*********************************************************************
                case 8:
                    /**
                     * 	Ejercicio 4.8.- (dif  3) Hacer un programa que nos diga la tabla de multiplicar
                     *  de un número que se pida por teclado, del 1 al 9. Se debe mostrar alineada
                     *  exactamente como se pide en el ejemplo.
                     *  Por ejemplo, si el numero que se introduce por teclado es el 3,
                     *  debe producirse una salida por pantalla así (sin las comillas):
                     *	" TABLA DEL 3 "
                     *	"3 por 01 es 03"
                     *	"3 por 02 es 06"
                     *	"3 por 03 es 09"
                     *	"3 por 04 es 12"
                     *	"3 por 05 es 15"
                     *	"3 por 06 es 18"
                     *	"3 por 07 es 21"
                     *	"3 por 08 es 24"
                     *	"3 por 09 es 27"
                     *	"3 por 10 es 30"
                     *
                     */

                    System.out.println("\n\n Ejercicio 4.8\n\n");
                    System.out.println("Introduce el numero para la tabla de multiplicar (1 al 9)");
                    Scanner objetoScanner8 = new Scanner(System.in);
                    int numero8 = objetoScanner8.nextInt();
                    System.out.println(" TABLA DEL " + numero8);
                    String a, b, prefijo1, prefijo2;
                    for (int i = 1; i < 11; i++) {
                        prefijo1 = "";
                        if (i < 10) prefijo1 = "0";
                        a = prefijo1 + i;
                        // las 3 lineas anteriores se pueden hacer facilmente con solo una linea...
                        // a = ( (i<10) ? "0"+i : ""+i);

                        prefijo2 = "";
                        if ((i * numero8) < 10) prefijo2 = "0";
                        b = prefijo2 + (i * numero8);

                        System.out.println(numero8 + " por " + a + " es " + b);
                    }

                    //*********************************************************************

                    //*********************************************************************
                case 12:
                    /**
                     * 	Ejercicio 4.12.- (dif 3)
                     *  Pedir un texto por teclado, y se indica cuantas vocales
                     *  de cada tipo tiene, (cuantas aes tiene, cuantas ies , oes , etc)
                     *
                     */
                    System.out.println("\n\n Ejercicio 4.12\n\n");
                    System.out.println("Introduce un texto:");
                    Scanner objetoScanner12 = new Scanner(System.in);
                    String texto12 = objetoScanner12.nextLine();
                    int canta = 0, cante = 0, canti = 0, canto = 0, cantu = 0;

                    for (int i = 0; i < texto12.length(); i++) {
                        String letra = texto12.substring(i, i + 1);
                        switch (letra.toUpperCase()) {
                            case "A":
                                canta++;
                                break;
                            case "E":
                                cante++;
                                break;
                            case "I":
                                canti++;
                                break;
                            case "O":
                                canto++;
                                break;
                            case "U":
                                cantu++;
                                break;
                        }
                    }
                    System.out.println("Hay " + canta + " veces la letra a");
                    System.out.println("Hay " + cante + " veces la letra e");
                    System.out.println("Hay " + canti + " veces la letra i");
                    System.out.println("Hay " + canto + " veces la letra o");
                    System.out.println("Hay " + cantu + " veces la letra u");


                    break;


                //*********************************************************************
                case 14:
                    /**
                     * 	Ejercicio 4.14.- (dif 3)
                     *  Se solicita una palabra por teclado, y se indica si la palabra
                     *  es un palíndromo.
                     *
                     */
                    System.out.println("\n\n Ejercicio 4.14\n\n");
                    System.out.println("Introduce un texto:");
                    Scanner objetoScanner14 = new Scanner(System.in);
                    String texto14 = objetoScanner14.nextLine();
                    boolean esPalindromo = true;
                    int tamano = texto14.length();
                    String f1, f2;
                    for (int i = 0; i < tamano / 2 + 1; i++) {
                        f1 = texto14.substring(i, i + 1);
                        f2 = texto14.substring(tamano - i - 1, tamano - i);
                        if (!f1.equals(f2)) esPalindromo = false;
                    }
                    if (esPalindromo) {
                        System.out.println(" La palabra " + texto14 + " es un palindromo");
                    } else {
                        System.out.println(" La palabra " + texto14 + " NO es un palindromo");
                    }


                    break;
                //*********************************************************************


            }  // fin del switch

        } while (opcion != 0);          //fin del while

        System.out.println("\nPrograma finalizado.");


    } // fin del main


}  // fin del programa
