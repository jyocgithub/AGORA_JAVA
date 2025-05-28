public class MultiplicacionRusa {



    public static void main(String[] args) {
        int h = 12;
        int k = 33;
        System.out.println("Multiplicacion normal " + h * k);
        System.out.println("Multiplicacion rusa   " + multiplicarRusa(h, k));
        System.out.println("Multiplicacion rusa r " + multiplicarRusaRecursiva(h, k));

    }
    public static int multiplicarRusaRecursiva(int x, int y) {
        if (x == 1) {
            return y;
        } else {
            int z = multiplicarRusaRecursiva(x / 2, y * 2);
            if (x % 2 == 0) {
                return z;
            } else {
                return y + z;
            }
        }
    }


    public static int  multiplicarRusa(int x, int y) {
        int suma = 0;
        suma = suma;
        do {
            x = x / 2;
            y = y * 2;
            if (x % 2 != 0) {
                suma = suma + y;
            }
        } while (x != 1);
        return suma;
    }


}
