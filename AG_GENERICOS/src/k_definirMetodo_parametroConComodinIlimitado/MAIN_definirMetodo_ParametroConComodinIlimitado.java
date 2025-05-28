package k_definirMetodo_parametroConComodinIlimitado;
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

public class MAIN_definirMetodo_ParametroConComodinIlimitado {


    // INTENTO 1
    // ==========================
    // No queremos acotar los parametros, pero si permitir tipos de colecciones de cualesquiera cosa
    // tenemos que usar COMODINES ILIMITADOS, en un método GENERICO, O NO GENERICO
    static public void recorre(List<?> lista){
        for(Object cadacosa : lista){
            System.out.println(cadacosa);
        }
    }


    public static void main(String [] args){

        Integer[] arraynumeros = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        String[]  arraycadenas = new String[]{ "uno", "dos", "tres", "cuatro"};
        Double[] arraydoubles = new Double[]{1.3, 2.7, 3.9, 2.0};

        List<Integer> listaInt = Arrays.asList(arraynumeros);
        List<Double> listaDouble = Arrays.asList(arraydoubles);
        List<String> listaString = Arrays.asList(arraycadenas);

        // llamada al método no generico, con parámetros comodin ilimitado que es una lista de tipo Integer:
        recorre(listaInt);
        // llamada al método no generico, con parámetros comodin ilimitado que es una lista de tipo double:
        recorre(listaDouble);
        // llamada al método no generico, con parámetros comodin ilimitado que es una lista de tipo String:
        recorre(listaString);


    }

}
