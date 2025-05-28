package chat_consola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class HiloServidorParaCadaCliente extends Thread {

    ArrayList<Usuario> listaUsuarios;
    Usuario usuario;

    public HiloServidorParaCadaCliente(Usuario usuario, ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        this.usuario = usuario;
    }

    public void run() {
        try {

            boolean error = true;
            String mensaje = "";

            String nombreusuarioconectado = usuario.lector.readUTF();
            usuario.nombre = nombreusuarioconectado;

            System.out.println("Recibida conexion de " + usuario.nombre);

            while (usuario.conectado) {

                // recibe mensaje de un cliente
                mensaje = usuario.lector.readUTF();

                System.out.println("Recibido mensaje de : " + usuario.nombre);
                System.out.println("Mensaje : " + mensaje);
                System.out.println("... reenviandolo ...");

                // y lo manda a todos los clienetes
                for(Usuario cadaunodelosotrosusuarios : listaUsuarios){
                    cadaunodelosotrosusuarios.escritor.writeUTF(mensaje);
                    System.out.println("    -- enviado a :" + cadaunodelosotrosusuarios.nombre);
                }

                if (mensaje.equalsIgnoreCase("FIN")) {
                    System.out.println("Fin del chat de "+ usuario.nombre);
                    usuario.conectado = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
