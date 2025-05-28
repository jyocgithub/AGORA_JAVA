package patron_decorador;

import java.util.Collections;
import java.util.HashSet;

public class PatronDecorador {
    public static void main(String[] args) {
        Utilitario u = new Utilitario(12000);
        Familiar f = new Familiar(24000);
        System.out.println(u.descripcion());
        System.out.println(f.descripcion());

//------------------------------- primera aproximacion

        //-------------------------------  aproximacion final

        Vehiculo vehiculo = new Utilitario(12000);

        vehiculo = new VehiculoConAirbag(vehiculo, 840);
        System.out.println(vehiculo.descripcion());
        System.out.println(vehiculo.getPrecio());

        vehiculo = new VehiculoConXenon(vehiculo, 300);
        System.out.println(vehiculo.descripcion());
        System.out.println(vehiculo.getPrecio());




    }
}


//--------------------------------- VEHICULO
abstract class Vehiculo {
    private float precio;

    public Vehiculo(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public abstract String descripcion();
}


//--------------------------------- UTILITARIO
class Utilitario extends Vehiculo {
    public Utilitario(float precio) {
        super(precio);
    }

    @Override
    public String descripcion() {
        return "Vehículo utilitario";
    }
}

//--------------------------------- FAMILIAR
class Familiar extends Vehiculo {
    public Familiar(float precio) {
        super(precio);
    }

    @Override
    public String descripcion() {
        return "Vehículo familiar";
    }
}


class VehiculoConAirbag extends Vehiculo {  // Lo que se cree ahora sigue siendo un Vehiculo
    private Vehiculo vehiculo;      // Es es el objeto que va a decorar al vehículo original

    public VehiculoConAirbag(Vehiculo vehiculo, float precioExtra) {
        super(precioExtra);                  // Pasamos a la madre el precio del extra para que lo guarde
        this.vehiculo = vehiculo;   // Recibimos aqui una referencia del Vehiculo que vamos a decorar

    }

    @Override
    public String descripcion() {
        return vehiculo.descripcion() +  // La descripcion del vehiculo decorado es la del vehículo original
                ", con airbag";          // mas la descripcion de lo que se decora
    }

    @Override
    public float getPrecio() {
        return vehiculo.getPrecio() +  // El precio del vehiculo con su decorado es el del vehículo original
                super.getPrecio();     // mas el precio extra que se añade ahora (y lo tenia la madre).
    }
}

class VehiculoConXenon extends Vehiculo {  // Lo que se cree ahora sigue siendo un Vehiculo
    private Vehiculo vehiculo;      // Es es el objeto que va a decorar al vehículo original

    public VehiculoConXenon(Vehiculo vehiculo, float precioExtra) {
        super(precioExtra);         // Pasamos a la madre el precio del extra para que lo guarde
        this.vehiculo = vehiculo;   // Recibimos aqui una referencia del Vehiculo que vamos a decorar

    }

    @Override
    public String descripcion() {
        return vehiculo.descripcion() +  // La descripcion del vehiculo decorado es la del vehículo original
                ", con xenon";          // mas la descripcion de lo que se decora
    }

    @Override
    public float getPrecio() {
        return vehiculo.getPrecio() +  // El precio del vehiculo con su decorado es el del vehículo original
                super.getPrecio();     // mas el precio extra que se añade ahora (y lo tenia la madre).
    }
}

abstract class Extra extends Vehiculo {
    private Vehiculo vehiculo;

    public Extra(Vehiculo vehiculo, float precioExtra) {
        super(precioExtra);
        this.vehiculo = vehiculo;
    }

    @Override
    public float getPrecio() {
        return vehiculo.getPrecio() + super.getPrecio();
    }

    @Override
    public String descripcion() {
        return vehiculo.descripcion();
    }
}

 class ConAireAcondicionado extends Extra {
    public ConAireAcondicionado(Vehiculo vehiculo, float precioExtra) {
        super(vehiculo, precioExtra);
    }
    @Override
    public String descripcion() {
        return super.descripcion() + ", con aire acondicionado";
    }
}

 class ConPinturaMetalizada extends Extra {
    public ConPinturaMetalizada(Vehiculo vehiculo, float precioExtra) {
        super(vehiculo, precioExtra);
    }
    @Override
    public String descripcion() {
        return super.descripcion() + ", con pintura metalizada";
    }
}