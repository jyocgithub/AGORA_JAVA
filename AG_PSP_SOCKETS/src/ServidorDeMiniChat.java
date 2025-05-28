import java.io.*;
import java.net.*;
import java.util.*;


//public class ServidorDeMiniChat {
//    public static void main (String[] args) {
//        Socket socketCliente = null;
//        ServerSocket serverSocket = null;
//        PrintWriter escritor;
//        BufferedReader lector;
//        Scanner sc = new Scanner (System.in);
//        String mensaje = "";
//        String leido;
//        try {
//            serverSocket = new ServerSocket (22222); // Creamos el ServerSocket donde nos quedaremos escuchando.
//        }
//        catch (IOException e) {
//            System.out.println ("No pude escuchar en el puerto elegido ");   return;
//        }
//
//        boolean seguirEnElBucle = true;
//        System.out.println ("Servidor arrancado, esperando que el cliente conecte");   return;
//
//        try {
//            socketCliente = serverSocket.accept ();    // Esperamos que "llame" un cliente.
//        }
//        catch (IOException ioe) {
//            System.err.println ("Error esperando clientes: " + ioe.getLocalizedMessage ()); return;
//        }
//
//        // Acaba de llegarnos un nuevo cliente.
//        // Obtenemos el canal para escribir en el socket, que sera el de entrada a este cliente cuando cualquier otro escriba.
//        try {
//            escritor = new PrintWriter (socketCliente.getOutputStream ());  	//obtenemos los canales para leere y escribir en el cliente
//            lector = new BufferedReader (new InputStreamReader (socketCliente.getInputStream ()));
//
//            escritor.println ("Hola !!! Acabas de conectarte a nuestro saervidor");
//            escritor.flush ();
//            while (!mensaje.equals ("ADIOS")) {
//                leido = lector.readLine ();
//                System.out.println ("-- Mensaje del cliente : " + leido);
//                System.err.println ("-- ¿Que responde al Cliente?");
//                mensaje = sc.nextLine ();
//                escritor.println (mensaje);
//                escritor.flush ();
//            }
//        }
//        catch (IOException e) {  	e.printStackTrace ();  	}
//        finally {
//            try {
//                serverSocket.close ();
//            }
//            catch (IOException e) {       e.printStackTrace ();   		}
//        }
//    }  }