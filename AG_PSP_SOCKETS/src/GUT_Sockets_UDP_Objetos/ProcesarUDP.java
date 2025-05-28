package GUT_Sockets_UDP_Objetos;

import java.io.*;
import java.net.*;

public class ProcesarUDP {

    private String  miReadChars(int tamano, RandomAccessFile raf){
        char [] cad = new char[tamano];
        char aux;
        String cadena;
        for (int i = 0; i < cad.length; i++) {
            try {
                aux = raf.readChar();
                cad[i] = aux;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        cadena = new String(cad).trim();
        return cadena;
    }

    public static void enviarObjetoUDP(Object objeto, String host, int puerto) {
        DatagramSocket dSocket = null;
        try {
            // ponemos una espera minima para asegurar que quien este esperando lo haga antes que esta lectura
            Thread.sleep(400);
            byte[] array = objetoToByteArray(objeto);  // Convertimos el objeto en un array de bytes
            InetAddress direcc = InetAddress.getByName(host);  // Enviamos el byte[] como un Datagram normal
            DatagramPacket dpacket = new DatagramPacket(array, array.length, direcc, puerto);
            dSocket = new DatagramSocket();
            dSocket.send(dpacket);
            dSocket.close();
            Thread.sleep(100);  // esperar un poco para no mezclarse  con siguientes mensajes
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dSocket.close();
        }
    }

    public static Object recibirObjectUDP(String host, int puerto) {
        DatagramSocket dSocket = null;
        try {
            byte[] array = new byte[5000]; // Preparar una array de bytes donde recibir un datagrama
            DatagramPacket packet = new DatagramPacket(array, array.length);  // Recibir un datagrama
            InetAddress direcc = InetAddress.getByName(host);
            dSocket = new DatagramSocket(puerto, direcc);
            dSocket.receive(packet);
            Object objetoLeido = byteArrayToObject(array);  // Convertir el datagrama leido como byte[] en un objeto

            return objetoLeido;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dSocket.close();
        }
        return null; // si se llega aqui es por que hubo un error...
    }

    public static byte[] objetoToByteArray(Object o) {
        ObjectOutputStream oos = null;
        try {
            // Escribimos el objeto en un ByteArrayOutpuStream, y de ahi lo convertimos en byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();
            byte[] array = baos.toByteArray(); // convertimos el objeto escrito en el byte[]

            return array;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;      // si se llega aqui es por que hubo un error...
    }

    public static Object byteArrayToObject(byte[] array) {
        ObjectInputStream is = null;
        try {
            // Leemos el byte[] de un ByteArrayInpuStream, y de ahi lo convertimos en Object
            ByteArrayInputStream byteStream = new ByteArrayInputStream(array);
            is = new ObjectInputStream(byteStream);
            Object objetoLeido = is.readObject();
            return objetoLeido;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;      // si se llega aqui es por que hubo un error...
    }

}

