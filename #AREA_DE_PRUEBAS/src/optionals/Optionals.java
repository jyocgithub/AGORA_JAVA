package optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Optionals {


    public String buscarAlguno(List<String> lista, String busqueda) {
        Stream<String> plan = lista.stream();
        Optional<String> unPlaneta = plan.filter(b -> b.startsWith("T")).findFirst();
//        return (unPlaneta.isPresent())  ? unPlaneta.get() : "No hay planeta";
        return unPlaneta.orElse("No hay planeta");
    }


    public static void main(String[] args) throws Exception {

        String d = null;
        Optional<String> op1 = Optional.of("HOLA");
        Optional<String> op3 = Optional.ofNullable(d);

        if (op3.isPresent()) {
            System.out.println("op3 tiene contenido");
        } else {
            System.out.println("op3 no tiene contenido");
        }


        List<String> lista = new ArrayList<String>();
        lista.add("Marte");
        lista.add("Saturno");
        lista.add("Jupiter");
        Stream<String> plan = lista.stream();
        Optional<String> unPlaneta = plan.filter(b -> b.startsWith("S")).findFirst();
        if (unPlaneta.isPresent()) {
            System.out.println("unPlaneta tiene contenido");
        } else {
            System.out.println("unPlaneta no tiene contenido");  // Entra por aqui, sí
        }

        Optional<Integer> unInt = Optional.empty();
        if (unInt.isPresent()) {
            System.out.println("unInt tiene contenido");
        } else {
            System.out.println("unInt no tiene contenido");  // Entra por aqui, sí
        }

        Optional<Integer> otro = Optional.ofNullable(null);
        if (otro.isPresent()) {
            System.out.println("otro tiene contenido");
        } else {
            System.out.println("otro no tiene contenido");  // Entra por aqui, sí
        }

        // ---------- ESTO ES UNA EXTRACCION CONDICIONAL CON ISPRESENT()
        if (unPlaneta.isPresent()) {
            System.out.println("unPlaneta es:" + unPlaneta.get());
        }


        // crear un stream con valores 3,4,5,6,7
        IntStream stream = IntStream.range(3, 8);

        Optional<String> valor = Optional.ofNullable("b");
        Optional<String> valor2 =  valor.map(x->x.toUpperCase());
        Optional<String> valor3 =  valor.map(String::toUpperCase);

        valor2.ifPresent( x -> System.out.println(x));


        Optional<Integer> z1 = Optional.of(44);
        OptionalInt z2 = OptionalInt.of(44);
        Optional<String> value = Optional.of("a");

        // when
//        Stream<String> ss = valor.stream();

        IntStream ist = IntStream.iterate(0, i -> i + 3).limit(4);

//
//        // File ( String nombreDeFicheroODirectorio);
//        File f = new File("C:/Usuarios/Pepe/Escritorio/prueba.txt");
//        File f = new File("../prueba.txt");
//        File f = new File("prueba.txt");
//
//            // File ( Strinf directorio, String nombreDeFicheroODirectorio);
//            // File ( File directorio,   String nombreDeFicheroODirectorio);
//            File fich1 = new File("C:/Usuarios/Pepe/Escritorio/", "prueba.txt");
//            File fich2 = new File(miDir,"prueba.txt");


//        Optional<String> value = Optional.of("b");
//        Stream<String> st = value.stream();
//        Optional<String> value2 =  value.filter(x->x.startsWith("b"));
//        value2.ifPresent( x -> System.out.println(x));







        // when
//        List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList());






    }


    public String buscarPlanet(String busqueda, List<String> lista) throws Exception {
        for (String c : lista) {
            if (c.equals(busqueda)) {
                return c;
            }
        }
//        throw null;
        throw new Exception("objeto no encontrado");
    }

    public Optional<String> buscarPlaneta(String busqueda, List<String> lista) throws Exception {
        for (String c : lista) {
            if (c.equals(busqueda)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }
}
