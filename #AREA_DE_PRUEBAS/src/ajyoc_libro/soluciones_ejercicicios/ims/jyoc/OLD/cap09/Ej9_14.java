//Crear una clase para trabajar con triángulos isósceles. Para ello, definir los atributos mínimos que
//requiera, crear métodos de consulta, un método constructor e implementar otros métodos para calcular el
//perímetro y el área de un triángulo.
package ej_capitulo_9;

public class Ej9_14 {

    public static void main(String[] args) {

        TrianguloIsosceles t = new TrianguloIsosceles(50, 30);
        System.out.println(t.area());
        System.out.println(t.perimetro());
        t.consulta();


    }

}

class TrianguloIsosceles {

    private int ladoIgual;
    private int base;

    public TrianguloIsosceles(int l, int b) {
        ladoIgual = l;
        base = b;
    }

    public void consulta() {
        System.out.println("Lados iguales:" + ladoIgual + ", base:" + base);

    }

    public double area() {
        double resultado = 0;
        double altura = Math.sqrt((ladoIgual * ladoIgual) - (base * base / 4));
        resultado = ladoIgual * altura / 2;
        return resultado;
    }

    public double perimetro() {
        double resultado = 0;
        resultado = ladoIgual * 2 + base;
        return resultado;
    }

}
