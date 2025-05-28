package morosolandiaConProdCon;

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

    public HiloServidor(Socket manguera, int numerocliente, Monitor monitor) throws IOException {
        this.manguera = manguera;
        this.numerocliente = numerocliente;
        this.monitor = monitor;
        escritor = new DataOutputStream(manguera.getOutputStream());
        lector = new DataInputStream(manguera.getInputStream());
    }

    public void run() {
        try {
            // -------  realizar comunicacion con escritor o lector
            int matricula = lector.readInt();
            int tipo = lector.readInt();
            int cantidad = lector.readInt();
            if (tipo == 1) {
                monitor.meter(cantidad);
                escritor.writeUTF("Confirmacion entrada: el camion de matricula " + matricula + " ha metido " + cantidad + " lingotes");
            } else if (tipo == 2) {
                monitor.sacar(cantidad);
                escritor.writeUTF("Confirmacion salida: el camion de matricula " + matricula + " ha sacado " + cantidad + " lingotes");
            } else {
                System.out.println("TIPO ERRONEOOOOOOOOOOOOO");
            }

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
