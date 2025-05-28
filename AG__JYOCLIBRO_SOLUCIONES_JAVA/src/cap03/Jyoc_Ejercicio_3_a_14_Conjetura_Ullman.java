package cap03;
import java.util.Scanner;


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



public class Jyoc_Ejercicio_3_a_14_Conjetura_Ullman {

    public static void main(String[] args) {

        System.out.println("Indica el numero a procesar");
        int n = new Scanner(System.in).nextInt();
        do {
            if (n % 2 == 0) {
                n = n / 2;
                System.out.println(n);
            }else{
                n = n * 3;
                n = n + 1;
                System.out.println(n);
            }
        } while(n!=1);

    }
}
