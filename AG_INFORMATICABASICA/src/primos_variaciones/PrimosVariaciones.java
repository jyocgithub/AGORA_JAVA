package primos_variaciones;

import java.util.ArrayList;

public class PrimosVariaciones {
    static ArrayList<Integer> lis = new ArrayList<>();

    public static void main(String[] args) {

        lis.clear();

        long inicio = System.currentTimeMillis();

        int cuantos =  bucle1(1, 100);
        System.out.println("hay " + cuantos);

        long fin = System.currentTimeMillis();
        System.out.println("Tardó " + (fin - inicio) + " milisegundos");
    }

// ///////////////////////////////////////////////////////////////////////////////////////
    public static int bucle1(int limiteinicial, int limitefinal) {
        int cuantos = 0;
        for (int i = limiteinicial; i <= limitefinal; i++) {
            if(primos1(i)) cuantos++;
        }
        return  cuantos;
    }

    public static boolean primos1(int x) {
        // vemos si i es primo...........
        for (int j = 2; j < x; j++) {
            if (x % j == 0) return false;
        }
        return true;
    }


// ///////////////////////////////////////////////////////////////////////////////////////

    public static int bucle2(int limiteinicial, int limitefinal) {
        int cuantos = 0;
        for (int i = limiteinicial; i <= limitefinal; i++) {
            if(primos2(i)) cuantos++;
        }
        return  cuantos;
    }

    public static boolean primos2(int x) {
        // vemos si i es primo...........
        for (int j = 2; j < x/2+1; j++) {
            if (x % j == 0) return false;
        }
        System.out.println(x);
        return true;
    }


// ///////////////////////////////////////////////////////////////////////////////////////
    public static int bucle3(int limiteinicial, int limitefinal) {
        int cuantos = 0;
        for (int i = limiteinicial; i <= limitefinal; i++) {
            if(primos3(i)) cuantos++;
        }
        return  cuantos;
    }

    public static boolean primos3(int x) {
        if(x<4) return true;
        // vemos si i es primo...........
        for (int j = 5; j < x/2+1; j++) {
            if (x % j == 0) return false;
        }
        System.out.println(x);
        return true;
    }

// ///////////////////////////////////////////////////////////////////////////////////////
    public static int bucle4(int limiteinicial, int limitefinal) {
        int cuantos = 2;
        for (int i = limiteinicial; i <= limitefinal; i=i+2) {
            if(primos4(i)) cuantos++;
        }
        return  cuantos;
    }

    public static boolean primos4(int x) {
        if(x<4) return true;
        // vemos si i es primo...........
        for (int j = 1; j < lis.size(); j++) {
            if (x % lis.get(j) == 0) return false;
        }
        lis.add(x);
        return true;
    }


}
