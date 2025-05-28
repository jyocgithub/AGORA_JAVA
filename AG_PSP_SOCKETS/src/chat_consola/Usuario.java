package chat_consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Usuario {

    String nombre;
    Socket manguera;
    DataInputStream lector;
    DataOutputStream escritor;

    boolean conectado = true;

    public Usuario(String nombre, Socket manguera) {
        this.nombre = nombre;
        this.manguera = manguera;
        inicializaUsuario();
    }

    public void inicializaUsuario() {
        try {
             lector = new DataInputStream(manguera.getInputStream());
             escritor = new DataOutputStream(manguera.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
