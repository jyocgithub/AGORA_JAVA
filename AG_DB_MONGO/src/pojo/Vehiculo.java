package pojo;

import com.google.gson.Gson;

public class Vehiculo {

    public String matricula;
    public int largo, precio;

    public Vehiculo(String matricula, int largo, int precio) {
        super();
        this.matricula = matricula;
        this.largo = largo;
        this.precio = precio;
    }

    public String convertirAJson() {
        Gson unGson = new Gson();
        String cadenaEnFormatoGSON = unGson.toJson(this);
        return cadenaEnFormatoGSON;
    }

    public static Vehiculo recuperarDeJson(String cadenaEnFormatoGSON) {
        Gson unGson = new Gson();
        Vehiculo objetoRecuperado = unGson.fromJson(cadenaEnFormatoGSON, Vehiculo.class);
        return objetoRecuperado;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" +
                matricula + ", largo=" + largo +
                ", precio=" + precio + "]";
    }


}
