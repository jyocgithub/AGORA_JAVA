//Crear una clase llamada Vehículo con los atributos privados numeroRuedas, velocidadMaxima,
//velocidadActual y peso. 
//Implementa los métodos necesarios para acceder a estos atributos de manera pública (getters y setters). 
//La clase dispondrá de un constructor que necesitará como parámetros los valores iniciales para todos sus atributos.
//Crear un método público que devuelva boolean, llamado esIgual(Vehiculo vehiculo) que sirva para
//comparar dos vehículos, de manera que devuelva true o false dependiendo de si son iguales o no (se
//consideran iguales si el valor de todos sus atributos es el mismo). El método recibirá como argumento un
//objeto de la clase Vehículo.
//Crear un método público que devuelva void llamado copia(Vehiculo vehiculo) que copiará los atributos
//de un vehículo en el propio objeto. El método recibirá como parámetro un objeto de la clase Vehículo del cual se
//copiarán sus valores.
//Crear una clase aparte con el método main para probar las funcionalidades de la clase Vehículo.
package ej_capitulo_9;

/**
 * @author ims
 */
public class Ej9_4 {

    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo(3, 160, 100, 1200);
        Vehiculo v2 = new Vehiculo(5, 180, 120, 1700);
        if (v1.esIgual(v2)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

        v1.copia(v2);
        if (v1.esIgual(v2)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

    }

}

class Vehiculo {

    private int numeroRuedas;
    private int velocidadMaxima;
    private int velocidadActual;
    private int peso;

    public Vehiculo(int numeroRuedas, int velocidadMaxima, int velocidadActual, int peso) {
        this.numeroRuedas = numeroRuedas;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = velocidadActual;
        this.peso = peso;
    }

    public boolean esIgual(Vehiculo otrovehiculo) {
        if (this.numeroRuedas != otrovehiculo.numeroRuedas) {
            return false;
        }
        if (this.velocidadMaxima != otrovehiculo.velocidadMaxima) {
            return false;
        }
        if (this.velocidadActual != otrovehiculo.velocidadActual) {
            return false;
        }
        if (this.peso != otrovehiculo.peso) {
            return false;
        }
        return true;
    }

    public void copia(Vehiculo otrovehiculo) {
        this.numeroRuedas = otrovehiculo.numeroRuedas;
        this.velocidadMaxima = otrovehiculo.velocidadMaxima;
        this.velocidadActual = otrovehiculo.velocidadActual;
        this.peso = otrovehiculo.peso;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
