
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) throws MiExcepcion {
        Optionals o = new Optionals();
    }

    public Optionals() throws MiExcepcion {


//## Creación de Optional

        // Crear un Optional vacío
        Optional<String> empty = Optional.empty();

        // Crear un Optional con un valor (no nulo)
        Optional<String> value = Optional.of("Hola Mundo");

        // Crear un Optional que puede contener un valor nulo
        Optional<String> nullable = Optional.ofNullable(null);

//## Verificar si hay un valor presente

        Optional<String> optional = Optional.ofNullable(null);

        // Verificar si hay un valor presente
        if (optional.isPresent()) {
            // Hacer algo con el valor
        }

        // O usando el método isEmpty() (disponible desde Java 11)
        if (optional.isEmpty()) {
            // Manejar el caso de ausencia de valor
        }

//## Obtener el valor

        // Obtener el valor directamente (lanza NoSuchElementException si está vacío)
        String valor = optional.get();

        // Formas seguras de obtener el valor
        String resultado1 = optional.orElse("valor por defecto");
        String resultado2 = optional.orElseGet(() -> calcularValorPorDefecto());
        String resultado3 = optional.orElseThrow(() -> new MiExcepcion("mensaje"));

//## Transformar y filtrar valores

        // Transformar el valor (si está presente)
        Optional<Integer> longitud = optional.map(s -> s.length());

        // Transformar a otro Optional (evita Optional<Optional<T>>)
        Optional<Integer> longitud2 = optional.flatMap(s -> calcularAlgo(s));

        // Filtrar valores
        Optional<String> filtrado = optional.filter(s -> s.length() > 5);

//## Ejecutar acciones si hay un valor

        // Ejecutar acción si hay un valor
        optional.ifPresent(valorx -> System.out.println(valorx));

        // Ejecutar acciones diferentes según haya valor o no (Java 9+)
        optional.ifPresentOrElse(
                valorz -> System.out.println("Valor: " + valorz),
                () -> System.out.println("No hay valor")
        );

//## Encadenamiento de operaciones

//       Esta estructura maneja tres posibles escenarios de valor nulo:
//        - Si unusuario es null
//        - Si getDireccion() devuelve null
//        - Si getCiudad() devuelve null
//        En cualquiera de estos casos, el resultado final será "Desconocida".
        Usuario unusuario = new Usuario();
        // esto espera que un usuario no sea nulo....
        String resultado = Optional.ofNullable(unusuario)
                // y aqui, que de ese usuario cojamos la direccion....
                .map(Usuario::getDireccion)
                // y aqui, que con esa direccion cojamos la ciudad....
                .map(Direccion::getCiudad)
                // y aqui, que si hay algun null en estos pasos previos, devuelve "Desconocida"
                .orElse("Desconocida");

//## Buenas prácticas
        //
        //      - Evita usar `get()` sin verificar antes con `isPresent()`
        //      - Usa `orElse()` o `orElseGet()` para proporcionar valores por defecto
        //              - Utiliza Optional para valores de retorno, no para parámetros o campos de clase
        //      - Aprovecha los métodos de transformación como `map()` y `flatMap()`
        //


    }

    private Optional<? extends Integer> calcularAlgo(String s) {
        return null;
    }

    private String calcularValorPorDefecto( ) {
        return null;
    }


}

class Usuario {
    Direccion direccion;
    String ciudad;

    public Direccion getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }
}
class Direccion {
    String ciudad;


    public String getCiudad() {
        return ciudad;
    }
}

class MiExcepcion extends  Exception{
    public MiExcepcion(String s) {
    }

}
