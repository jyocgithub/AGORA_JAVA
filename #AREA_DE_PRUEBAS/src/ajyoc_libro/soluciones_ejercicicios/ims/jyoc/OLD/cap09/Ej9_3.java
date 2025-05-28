package ej_capitulo_9;

public class Ej9_3 {

}

class Racional {

    private int numerador;
    private int denominador;

    Racional(int n, int d) {
        numerador = n;
        denominador = d;

    }

    public void asignarNumerador(int n) {
        numerador = n;
    }

    public void asignarDenominador(int d) {
        denominador = d;
    }

    public void consultar() {
        System.out.println(numerador + "/" + denominador);

    }

    public boolean esIgual(Racional b) {
        return (numerador == b.numerador && denominador == b.denominador);
    }

    public Racional sumar(Racional b) {
        Racional res = new Racional(0, 0);
        res.denominador = denominador * b.denominador;
        res.numerador = (numerador * b.denominador + b.numerador * denominador);
        return res;
    }

    public Racional restar(Racional b) {
        Racional res = new Racional(0, 0);
        res.denominador = denominador * b.denominador;
        res.numerador = (numerador * b.denominador - b.numerador * denominador);
        return res;
    }

    public Racional multiplicar(Racional b) {
        Racional res = new Racional(0, 0);
        res.denominador = denominador * b.denominador;
        res.numerador = (numerador * b.numerador);
        return res;
    }

    public Racional dividir(Racional b) {
        Racional res = new Racional(0, 0);
        res.numerador = numerador * b.denominador;
        res.denominador = b.numerador * denominador;
        return res;
    }
}
