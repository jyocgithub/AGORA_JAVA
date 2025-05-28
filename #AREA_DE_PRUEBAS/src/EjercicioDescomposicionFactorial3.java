
import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class EjercicioDescomposicionFactorial3 {

    public static void main(String[] args) throws IOException {

        

    }

    public static int descomposicion(int n, int[] divisores, int[] potencias) {

        int donde = 0;

        while (n != 1) {
            for (int x = 2; x < 10000; x++) {
                if (esPrimo(x)) {
                    if (n % x == 0) {
                        n = n / x;
                        donde = añadirpotencia(x, donde, divisores, potencias);
                    }
                }
            }
        }
        return donde;
    }

    public static int añadirpotencia(int w, int donde, int[] divisores, int[] potencias) {

        boolean encontrado = false;
        for (int x = 0; x < divisores.length; x++) {
            if (divisores[x] == w) {
                potencias[x]++;
                encontrado = true;
            }
        }

        // si no hemos encontrado un divisor en el array divisores....
        if (!encontrado) {
            divisores[donde] = w;
            potencias[donde] = 1;
            donde++;
        }
        return donde;
    }

    public static boolean esPrimo(int n) {
        boolean res = false;
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cont++;
            }
        }
        if (cont == 2) {
            res = true;
        }
        return res;
    }

}