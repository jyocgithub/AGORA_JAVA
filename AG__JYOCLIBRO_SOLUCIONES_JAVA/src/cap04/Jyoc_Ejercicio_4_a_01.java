package cap04;

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

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 4 Ejercicio a_1
 *  Dado un array int[] arrayDeDatos = {8,2,5,4,9,1,0,8,9,3} ,
 *  construir un programa que copie el  arrayDeDatos en el array
 *  llamado copiaDeDatos, pero sumando 2 a cada elemento,
 *  y que escriba el array copiaDeDatos por pantalla, esto es, que salga :
        "el elemento 1 de copiadedatos es 10”
        "el elemento 2 de copiadedatos es 4"
        "el elemento 3 de copiadedatos es 7"
        "el elemento 4 de copiadedatos es 6"
 …
 */
public class Jyoc_Ejercicio_4_a_01 {
    public static void main(String[] args) {
        int[] arrayDeDatos = {8,2,5,4,9,1,0,8,9,3};
        int[] copiaDeDatos = new int[arrayDeDatos.length];

        for (int i = 0; i < arrayDeDatos.length; i++) {
            copiaDeDatos[i] = arrayDeDatos[i] + 2;
        }

        for (int i = 0; i < arrayDeDatos.length; i++) {
            int x=i+1;
            System.out.println("el elemento "+x+" de copiadedatos es "+copiaDeDatos[i]);
        }
    }
}
