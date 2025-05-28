package j_definirMetodo_parametroConComodinAcotado;
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

import java.util.Arrays;
import java.util.List;

public class MAIN_definirMetodo_ParametroConComodinAcotado {

    // esto es un intento de acotar un parametro de un método

    // INTENTO 1
    // ==========================
    // asi intento acotar un parametro de un método, pero NO SE PUEDE USAR T EXTENDS EN UN PARAMETRO
//    static public <T>  boolean existe1(List<T extends Number> lista, int n){


    // INTENTO 2
    // ==========================
    // ahora intento esto, con un método no GENERICO con parámetros de tipo Number
    // esperando al menos poder poner u number o toda su herencia, por polimorfismo
    static public boolean existe2(List<Number> lista, Number n) {
        for (Number cadacosa : lista) {
            if (cadacosa.equals(n))   return true;
        }
        return false;
    }

    // INTENTO 3
    // ==========================
    // ahora intento esto, con un método-GENERICO con parámetros no acotados:
    static public <T> boolean existe3(List<T> lista, Object n) {
        for (Object cadacosa : lista) {
            if (cadacosa.equals(n))   return true;
        }
        return false;
    }

    // INTENTO 4
    // ==========================
    // pero si queremos realmente acotar los parametros, para ello,
    // tenemos que usar COMODINES, en un método GENERICO, O NO GENERICO
    static public boolean existe4(List<? extends Number> lista, int n){
        for(Number cadacosa : lista){
            if (cadacosa.equals(n))   return true;
        }
        return false;
    }


    public static void main(String [] args){

        Integer[] arraynumeros = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        String[]  arraycadenas = new String[]{ "uno", "dos", "tres", "cuatro"};
        Double[] arraydoubles = new Double[]{1.3, 2.7, 3.9, 2.0};

        List<Integer> listaInt = Arrays.asList(arraynumeros);
        List<Double> listaDouble = Arrays.asList(arraydoubles);
        List<String> listaString = Arrays.asList(arraycadenas);

        // ------- INTENTO 1
        // no se puede crear el metodo

        // ------- INTENTO 2
        // Usando el método no generico con parámetro Number:

        // NNNOOOOOOOOOO FUNCIONA, pues resulta que el metodo espera un List<Number>
        // y le pasamos un List<Integer>, y resulta que un Integer si es un Number,
        // pero un  List<Integer>    NO ES UN   List<Number>
//        boolean solucion1 = existe2(listaInt, 3);

        // ------- INTENTO 2
        // Usando el "intento" del método-generico con parámetro no acotado:

        // llamada al método-generico con parametros NO acotados, usando tipos Integer
        boolean solucion1 = existe3(listaInt, 3);
        // llamada al método-generico con parametros NO acotados, usando tipos Double
        boolean solucion2 = existe3(listaDouble, 2);

        System.out.println(solucion1);
        System.out.println(solucion2);

        // pero es que tambien nos deja, esto:
        // llamada al método-generico con parametros NO acotados, usando tipos String
        // NO HEMOS LIMITADO EL ACCESO !!!!!!!!
        boolean solucion3 = existe3(listaString, "uno");
        System.out.println(solucion3);


        // ------- INTENTO 3
        // Usando el método no generico, con parámetros comodin acotado:

        // llamada al método no generico, con parámetros comodin acotado que es una lista de tipo Integer:
        boolean solucion4 = existe4(listaInt, 3);
        // llamada al método no generico, con parámetros comodin acotado que es una lista de tipo double:
        boolean solucion5 = existe4(listaDouble, 2);

        System.out.println(solucion4);
        System.out.println(solucion5);

        // NNNOOOOOOOOOOOO , esto no nos deja, pues listaString no es una lista de subclases de Number
//        boolean solucion6 = existe1(listaString, "uno");


    }

}
