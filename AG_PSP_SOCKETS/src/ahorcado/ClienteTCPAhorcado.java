package ahorcado;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTCPAhorcado {


    public static int puerto = 45003;
    private static DataInputStream lector = null;
    private static DataOutputStream escritor = null;

    public static void main(String[] args) {

        Socket manguera = null;
        try {
            manguera = new Socket("localhost", puerto);

            escritor = new DataOutputStream(manguera.getOutputStream());
            lector = new DataInputStream(manguera.getInputStream());

            conversacion();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                manguera.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void conversacion() {

        Scanner sc = new Scanner(System.in);

        try {
            boolean seguir =true;
            while (seguir) {
                System.out.println("Escribe una letra para mandar al servidor:");

                String letraElegida = sc.nextLine();

                escritor.writeUTF(letraElegida);
                //Mensaje 1
                String nuevosasteriscos = lector.readUTF();
                //Mensaje 2
                String respuesta = lector.readUTF();
                //Mensaje 3
                String horca = lector.readUTF();
                //Mensaje 4
                String mensajeletrasusadas = lector.readUTF();


                System.out.println(nuevosasteriscos);
                System.out.println(respuesta + "\n" + horca);
                System.out.println(mensajeletrasusadas);

                // analizar si hemos ganado o perdido
                if(respuesta.equals("Estas muerto")) {
                    seguir=false;
                }
                if(respuesta.equals("HAS GANADO !")) {
                    seguir=false;
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
