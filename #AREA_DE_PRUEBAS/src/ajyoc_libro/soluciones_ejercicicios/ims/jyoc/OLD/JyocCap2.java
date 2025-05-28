package soluciones_ejercicicios.ims.jyoc.OLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 2
 *
 * @author Iñaki Martin
 */

public class JyocCap2 {

    public static void main(String[] args) {

        /**
         * Ejercicio 1 (dificultad 1) Escribir un programa que crea e inicializa
         * dos variables con números enteros y muestre :
         * "El numero [poner aquí el primer numero] sumado a [poner aquí el otro numero] da [poner el resultado]"
         * "El numero [poner aquí el primer numero] restado a [poner aquí el otro numero] da [poner  el resultado]"
         * "El numero [poner aquí el primer numero] multiplicado por [poner aquí el otro numero] da [poner el resultado]"
         * "El numero [poner aquí el primer numero] dividido entre [poner aquí el otro numero] da [poner el resultado]"
         */
        System.out.println("\n\n Ejercicio 2.1\n\n");
        Scanner objetoScanner1 = new Scanner(System.in);
        System.out.println("Indíque un numero: ");
        int numero1 = objetoScanner1.nextInt();
        System.out.println("Indíque otro numero: ");
        int numero2 = objetoScanner1.nextInt();
        System.out.println("El numero " + numero1 + " sumado a " + numero2 + " da " + (numero1 + numero2));
        System.out.println("El numero " + numero1 + " restado a " + numero2 + " da " + (numero2 - numero1));
        System.out.println("El numero " + numero1 + " multiplicado por " + numero2 + " da " + (numero1 * numero2));
        System.out.println("El numero " + numero1 + " dividido entre " + numero2 + " da " + (numero1 / numero2));

        /**
         * Ejercicio 2 (dif 2) Diseñe un programa que convierta una temperatura
         * en grados Celsius a Fahrenheit. La temperatura celsius se guarda en
         * una variable double. Una temperatura en grados Celsius o centígrados
         * puede convertirse a su equivalente en Fahrenheit de acuerdo con la
         * siguiente fórmula: f = (9/5) * C + 32
         *
         */
        System.out.println("\n\n Ejercicio 2.2\n\n");
        Scanner objetoScanner2 = new Scanner(System.in);
        System.out.println("Indíque un numero de grados Celsius: ");
        int gradosCelsius = objetoScanner2.nextInt();
        double gradosFarenheit = ((9 / 5) * gradosCelsius) + 32;
        System.out.println(gradosCelsius + " grados Celsius son " + gradosFarenheit + "grados Farenheit");

        /**
         * Ejercicio 3 (dif 4) Programa que pone en una variable int un numero
         * de segundos y nos dice a cuantas horas, minutos y segundos
         * corresponde dicha cantidad de segundos. Por ejemplo, si en el
         * programa se define un int seg = 3734, después nos dice; 3734 segundos
         * son 1 horas 2 minutos y 14 segundos
         *
         */
        System.out.println("\n\n Ejercicio 2.3\n\n");
        Scanner objetoScanner3 = new Scanner(System.in);
        System.out.println("Indíque un numero de segundos: ");
        int segundos = objetoScanner3.nextInt();

        int minutos = segundos / 60;
        segundos = segundos % 60;
        int horas = minutos / 60;
        minutos = minutos % 60;

        System.out.println(
                segundos + " segundo son " + horas + " horas , " + minutos + " minutos y " + segundos + " segundos ");

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
         * Ejercicio 6 (dif 2) Escribir un programa que escriba este texto por
         * consola, utilizando secuencias de escape, con un solo System.out:
         * Estas líneas son difíciles, necesito poner una \ , pero no se si será
         * mas fácil decir "una barra", ayudadme !!!
         *
         */
//		System.out.println("\n\n Ejercicio 2.6\n\n");
//		System.out.printf("Estas líneas son difíciles,\nnecesito poner una \\ , pero no se si será\n"
//				+ "mas fácil decir \"una barra\", ayudadme !!!");

        /**
         * Ejercicio 2.7.- (dif 1) Pide un nombre por pantalla y da por consola
         * la bienvenida, p.e., "Bienvenido Juan !!!"
         *
         */
        System.out.println("\n\n Ejercicio 2.7\n\n");

//		// -- Opción con Scanner
//		Scanner objeto7 = new Scanner(System.in);
//		System.out.println("Indíqueme su nombre, por favor: ");
//		String nombre = objeto7.nextLine();
//		System.out.println("¡¡ Bienvenido, señor " + nombre + " !!");
//
//		// -- Opción con BufferedReader
//		InputStreamReader objetoIsr = new InputStreamReader(System.in);
//		BufferedReader objetoBf = new BufferedReader(objetoIsr);
//		System.out.println("Indíqueme su nombre, por favor: ");
//		String nombre2 = "";
//		try {
//			nombre2 = objetoBf.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("¡¡ Bienvenido, señor " + nombre2 + " !!");

        /**
         * Ejercicio 2.8.- (dif 1) Pide un número por teclado y muestra el
         * carácter que le corresponde en la tabla ASCII, p.e., si le doy 65, me
         * muestra "es una A"
         *
         */
        System.out.println("\n\n Ejercicio 2.8\n\n");
//		Scanner objetoScanner8 = new Scanner(System.in);
//		System.out.println("Indíque un numero asii para un caracter: ");
//		int numeroAscii = objetoScanner8.nextInt();
//		char caracterAscii = (char) numeroAscii;
//		System.out.println("El numero ASCII " + numeroAscii + " corresponde al caracter " + caracterAscii);

        /**
         * Ejercicio 2.9.- (dif 1) Pide un número por teclado y muestra el
         * carácter que le corresponde en la tabla ASCII, p.e., si le doy 65, me
         * muestra "es una A"
         *
         */
//		System.out.println("\n\n Ejercicio 2.9\n\n");
//		final double PI = 3.14159;
//		Scanner objetoScanner9 = new Scanner(System.in);
//		System.out.println("Indíque un numero para el radio del círculo: ");
//		int numeroRadio = objetoScanner9.nextInt();
//		double areaCirculo = (2 * PI) * numeroRadio;
//		System.out.println("El area del círculo de radio " + numeroRadio + " es " + areaCirculo);

        /**
         * Ejercicio 2.10.- (dif 1) Leer el precio de un producto por teclado, y
         * nos die el precio con IVA añadido (suponemos un IVA único del 21% )
         */
        System.out.println("\n\n Ejercicio 2.10\n\n");
//		final int IVA = 21;
//		Scanner objetoScanner10 = new Scanner(System.in);
//		System.out.println("Indíque el precio del producto: ");
//		int importeProducto = objetoScanner10.nextInt();
//		double importeConIva = (importeProducto) + (importeProducto / 100 * IVA);
//		System.out.println("El precio del producto con IVA del 21% incluido es de " + importeConIva);


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

    }

}
