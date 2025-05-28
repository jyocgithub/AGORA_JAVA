
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

public class MultiplicacionPorRecursividad {

    public static void main(String[] args) {

        int numero = 123;

        System.out.println(multi(5,4));

    }

    public static int multi(int x, int y) {
        if (y == 0) {
            return 0;
        }
//        int parcial = multi(x, y - 1);
//        int suma = parcial + x;
//        return suma;
        return x + multi(x,y-1);
    }
}
