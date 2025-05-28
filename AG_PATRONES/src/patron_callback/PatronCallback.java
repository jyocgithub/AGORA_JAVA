package patron_callback;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatronCallback {

    // una version inicial de un método para filtrar una lista de palabras
    public static List<String> validar(List<String> input) {
        List<String> output = new ArrayList<>();
        for (String palabra : input) {
            if (palabra.length() > 4) {
                output.add(palabra);
            }
        }
        return output;
    }

    // una segunda version
    interface IFiltro {
        boolean esValida(String word);
    }

    static public List<String> filtrarPalabras(List<String> input, IFiltro filter) {
        List<String> output = new ArrayList<>();
        for (String palabra : input) {
            if (filter.esValida(palabra)) {
                output.add(palabra);

            }
        }
        return output;
    }


    // y ahora aplicamos el filtro como un callback
    static class SoloValenLasLargas implements IFiltro {
        public boolean esValida(String palabra) {
            return palabra.length() > 4;
        }
    }


    static class SoloValenPlurales implements IFiltro {
        public boolean esValida(String palabra) {
            return palabra.endsWith("s");
        }
    }

    public static void main(String[] args) {
        List<String> muchasPalabras = Arrays.asList(new String[]{"manzanas", "melocoton", "platanos", "uvas"});

        List<String> palabrasLargas = filtrarPalabras(muchasPalabras, new SoloValenLasLargas());
        System.out.println(palabrasLargas);
        List<String> palabrasPlurales = filtrarPalabras(muchasPalabras, new SoloValenPlurales());
        System.out.println(palabrasPlurales);


        List<String> palabrasLargaslambda = filtrarPalabras(muchasPalabras, new SoloValenLasLargas());
        System.out.println(palabrasLargaslambda);
        List<String> palabrasPluralesLambda = filtrarPalabras(muchasPalabras, a -> a.endsWith("s"));
        System.out.println(palabrasPluralesLambda);
    }

}