import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Java8Pruebas {


    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Paco", 12));
        lista.add(new Persona("Eva", 34));
        lista.add(new Persona("Ana", 40));
        lista.add(new Persona("Luis", 74));
        lista.add(new Persona("Maria", 17));

//        USANDO PREDICADOS CON UNA CLASE QUE IMPLEMENTA PREDICATE
        Predicate pred_menoredad = new EsMenorDeEdad();
        lista.removeIf(pred_menoredad);
        System.out.println(lista);


//        USANDO PREDICADOS CON FUNCION LAMBDA
        lista.removeIf(p -> p.edad < 18);
        System.out.println(lista);


//        USANDO COMSUMERS CON UNA CLASE QUE IMPLEMENTA CONSUMER
        MiConsumidorPersonas miConsumidor = new MiConsumidorPersonas();
        lista.forEach(miConsumidor);
//
//        USANDO CONSUMER CON FUNCION LAMBDA
        lista.forEach(p -> System.out.println(p));


    }

}

class EsMenorDeEdad implements Predicate<Persona> {
    @Override
    public boolean test(Persona persona) {
        return persona.edad < 18;
    }
}

class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}


class Avion {
    String modelo;
    int plazas;

}

class MiConsumidorPersonas implements Consumer<Persona> {
    @Override
    public void accept(Persona per) {
        System.out.println(per);
    }
}