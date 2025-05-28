package soluciones_ejercicicios.ims.jyoc.OLD;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 3: BIFURCACIONES
 *
 * @author Iñaki Martin
 */

public class JyocCap3 {

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n************ MENU DE EJERCICIOS ****************");
            System.out.println("Elija un ejercicio a realizar (\"0\" para acabar)");
            Scanner objetoScanner0 = new Scanner(System.in);
            opcion = objetoScanner0.nextInt();

            switch (opcion) {

                case 1:

                    break;
                case 5:
                    /**
                     * Ejercicio 3.5 (dif 1) Escribir un programa que lea dos
                     * palabras del teclado, y nos diga si son iguales. En este caso
                     * no se consideran mayúsculas-minúsculas, ("Casa" si es igual
                     * que "casa")
                     *
                     */
                    System.out.println("\n\n Ejercicio 3.5\n\n");
                    Scanner objetoScanner5 = new Scanner(System.in);
                    System.out.println("Indíque una primera palabra: ");
                    String palabra5 = objetoScanner5.nextLine();
                    System.out.println("Indíque una segunda palabra: ");
                    String palabra5segunda = objetoScanner5.nextLine();
                    if (palabra5.equalsIgnoreCase(palabra5segunda)) {
                        System.out.println("La palabra " + palabra5 + " y la palabra " + palabra5segunda + " son iguales.");
                    } else {
                        System.out.println(
                                "La palabra " + palabra5 + " y la palabra " + palabra5segunda + " NO son iguales.");
                    }

                    break;
                case 7:
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

                    break;

                case 9:
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

                    break;
                case 10:
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

            } // fin del switch

        } while (opcion != 0); // fin del while

        System.out.println("\nPrograma finalizado.");
    } // fin del main
} // fin del programa
