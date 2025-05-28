
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

enum ENombres{
    FRANCISCO ("PACO"),
    JOSE ("PEPE");

    // identificacion de los ATRIBUTOS
    String apodo;

   //   llamada al constructor
    ENombres(String apodo) {
        this.apodo = apodo;
    }

    // obtener el apodo de un nombre
    public String getApodo(){
        return apodo;
    }

    // convierte un String en un enumerado
    public ENombres getNombre(String apodo) {
        return ENombres.valueOf(apodo);
    }

}

public class EnumeradosConConstructorSimple {

    public static void main(String[] args) {

        ENombres nom=  ENombres.FRANCISCO;
        System.out.println(nom.getApodo());           // PACO
        System.out.println(nom.getNombre("JOSE"));    // JOSE

    }
}

