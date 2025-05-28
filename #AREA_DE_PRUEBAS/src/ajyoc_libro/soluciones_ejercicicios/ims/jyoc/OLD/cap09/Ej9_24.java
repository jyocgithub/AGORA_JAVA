//Crea una clase llamada Rectángulo con atributos privados base, altura, x e y (estos
//últimos indican su posición).
//• Implementa los siguientes constructores, teniendo en cuenta que cuando se omitan los valores
//se asignarán por defecto los siguientes: base=1, altura=1, x=0, y=0.
//✴ Rectangulo(float base, float altura, float x, float y)
//✴ Rectangulo(float base, float altura)
//✴ Rectangulo(float base)
//✴ Rectangulo( )
//• Implementa los métodos públicos getters y setters.
//• Implementa los sigientes métodos:
//✴ float getArea( )
//✴ float getPerimetro( )
//Implementa los siguientes métodos sobrecargados:
//• agranda(float aumentaBase, float aumentaAltura) Aumenta la base y la altura del rectángulo con los
//valores indicados.
//• agranda(float valor) Aumenta tanto la base como la altura con el valor indicado.
//• agranda( ) Aumenta la base y la altura en una unidad.
//• desplaza(int cambiox, int cambioy) que cambia las coordenadas, incrementando el valor que se pasa por parametro
//Crea una clase aparte con el método main para probar todas las funcionalidades de la clase Rectángulo
package ej_capitulo_9;

/**
 * @author ims
 */
public class Ej9_24 {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(12, 33, 10, 20);
        r.agranda();
        r.agranda(2, 3);
        System.out.println(r.getArea());
        System.out.println(r.getPerimetro());
    }
}

class Rectangulo {

    private int base, altura, x, y;

    public Rectangulo() {
        this.base = 1;
        this.altura = 1;
        this.x = 0;
        this.y = 0;
    }

    public Rectangulo(int base, int altura, int x, int y) {
        this.base = base;
        this.altura = altura;
        this.x = x;
        this.y = y;
    }

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
        this.x = 0;
        this.y = 0;
    }

    public Rectangulo(int base) {
        this.base = base;
        this.altura = 1;
        this.x = 0;
        this.y = 0;
    }

    public void agranda(float aumentaBase, float aumentaAltura) {
        base += aumentaBase;
        altura += aumentaAltura;
    }

    public void agranda(float valor) {
        base += valor;
        altura += valor;
    }

    public void agranda() {
        base += 1;
        altura += 1;
    }

    public void desplaza(int cambiox, int cambioy) {
        x += cambiox;
        y += cambioy;
    }


    public double getArea() {
        return base * altura;
    }

    public double getPerimetro() {
        return base * 2 + altura * 2;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
