//Con la clase del ejercicio anterior, realiza un programa con un menú de opciones que ofrezca las
//siguientes posibilidades:
//Menú:
//1.-Introducir nombre.
//2.-Listar nombres.
//3.-Eliminar nombre (debe recolocar el vector para no dejar huecos intermedios)
//4.-Eliminar todos los nombres.
//5.-Salir.
//NOTA: Se podrán almacenar hasta un máximo de 5 nombres. No se permitirán nombres repetidos. Los
//nombres no son sensibles a mayúsculas. El array de los nombres es private en la clase Nombres, y no tiene getters ni setters
package ej_capitulo_9;

import java.util.Scanner;

public class Ej9_7 {

    public static void main(String[] args) {

        NuevaNombres nombres = new NuevaNombres(5);

        int opcion = -1;
        do {
            System.out.println("MENU");
            System.out.println("1.Introducir nombre");
            System.out.println("2.Listar nombres");
            System.out.println("3.Eliminar nombre");
            System.out.println("4.Eliminar todos los nombres");
            System.out.println("5.Salir");

            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Indique el nombre a añadir:");
                    String nombre = new Scanner(System.in).nextLine();
                    if (nombres.anadir(nombre)) {
                        System.out.println("Nombre añadido correctamente");
                    } else {
                        System.out.println("Nombre no añadido, ya existia anterioremente");
                    }
                    break;
                case 2:
                    System.out.println("Listado de nombres:");
                    for (int i = 0; i < nombres.numNombres(); i++) {
                        System.out.println(nombres.mostrar(i));
                    }
                    break;
                case 3:
                    System.out.println("Indique el nombre a eliminar:");
                    String nombre2 = new Scanner(System.in).nextLine();
                    if (nombres.eliminar(nombre2)) {
                        System.out.println("Nombre eliminado correctamente");
                    } else {
                        System.out.println("Nombre no eliminado, no existia anterioremente");
                    }
                    break;
                case 4:
                    nombres.vaciar();
                    System.out.println("Nombres eliminados");
                    break;
            }

        } while (opcion != 5);

    }

}

class NuevaNombres {

    private String[] lista;
    int proximoIndiceAUsar;

    public NuevaNombres(int tamano) {
        lista = new String[tamano];
        proximoIndiceAUsar = 0;
    }

    boolean anadir(String nombre) {
        // mirar si la lista esta ya llena
        if (proximoIndiceAUsar == lista.length) {
            return false;
        }

        // mirar si el nombre ya existia en la lista
        boolean estaenlalista = false;
        for (int i = 0; i < proximoIndiceAUsar && !estaenlalista; i++) {
            String cadaelemento = lista[i];
            if (cadaelemento.equalsIgnoreCase(nombre)) {
                estaenlalista = true;
            }
        }
        if (estaenlalista) {
            return false;
        }

        // añadir elemento 
        lista[proximoIndiceAUsar] = nombre;
        proximoIndiceAUsar++;
        return true;
    }

    boolean eliminar(String nombre) {
        // mirar si el nombre ya existia en la lista
        boolean estaenlalista = false;
        for (int i = 0; i < proximoIndiceAUsar && !estaenlalista; i++) {
            String cadaelemento = lista[i];
            if (cadaelemento.equals(nombre)) {
                // eliminamos el elemento, al reordenar todos los demas una posicion hacia atras
                for (int j = i; j < lista.length - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[lista.length - 1] = null;
                proximoIndiceAUsar--;
                estaenlalista = true;
            }
        }
        if (estaenlalista) {
            return true;
        }
        return false;
    }

    void vaciar() {
        lista = new String[lista.length];
        proximoIndiceAUsar = 0;
    }

    String mostrar(int posicion) {

        if (posicion < 0 || posicion >= proximoIndiceAUsar) {
            return null;
        }
        return lista[posicion];

    }

    int numNombres() {
        return proximoIndiceAUsar;
    }

    int maxNombres() {
        return lista.length;
    }

    boolean estaLlena() {
        return (proximoIndiceAUsar == lista.length);
    }
}
