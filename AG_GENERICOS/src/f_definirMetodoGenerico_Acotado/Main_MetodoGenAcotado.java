package f_definirMetodoGenerico_Acotado;
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

public class Main_MetodoGenAcotado {


    static public <T extends Number> T existe(T[] lista, T n) {
        for (T cadacosa : lista) {
            if (cadacosa.equals(n)) {
                return cadacosa;
            }
        }
        return null;
    }


    public static void main(String[] args) {

        Integer[] arraynumeros = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Double[] arraydoubles = new Double[]{1.3, 2.7, 3.9};
        String[] arraycadenas = new String[]{"uno", "dos", "tres", "cuatro"};

        List<Integer> listaInt = Arrays.asList(arraynumeros);
        List<Double> listaDouble = Arrays.asList(arraydoubles);
        List<String> listaString = Arrays.asList(arraycadenas);

        // llamada al método generico con parametros y valor de retorno que usan tipos Integers
        int solucion1 = existe(arraynumeros, 3);

        // NOOOOOOOOO, pues String no es una subclase de Number
//        boolean solucion2 = existe(arraycadenas, "seis");

        System.out.println(solucion1);

    }

}
