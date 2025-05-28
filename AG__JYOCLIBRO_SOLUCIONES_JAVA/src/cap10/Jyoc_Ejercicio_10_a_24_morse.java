package cap10;
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

import java.util.HashMap;

public class Jyoc_Ejercicio_10_a_24_morse {

    public static void main(String[] args) {

        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("A", ".-");
        mapa.put("B", "-...");
        mapa.put("C", "-.-.");
        mapa.put("D", "-..");
        mapa.put("E", ".");
        mapa.put("F", "..-.");
        mapa.put("G", "--");
        mapa.put("H", "....");
        mapa.put("I", "..");
        mapa.put("J", ".---");
        mapa.put("K", "-.-.");
        mapa.put("L", ".-..");
        mapa.put("M", "--");
        mapa.put("N", "-.");
        mapa.put("O", "---.");
        mapa.put("P", ".--.");
        mapa.put("Q", "--.-");
        mapa.put("R", ".-.");
        mapa.put("S", "...");
        mapa.put("T", "-");
        mapa.put("U", "..-");
        mapa.put("V", "...-");
        mapa.put("W", ".--");
        mapa.put("X", "-..-");
        mapa.put("Y", "-.--");
        mapa.put("Z", "--..");

        String texto = "buenas tardes";

        char letraText = '\0';

        // recorremos el texto y sacamos una a una cada letra
        for (int i = 0; i < texto.length(); i++) {
            letraText = texto.toUpperCase().charAt(i);

            // convertimos el char en string, pues el mapa tiene string como clave
            // tambien podemos evitar esta linea si ponemos en el mapa la clave como char
            String letrastring = letraText + "";

            // ahora, con la letra, buscamos entre las claves su valor morse
            String valormorse = mapa.get(letrastring);

            // si la letra es una clave del mapa, nos devuelve su valor, si no, nos daria null
            if(valormorse!=null) {
                System.out.println(valormorse);
            }
        }
    }
}
