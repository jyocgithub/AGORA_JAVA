package _Soluciones_ejercicios_libro_jyoc.clase_calcula;


public class Calcula {

    // Método para encontrar el mayor número en un array de enteros
    public static int mayor(int[] num) {
        int mayor = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > mayor) {
                mayor = num[i];
            }
        }
        return mayor;
    }

    // Método para encontrar el mayor número en un array de doubles
    public static double mayor(double[] num) {
        double mayor = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > mayor) {
                mayor = num[i];
            }
        }
        return mayor;
    }

    // Método para encontrar la cadena de mayor longitud en un array de Strings
    public static String mayor(String[] cadena) {
        String mayor = cadena[0];
        for (int i = 1; i < cadena.length; i++) {
            if (cadena[i].length() > mayor.length()) {
                mayor = cadena[i];
            }
        }
        return mayor;
    }

    // Método para encontrar el menor número en un array de enteros
    public static int menor(int[] num) {
        int menor = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < menor) {
                menor = num[i];
            }
        }
        return menor;
    }

    // Método para encontrar el menor número en un array de doubles
    public static double menor(double[] num) {
        double menor = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < menor) {
                menor = num[i];
            }
        }
        return menor;
    }

    // Método para encontrar la cadena de menor longitud en un array de Strings
    public static String menor(String[] cadena) {
        String menor = cadena[0];
        for (int i = 1; i < cadena.length; i++) {
            if (cadena[i].length() < menor.length()) {
                menor = cadena[i];
            }
        }
        return menor;
    }
}