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

public class GR_12_Clone_con_Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {

//
//        Collar collar = new Collar("PerroCardin");
//
//        Perro perro = new Perro("Blas", collar);
//        Perro perroclon = (Perro) perro.clone();
//
//        System.out.println(perro.nombre + " - " + perro.collar.modelo);
//        System.out.println(perroclon.nombre + " - " + perroclon.collar.modelo);
//
//        perroclon.nombre = "Cloe";
//        perroclon.collar.modelo = "NewRastutin";   // este cambio afecta LOS DOS PERROR pues no es deep copy
//
//        System.out.println(perro.nombre + " - " + perro.collar.modelo);
//        System.out.println(perroclon.nombre + " - " + perroclon.collar.modelo);
//
//        // ***************************************************
//        System.out.println("--------------------------------------");
//
//        Collar collardeep = new Collar("PerroCardin");
//
//        PerroDeep perrodeep = new PerroDeep("Blas", collardeep);
//        PerroDeep perrodeepclon = (PerroDeep) perrodeep.clone();
//
//        System.out.println(perrodeep.nombre + " - " + perrodeep.collar.modelo);
//        System.out.println(perrodeepclon.nombre + " - " + perrodeepclon.collar.modelo);
//
//        perrodeepclon.nombre = "Cloe";
//        perrodeepclon.collar.modelo = "Rastutin";
//
//        System.out.println(perrodeep.nombre + " - " + perrodeep.collar.modelo);
//        System.out.println(perrodeepclon.nombre + " - " + perrodeepclon.collar.modelo);
//

    }


}

// ***************************************************

//
//class Perro implements Cloneable {
//    String nombre;
//    Collar collar;
//
//    public Perro(String nombre, Collar collar) {
//        this.nombre = nombre;
//        this.collar = collar;
//    }
//
//    public Object clone() throws CloneNotSupportedException{
//        Object clonado = super.clone();
//        return clonado;
//    }
//}
//
//class PerroDeep implements Cloneable{
//    String nombre;
//    Collar collar;
//
//    public PerroDeep(String nombre, Collar collar) {
//        this.nombre = nombre;
//        this.collar = collar;
//    }
//
//    protected Object clone() throws CloneNotSupportedException {
//        PerroDeep clonado = (PerroDeep) super.clone();
//        clonado.collar = (Collar) this.collar.clone();
//        return clonado;
//    }
//}
//
//
//class Collar implements Cloneable{
//    String modelo;
//
//    public Collar(String modelo) {
//        this.modelo = modelo;
//    }
//
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//}
//




