package g_instanciandoClasesGen_comodinAcotado;
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

public class MAIN_instanciandoClasesGen_comodinAcotado {

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
//    |       COMODINES ACOTADOS       |
//    |       CON EXTENDS              |
//    |                                |
//    + ------------------------------ +

        // instanciando una lista con comodin-acotado (a extends Number) que contiene un arraylist vacio
        List<? extends Number> listaVaciaDeExtendsNumber = new ArrayList<>();
        // NNOOOOOOOOOOOOOO  no se puede modificar el contenido de una lista con comodines
//        listaVaciaDeExtendsNumber.add(32);

        // instanciando una lista con comodin-acotado (a extends Number) que contiene un arraylist de enteros
        List<? extends Number> listaDeExtendsNumber1 = listaInt;
        for (Object cadaelemento : listaDeExtendsNumber1) {
            if ((int) cadaelemento > 3) {            // se necesita, claro, un cast para saber qué es realmente cadaelemento
                System.out.println(cadaelemento);
            }
        }

        // instanciando una lista con comodin-acotado (a extends Number) que contiene un arraylist de doubles
        List<? extends Number> listaDeExtendsNumber2 = listaDouble;
        for (Object cadaelemento : listaDeExtendsNumber2) {
            if ((double) cadaelemento > 3) {            // se necesita, claro, un cast para saber qué es realmente cadaelemento
                System.out.println(cadaelemento);
            }
        }

        // instanciando una lista con comodin-acotado (a extends Animal) que contiene un arraylist de animales
        List<? extends Animal> listaDeExtendsAnimal = listaAnimales;
        for (Object cadaelemento : listaDeExtendsAnimal) {
            Animal anim = (Animal) cadaelemento ;         // se necesita, claro, un cast para saber qué es realmente cadaelemento
            if ( anim.peso > 3) {
                System.out.println(((Animal) cadaelemento).nombre);
            }
        }

        // instanciando una lista con comodin-acotado (a extends Animal) que contiene un arraylist de perros
        List<? extends Animal> listaDeExtendsPerro = listaPerros;
        for (Object cadaelemento : listaDeExtendsPerro) {
            Perro anim = (Perro) cadaelemento ;         // se necesita, claro, un cast para saber qué es realmente cadaelemento
            if ( anim.peso > 3) {
                System.out.println(((Animal) cadaelemento).nombre);
            }
        }
        // instanciando una lista con comodin-acotado (a extends Animal) que contiene un arraylist de enteros
        // NNNOOOOOOOOOOOOO pues listaInt contiene Integer, que no son subclases de Animal
//        List<? extends Animal> listaDeExtendsPerro2  = listaInt;

//    + ------------------------------ +
//    |                                |
//    |       COMODINES ACOTADOS       |
//    |       CON SUPER                |
//    |                                |
//    + ------------------------------ +
        System.out.println("----------------------");

        List<? super Perro> listaDeSuperAnimal = listaAnimales;
        for (Object cadaelemento : listaDeSuperAnimal) {
            Animal anim = (Animal) cadaelemento ;         // se necesita, claro, un cast para saber qué es realmente cadaelemento
            if ( anim.peso > 3) {
                System.out.println(((Animal) cadaelemento).nombre);
            }
        }

        // NNNOOOOOOOOOOOOO pues listaInt contiene Integer, que no es una superclase de Perro
//        List<? super Perro> listaDeSuperAnimal2 = listaInt;

    }
}
