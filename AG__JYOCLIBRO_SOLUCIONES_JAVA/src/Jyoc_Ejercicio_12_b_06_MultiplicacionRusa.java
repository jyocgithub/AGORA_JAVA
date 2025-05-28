public class Jyoc_Ejercicio_12_b_06_MultiplicacionRusa {


    public static int multirusa(int x, int y) {
        if (x == 1) {
            if (x % 2 == 0) {
                System.out.println("NO SUMAR x:" + x + "   y:" + y);
                return 0;
            } else {
                System.out.println("SI SUMAR x:" + x + "   y:" + y);
                return y;
            }
        } else {
            int z = multirusa(x / 2, y * 2);
            if (x % 2 == 0) {
                System.out.println("NO SUMAR x:" + x + "   y:" + y + "    z:" + z);
                return z;
            } else {
                System.out.println("SI SUMAR x:" + x + "   y:" + y + "    z:" + z);
                return y + z;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(111 * 37);
        System.out.println(multirusa(111, 37));

    }

}
