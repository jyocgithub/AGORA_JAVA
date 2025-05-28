package h_instanciandoClasesGen_comodinIlimitado;
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

import z_clases_para_ejemplos.Animal;
import z_clases_para_ejemplos.Perro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAIN_instanciandoClasesGen_comodinIlimitado {

    public static void main(String[] args) {

        /*
        Se puede pensar en que las clases genericas de comodines son como clases de "solo lectura" puesto que no se pueden añadir ni modificar elementos
        Esto es casi cierto, aunque hay cosas que sí se pueden hacer para modificar su contenido. Por ejemplo, con una lista generica con comodines:
        - Se puede añadir un elemento null (esto vale para cualquier clases genericas de comodines, no solo listas)
        - Se puede usar el método clear()
        - Se puede usar su iterator y llamar al método remove()
         */

        Integer[] arraynumeros = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Double[] arraydoubles = new Double[]{1.3, 2.7, 3.9};
        String[] arraycadenas = new String[]{"uno", "dos", "tres", "cuatro"};

        List<Integer> listaInt = Arrays.asList(arraynumeros);
        List<Double> listaDouble = Arrays.asList(arraydoubles);
        List<String> listaString = Arrays.asList(arraycadenas);

        List<Animal> listaAnimales = new ArrayList<>();
        listaAnimales.add(new Animal("pepe",12));
        listaAnimales.add(new Animal("paco",23));
        listaAnimales.add(new Animal("pisto",2));
        listaAnimales.add(new Animal("plasta",7));

        List<Perro> listaPerros = new ArrayList<>();
        listaPerros.add(new Perro("blas",12,"bulldog"));
        listaPerros.add(new Perro("blasito",23,"caniche"));
        listaPerros.add(new Perro("blum",2,"doberman"));
        listaPerros.add(new Perro("blam",7,"dogo"));

//    + ------------------------------ +
//    |                                |
//    |       COMODINES ILIMITADOS     |
//    |                                |
//    + ------------------------------ +

        // instanciando una lista con comodin-ilimitado que contiene un arraylist de enteros

        ArrayList<?> listaVaciaIlimitada1 = new ArrayList<>();
        // NNOOOOOOOOOOOOOO  no se puede modificar el contenido de una lista con comodines
//        listaVaciaIlimitada.add(32);

        // instanciando una lista con comodin-ilimitado que contiene un arraylist de enteros
        List<?> listaVaciaIlimitada2 = listaInt;
        for (Object cadaelemento : listaVaciaIlimitada2) {
            if ((int) cadaelemento > 3) {            // se necesita, claro, un cast para saber qué es realmente cadaelemento
                System.out.println(cadaelemento);
            }
        }

        // instanciando una lista con comodin-ilimitado que contiene un arraylist de doubles
        List<?> listaVaciaIlimitada3 = listaDouble;
        for (Object cadaelemento : listaVaciaIlimitada3) {
            if ((double) cadaelemento > 3) {            // se necesita, claro, un cast para saber qué es realmente cadaelemento
                System.out.println(cadaelemento);
            }
        }

        // instanciando una lista con comodin-ilimitado que contiene un arraylist de Perros
        List<?> listaVaciaIlimitada4 = listaPerros;
        for (Object cadaelemento : listaVaciaIlimitada4) {
            Animal anim = (Animal) cadaelemento ;         // se necesita, claro, un cast para saber qué es realmente cadaelemento
            if ( anim.peso > 3) {
                System.out.println(((Animal) cadaelemento).nombre);
            }
        }


        // instanciando una lista RAW que contiene un arraylist de Perros
        List listaRAWvacia = listaPerros;
        for (Object cadaelemento : listaRAWvacia) {
            Perro anim = (Perro) cadaelemento ;         // se necesita, claro, un cast para saber qué es realmente cadaelemento
            if ( anim.peso > 3) {
                System.out.println(((Animal) cadaelemento).nombre);
            }
        }

        List<Object> listaobject = new ArrayList<>();
        listaobject.add(123);
        listaobject.add("w34");
        listaobject.add(new Perro("blas",12,"bulldog"));


    }

}
