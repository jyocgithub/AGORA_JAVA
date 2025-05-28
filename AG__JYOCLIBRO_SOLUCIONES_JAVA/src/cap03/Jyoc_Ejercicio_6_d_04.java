package cap03;

import java.util.Scanner;

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
 *
 * @author Iñaki Martin
 */

/*
 Dado este esqueleto de programa,

 System.out.println("=========== CODIGO MORSE ===========");
 System.out.println("-------------------------------------");
 System.out.println(":A .-       :  B -... :  C -.-. :  D -.. ");
 System.out.println(":E .        :  F ..-. :  G --.  :  H ....");
 System.out.println(":I ..       :  J .--- :  K -.-. :  L .-..");
 System.out.println(":M --       :  N -.   :  O ---. :  P .--.");
 System.out.println(":Q --.-     :  R .-.  :  S ...  :  T - ");
 System.out.println(":U ..-      :  V ...- :  W .--  :  X -..- ");
 System.out.println(":Y -.--     :  Z --.. ");
 System.out.println(“——————————————————");

 String[] codigos = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
 "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
 "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
 "-.--", “--.." };

 donde se define un array de strings que corresponden con cada letra del abecedario, hacer un programa que pida al usuario por teclado un texto, y posteriormente escriba por consola la secuencia en morse que representa dicho texto. Ejemplo de ejecución del programa:

 Escribe el texto que vamos a enviar por morse:
 hola
 Enviamos:
 ....
 ---
 .-..
 .-

 */
public class Jyoc_Ejercicio_6_d_04 {

    public static void main(String[] args) {

        System.out.println("=========== CODIGO MORSE ===========");
        System.out.println("-------------------------------------");
        System.out.println(":A .-       :  B -... :  C -.-. :  D -.. ");
        System.out.println(":E .        :  F ..-. :  G --.  :  H ....");
        System.out.println(":I ..       :  J .--- :  K -.-. :  L .-..");
        System.out.println(":M --       :  N -.   :  O ---. :  P .--.");
        System.out.println(":Q --.-     :  R .-.  :  S ...  :  T - ");
        System.out.println(":U ..-      :  V ...- :  W .--  :  X -..- ");
        System.out.println(":Y -.--     :  Z --.. ");
        System.out.println("-------------------------------------");

        String[] codigos = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el texto que vamos a enviar por morse:");
        String texto = sc.nextLine();
        texto = texto.toUpperCase();
        System.out.println("Enviamos:");
        for (int i = 0; i <texto.length() ; i++) {
            char c = texto.charAt(i);
            int indice = c-'A';
            System.out.println(codigos[indice]);
        }

    }
}

/*
  ____          _____               _ _           _
 |  _ \        |  __ \             (_) |         | |
 | |_) |_   _  | |__) |_ _ _ __ _____| |__  _   _| |_ ___
 |  _ <| | | | |  ___/ _` | '__|_  / | '_ \| | | | __/ _ \
 | |_) | |_| | | |  | (_| | |   / /| | |_) | |_| | ||  __/
 |____/ \__, | |_|   \__,_|_|  /___|_|_.__/ \__, |\__\___|
         __/ |                               __/ |
        |___/                               |___/

  ____      _    _____               _ _           _
 |  _ \    | |  __ \             (_) |         | |
 | |_) |_  | |  | |__) |_ _ _ __ _____| |__  _   _| |_ ___
 |  _ <| | | | |  ___/ _` | '__|_  / | '_ \| | | | __/ _ \
 | |_) |   | | | |  | (_| | |   / /| | |_) | |_| | ||  __/
           | | |_|   \__,_|_|  /___|_|_.__/ \__, |\__\___|
         __/ |                               __/ |
        |___/                               |___/


  ____          _____               _ _           _
 |  _ \        |  __ \             (_) |         | |
 | |_) |_   _  | |__) |_ _ _ __ _____| |__  _   _| |_ ___
 |  _ <| | | | |  ___/ _` | '__|_  / | '_ \| | | | __/ _ \
 | |_) | |_| | | |  | (_| | |   / /| | |_) | |_| | ||  __/
 |____/ \__, | |_|   \__,_|_|  /___|_|_.__/ \__, |\__\___|
         __/ |                               __/ |
        |___/                               |___/


  ____          _____               _ _           _
 |  _ \        |  __ \             (_) |         | |
 | |_) |_   _  | |__) |_ _ _ __ _____| |__  _   _| |_ ___
 |  _ <| | | | |  ___/ _` | '__|_  / | '_ \| | | | __/ _ \
 | |_) | |_| | | |  | (_| | |   / /| | |_) | |_| | ||  __/
 |____/ \__, | |_|   \__,_|_|  /___|_|_.__/ \__, |\__\___|
         __/ |                               __/ |
        |___/                               |___/






 */