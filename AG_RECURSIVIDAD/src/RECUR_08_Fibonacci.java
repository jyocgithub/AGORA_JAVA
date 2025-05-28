
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

public class RECUR_8_Fibonacci {

    public static void main(String[] args) {
        System.out.println( fibonacci(8) );
    }

    public static int fibonacci(int n){
        if(n==1 || n==2) {
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }


}
