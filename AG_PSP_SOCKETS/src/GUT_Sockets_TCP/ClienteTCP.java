package GUT_Sockets_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClienteTCP {

    private static String ip = "localhost";
    private static DataOutputStream escritor;
    private static DataInputStream lector;

    public static void main(String[] args) {

        Socket manguera = null;
        try {
            manguera = new Socket(ip, ServidorTCP.PUERTO_DEL_SERVIDOR);
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

        String mensajeinicial = lector.readUTF();
        System.out.println(mensajeinicial);
        escritor.writeUTF("FIN");



        // SOLO si se quiere recibir un array de bytes, se puede hacer del modo siguiente
        String mensaje = recibirByteArray(lector);
        System.out.println(mensaje);

    }

    // metodo solo necesario si se quiere recibir un array de bytes...
    public static String recibirByteArray(InputStream is) throws IOException {
        int tamano = is.read();
        byte[] arraypreparado = new byte[tamano];
        is.read(arraypreparado);
        String mensaje = new String(arraypreparado);
        return mensaje;
    }


}
