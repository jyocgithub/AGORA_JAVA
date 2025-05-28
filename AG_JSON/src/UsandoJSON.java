import com.google.gson.Gson;

import java.util.ArrayList;

public class UsandoJSON {


    public static void main(String[] args) {
        new UsandoJSON();
    }

    public UsandoJSON() {

        // LEER FICHERO JSON CON SIMPLE.JSON

        System.out.println("================ 1 ");

        Libreria libreria = (Libreria) AUX_JSON.ficheroJSONToObjeto("ficheros/librosjson.json");
        for(Libro l : libreria.libros) {
            System.out.println(l);
        };

        ArrayList<Libro> arrlibro = AUX_JSON.readPartOfJsonFileWithOrgjson("ficheros/librosjson.json");
        for(Libro l : arrlibro) {
            System.out.println(l);
        };

        System.out.println("===================== 1 bis");
        // Usando GUTHJSOn con ficheros JSON y objetos
        AUX_JSON.objetoToficheroJSON(libreria, "ficheros/copialibros.json");
        Libreria libreria2 = (Libreria) AUX_JSON.ficheroJSONToObjeto("ficheros/librosjson.json");
        for(Libro l : libreria2.libros) {
            System.out.println(l);
        };

        // JSON CON OBJETOS de cualquier clase

        System.out.println("================ 2 ");
        Libro unlibro = new Libro("PACO", "EL ENTE", 12);

        String jslibro = AUX_JSON.objetoToJSON(unlibro);
        System.out.println(jslibro);
        System.out.println("----------------------------------------------");

        Libro recuperado = (Libro) AUX_JSON.JSONToObjeto(jslibro, Libro.class);
        System.out.println(recuperado);
        System.out.println("----------------------------------------------");


        // JSON con arrayList que no sean atributos de una clase

        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(new Libro("Cervantes", "El Quijote", 33.50));
        libros.add(new Libro("C. Jose Cela", "La Colmena", 11.80));
        libros.add(new Libro("C. Jose Cela", "San Camilo 1936", 22.00));


        String arrayListEnFormatoGSON = AUX_JSON.arrayListToJSON(libros);
        System.out.println(arrayListEnFormatoGSON);
        System.out.println("----------------------------------------------");


        ArrayList<Libro> arrayListRecuperado = AUX_JSON.JSONtoarrayList(arrayListEnFormatoGSON, Libro.class);
        for (Libro li : arrayListRecuperado) {
            System.out.println(li);
        }
        System.out.println("----------------------------------------------");



        // JSON CON ARRAYS que no son atributos de una clase
        // Se usa GSON directamente, no se han hecho métodos en MiJSON

        Libro[] librosarr = new Libro[3];
        librosarr[0] = new Libro("Cervantes", "El Quijote", 33.50);
        librosarr[1] = new Libro("C. Jose Cela", "La Colmena", 11.80);
        librosarr[2] = new Libro("C. Jose Cela", "San Camilo 1936", 22.00);

        Gson unGson = new Gson();
        String arrayEnFormatoGSON = unGson.toJson(librosarr);
        System.out.println(arrayEnFormatoGSON);
        System.out.println("----------------------------------------------");

        Libro[] arrayRecuperado = unGson.fromJson(arrayEnFormatoGSON, Libro[].class);
        System.out.println(arrayRecuperado[1].titulo);
        System.out.println("----------------------------------------------");


        // JSON CON CLASES con metodos internos EN LA CLASE de conversion a/desde json

        // --- clase simple

        Libro l = new Libro("PACO", "EL ENTE", 12);
        String js = l.convertirAJson();
        System.out.println(js);
        System.out.println("----------------------------------------------");

        Libro nuevo = Libro.recuperarDeJson(js);
        System.out.println(nuevo);
        System.out.println("----------------------------------------------");


        // --- clase con una coleccion como atributo

        Libro l2 = new Libro("ANA", "LOS PILARES", 26);
        Libro[] array = {l, l2};
        Libreria lib = new Libreria("LOS PACOS", array);

        String jsonlibreria = lib.convertirAJson();
        System.out.println(jsonlibreria);
        System.out.println("----------------------------------------------");

        Libreria nuevalibreria = Libreria.recuperarDeJson(jsonlibreria);
        System.out.println(nuevalibreria);
        System.out.println("----------------------------------------------");










    }

}

