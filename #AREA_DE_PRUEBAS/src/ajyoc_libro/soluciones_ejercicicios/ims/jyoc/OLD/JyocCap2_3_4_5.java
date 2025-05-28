package soluciones_ejercicicios.ims.jyoc.OLD;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 2
 *
 * @author Iñaki Martin
 */

public class JyocCap2_3_4_5 {

    public static void main(String[] args) {

        /**
         * Ejercicio 4 (dif 3) Escribir un programa que dada una variable String
         * que tenga una frase, deje solo la primera palabra
         *
         */
        System.out.println("\n\n Ejercicio 2.4\n\n");
        Scanner objetoScanner4 = new Scanner(System.in);
        System.out.println("Escriba una frase: ");
        String frase = objetoScanner4.nextLine();
        int posicionPrimerEspacio = frase.indexOf(" ");
        String primeraPalabra = frase.substring(0, posicionPrimerEspacio);
        System.out.println("La primera palabra es : " + primeraPalabra);

        /**
         * Ejercicio 5 (dif 2) Escribe un programa que de una variable String
         * que es una frase, ponga la mitad primera de la misma en mayúsculas.
         *
         */
        System.out.println("\n\n Ejercicio 2.5\n\n");
        Scanner objetoScanner5 = new Scanner(System.in);
        System.out.println("Escriba una frase: ");
        String frase2 = objetoScanner5.nextLine();
        int posicionMedio = frase2.length() / 2;
        String primeraMitad = frase2.substring(0, posicionMedio);
        System.out.println("La primera mitad de la frase es : " + primeraMitad);


        /**
         * Ejercicio 2.12.- Crear un programa que elija dos números enteros aleatorios A y B
         * pero no los muestre por pantalla aún. El programa preguntará por quién apostamos, por
         * A o por B (gana el número más alto). Una vez el usuario haya introducido su apuesta,
         * el programa mostrará el valor de A y B, dirá si hemos ganado la apuesta (acertado el número más alto) o perdido
         */

        Scanner objetoScanner = new Scanner(System.in);
        int numA = (int) (Math.random() + 10);
        int numB = (int) (Math.random() + 10);
        System.out.println("Indíque que número es mas alto, A o B: ");
        String apuesta = objetoScanner.nextLine();
        if ((apuesta.equalsIgnoreCase("A") && numA > numB) || (apuesta.equalsIgnoreCase("B") && numB > numA)) {
            System.out.println("Ha ganado !!!");
        } else {
            System.out.println("Ha fallado ...");
        }


        /**
         * Ejercicio 3.5 (dif 1) Escribir un programa que lea dos
         * palabras del teclado, y nos diga si son iguales. En este caso
         * no se consideran mayúsculas-minúsculas, ("Casa" si es igual
         * que "casa")
         *
         */
        System.out.println("\n\n Ejercicio 3.5\n\n");
        Scanner objetoScanner53 = new Scanner(System.in);
        System.out.println("Indíque una primera palabra: ");
        String palabra5 = objetoScanner53.nextLine();
        System.out.println("Indíque una segunda palabra: ");
        String palabra5segunda = objetoScanner53.nextLine();
        if (palabra5.equalsIgnoreCase(palabra5segunda)) {
            System.out.println("La palabra " + palabra5 + " y la palabra " + palabra5segunda + " son iguales.");
        } else {
            System.out.println("La palabra " + palabra5 + " y la palabra " + palabra5segunda + " NO son iguales.");
        }

        /**
         * Ejercicio 3.7 (dif 2) Escribir un programa que lea la hora en
         * notación de 24 horas y que imprima en notación 12 horas ; por
         * ejemplo, si la entrada es 13:45, la salida será 1:45 pm. El
         * programa debe solicitar al usuario que introduzca exactamente
         * cinco caracteres para especificar una hora; por ejemplo, las
         * 9 en punto se debe introducir así: 09:00
         *
         */
        //				System.out.println("\n\n Ejercicio 3.7\n\n");
        //				Scanner objetoScanner7 = new Scanner(System.in);
        //				System.out.println("Indíque una hora en formato \"99:99\" : ");
        //				String cadena7 = objetoScanner7.nextLine();
        //				if (cadena7.length() != 5) {
        //					System.out.println("Hora erronea, número incorrecto de caracteres");
        //				} else if (!(cadena7.substring(2, 3).equals(":"))) {
        //					System.out.println("Hora erronea, formato incorrecto");
        //				} else {
        //					// Aqui vamos a evaluar si los minutos son correctos
        //					// podemos extraer cada caracter que debe estar en la
        //					// posision de los numeros
        //					// y analizar si es numero y si estan dentro del rango
        //					// permitido
        //					// pero mas facil usaremos un metodo de la clase Integer que
        //					// nos convierte
        //					// una cadena a numero directamente
        //					// No vamos a controlar si se han metido letras en vez de
        //					// numeros.
        //					int horas = Integer.parseInt(cadena7.substring(0, 2));
        //					int minutos = Integer.parseInt(cadena7.substring(3));
        //					if (minutos > 59) {
        //						System.out.println("Hora erronea, numero de minutos incorrecto");
        //					} else if (horas > 23) {
        //						System.out.println("Hora erronea, numero de horas incorrecto");
        //					} else {
        //						if (horas > 12) {
        //							horas = horas - 12;
        //							cadena7 = String.valueOf(horas) + cadena7.substring(2);
        //						}
        //						System.out.println(" Nueva hora: " + cadena7);
        //					}
        //				}

        /**
         * Ejercicio 3.9 (dif 4) Solicitar por teclado una fecha escrita
         * "dd:mm:aa" (por ejemplo, 15:02:12" y la escriba luego en
         * texto, de este modo: 15 de febrero de 2012 Si el año es menor
         * de 50, debe pertenecer al siglo XXI, sino, al XX. Esto es, si
         * se introduce 15:02:87 debe salir 15 de febrero de 1987
         */

        // No validamos que el formato de la cadena a introducir sea
        // correcto (99:99:99),
        // solo que la cadena tenga 8 caracteres
        // Se propones como mejora

        //				System.out.println("\n\n Ejercicio 3.9\n\n");
        //				Scanner objetoScanner9 = new Scanner(System.in);
        //				System.out.println("Indíque una fecha en formato \"99:99:99\" : ");
        //				String cadena9 = objetoScanner9.nextLine();
        //				if (cadena9.length() != 8) {
        //					System.out.println("Fecha erronea, número incorrecto de caracteres");
        //				} else {
        //					int mes = Integer.parseInt(cadena9.substring(3, 5));
        //					int anio = Integer.parseInt(cadena9.substring(6));
        //					String mesEnTexto = "";
        //					switch (mes) {
        //					case 1:
        //						mesEnTexto = "Enero";
        //						break;
        //					case 2:
        //						mesEnTexto = "Febrero";
        //						break;
        //					case 3:
        //						mesEnTexto = "Marzo";
        //						break;
        //					case 4:
        //						mesEnTexto = "Abril";
        //						break;
        //					case 5:
        //						mesEnTexto = "Mayo";
        //						break;
        //					case 6:
        //						mesEnTexto = "Junio";
        //						break;
        //					case 7:
        //						mesEnTexto = "Julio";
        //						break;
        //					case 8:
        //						mesEnTexto = "Agosto";
        //						break;
        //					case 9:
        //						mesEnTexto = "Septiembre";
        //						break;
        //					case 10:
        //						mesEnTexto = "Octubre";
        //						break;
        //					case 11:
        //						mesEnTexto = "Noviembre";
        //						break;
        //					case 12:
        //						mesEnTexto = "Diciembre";
        //						break;
        //					default:
        //						mesEnTexto = "error";
        //						break;
        //					}
        //					if (!(mesEnTexto.equals("error"))) {
        //						String anioEnTexto = (anio < 50 ? (anio + 2000) + "" : (anio + 1900) + "");
        //						String fechaFinal = cadena9.substring(0, 2) + " de " + mesEnTexto + " de " + anioEnTexto;
        //						System.out.println("Fecha final: " + fechaFinal);
        //					} else {
        //						System.out.println("Fecha erronea, numero incorrecto de mes");
        //					}
        //				}

        /**
         * Ejercicio 3.10 (dif 3) Escribir un programa que calcule el
         * número de días de un mes, dados los valores numéricos del mes
         * y el año. Se debe comprobar que el valor introducido para el
         * mes esté comprendido entre 1 y 12. El calculo de si el año es
         * bisiesto se simplifica a que sea bisiesto un año múltiplo de
         * 4 y no de 100, pero si de 400
         *
         */
        //				System.out.println("\n\n Ejercicio 3.10\n\n");
        //				Scanner objetoScanner10 = new Scanner(System.in);
        //				System.out.println("Indíque un número de mes : ");
        //				int mes10 = objetoScanner10.nextInt();
        //				System.out.println("Indíque un número de año : ");
        //				int anio10 = objetoScanner10.nextInt();
        //				int numDias = 31;
        //				switch (mes10) {
        //				case 2:
        //					numDias = 28;
        //					if ((anio10 % 4 == 0) && !(anio10 % 100 == 0))
        //						numDias = 29;
        //					if ((anio10 % 400 == 0))
        //						numDias = 29;
        //					// en una sola linea las tres anteriores podría ser:
        //					// numDias = ( (anio10 % 4==0) && !(anio10 % 100==0) ||
        //					// (anio10 % 400==0) ? 29 : 28);
        //					break;
        //				case 4:
        //				case 6:
        //				case 9:
        //				case 11:
        //					numDias = 30;
        //					break;
        //				}
        //
        //				if (mes10 > 12 || mes10 < 1) {
        //					System.out.println("Número de mes erróneo");
        //				} else {
        //					System.out.println(" El mes " + mes10 + " del año " + anio10 + " tiene " + numDias + " días");
        //				}


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


        //*********************************************************************
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


        //*********************************************************************
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


        //*********************************************************************


        //*********************************************************************
        //		case 10:
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

        //*********************************************************************
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


    }

}
