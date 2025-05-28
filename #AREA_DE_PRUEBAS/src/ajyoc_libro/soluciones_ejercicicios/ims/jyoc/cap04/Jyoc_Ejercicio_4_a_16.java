package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.IOException;
import java.util.Random;

/**
 * Capitulo 4 Ejercicio a_16
 * <p>
 * Escribir un programa que genere 50 números enteros aleatorios
 * entre el 97 y el 123 que representarán las letras minusculas del alfabeto
 * (exceptuando la ñ), los almacene en un vector de char, y cuente
 * cuantas vocales se han generado.
 * Mostrar todas las letras generadas en una linea y el numero de vocales en la siguiente
 * Nota: para pasar del código entero a carácter puedes utilizar:
 * char c = (char) numero;
 */

public class Jyoc_Ejercicio_4_a_16 {
    public static void main(String[] args) throws IOException {
        char[] letras = new char[50];
        Random rn = new Random();
        int cont = 0;
        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 50; j++) {
            letras[j] = (char) (rn.nextInt(123 - 97) + 97);
            if (letras[j] == 'a' || letras[j] == 'e' || letras[j] == 'i' ||
                    letras[j] == 'o' || letras[j] == 'u') {
                cont++;
            }
        }

        System.out.print("LETRAS: ");
        for (int j = 0; j < 50; j++) {
            System.out.print(letras[j]);
        }
        System.out.print("\nNumero de vocales: " + cont);

    }
}
