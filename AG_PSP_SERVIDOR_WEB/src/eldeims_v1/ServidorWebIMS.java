package eldeims_v1;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ServidorWebIMS {

    static final String Directorioraizdepaginas = "./";

    public static void main(String[] args) {
        int puerto = 4321;
        ServerSocket ss;
        Socket socket;

        try {
            ss = new ServerSocket(puerto);
            System.out.println("========== SERVIDOR CREADO ===========");
            while (true) {
                System.out.println("-- Esperando clientes...");
                socket = ss.accept();
                System.out.println("-- Cliente conectado...");
                HiloDelServidorWeb hds = new HiloDelServidorWeb(socket);
                Thread t = new Thread(hds);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

