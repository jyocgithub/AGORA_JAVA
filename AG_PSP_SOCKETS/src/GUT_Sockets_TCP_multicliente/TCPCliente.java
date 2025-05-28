package GUT_Sockets_TCP_multicliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPCliente {

    private static String ip = "localhost";
    private static DataOutputStream escritor;
    private static DataInputStream lector;

    public static void main(String[] args) {

        Socket manguera = null;
        try {
            manguera = new Socket(ip, TCPServidor.PUERTO_DEL_SERVIDOR);
            lector = new DataInputStream(manguera.getInputStream());
            escritor = new DataOutputStream(manguera.getOutputStream());
            System.out.println("Conectado con servidor, comienza comunicación:");

            comunicacion();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (manguera != null) {
                    lector.close();
                    escritor.close();
                    manguera.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void comunicacion() throws IOException {

        // -------  realizar comunicacion con escritor o lector

        System.out.println(lector.readUTF());
        escritor.writeUTF("ADIOS");

        // -------  fin de la comunicacion
    }

}
