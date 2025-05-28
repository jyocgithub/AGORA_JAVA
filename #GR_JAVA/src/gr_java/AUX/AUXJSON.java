package gr_java.AUX;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class AUXJSON {


    public static Object readJsonFileWithGson(String pFileName) {
        Object result = null;
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(pFileName));
            Libreria libreria = gson.fromJson(reader, Libreria.class);
            result = libreria;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }

    public static ArrayList<Libro> readPartOfJsonFileWithOrgjson(String pFileName) {
        ArrayList<Libro> arrlibro = new ArrayList<>();
        try {
            String textocompleto = src.gr_java.GUT.AUXJSON.readFileToString("ficheros/librosjson.json");
            JSONObject objjson = new JSONObject(textocompleto);
            JSONArray arr = objjson.getJSONArray("libros");

            for(int i = 0; i < arr.length(); i++){
                String autor = arr.getJSONObject(i).getString("autor");
                String titulo = arr.getJSONObject(i).getString("titulo");
                int precio = arr.getJSONObject(i).getInt("precio");
                arrlibro.add( new Libro(autor,titulo,precio));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return arrlibro;
    }


    // METODOS PARA CONVERSIONES DE JSON

    public static String objetoToJSON(Object objeto) {
        Gson unGson = new Gson();
        String arrayListEnFormatoGSON = unGson.toJson(objeto);
        return arrayListEnFormatoGSON;
    }

    public static Object JSONToObjeto(String objetoEnJson, Class clase) {
        Gson unGson = new Gson();
        Object objeto = unGson.fromJson(objetoEnJson, clase);
        clase.cast(objeto);
        return objeto;
    }

    public static String arrayListToJSON(ArrayList lista) {
        Gson unGson = new Gson();
        String arrayListEnFormatoGSON = unGson.toJson(lista);
        return arrayListEnFormatoGSON;
    }

    public static ArrayList JSONtoarrayList(String arrayListEnFormatoGSON, Class clase) {
        Gson unGson = new Gson();
        // No se puede usar en fromJSON un ArrayList como tipo de dato
        // Hay que sacar el "tipo de dato" del ArrayList con la clase TypeToken de GSON
        // y la clase Type de Java
        Type typeDeArrayList = TypeToken.getParameterized(ArrayList.class, clase).getType();
        ArrayList arrayListRecuperado = unGson.fromJson(arrayListEnFormatoGSON, typeDeArrayList);
        return arrayListRecuperado;
    }

    public static String readFileToString(String pFileName) throws IOException {
        // usa java NIO (disponible desde Java 7)
        if (new File(pFileName).exists()) {
            String textocompleto = new String(Files.readAllBytes(Paths.get(pFileName)), StandardCharsets.UTF_8);
            return textocompleto;
        }
        return null;
    }

}


class Libro {
    String autor;
    String titulo;
    double precio;

    public Libro(String autor, String titulo, double precio) {
        this.autor = autor;
        this.titulo = titulo;
        this.precio = precio;
    }

    public String convertirAJson() {
        Gson unGson = new Gson();
        String cadenaEnFormatoGSON = unGson.toJson(this);
        return cadenaEnFormatoGSON;
    }

    public static Libro recuperarDeJson(String cadenaEnFormatoGSON) {
        Gson unGson = new Gson();
        Libro libroRecuperado = unGson.fromJson(cadenaEnFormatoGSON, Libro.class);
        return libroRecuperado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                '}';
    }
}


class Libreria {
    String nombre;
    Libro[] libros;

    public Libreria(String nombre, Libro[] libros) {
        this.nombre = nombre;
        this.libros = libros;
    }

    public String convertirAJson() {
        Gson unGson = new Gson();
        String cadenaEnFormatoGSON = unGson.toJson(this);
        return cadenaEnFormatoGSON;
    }

    public static Libreria recuperarDeJson(String cadenaEnFormatoGSON) {
        Gson unGson = new Gson();
        Libreria libreriaRecuperada = unGson.fromJson(cadenaEnFormatoGSON, Libreria.class);
        return libreriaRecuperada;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "nombre='" + nombre + '\'' +
                ", libros=" + Arrays.toString(libros) +
                '}';
    }
}