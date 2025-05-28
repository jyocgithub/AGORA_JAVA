package d_definirMetodoGenerico_SimpleEnParametrosORetorno;
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

public class Main_MetodoGenSimpleEnParametrosORetorno {


    // método generico con parametros que usan tipos T
    static public <T> boolean existe(T[] lista,T n){
        for(T cadacosa : lista){
            if(cadacosa.equals(n)){
                return true;
            }
        }
        return false;
    }

    // método generico con parametros y retorno que usan tipos T
    static public <T> T existe2(T[] lista,T n){
        for(T cadacosa : lista){
            if(cadacosa.equals(n)){
                return cadacosa;
            }
        }
        return null;
    }


    public static void main(String [] args){

        Integer[] arraynumeros = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        String[]  arraycadenas = new String[]{ "uno", "dos", "tres", "cuatro"};

        List<Integer> listaInt = Arrays.asList(arraynumeros);
        List<String> listaString = Arrays.asList(arraycadenas);

        // llamada al método generico con parametros que usando tipos Integers
        boolean solucion1 = existe(arraynumeros, 3);
        // llamada al método generico con parametros que usando tipos String
        boolean solucion2 = existe(arraycadenas, "seis");



        System.out.println(solucion1);
        System.out.println(solucion2);


        // llamada al método generico con parametros y valor de retorno que usan tipos Integers
        Integer solucion3 = existe2(arraynumeros, 3);
        // llamada al método generico con parametros y valor de retorno que usan tipos String
        String solucion4 = existe2(arraycadenas, "seis");

        System.out.println(solucion3);
        System.out.println(solucion4);

    }

}
