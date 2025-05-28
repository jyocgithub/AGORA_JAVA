package chat_consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Locale;

public class HiloLectorParaClientes extends Thread {

    Usuario usuario;
    public boolean fin = false;

    public HiloLectorParaClientes(Usuario usuario) {
        super();
        this.usuario = usuario;
    }

    public void run() {

        String mensajetemp , nombretemp;

        while (usuario.conectado == true) {

            try {
                nombretemp = usuario.lector.readUTF();
                mensajetemp = usuario.lector.readUTF();

                System.out.println("\n (" + nombretemp + ") : " + mensajetemp );
                System.out.print("-->");

                if (mensajetemp.toUpperCase().contains("FIN")) {
                    usuario.conectado = false;
                }

            } catch (IOException e) {
                if (e.getMessage().equals("Socket closed")){
                    System.out.println("Sockets cerrados");
                }else{
                   e.printStackTrace();
                }
            }
        }
    }
}
