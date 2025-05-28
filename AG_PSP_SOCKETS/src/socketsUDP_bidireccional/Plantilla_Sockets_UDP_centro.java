/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioMediaNotas;


import java.net.*;

/**
 * @author atico
 */
public class Plantilla_Sockets_UDP_centro {

    public static void enviarStringUDP(String mensaje, String maquinaDestino, int puerto) {
        DatagramSocket maquinaEnviar = null;  // simplemente declaramos la maquina que luego vamos a crear
        try {
            Thread.sleep(100);   // ponemos una espera minima para asegurar que quien este esperando lo haga antes que esta lectura
            byte[] arrayLleno = mensaje.getBytes();  // Convertimos el mensaje a enviar en un array de bytes
            InetAddress direcc = InetAddress.getByName(maquinaDestino);// creo un objeto con la direccion de la maquina destino del mensaje

            DatagramPacket paqueteLleno = new DatagramPacket(arrayLleno, arrayLleno.length, direcc, puerto); // creamos el paquete ya con los datos del array de bytes relleno

            maquinaEnviar = new DatagramSocket();  // creamos la maquina de enviar
            maquinaEnviar.send(paqueteLleno);     // usamos la maquina para enviar el paquete
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (maquinaEnviar != null)  maquinaEnviar.close();
        }
    }


    public static String recibirStringUDP(String ipMaquinaOrigen, int puerto) {
        DatagramSocket maquinaRecibir = null;  // simplemente declaramos la maquina que luego vamos a crear
        try {
            byte[] arrayvacio = new byte[5000]; // Preparar una array de bytes vacio donde recibir un datagrama en el futuro

            InetAddress direcc = InetAddress.getByName(ipMaquinaOrigen); // creo un objeto con la direccion de la maquina origen del mensaje
            DatagramPacket paquetevacio = new DatagramPacket(arrayvacio, arrayvacio.length);  // Crear un paquete vacio que tiene dentro el array vacio

            maquinaRecibir = new DatagramSocket(puerto, direcc);  // creo una maquina y la activo . apuntando con la direccion y el puerto
            maquinaRecibir.receive(paquetevacio);  // con la maquina recibimos lo que se este enviando, y eso que se mete en le paquetevacio (realmente, en el array vacio que tiene el paquetevacio)

            String mensajerecibido = new String(arrayvacio);  // Convertir el array de bytes en un string
            //String mensajerecibido = new String(paquetevacio.getData(),paquetevacio.getOffset(), paquetevacio.getLength());  // otro modo

            return mensajerecibido.trim();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (maquinaRecibir != null) maquinaRecibir.close();
        }
        return null; // si se llega aqui es por que hubo un error...
    }
//    public static void enviarStringUDP(String mensaje, String maquinaDestino, int puerto) {
//
//        new Thread(() -> {
//            DatagramSocket maquinaEnviar = null; // simplemente declaramos la maquina que luego vamos a crear
//            try {
//                Thread.sleep(400);
//                byte[] arrayLleno = mensaje.getBytes();  // Convertimos el mensaje a enviar en un array de bytes
//                InetAddress direcc = InetAddress.getByName(maquinaDestino);// creo un objeto con la direccion de la maquina destino del mensaje
//                DatagramPacket paqueteLleno = new DatagramPacket(arrayLleno, arrayLleno.length, direcc, puerto); // creamos el paquete ya con los datos del array de bytes relleno
//                maquinaEnviar = new DatagramSocket();  // creamos la maquina de enviar
//                maquinaEnviar.send(paqueteLleno);     // usamos la maquina para enviar el paquete
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (maquinaEnviar != null) maquinaEnviar.close();
//            }
//        }).start();
//    }
//
//
//    public static String recibirStringUDP(String ipMaquinaOrigen, int puerto) {
//        DatagramSocket maquinaRecibir = null;  // simplemente declaramos la maquina que luego vamos a crear
//        try {
//            byte[] arrayvacio = new byte[500]; // Preparar una array de bytes vacio donde recibir un datagrama en el futuro
//            DatagramPacket paquetevacio = new DatagramPacket(arrayvacio, arrayvacio.length);  // Crear un paquete vacio que tiene dentro el array vacio
//            InetAddress direcc = InetAddress.getByName(ipMaquinaOrigen); // creo un objeto con la direccion de la maquina origen del mensaje
////            maquinaRecibir = new DatagramSocket(puerto, direcc);  // creo una maquina y la activo . apuntando con la direccion y el puerto
//            maquinaRecibir = new DatagramSocket(puerto);  // creo una maquina y la activo . apuntando con la direccion y el puerto
//            maquinaRecibir.receive(paquetevacio);  // con la maquina recibimos lo que se este enviando, y eso que se mete en le paquetevacio (realmente, en el array vacio que tiene el paquetevacio)
//            String mensajerecibido = new String(arrayvacio);  // Convertir el array de bytes en un string
//            return mensajerecibido.trim();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (maquinaRecibir != null) maquinaRecibir.close();
//        }
//        return null; // si se llega aqui es por que hubo un error...
//
//    }

}
