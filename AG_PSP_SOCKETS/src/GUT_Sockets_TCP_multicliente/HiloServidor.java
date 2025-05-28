package GUT_Sockets_TCP_multicliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class HiloServidor extends Thread {
    private Socket manguera = null;
    private DataInputStream lector;
    private DataOutputStream escritor;
    private int numerocliente;

    public HiloServidor(Socket manguera, int numerocliente) throws IOException {
        this.manguera = manguera;
        this.numerocliente = numerocliente;
        escritor = new DataOutputStream(manguera.getOutputStream());
        lector = new DataInputStream(manguera.getInputStream());
    }

    public void run() {
        try {
            // -------  realizar comunicacion con escritor o lector

            escritor.writeUTF("hola");
            System.out.println(lector.readUTF());

            // -------  fin de la comunicacion

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // no olvidar, cerrar el socket (la manguera)
                manguera.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
