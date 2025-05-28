//Crear una clase llamada Nombres, capaz de gestionar una lista de nombres, sin repetir, de un
//tamaño determinado. El constructor recibirá como parámetro el número máximo de nombres que
//albergará. Tendrá los siguientes métodos:
//• boolean anadir (String nombre): Añade a la lista el nombre pasado como parámetro. Devuelve false si
//la lista está llena o si ya existe el nombre, true si se añade con éxito. No admite repetidos.
//• boolean eliminar(String nombre): Elimina de la lista el nombre pasado como parámetro. Devuelve
//true en caso de éxito y false si no encuentra el nombre a eliminar.
//• void vaciar(): Elimina todos los nombres de la lista.
//• String mostrar(int posicion): Devuelve el nombre que se encuentra en la posición pasada como
//parámetro (la primera es la posición 0). Devuelve null si no es una posición válida.
//• int numNombres(): Devuelve el número de nombres que hay actualmente.
//• int maxNombres(): Devuelve el número máximo de nombres que puede albergar.
//• boolean estaLlena(): Devuelve true si la lista está llena y false en caso contrario.
package ej_capitulo_9;

public class Ej9_6 {

}

class Nombres {
    private String[] lista;
    int proximoIndiceAUsar;

    public Nombres(int tamano) {
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
