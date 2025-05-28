
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

public class RECUR_01_Sumanumeros {

    public static void main(String[] args) {

        int n = 10;
        //guardamos el resultado en una variable
        int resultado = sumaRecursiva(n);
        //Mostramos el resultado
        System.out.println(resultado);

    }

    public static int sumaRecursiva(int numero) {
        if (numero == 1) {
            //Se termina la recursion
            return 1;
        }
        //Se llama a si misma la función con el parametro numero menos 1
        //sumandole el numero actual
        return numero + sumaRecursiva(numero - 1);
    }

}
