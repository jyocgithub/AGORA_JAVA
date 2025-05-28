package pojo;

import com.google.gson.Gson;

public class Cliente {

    String nombre , dni;
    Vehiculo vehiculo;

    public Cliente(String nombre, String dni, Vehiculo vehiculo) {
        super();
        this.nombre = nombre;
        this.dni = dni;
        this.vehiculo = vehiculo;
    }

    public String convertirAJson() {
        Gson unGson = new Gson();
        String cadenaEnFormatoGSON = unGson.toJson(this);
        return cadenaEnFormatoGSON;
    }

    public static Cliente recuperarDeJson(String cadenaEnFormatoGSON) {
        Gson unGson = new Gson();
        Cliente objetoRecuperado = unGson.fromJson(cadenaEnFormatoGSON, Cliente.class);
        return objetoRecuperado;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", dni=" + dni + ", vehiculo=" + vehiculo + "]";
    }



}
