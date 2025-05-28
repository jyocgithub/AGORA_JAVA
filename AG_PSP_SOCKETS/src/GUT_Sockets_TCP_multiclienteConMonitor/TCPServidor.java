package GUT_Sockets_TCP_multiclienteConMonitor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServidor {

    public static final int PUERTO_DEL_SERVIDOR = 20001;

    public static void main(String[] args) {

        ServerSocket serversocket = null;
        Socket manguera;
        Monitor monitor = new Monitor();
        int contadorclientes = 0;

        try {
            serversocket = new ServerSocket(PUERTO_DEL_SERVIDOR);
            System.out.println("Servidor preparado, esperando algún cliente...");

            while (true) {

                manguera = serversocket.accept();
                System.out.println("Cliente "+contadorclientes+"conectado");

                HiloServidor hs = new HiloServidor(manguera, contadorclientes,    monitor );
                hs.start();

                contadorclientes++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serversocket != null) {
                    serversocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



