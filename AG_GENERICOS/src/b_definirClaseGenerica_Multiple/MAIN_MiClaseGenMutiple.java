package b_definirClaseGenerica_Multiple;
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

public class MAIN_MiClaseGenMutiple {

    public static void main(String [] args){

        // clase cuyos atributos son un String, un Integer y un Double
        MiClaseGenMultiple<String,Integer,Double> objetoconStringIntDouble = new MiClaseGenMultiple<>("texto",1,22.33);
        objetoconStringIntDouble.setInformacion("alguna cosa");
        objetoconStringIntDouble.setOrigen(33);
        String cosa = objetoconStringIntDouble.getInformacion();
        double algo = objetoconStringIntDouble.getDestino();

        // clase cuyos atributos son un Integer, otro Integer y un String
        MiClaseGenMultiple<Integer,Integer,String> objetoconIntIntString = new MiClaseGenMultiple<>(2,6,"texto");
        objetoconIntIntString.setInformacion(33);
        objetoconIntIntString.setOrigen(33);
        int num = objetoconIntIntString.getInformacion();
        String tex = objetoconIntIntString.getDestino();

        // clase cuyos atributos son un Perro, un Integer y un String
        MiClaseGenMultiple<Perro,Integer,String> objetoconPerroIntString = new MiClaseGenMultiple<>( new Perro("Blas", 12, "Caniche"),6,"texto");
        objetoconPerroIntString.getInformacion().nombre = "Pepillo";
        Perro per = objetoconPerroIntString.getInformacion();


    }

}
