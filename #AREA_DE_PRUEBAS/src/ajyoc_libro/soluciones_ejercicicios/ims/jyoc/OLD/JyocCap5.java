package soluciones_ejercicicios.ims.jyoc.OLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 5: BUCLES
 *
 * @author Iñaki Martin
 */

public class JyocCap5 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int opcion = 0;
        do {
            System.out.println("\n************ MENU DE EJERCICIOS ****************");
            System.out.println("Elija un ejercicio a realizar (\"0\" para acabar)");
            Scanner objetoScanner0 = new Scanner(System.in);
            opcion = objetoScanner0.nextInt();

            switch (opcion) {

                case 1:

                    /** **************************************************************************
                     * 	Ejercicio 5.1.- (dif 1)
                     * Dado un array de países que tenga este contenido:
                     * {"Cuba", "Republica de Colombia", "Reino de Perú",
                     * "Nuevo Reino de Canadá", "Republica de Argentina", "Honduras",
                     * "Republica Bananera" };
                     * Indicar cuántos son repúblicas, cuántos reinos y cuántos el resto
                     *
                     */
                    System.out.println("\n\n Ejercicio 5.1\n");
                    String paises[] = {"Cuba", "Republica de Colombia", "Reino de Perú", "Nuevo Reino de Canadá", "Republica de Argentina", "Honduras", "Republica Uruguay"};
                    int contadorRep = 0, contadorRei = 0, contadorOtros = 0;
                    for (int i = 0; i < paises.length; i++) {
                        if (paises[i].toUpperCase().contains("REP")) contadorRep++;
                        else if (paises[i].toUpperCase().contains("REI")) contadorRei++;
                        else contadorOtros++;
                    }
                    System.out.println("Hay " + contadorRep + " repúblicas");
                    System.out.println("Hay " + contadorRei + " reinos");
                    System.out.println("Hay " + contadorOtros + " de otros gobiernos");


                    break;
                case 2:
                    /** **************************************************************************
                     * 	Ejercicio 5.2 - (dif 2)
                     * Dado el array del ejercicio 5.1, construir tres arrays nuevos
                     *  y guardar en uno ellos los que son repúblicas, en otro los que son reinos y el resto
                     *  en el tercer array.
                     *  Escribir los tres arrays posteriormente
                     */
                    System.out.println("\n\n Ejercicio 5.2\n");
                    String paises2[] = {"Cuba", "Republica de Colombia", "Reino de Perú", "Nuevo Reino de Canadá", "Republica de Argentina", "Honduras", "Republica Uruguay"};
                    int contadorRep2 = 0, contadorRei2 = 0, contadorOtros2 = 0;
                    for (int i = 0; i < paises2.length; i++) {
                        if (paises2[i].toUpperCase().contains("REP")) contadorRep2++;
                        else if (paises2[i].toUpperCase().contains("REI")) contadorRei2++;
                        else contadorOtros2++;
                    }
                    String arrayRepus[] = new String[contadorRep2];
                    String arrayReinos[] = new String[contadorRei2];
                    String arrayOtros[] = new String[contadorOtros2];
                    contadorRep2 = 0;
                    contadorRei2 = 0;
                    contadorOtros2 = 0;
                    for (int i = 0; i < paises2.length; i++) {
                        if (paises2[i].toUpperCase().contains("REP")) arrayRepus[contadorRep2++] = paises2[i];
                        else if (paises2[i].toUpperCase().contains("REI")) arrayReinos[contadorRei2++] = paises2[i];
                        else arrayOtros[contadorOtros2++] = paises2[i];
                    }

                    System.out.println("El array de repúblicas tiene " + contadorRep2 + " paises que son:");
                    for (int i = 0; i < arrayRepus.length; i++) {
                        System.out.println(" -" + arrayRepus[i]);
                    }
                    System.out.println("El array de reinos tiene " + contadorRei2 + " paises que son:");
                    for (int i = 0; i < arrayReinos.length; i++) {
                        System.out.println(" -" + arrayReinos[i]);
                    }
                    System.out.println("El array de Otros tiene " + contadorOtros2 + " paises que son:");
                    for (int i = 0; i < arrayOtros.length; i++) {
                        System.out.println(" -" + arrayOtros[i]);
                    }


                    break;

                case 3:
                    /** **************************************************************************
                     * 	Ejercicio 5.3.- (dif 2)
                     * Crear un array con las 27 fichas de domino,
                     *  usando bucles. Escribir posteriormente el array.
                     */
                    System.out.println("\n\n Ejercicio 5.3\n");
                    int contador = 0;
                    String fichas[] = new String[28];
                    for (int i = 0; i <= 6; i++) {
                        for (int j = i; j <= 6; j++) {
                            fichas[contador] = i + "-" + j;
                            String num2digitos = "" + (contador + 1);
                            if (contador < 9) num2digitos = "0" + num2digitos;
                            System.out.println("La ficha " + num2digitos + " es " + fichas[contador]);
                            contador++;
                        }
                    }

                    // MEJORA 1: hacer posteriormente el reparto inicial de las fichas,
                    // que quedan en 4 arrays de 7 fichas, sin repetir, evidendemente.


                    //*********************************************************************


                    /**
                     * 	Ejercicio 5.6.- (dif 4)
                     * Palíndromos 2. Dada una matriz existente de números enteros,
                     * decir si alguna de las filas es un palíndromo.
                     *
                     */
                    // Variables que se van a necesitar
                    int[][] matrix = {{1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 1, 0}};
                    boolean EsPalindromo;
                    int e = matrix.length;
                    int l = matrix[1].length;

                    // Bucle externo, el valor de k va a representar a cada una de las filas de la matriz
                    for (int k = 0; k < matrix.length; k++) {
                        // Buble interno, el valor de i va a representar a cada una de las columnas de cada fila
                        String EsPalindromo2 = "SI";
                        for (int i = 0; i < matrix[k].length; i++) {
                            if (matrix[k][i] != matrix[k][6 - i]) {
                                EsPalindromo2 = "NO";
                            }
                        }
                        // escritura de resultados evaluando el valor de noEsPalindromo en cada fila
                        System.out.println("la linea " + k + " de la matriz " + EsPalindromo2 + " es palindromo");

                    }


                    break;
                //*********************************************************************


                //*********************************************************************


                //*********************************************************************
                case 10:
                    /**
                     * 	Ejercicio 5.10 (dif 5)
                     *  Un programa pide un texto por teclado, y si en el texto encuentra las palabras
                     *  lunes, martes, miércoles,jueves, viernes, sábado o domingo, las pone en mayúsculas.
                     *  Ejemplo:
                     *  Texto introducido por teclado: "no me gustan los lunes ni los miércoles"
                     *  debe escribir "no me gustan los Lunes ni los Miércoles"
                     *
                     */
                    System.out.println("\n\n Ejercicio 5.10\n");
                    Scanner objetoScanner10 = new Scanner(System.in);
                    String texto10 = objetoScanner10.nextLine();
                    String dias[] = {"lunes", "martes", "miercoles", "jueves", "viernes"};

                    // recorrer el texto buscando coincidencias
                    for (int i = 0; i < texto10.length(); i++) {

                        for (int k = 0; k < dias.length - 1; k++) {
                            if ((texto10.length() >= i + dias[k].length()) &&

                                    (texto10.substring(i, i + dias[k].length()).equals(dias[k]))) {
                                texto10 = texto10.substring(0, i) + dias[k].toUpperCase() + texto10.substring(i + dias[k].length());
                            }
                        }
                    }

                    System.out.println(" Texto final: " + texto10);

                    break;

                //*********************************************************************
                case 14:
                    /**
                     * 	Ejercicio 5.14.- (dif 3) Simular un lanzamiento de 6000 veces un dado, y decir al finalizar cuantas veces ha salido cada
                     uno de los números del dado

                     MEJORA 1; decir además la desviación máxima y mínima (la mayor diferencia entre dos resultados y la minima)
                     *
                     */
                    System.out.println("\n\n Ejercicio 5.14\n");

                    // dados sin desviacion
                    int res[] = new int[6];

                    for (int i = 1; i <= 6000; i++) {
                        int numero = (int) (Math.random() * 6 + 1);
                        res[numero - 1]++;
                    }
                    for (int i = 0; i < res.length; i++) {
                        System.out.println("El numero " + (i + 1) + " ha salido: " + res[i]);
                    }


                    break;
            }  // fin del switch

        } while (opcion != 0);          //fin del while

        System.out.println("\nPrograma finalizado.");


    } // fin del main


}  // fin del programa
