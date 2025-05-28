package psp_ej_07_a_02_concursocripto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class Concursante {
    public static void main(String[] args) {

        DataOutputStream canalDeEnviar = null;
        DataInputStream canalDeRecibir = null;
        Socket manguera = null;


        // crear un socket
        try {
            // llamar al servidor
            manguera = new Socket("localhost", Concurso.PUERTO);

            // crear los canales de comunicacion (las maquinas de leer y de escribir en el socket)
            canalDeRecibir = new DataInputStream(manguera.getInputStream());
            canalDeEnviar = new DataOutputStream(manguera.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String palabra;
            String palabraEncriptada;
            String mensaje;
            for(int i = 0; i < 5; i++) {
                System.out.println("adivina la palabra: ");
                palabra = sc.nextLine();
                palabraEncriptada = GestorCifrados.conAES_cifrarString(palabra);
                canalDeEnviar.writeUTF(palabraEncriptada);
                mensaje = canalDeRecibir.readUTF();
                System.out.println(GestorCifrados.conAES_descifrarString(mensaje));
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

}