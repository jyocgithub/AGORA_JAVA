package c_definirClaseGenerica_Acotado;
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

public class MAIN_MiClaseGenAcotada {

    public static void main(String [] args){


        // clase cuyo atributo es un Integer
        MiClaseGenAcotada<Integer> objetoconint = new MiClaseGenAcotada<Integer>(332);
        objetoconint.setInformacion(123);
        int  cosa2 = objetoconint.getInformacion();

        // clase cuyo atributo es un Double
        MiClaseGenAcotada<Double> objetoconDouble = new MiClaseGenAcotada<Double>(53.63);
        objetoconDouble.setInformacion(125.23);
        double cosa3 = objetoconDouble.getInformacion();

        // NOOOOOOOOOOOO : no puede ser un String, pues String no es subclase de Number
//        MiClaseGenAcotada<String> objetoconstring = new MiClaseGenAcotada<String>("algo");

        // NOOOOOOOOOOOO : no puede ser un Perro, pues Perro no es subclase de Number
//        MiClaseGenAcotada<Perro> objetoconstring = new MiClaseGenAcotada<Perro>(new Perro("Blas", 12, "Caniche"));

        // clase cuyo atributo es un Perro, de una acotada que exitiende de Animal
        MiClaseGenAcotadaDeAnimal<Perro> objetoconstring = new MiClaseGenAcotadaDeAnimal<Perro>(new Perro("Blas", 12, "Caniche"));

    }

}
