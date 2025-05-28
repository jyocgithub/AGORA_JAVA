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

import z_clases_para_ejemplos.Animal;

public class MiClaseGenAcotadaDeAnimal<T extends Animal> {    // Esta T indica que luego al crear objetos se dirà qué tipo de dato es T
    private T informacion;                            // Ese tipo de dato T será el que tendrá mi atributo “info”

    public MiClaseGenAcotadaDeAnimal(T informacion) {         // El parámetro del constructor sera, claro, de tipo T
        this.informacion = informacion;
    }

    public T getInformacion() {                       // igual que el parámetro de devuelve el getter
        return this.informacion;
    }

    public void setInformacion(T informacion) {       // o el parámetro que necesita el setter
        this.informacion = informacion;
    }

}

