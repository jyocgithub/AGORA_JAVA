package GUT_Sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static final int PUERTO_DEL_SERVIDOR = 2001;
    private static DataInputStream lector;
    private static DataOutputStream escritor;

    public static void main(String[] args) {

        ServerSocket serversocket = null;
        Socket manguera = null;

        try {
            serversocket = new ServerSocket(PUERTO_DEL_SERVIDOR);
            System.out.println("Servidor preparado, esperando algún cliente...");

            manguera = serversocket.accept();
            escritor = new DataOutputStream(manguera.getOutputStream());
            lector = new DataInputStream(manguera.getInputStream());
            System.out.println("Cliente conectado, comienza comunicación:");

            comunicacion();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serversocket != null) {
                    lector.close();
                    escritor.close();
                    manguera.close();
                    serversocket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void comunicacion() throws IOException {

        escritor.writeUTF("INICIO");
        String respuesta = lector.readUTF();
        System.out.println(respuesta);


        // SOLO si se quiere enviar un array de bytes, se puede hacer del modo siguiente
//        String mensaje = "Mensaje a convertir";
//        enviarByteArray(escritor,mensaje);

    }

    // metodo solo necesario si se quiere enviar un array de bytes...
    public static void enviarByteArray(OutputStream os, String mensaje) throws IOException {
        byte[] mensajearray = mensaje.getBytes();
        os.write(mensajearray.length);
        os.write(mensajearray);
    }

}
