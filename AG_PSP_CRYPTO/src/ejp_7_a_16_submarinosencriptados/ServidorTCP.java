package ejp_7_a_16_submarinosencriptados;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorTCP {

    public static int puerto = 45003;
    private DataInputStream lector = null;
    private DataOutputStream escritor = null;


    public ServidorTCP() {
        mimain();
    }


    public void mimain() {
        ServerSocket servidor = null;
        Socket manguera = null;
        try {

            servidor = new ServerSocket(puerto);
            System.out.println("Servidor arrancado.....Esperando Submarino");

            manguera = servidor.accept();// servidor esperando a que alguien le conecte la manguera

            lector = new DataInputStream(manguera.getInputStream());
            escritor = new DataOutputStream(manguera.getOutputStream());
            conversacion();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } finally {
            try {
                manguera.close();
                servidor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ServidorTCP s = new ServidorTCP();
    }

    public void conversacion() throws IllegalBlockSizeException, BadPaddingException {
        UtilCriptoSimetricosFile ucs = new UtilCriptoSimetricosFile("AES");
        List<String> arrayFicticios = new ArrayList<>();
        List<String> arrayReales = new ArrayList<>();
        int x = 0;
        while (x < 10) {
            espera();
            byte[] recibido = dataInput_ReadArrayBytes(lector);
            String desencriptado = ucs.descifrarString(recibido);

            if (desencriptado.contains("m"))
                arrayReales.add(desencriptado);
            else
                arrayFicticios.add(desencriptado);
            x++;
            System.out.println("recibido : " + desencriptado);
        }
        System.out.println("MENSAJES VALIDOS : "+arrayReales);
        System.out.println("MENSAJES INVALIDOS : "+arrayFicticios);
    }

    public byte[] dataInput_ReadArrayBytes(DataInputStream dis) {
        try {
            byte[] recibido = new byte[1000];
            int tamano = dis.read(recibido);
            byte[] resp = new byte[tamano];
            for (int i = 0; i < tamano; i++) {
                resp[i] = recibido[i];
            }
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void espera() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
