package a_definirClaseGenerica_Simple;
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

import z_clases_para_ejemplos.Perro;

import java.util.Arrays;
import java.util.List;

public class MAIN_MiClaseGenSimple {

    public static void main(String [] args){

        // clase cuyo atributo es un String
        MiClaseGenSimple<String>  objetoconstring = new MiClaseGenSimple<String>("algo");
        objetoconstring.setInformacion("alguna cosa");
        String cosa = objetoconstring.getInformacion();

        // clase cuyo atributo es un Integer
        MiClaseGenSimple<Integer> objetoconint = new MiClaseGenSimple<Integer>(332);
        objetoconint.setInformacion(123);
        int  cosa2 = objetoconint.getInformacion();

        // clase cuyo atributo es un Double
        MiClaseGenSimple<Double>  objetoconDouble = new MiClaseGenSimple<Double>(53.63);
        objetoconDouble.setInformacion(125.23);
        double cosa3 = objetoconDouble.getInformacion();

        // clase cuyo atributo es un objeto de Perro
        MiClaseGenSimple<Perro>  objetoPerro = new MiClaseGenSimple<Perro>( new Perro("Blas", 12, "Caniche"));

        // clase cuyo atributo es una lista de enteros
        Integer[] arraynumeros = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listaInt = Arrays.asList(arraynumeros);
        MiClaseGenSimple< List<Integer>> objetoconlistaInteger = new MiClaseGenSimple< List<Integer>>(listaInt);

    }

}


