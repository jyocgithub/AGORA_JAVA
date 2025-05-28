package psp_ej_07_a_02_concursocripto;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Concurso {

    public static final int PUERTO = 10080;
    public static final int PUERTO2 = 10100;
    public static void main(String[] args) {
        DataOutputStream canalDeEnviar = null;
        DataInputStream canalDeRecibir = null;
        ServerSocket servidor = null;
        ServerSocket servidor2 = null;
        Socket manguera = null;
        Socket manguera2 = null;

        Scanner sc = new Scanner(System.in);
        // crear un servidor de sockets
        try {
            ArrayList<String> palabras = new ArrayList<>();

            for(int i = 0; i < 5; i++) {

                System.out.println("Escriba una palabra: ");
                palabras.add(sc.nextLine());
            }
            servidor = new ServerSocket(Concurso.PUERTO);

            manguera = servidor.accept();

            canalDeRecibir = new DataInputStream(manguera.getInputStream());
            canalDeEnviar = new DataOutputStream(manguera.getOutputStream());

            String palabraEncriptada;
            String palabra;
            String ok = GestorCifrados.conAES_cifrarString("Ok");
            String mal = GestorCifrados.conAES_cifrarString("mal");
            for(int i = 0; i < 5; i++) {
                palabraEncriptada = canalDeRecibir.readUTF();
                palabra = GestorCifrados.conAES_descifrarString(palabraEncriptada);
                if(comprobarPalabra(palabras,palabra)) {
                    canalDeEnviar.writeUTF(ok);
                }else {
                    canalDeEnviar.writeUTF(mal);
                }

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                canalDeRecibir.close();
                canalDeEnviar.close();
                manguera.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean comprobarPalabra(ArrayList<String> array, String palabra ) {
        boolean esIgual = false;
        for(int i = 0; i < array.size(); i++) {
            if(palabra.equals(array.get(i))) {
                esIgual = true;
            }
        }

        return esIgual;

    }

}