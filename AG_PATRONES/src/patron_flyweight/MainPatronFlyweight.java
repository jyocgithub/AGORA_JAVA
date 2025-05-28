package patron_flyweight;
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

import java.util.HashMap;
import java.util.Map;

/**
 * El patrón de "objeto ligero" o LightWeight se basa en una factoria que recicla
 * los objetos creados almacenándolos después de la creación.
 * Cada vez que se solicita un objeto, la fábrica busca el objeto
 * para comprobar si ya se ha creado. Si es así, se devuelve el objeto existente;
 * de lo contrario, se crea, almacena y luego se devuelve uno nuevo.
 */

public class MainPatronFlyweight {

    /*  DESCRIPCION DEL EJEMPLO:
     *  Queremos guardar informacion de todos los animales que hay en una reserva.
     *  De cada animal hay que almacenar informacion propia y de su propia especie
     *  Pero no queremos repetir la info de una misma especie en sus miles de ejemplares, asi que hacemos una
     *  clase Especie que será atributo de la clase Animal...
     *  Pero tampoco queremos que existan miles de objetos de una misma especie, si el opbjeo lo pueden 'compartir'
     *  todos los animales de dicha especie... asi que hacemos una fábrica que garantice un unico objeto de cada especie
     *  y almacenamos todas las especies en un mapa
     */

    public static void main(String[] args) {
            //asi creamos los animales
            Especie unleon1 = FabricaAnimales.getEspecie("Leon", "Leo", 90, true);
            Animal leon1 = new Animal("Paquito", "Tsavo", unleon1);

            Especie unleon2 = FabricaAnimales.getEspecie("Leon", "Leo", 90, true);
            Animal leon2 = new Animal("Leopoldo", "Tsavo", unleon2);

            Especie unaCebra1 = FabricaAnimales.getEspecie("Cebra", "Dolichohippus Hippotigris", 82, false);
            Animal cebra1 = new Animal("Marcelina", "Tsavo", unaCebra1);

            Especie unaCebra2 = FabricaAnimales.getEspecie("Cebra", "Dolichohippus Hippotigris", 82, false);
            Animal cebra2 = new Animal("Cebralina", "Tsavo", unaCebra2);

            // Puede parecer que hemos hecho dos objetos de la especie Leon y dos mas de Cebra, pero realmente
            // solo hay 2 objetos en la memoria, uno de cada ...
            // Y no es como un Singleton, pues hay varios objetos distintos de la clase Especie...
    }
}


class FabricaAnimales{
    static Map<String, Especie> mapaEspecies = new HashMap<>();
    private FabricaAnimales(){
    }
    public static Especie getEspecie( String nombreEspecie, String familia, int velocidad, boolean esNocturno ){
        Especie especiefinal = mapaEspecies.get(nombreEspecie);
        if(especiefinal == null){
            especiefinal = new Especie(nombreEspecie,  familia,  velocidad,  esNocturno);
            mapaEspecies.put(nombreEspecie,especiefinal);
        }
        return especiefinal;
    }
}

class Animal{
    String nombreAnimal;
    String parqueactual;
    Especie especie;

    public Animal(String nombreAnimal, String parqueactual, Especie especie) {
        this.nombreAnimal = nombreAnimal;
        this.parqueactual = parqueactual;
        this.especie = especie;
    }
}


class Especie{
    String nombreEspecie;
    String familia;
    int velocidad;
    boolean esNocturno;

    public Especie(String nombreEspecie, String familia, int velocidad, boolean esNocturno) {
        this.nombreEspecie = nombreEspecie;
        this.familia = familia;
        this.velocidad = velocidad;
        this.esNocturno = esNocturno;
    }
}