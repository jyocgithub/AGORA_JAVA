//Ejercicio Cuenta Bancaria. Escribir una clase que represente una cuenta bancaria con estos
//atributos: numerocuenta, saldo, nombretitular. Hacer metodos que hagan estas funciones:
//• consultar el saldo (lo escribe en consola)
//• hacer un ingreso en la cuenta
//• hacer una extracción de la cuenta
//La clase ha de tener un constructor con todos los atributos.
//Hacer otra clase GestionCuentas que en un método main haga;
//• crear una cuenta con saldo inicial 500
//• consultar el saldo
//• hacer un ingreso de 300
//• consultar el saldo
//• hacer un reintegro de 600
//• consultar el saldo
//MEJORA 1: Tener en consideración que una cuenta no puede quedar al descubierto (con saldo < 0). El metodo de extraer dinero devuelve false si no se pude hacer una extraccion
//MEJORA 2: Añadir la siguiente funcionalidad: Por cada ingreso que se haga en la cuenta, se ha de
//acumular en algún sitio un importe a pagar como impuesto, que corresponde al 2% de la cantidad
//ingresada. Se ha de hacer un método que permita la consulta del importe de este valor "Impuesto"
//Este valor se acumula con los sucesivos ingresos en cuenta
//MEJORA 3: Tener en consideración que el crear la cuenta se considera asimismo un ingreso
//MEJORA 4: Crear un método que sea transferencia, que permita el paso de dinero de una cuenta a otra
package ej_capitulo_9;

public class Ej9_17 {

    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria(424233, 500, "Juan Pi");
        cb.consularSaldo();
        cb.hacerIngreso(300);
        cb.consularSaldo();
        cb.hacerExtraccion(600);
        cb.consularSaldo();

    }
}

class CuentaBancaria {

    private int numerocuenta;
    private double saldo;
    private String nombretitular;
    private double impuestos;

    public CuentaBancaria(int numerocuenta, double saldo, String nombretitular) {
        this.numerocuenta = numerocuenta;
        this.saldo = saldo;
        this.nombretitular = nombretitular;
        impuestos += (saldo * 0.02);
    }

    public void transferencia(CuentaBancaria otracu, double importe) {
        if (this.hacerExtraccion(importe)) {
            otracu.hacerIngreso(importe);
        }

    }

    public void hacerIngreso(double ingreso) {
        saldo += ingreso;
        impuestos += (ingreso * 0.02);
    }

    public boolean hacerExtraccion(double extraer) {

        if (extraer <= saldo) {
            saldo -= extraer;
            return true;
        }
        return false;
    }

    public void consularSaldo() {
        System.out.println("El saldo es:" + saldo);

    }

    public CuentaBancaria(double impuestos) {
        this.impuestos = impuestos;
    }

}
