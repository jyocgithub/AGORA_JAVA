package soluciones_ejercicicios.ims.jyoc.cap06;

import java.util.Scanner;
/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 6 Ejercicio a_12
 * <p>
 * Escribir un método que devuelva el número de caracteres que hay entre la primera
 * y última aparición de un carácter concreto en una cadena.
 * El método será int calcularDistancia(String cadena, String letra).
 * Por ejemplo, si se le pasa ”Hola Juan Antonio Santos” y el String “a” debe devolver 15,
 * pues entre la primera y última “a” hay 15 caracteres (" Juan Antonio S")
 */

public class Jyoc_Ejercicio_6_a_12 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba frase");
        String texto = entrada.nextLine();
        System.out.println("Escriba letra");
        String letra = entrada.nextLine();

        int res = calcularDistancia(texto, letra);
        System.out.println("suma de numeros de la frase:" + res);
    }

    public static int calcularDistancia(String cadena, String letra) {
        int res = 0;
        int ini = cadena.indexOf(letra);
        int fin = cadena.lastIndexOf(letra);
        res = fin - ini;
        return res;
    }

}
