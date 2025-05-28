package cap01;

import java.util.Random;

/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */



/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Realiza un programa que genere un carácter aleatorio entre el 32 y el 125
 * y nos diga si pertenece a una letra minúscula, mayúscula o a ninguno de esos casos
 */
public class Jyoc_Ejercicio_1_c_02 {
    public static void main(String[] args) {

        Random azar = new Random();
        int car = azar.nextInt(125 - 31 + 1) + 31;

        System.out.println("Ascii elegid0 :" + car);
        if (car >= 'a' && car <= 'z') {
            System.out.println("es una letra minuscula");
        }
        if (car >= 'A' && car <= 'Z') {
            System.out.println("es una letra mayuscula");
        }
        if (car >= '0' && car <= '9') {
            System.out.println("es un numero");
        }
    }
}
