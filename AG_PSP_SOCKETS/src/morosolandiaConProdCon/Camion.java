package morosolandiaConProdCon;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class Camion extends Thread {

    private  String ip = "localhost";
    private  DataOutputStream escritor;
    private  DataInputStream lector;

    public void run() {

        Socket manguera = null;
        try {
            manguera = new Socket(ip, Banco.PUERTO_DEL_SERVIDOR);
            lector = new DataInputStream(manguera.getInputStream());
            escritor = new DataOutputStream(manguera.getOutputStream());
            System.out.println("Acceso concedido al banco");
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

    public void comunicacion() throws IOException {
        int tipo = 1, cantidad = 0;
        int matricula;
        tipo = azar(1, 2);
        System.out.println("Tipo elegido " + tipo);
        matricula = azar(100000, 500000);
        cantidad = azar(10, 50);

        escritor.writeInt(matricula);
        escritor.writeInt(tipo);
        escritor.writeInt(cantidad);

        String mensaje = lector.readUTF();
        System.out.println(mensaje);

    }

    public int azar(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

}
