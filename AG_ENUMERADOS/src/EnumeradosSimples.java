
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


enum EPuntos {
    NORTE, SUR, ESTE, OESTE
}


public class EnumeradosSimples {

    public static void main(String[] args) {
        EPuntos a = EPuntos.ESTE;
        EPuntos b = EPuntos.NORTE;
        if (a == b) {
            System.out.println("El mismo");
        } else {

            System.out.println("NO es el el mismo");
        }


        // recorrer todos los valores del enumerado
        for (EPuntos d : EPuntos.values()) {
            System.out.println(d.toString());
        }


        System.out.println(a.toString());   // escribe el valor enumerado como String:  ESTE
        System.out.println(a);              // esto igual que si se ejecuta el toString()
        System.out.println(a.name());       // esto tambien da un String con el valor, por si se cambia toString()
        System.out.println(a.ordinal());    // esto da el ordinal del objeto dentro del conjunto de enumerados: Empieza en 0
        System.out.println("comparacion:" + a.compareTo(b)); // devuelve un int,el de la comparacion, el de la comparación,
        // como cualquier compareto, <0 si a<b, >0 si a>b, o 0 si a==b
        // realmente hace a.ordinal() - b.ordinal()
        EPuntos[] valoresPosibles = EPuntos.values();   // devuelve un ARRAY con los valores del tipo PUNTOS
        System.out.println(EPuntos.values().length);   // devuelve número de valores de PUNTOS, 4 en este caso


    }


}
