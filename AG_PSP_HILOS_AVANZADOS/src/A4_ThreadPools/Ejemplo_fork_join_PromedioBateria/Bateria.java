package ioc.dam.m9.uf2.eac1.b4;

public class Dispositivo {
    private int bateria;
    private String modelo;
    private String marca;

    public Dispositivo(int bateria, String modelo, String marca) {
        this.bateria = bateria;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getBateria() {
        return bateria;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
}
