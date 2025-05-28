package GUT_Sockets_TCP_multiclienteConMonitor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class HiloServidor extends Thread {
    private Socket manguera = null;
    private DataInputStream lector;
    private DataOutputStream escritor;
    private int numerocliente;
    Monitor monitor;
    public HiloServidor(Socket manguera, int numerocliente,  Monitor monitor ) throws IOException {
        this.manguera = manguera;
        this.numerocliente = numerocliente;
        this.monitor = monitor;
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
