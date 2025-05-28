package soluciones_ejercicicios.ims.jyoc.OLD.cap06;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 6
 * Ejercicio 6.6.3.- Construir una clase Racional que permita representar y manipular números racionales.
 * Un número racional permite representar la relación a/b entre dos números enteros
 * siendo a el numerador y b el denominador (distinto de cero).
 * Se deben implementar los siguientes métodos para la clase Racional:
 * - void asignaNumerador(int x)
 * - void asignaDenominador(int y)
 * - void consultarDatos()
 * - Racional suma(Racional b)
 * - Racional resta(Racional b)
 * - Racional producto(Racional b)
 * - Racional division(Racional b)
 * - boolean esIgual(Racional b)
 *
 * @author Iñaki Martin
 */

public class JyocCap6_3_Racional {

    public static void main(String[] args) {
        Racional x = new Racional();
        x.asignaNumerador(3);
        x.asignaDenominador(4);
        x.consultaDatos();

        Racional y = new Racional();
        y.asignaNumerador(1);
        y.asignaDenominador(4);
        y.consultaDatos();

        x.suma(y).consultaDatos();
        x.resta(y).consultaDatos();
        x.producto(y).consultaDatos();
        x.division(y).consultaDatos();

        Racional k = x.resta(y);
        k.simplificaRacional();
        k.consultaDatos();

    }
}

class Racional {
    private int num, den;

    public Racional(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public Racional() {
    }

    public void asignaNumerador(int num) {
        this.num = num;
    }

    public void asignaDenominador(int den) {
        this.den = den;
    }

    public void consultaDatos() {
        System.out.println(num + " / " + den);

    }

    public Racional suma(Racional r2) {
        Racional sum = new Racional(num * r2.den + den * r2.num, den * r2.den);
        return sum;
    }

    public Racional resta(Racional r2) {
        Racional dif = new Racional(num * r2.den - den * r2.num, den * r2.den);
        return dif;
    }

    public Racional producto(Racional b) {
        Racional mult = new Racional(num * b.num, den * b.den);
        return mult;
    }

    public Racional division(Racional b) {
        Racional segundoOperandoInvertido = new Racional(b.den, b.num);
        Racional divi = producto(segundoOperandoInvertido);
        return divi;
    }

    public boolean esIgual(Racional b) {
        boolean res = false;
        if (num / den == b.num / b.den) res = true;
        return res;
    }


    // Método para calcular el máximo común divisor de dos números enteros positivos.
    // Usa el Algoritmo de Euclides
    private int calcularMCD(int a, int b) {
        int resto;
        while (a % b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        return b;
    }

    // Metodo que simplifica un numero Racional
    // Usa el metodo calcularMCD
    public void simplificaRacional() {

        // Como el metodo de calculo del MCD solo funciona con enteros positivos
        // guardo el valor absoluto y el signo de numerador y denomindor

        // valores absolutos:
        int absNum = Math.abs(num);
        int absDen = Math.abs(den);
        // signos del denominador y numerador:
        int signon = num / absNum;
        int signod = den / absDen;

        // calculo el MCD de los dos numeros
        int elMCD = calcularMCD(absNum, absDen);

        // calculo valores nuevor de numerador y denomniador
        num = num / elMCD;
        den = den / elMCD;

        // aplico el signo que tenian ambo
        num = signon * (num);
        den = signod * (den);
    }


}

