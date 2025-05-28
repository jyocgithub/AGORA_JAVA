package soluciones_ejercicicios.ims.jyoc.cap06;

import java.util.Scanner;
/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 * <p>
 */

/**
 * Capitulo 6 Ejercicio b_12
 * Realizar un programa que lea una cadena de caracteres y un número entero entre 0 y 10 y,
 * después de pasar la cadena a minúsculas, codifique la cadena de la siguiente forma:
 * cada letra de la cadena se cambiará por ese carácter más el número leído.
 * Por ejemplo si el número es 3, la letra 'a' cambiará por 'd', la 'b' por 'e' etc.
 * Se considerará que el abecedario es circular y la 'z' cambiaría por la 'c'.
 * Los caracteres que no son letras no se modificarán.
 */
public class Jyoc_Ejercicio_6_b_12 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba texto a codificar");
        String texto = entrada.nextLine();
        System.out.println("Escriba numero a desplazar");
        int numero = entrada.nextInt();

        String codificado = codificar(texto, numero);
        System.out.println("Texto codificado:" + codificado);

        String descodificado = descodificar(codificado, numero);
        System.out.println("Texto descodificado:" + descodificado);

    }

    public static String codificar(String cadena, int desplazamiento) {
        String respuesta = "";
        // cadena a minusculas
        cadena = cadena.toLowerCase();
        int nuevochar;

        for (int i = 0; i < cadena.length(); i++) {
            // extraemos cada caracter de la cadena
            char cadachar = cadena.charAt(i);

            // solo cambiamos las letras, no otro caracter
            if (cadachar >= 'a' && cadachar <= 'z') {
                nuevochar = (char) cadachar + desplazamiento;
                if (nuevochar > 'z') {
                    nuevochar = ('a' - 1) + (nuevochar - 'z');
                }
            } else {
                nuevochar = cadachar;
            }
            respuesta = respuesta + (char) nuevochar;
        }
        return respuesta;
    }

    public static String descodificar(String cadena, int desplazamiento) {
        String respuesta = "";
        int nuevochar;

        for (int i = 0; i < cadena.length(); i++) {
            // extraemos cada caracter de la cadena
            char cadachar = cadena.charAt(i);

            // solo cambiamos las letras, no otro caracter
            if (cadachar >= 'a' && cadachar <= 'z') {
                nuevochar = cadachar - desplazamiento;
                if (nuevochar < 'a') {
                    nuevochar = ('z' + 1) - ('a' - nuevochar);
                }
            } else {
                nuevochar = cadachar;
            }
            respuesta = respuesta + (char) nuevochar;
        }
        return respuesta;
    }
}
