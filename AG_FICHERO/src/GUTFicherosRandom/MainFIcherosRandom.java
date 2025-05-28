package GUTFicherosRandom;

import java.util.ArrayList;

public class MainFIcherosRandom {

    public static void main(String[] args) {

        ArrayList<Pieza> listapiezas = new ArrayList<>();
        listapiezas.add(new Pieza("453PP4", "Tornillo", 3));
        listapiezas.add(new Pieza("7845YY", "Clavillo", 4));
        listapiezas.add(new Pieza("11111A", "Alicate", 23));
        listapiezas.add(new Pieza("WWGYU9", "Martillo", 13));
        listapiezas.add(new Pieza("434GGS", "Clemas", 8));


        GUTFicheroRandom gfr = new GUTFicheroRandom("ficheros/FicheroPiezas.bin");

        // añadir todos
        for (Pieza p : listapiezas) {
            gfr.anadirRegistro(p);
        }

        System.out.println("--------------------------------------- leer todos");
        // leer todos
        for (int i = 0; i < gfr.getNumRegistros(); i++) {
            Pieza p = gfr.leerRegistroPorPosicion(i);
            System.out.println(p);
        }

        System.out.println("--------------------------------------- leer registro 3");
        // leer el tercer registro
        Pieza p = gfr.leerRegistroPorPosicion(3);
        System.out.println(p);

        System.out.println("--------------------------------------- leer regisrto codigo 11111A");
        // leer el registro con codigo 11111A
        Pieza p2 = gfr.leerRegistroPorCodigo("11111A");
        System.out.println(p2);


        System.out.println("--------------------------------------- modificar el 2");
        // modificar
        gfr.modificarRegistroPorPosicion(2,new Pieza("22222A", "Taburete", 11));
        for (int i = 0; i < gfr.getNumRegistros(); i++) {
            Pieza pp = gfr.leerRegistroPorPosicion(i);
            System.out.println(pp);
        }

        System.out.println("--------------------------------------- eliminar el 3");
        // eliminar por posicion
        gfr.eliminarPorPosicion(3);
        for (int i = 0; i < gfr.getNumRegistros(); i++) {
            Pieza pp = gfr.leerRegistroPorPosicion(i);
            System.out.println(pp);
        }



        // cerramos todas antes de irnos
        gfr.cerrarFichero();

    }


}
