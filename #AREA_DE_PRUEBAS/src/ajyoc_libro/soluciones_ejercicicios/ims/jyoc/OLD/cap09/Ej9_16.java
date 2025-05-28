//Ejercicio Garage. Hacer una clase "Coche" que tenga declaradas estos atributos :
//• String marca: se carga en el constructor y no se modifica nunca
//• String color: se carga en el constructor y se puede modificar
//• int km: al principio vale 0, y se puede cambiar (solo incrementando)
//• double precio: se carga en el constructor y se puede modificar
//• double factor_contaminación: se carga en el constructor y no se puede modificar int anio : se carga en
//el constructor y no se puede modificar
//• String matricula: se crea con el coche, no se puede cambiar después.
//• double impuestoMatriculacion: no se crea con el coche, no se puede cambiar después con un setter, sino con un metodo descrito mas adelante.
//• String dniTitular: no se crea con el coche, se puede cambiar después.
//Hacer setter y getter unicamente si son necesarios, segun indicado anteriormente
//Hacer constructor unicamente con los parámetros necesarios
//Añadir el método comprarCoche(String dniTitular), que asigna el campo al coche.
//Hacer una clase Prueba que cree 3 objetos de la clase coche con varios valores, escriba por pantalla los
//atributos de cada coche, tras haberlos creado, escriba por pantalla la media de consumo de los 3 coches y
//escriba por pantalla cual de los 3 es el que tiene mas factor_contaminacion
//MEJORA 1: Incluir un método que calcule el impuesto de contaminación, que depende del
//factor_contaminacion, según estas reglas:
//• si el factor_contaminacion es < 5.0, el impuesto es el 2% del precio del coche
//• si el factor_contaminacion es > 5.0 y < 10.0 , el impuesto es el 5% del precio del coche
//• si el factor_contaminacion es > 10.0, el impuesto es el 10% del precio del coche
//MEJORA 2:
//• Crear método hacerTransferencia, que cambia de titular al coche. Debe recibir como parametro el nuevo precio del coche y el dni del nuevo titular
//• añadir atributo companiaSeguro y precioSeguro. Incluirlos en un nuevo constructor del coche.
//• hacer método traspasar seguro, que pasa los atributos companiaSeguro y precioSeguro. de un coche a otro coche (el que recibe por parametro)
//MEJORA 3: Crear clase Garage, con constructor, getters y setters, que tiene como atributos y metodos:
//• atributo vector de coches, con capacidad para 10 plazas de coches
//• atributo vector de double llamado importePendiente, que tiene el importe que adeuda cada plaza y los
//• método alquilarPlaza, Recibe por parametro un coche y un importe de alquiler. No puede alquilar mas de 10 plazas. Si no puede alquilarse, devuelve false, y true si se puede alquilar
//• método calcularIngresos, que calcula y devuelve los ingresos por todos los coches que esten alquilados
//• método bajaPlaza: Elimina un coche del garage. El coche se recibe por parametro. Si el coche existe se devuelve true, false si no existe.
package ej_capitulo_9;

public class Ej9_16 {
    public static void main(String[] args) {
        Coche c = new Coche("Fiat", "rojo", 1200, 3.7, "PEPES SEGUROS", 200);
        c.setMatricula("8765DDD");

    }
}

class Garage {

    Coche[] plazas;
    double[] preciosAlquiler;
    int plazasalquiladas;

    public Garage(Coche[] plazas, double[] precios) {
        this.plazas = plazas;
        this.preciosAlquiler = precios;
        plazasalquiladas = 0;
    }

    public boolean alquilarPlaza(Coche c, double pre) {
        if (plazasalquiladas >= 9) {
            return false;
        }
        plazas[plazasalquiladas] = c;
        preciosAlquiler[plazasalquiladas] = pre;
        plazasalquiladas++;
        return true;
    }

    public double calcularIngresos() {
        double ingresos = 0;
        for (int i = 0; i < plazas.length; i++) {
            Coche cadacoche = plazas[i];
            if (cadacoche != null) {
                ingresos += preciosAlquiler[i];
            }
        }
        return ingresos;
    }

    public boolean bajaPlaza(Coche c) {
        boolean bajaefectuada = false;
        for (int i = 0; i < plazas.length && !bajaefectuada; i++) {
            Coche cadacoche = plazas[i];
            if (cadacoche != null) {
                if (cadacoche.equals(c)) {
                    // eliminamos el coche reordenando el array
                    for (int j = i; j < plazas.length - 1; j++) {
                        plazas[j] = plazas[j + 1];
                    }
                    plazas[plazas.length] = null;
                    bajaefectuada = true;
                }
            }
        }
        return bajaefectuada;
    }

}

class Coche {

    private String marca;
    private String color;
    private int km = 0;
    private double precio;
    private double factor_contaminacion;
    private String matricula;
    private double impuestoCirculacion;
    private String dniTitular;
    private String companiaSeguro;

    double precioSeguro;

    public Coche(String marca, String color, double precio, double factor_contaminacion) {
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.factor_contaminacion = factor_contaminacion;
    }

    public Coche(String marca, String color, double precio, double factor_contaminacion, String companiaSeguro, double precioSeguro) {
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.factor_contaminacion = factor_contaminacion;
        this.companiaSeguro = companiaSeguro;
        this.precioSeguro = precioSeguro;
    }

    public void traspasarSeguro(Coche otrocoche) {
        otrocoche.companiaSeguro = this.companiaSeguro;
        otrocoche.precioSeguro = this.precioSeguro;
    }

    public void hacerTransferencia(String nuevodni, double nuevoprecio) {
        dniTitular = nuevodni;
        precio = nuevoprecio;
    }

    public void calcularImpuestoCirculacion() {
        if (factor_contaminacion < 5.0) {
            impuestoCirculacion = precio * 0.02;
        } else if (factor_contaminacion >= 5.0 && factor_contaminacion < 10.0) {
            impuestoCirculacion = precio * 0.05;
        } else {
            impuestoCirculacion = precio * 0.1;
        }
    }

    public void comprarCoche(String dni) {
        dniTitular = dni;
    }

    // consideramos que dos coches son iguales si tienen la misma matricula
    @Override
    public boolean equals(Object o) {
        Coche c = (Coche) o;
        if (c.matricula.equals(this.matricula)) {
            return true;
        }
        return false;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKm() {
        return km;
    }

    // El valor de los kilometros solo puede cambiarse para incrementarlo
    public void setKm(int km) {
        if (km > this.km) {
            this.km = km;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getFactor_contaminacion() {
        return factor_contaminacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public String getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(String dniTitular) {
        this.dniTitular = dniTitular;
    }

}
