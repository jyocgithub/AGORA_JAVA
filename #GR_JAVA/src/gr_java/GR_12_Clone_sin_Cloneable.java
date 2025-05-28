package gr_java;
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

public class GR_12_Clone_sin_Cloneable {

    public static void main(String[] args) {


        Collar collar = new Collar("PerroCardin");

        Perro perro = new Perro("Blas", collar);
        Perro perroclon = perro.clone();

        System.out.println(perro.nombre + " - " + perro.collar.modelo);
        System.out.println(perroclon.nombre + " - " + perroclon.collar.modelo);

        perroclon.nombre = "Cloe";
        perroclon.collar.modelo = "NewRastutin";   // este cambio afecta LOS DOS PERROR pues no es deep copy

        System.out.println(perro.nombre + " - " + perro.collar.modelo);
        System.out.println(perroclon.nombre + " - " + perroclon.collar.modelo);

        // ***************************************************
        System.out.println("--------------------------------------");

        Collar collardeep = new Collar("PerroCardin");

        PerroDeep perrodeep = new PerroDeep("Blas", collardeep);
        PerroDeep perrodeepclon = perrodeep.clone();

        System.out.println(perrodeep.nombre + " - " + perrodeep.collar.modelo);
        System.out.println(perrodeepclon.nombre + " - " + perrodeepclon.collar.modelo);

        perrodeepclon.nombre = "Cloe";
        perrodeepclon.collar.modelo = "Rastutin";

        System.out.println(perrodeep.nombre + " - " + perrodeep.collar.modelo);
        System.out.println(perrodeepclon.nombre + " - " + perrodeepclon.collar.modelo);


    }


}

// ***************************************************


class Perro {
    String nombre;
    Collar collar;

    public Perro(String nombre, Collar collar) {
        this.nombre = nombre;
        this.collar = collar;
    }

    protected Perro clone() {
        Perro clonado = new Perro(this.nombre, this.collar);
        return clonado;
    }
}

class PerroDeep {
    String nombre;
    Collar collar;

    public PerroDeep(String nombre, Collar collar) {
        this.nombre = nombre;
        this.collar = collar;
    }

    protected PerroDeep clone() {
        PerroDeep clonado = new PerroDeep(this.nombre, this.collar);
        clonado.collar = this.collar.clone();
        return clonado;
    }
}


class Collar {
    String modelo;

    public Collar(String modelo) {
        this.modelo = modelo;
    }

    public Collar clone() {
        return new Collar(this.modelo);
    }

}





