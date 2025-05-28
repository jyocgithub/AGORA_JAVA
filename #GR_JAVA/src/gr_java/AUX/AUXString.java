package gr_java.AUX;
import java.io.*;
import java.util.Random;
import java.util.regex.Pattern;

/*

#######################################################################################
############################  GUIA DE CONTENIDOS ######################################
#######################################################################################
#                                                                                     #
# STRING (JAVA)                                                                       #
# #############                                                                       #
#     - isNumeric                  (String origen)                                    #
#     - indiceDeEnesimaOcurrencia  (String origen, String busqueda, int ocurrencia)   #
#     - validarRegEx               (String expresionregular, String valor)            #
#     - cuantasVecesEsta           (String origen, char busqueda)                     #
#     - generarClaveAleatoria      (int tamano)                                       #
#     - posicionEnArray            (String str, String[] donde)                       #
#     - repetirCHar                (char pchar, int pveces )                          #
#                                                                                     #
###################################### (fin) ##########################################

 */

/**
 * ***************************************************************************
 * ************ STRING (JAVA) **************
 * ***************************************************************************
 */
public class AUXString {
    /**
     * isNumeric
     * <p>
     * Devuelve true si la cadena contiene un numero
     *
     * @param strNum     Cadena que se quiere analizar
     */
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        
        // podria comprobarse solo con NumberFormatException, pero asi 
        // tambien se controla que strNum sea null 
        } catch (Exception nfe) {
            return false;
        }
        return true;
    }





    /**
     * indiceDeEnesimaOcurrencia
     * <p>
     * Devuelve la posision de una cadena en otra, en su enésima aparición
     *
     * @param origen     Cadena donde buscar
     * @param busqueda   Cadena que se busca
     * @param ocurrencia numero de ocurrencia buscada
     * @return la posision de la enésima aparición de la cadena buscada. o -1 si
     * algun parametro es incorrecto
     */
    public static int indiceDeEnesimaOcurrencia(String origen, String busqueda, int ocurrencia) {
        int pos = -1;
        if (origen == null || busqueda == null || ocurrencia < 1) {
            return -1;
        }
        do {
            pos = origen.indexOf(busqueda, pos + 1);
        } while (ocurrencia-- > 0 && pos != -1);

        return pos;
    }
    /**
     * cuantas veces
     * <p>
     * Cuenta cuantas veces aparece un char en un String
     *
     * @param origen     Cadena donde buscar
     * @param busqueda   char buscado
     * @return numero de apariciones de char en la cadena o -1 si la cadena pasada es null
     */
    public static int cuantasVecesEsta(String origen, char busqueda) {
        int cont  = 0;
        if (origen == null ) {
            return -1;
        }

        for (int i = 0; i <origen.length() ; i++) {
            if(origen.charAt(i)== busqueda){
                cont++;
            }
        }
        // version en una sola instruccion
        //cont = origen.length() - origen.replace(busqueda+"", "").length();
        return cont;
    }

    /**
     * validarRegEx
     * Valida una xexpresion regular usando Pattern, pero sin compilar la expresion
     *
     * @param expresionregular expresion regular que comprueba el valor
     * @param valor     valor que se  quiere comprobar
     * @return true si el valor cumple la expresion regular dada
     */
    public static boolean validarRegEx(String expresionregular, String valor) {
        // return valor.matches(expresionregular);  // otra forma
        return Pattern.matches(expresionregular, valor);
    }

    /**
     * generarClaveAleatoria
     * Crea una cadena de texto aleatoria con letras mayusculas minusculas y numeros, de un tamaño definido
     *
     * @param tamano tamaño de la cadena a crear
     * @return una cadena aleatoria
     */
    public static String generarClaveAleatoria(int tamano) {
        String madre ="ABCDEFGHIJKLMNOPQRSTUVWXUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random azar = new Random();
        String resultado = "";
        for (int i = 0; i < tamano ; i++) {
            resultado += madre.charAt( azar.nextInt(madre.length()));
        }
        return resultado;
    }


    /**
     * posicionEnArray
     *
     * Busca una cadena en un array de Strings
     * Devuelve posicion de la cadena, o -1 si no esta
     * @param str  cadena a buscar
     * @param donde array de string donde buscar
     * @return  posicion de la cadena, o -1 si no esta
     */
    public static int posicionEnArray(String str, String[] donde) {
        int resultado = -1;
        for (int i = 0; i < donde.length && resultado == -1; i++) {
            if (donde[i].equals(str))
                resultado = i;
        }
        return resultado;
    }


    public static String repetirChar(char pchar, int pveces) {
        return new String (new char[pveces]).replace('\0', pchar);
    }

    // por si alguien quiere probar los metodos previos .......
    public static void main(String[] args) throws IOException {

        System.out.println(repetirChar('w',15));

    }

    /**
     * RELLENAR CON BLANCOS
     * <p>
     * Rellena con blancos a la derecha una cadena , hasta el tamaño indicado parametro. Si la el tamaño es mas pequeño que la
     * cadena original recorta esta dejando solo el tamaño solicitado
     * <p>
     * Ejemplos rellenar("hola",4) -> da "hola    " rellenar("",3) -> da "   " rellenar("1234567",4) -> da "1234"
     *
     * @param cadenaARellenar cadena que se desea ampliar tamano
     * @param tamano          tamaño de la cadena final
     */
    static public String rellenarConBlancos(String cadenaARellenar, int tamano) {
        int cuantos = tamano - cadenaARellenar.length();
        if (cuantos < 1 || tamano < 1) return cadenaARellenar;
        if (cadenaARellenar.length() > tamano) return cadenaARellenar.substring(tamano);
        StringBuilder resultado = new StringBuilder(cadenaARellenar);
        for (int i = 0; i < cuantos; i++)
            resultado.append( " ");
        return resultado.toString();
//        String resultado = cadenaARellenar;
//        for (int i = 0; i < cuantos; i++)
//            resultado += " ";
//        return resultado;
    }


    /**
     * RELLENAR CON PATRON
     * <p>
     * Rellena con UN CARACTER definido a la derecha una cadena , hasta el tamaño indicado parametro. Si la el tamaño es mas pequeño
     * que la cadena original recorta esta dejando solo el tamaño solicitado
     * <p>
     * Ejemplos rellenar("hola",4) -> da "hola    " rellenar("",3) -> da "   " rellenar("1234567",4) -> da "1234"
     *
     * @param cadenaARellenar -> cadena que se desea ampliar
     * @param tamano          -> tamaño de la cadena final
     * @param patron          -> cadena de relleno
     * @param orientacion     -> true rellena por delante de la cadena parametro, false rellena por el final
     * @author Iñaki Martin
     */
    static public String rellenarConPatron(String cadenaARellenar, int tamano, String patron, boolean orientacion) {
        int cuantos = tamano - cadenaARellenar.length();
        if (cuantos < 1 || tamano < 1 || patron.length() > 1) return cadenaARellenar;
        if (cadenaARellenar.length() > tamano) return cadenaARellenar.substring(tamano);
        StringBuilder relleno = new StringBuilder();
        for (int i = 0; i < cuantos; i++)
            relleno.append(patron);
        return (orientacion ? relleno.toString() + cadenaARellenar : cadenaARellenar + relleno.toString());
    }



    /**
     * Metodo que devuelve un numero con ceros por delante
     *
     * @param : numero original - el numero que se desea convertir
     * @param : numeroDeCharTamanoFinal - el tamaño final de la cadena a devolver, con ceros a la izquierda
     * @author: Iñaki Martin
     * @return: String con el numero con ceros por delante
     * <p>
     * Si el numero a convertir es mayor que el tamaño de la cadena solicitada, devuelve el numero original Ejemplos:
     * intConCeros(3, 5) -> 00003 intConCeros(3234, 8)); -> 00003234 intConCeros(322, 2) -> 322
     */
    static public String intConCeros(int numeroOriginal, int numeroDeCharTamanoFinal) {
//        long intMaximo = (long) Math.pow(10, numeroDeCharTamanoFinal);
//        if (numeroOriginal > intMaximo) return Integer.toString(numeroOriginal);
//        long x = numeroOriginal + (intMaximo);
//        return Long.toString(x).substring(1);
        return rellenarConPatron(numeroOriginal+"", numeroDeCharTamanoFinal, "0",true);
    }


}
