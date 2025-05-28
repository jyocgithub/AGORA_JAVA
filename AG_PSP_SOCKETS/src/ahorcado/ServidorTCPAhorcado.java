package ahorcado;

import java.io.*;
import java.net.*;
import java.util.Random;

public class ServidorTCPAhorcado {

    public static int puerto = 45003;
    private static DataInputStream lector = null;
    private static DataOutputStream escritor = null;

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket socket = null;
        try {

            servidor = new ServerSocket(puerto);
            System.out.println("Servidor arrancado.....Esperando cliente");

            socket = servidor.accept();// servidor esperando a que alguien le conecte la manguera

            lector = new DataInputStream(socket.getInputStream());
            escritor = new DataOutputStream(socket.getOutputStream());
            conversacion();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                servidor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void conversacion() {

        String horca0 = " ------+" + "\n |" + "\n |" + "\n |" + "\n |" + "\n =======";
        String horca1 = " ------+" + "\n |     O" + "\n |" + "\n |" + "\n |" + "\n =======";
        String horca2 = " ------+" + "\n |     O" + "\n |     |" + "\n |" + "\n |" + "\n =======";
        String horca3 = " ------+" + "\n |     O" + "\n |    /|" + "\n |" + "\n |" + "\n =======";
        String horca4 = " ------+" + "\n |     O" + "\n |    /|\\" + "\n |" + "\n |" + "\n =======";
        String horca5 = " ------+" + "\n |     O" + "\n |    /|\\" + "\n |    /" + "\n |" + "\n =======";
        String horca6 = " ------+" + "\n |     O" + "\n |    /|\\" + "\n |    / \\" + "\n |" + "\n =======";

        String[] array = { horca0, horca1, horca2, horca3, horca4, horca5, horca6 };

        System.out.println("JUEGO DEL AHORCADO");

        String[] baseDatos = { "cascabel", "calamar", "caramelo", "abuelo", "falda", "gafas", "ramo", "descansa",
                "sombrereria", "almibar", "emerita", "paraguas", "extrema", "sideral", "mexicano", "rosa", "boligrafo",
                "corazon", "salvado" };

        Random r = new Random();
        int contador = 0;
        String palabra = "";

        int eleccion = r.nextInt(baseDatos.length);
        String palabraDeBase = baseDatos[eleccion].toString();

        for (int i = 0; i < palabraDeBase.length(); i++) {
            palabra += "*";
        }

        String letrasusadas = "";
        try {
            boolean seguir =true;
            while (seguir) {
                String nuevapalabra = "";
                String letraDelCliente = lector.readUTF();
                letraDelCliente = letraDelCliente.toLowerCase();

                if (letrasusadas.contains(letraDelCliente)) {
                    escritor.writeUTF(palabra);
                    escritor.writeUTF("YA USASTE ESA LETRA !!!");
                    escritor.writeUTF(array[contador]);
                    escritor.writeUTF("Letras usadas : " + letrasusadas);
                } else {
                    boolean acierto = false;
                    letrasusadas += letraDelCliente.charAt(0);

                    for (int i = 0; i < palabraDeBase.length(); i++) {

                        if (letraDelCliente.charAt(0) == palabraDeBase.charAt(i)) {
                            nuevapalabra += palabraDeBase.charAt(i);
                            acierto = true;
                        } else {
                            nuevapalabra += palabra.charAt(i);
                        }

                    }
                    palabra = nuevapalabra;

                    //Mensaje 1
                    escritor.writeUTF(palabra);
                    //Mensaje 2
                    if (palabra.equals(palabraDeBase)) {
                        escritor.writeUTF("HAS GANADO !");
                        seguir = false;
                    } else {

                        if (acierto == false) {
                            contador++;
                            if (contador == 6) {
                                escritor.writeUTF("Estas muerto");
                                seguir = false;
                            } else {
                                escritor.writeUTF("has fallado");
                            }

                        } else {
                            escritor.writeUTF("Acertaste !!!");
                        }
                    }
                    //Mensaje 3
                    escritor.writeUTF(array[contador]);
                    //Mensaje 4
                    escritor.writeUTF("Letras usadas : " + letrasusadas);

                }

            }
            System.out.println("FIN DEL JUEGO");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




}
