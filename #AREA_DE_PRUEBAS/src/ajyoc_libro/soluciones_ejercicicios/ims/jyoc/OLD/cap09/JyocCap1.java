package soluciones_ejercicicios.ims.jyoc.OLD.cap09;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 *
 * @author Iñaki Martin
 */

public class JyocCap1 {

    public static void main(String[] args) {

        /**
         * Ejercicio 1 (dificultad 1) Escribir un programa que crea e inicializa
         * dos variables con números enteros y muestre :
         * "El numero [poner aquí el primer numero] sumado a [poner aquí el otro numero] da [poner el resultado]"
         * "El numero [poner aquí el primer numero] restado a [poner aquí el otro numero] da [poner  el resultado]"
         * "El numero [poner aquí el primer numero] multiplicado por [poner aquí el otro numero] da [poner el resultado]"
         * "El numero [poner aquí el primer numero] dividido entre [poner aquí el otro numero] da [poner el resultado]"
         */
//		System.out.println("\n\n Ejercicio 1.1\n\n");
//		int numero1 = 23;
//		int numero2 = 45;
//		System.out.println("El numero " + numero1 + " sumado a " + numero2 + " da " + (numero1 + numero2));
//		System.out.println("El numero " + numero1 + " restado a " + numero2 + " da " + (numero2 - numero1));
//		System.out.println("El numero " + numero1 + " multiplicado por " + numero2 + " da " + (numero1 * numero2));
//		System.out.println("El numero " + numero1 + " dividido entre " + numero2 + " da " + (numero1 / numero2));

        /**
         * Ejercicio 2 (dif 2) Diseñe un programa que convierta una temperatura
         * en grados Celsius a Fahrenheit. La temperatura celsius se guarda en
         * una variable double. Una temperatura en grados Celsius o centígrados
         * puede convertirse a su equivalente en Fahrenheit de acuerdo con la
         * siguiente fórmula: f = (9/5) * C + 32
         *
         */
//		System.out.println("\n\n Ejercicio 1.2\n\n");
//		int gradosCelsius = 44;
//		double gradosFarenheit = ((9 / 5) * gradosCelsius) + 32;
//		System.out.println(gradosCelsius + " grados Celsius son " + gradosFarenheit + " grados Farenheit");

        /**
         * Ejercicio 3 (dif 4) Programa que pone en una variable int un numero
         * de segundos y nos dice a cuantas horas, minutos y segundos
         * corresponde dicha cantidad de segundos. Por ejemplo, si en el
         * programa se define un int seg = 3734, después nos dice; 3734 segundos
         * son 1 horas 2 minutos y 14 segundos
         *
         */
//		System.out.println("\n\n Ejercicio 1.3\n\n");
//		int segundos = 3661;
//		int minutos = segundos / 60;
//		segundos = segundos % 60;
//		int horas = minutos / 60;
//		minutos = minutos % 60;
//
//		System.out.println(
//				segundos + " segundo son " + horas + " horas , " + minutos + " minutos y " + segundos + " segundos ");

        /**
         * Ejercicio 4 (dif 3) Escribir un programa que dada una variable String
         * que tenga una frase, deje solo la primera palabra
         *
         */
//		System.out.println("\n\n Ejercicio 1.4\n\n");
//		String frase = "Vamos a probar con esta frase";
//		int posicionPrimerEspacio = frase.indexOf(" ");
//		String primeraPalabra = frase.substring(0, posicionPrimerEspacio);
//		System.out.println("La frase original es : " + frase);
//		System.out.println("y su primera palabra es : " + primeraPalabra);

        /**
         * Ejercicio 5 (dif 1) ¿Cuál es el resultado de evaluar cada una de las
         * siguientes expresiones que usan h? ¿Qué valor tiene x al final de
         * todas las acciones? (Suponemos que se ejecutan todas seguidas)
         *
         * boolean h; int x=1; h = (x > 1) & (x++ < 10) //caso a h = (1 >= x) &&
         * ( 1 < x++) //caso b h = (1 == x) | (10 > x++) //caso c h = (2 == x)
         * || (10 > x++) //caso d x = (++x) + x; //caso e x = x + (++x) //caso f
         *
         */
        System.out.println("\n\n Ejercicio 1.5\n\n");
//		boolean h;
//		int x = 1;
//		h = (x > 1) & (x++ < 10); // caso a
//		h = (1 >= x) && (1 < x++); // caso b
//		h = (1 == x) | (10 > x++); // caso c
//		h = (2 == x) || (10 > x++); // caso d
//		x = (++x) + x; // caso e
//		x = x + (++x); // caso f
//
//		System.out.println("En el caso (a), la variable h es :" + false);
//		System.out.println("En el caso (b), la variable h es :" + false);
//		System.out.println("En el caso (c), la variable h es :" + false);
//		System.out.println("En el caso (d), la variable h es :" + false);
//		System.out.println("En el caso (e), la variable x es :" + 10);
//		System.out.println("En el caso (f), la variable x es :" + 21);

        /**
         * Ejercicio 6 (dif 2) Escribe un programa que de una variable String
         * que es una frase, ponga la mitad primera de la misma en mayúsculas.
         *
         */
//		System.out.println("\n\n Ejercicio 1.6\n\n");
//		String frase2 = "Consideremos que esta es la frase de este ejemplo";
//		int posicionMedio = frase2.length() / 2;
//		String primeraMitad = frase2.substring(0, posicionMedio);
//		System.out.println("La frase original es : " + frase2);
//		System.out.println("y su primera mitad es : " + primeraMitad);

    }

}
