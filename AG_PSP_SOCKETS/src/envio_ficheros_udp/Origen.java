package envio_ficheros_udp;

import java.io.File;

public class Origen {

    public static void main(String[] args) throws InterruptedException {
        // lee ficheros de un directorio y los envia a otro programa
        String directorioOrigen = ".";

        File directorio = new File(directorioOrigen);
        if (directorio.isDirectory()) {

            File[] ficherosExistentes = directorio.listFiles();

            // SE ENVIA AL OTRO PROCESO: ANTES DE NAD enviamos al otro proceso cuantos ficheros le vamos a mandar despues
            int cuantos = cuantosFicherosEnDirectorio(directorioOrigen);
            ProcesarUDP.enviarObjetoUDP(cuantos, "localhost", 8000);
            System.out.println("Enviado: ficheros que vamos a mandar : " + cuantos);
            // hacemos que ente envios el origen espere un poco a enviar el siguiente mensaje,
            // para que el destino tenga tiempo de procesar el envio previo.
            Thread.sleep(500);

            for (int f = 0; f < ficherosExistentes.length; f++) {
                File cadaelementodeldirectorio = ficherosExistentes[f];

                if (cadaelementodeldirectorio.isFile()) {

                    // SE ENVIA AL OTRO PROCESO: PRIMERO EL NOMBRE DEL FICHERO
                    String nombrefich = cadaelementodeldirectorio.getName();
                    ProcesarUDP.enviarObjetoUDP(nombrefich, "localhost", 8000);
                    System.out.println("Enviado: nombre de fichero que vamos a mandar : " + nombrefich);
                    Thread.sleep(500);

                    // SE ENVIA AL OTRO PROCESO: SEGUNDO EL CONTENIDO DEL FICHERO
                    // leer el fichero y meterlo en un array de bytes
                    byte[] archivoEnBytes = ProcesarFicherosConBytes.leerArchivoEnBytes(directorioOrigen, nombrefich);
                    ProcesarUDP.enviarObjetoUDP(archivoEnBytes, "localhost", 8000);
                    System.out.println("Enviado fichero " + nombrefich);
                    Thread.sleep(500);
                }
            }
        }
    }

    public static int cuantosFicherosEnDirectorio(String directorioOrigen) {
        File directorio = new File(directorioOrigen);
        File[] ficherosExistentes = directorio.listFiles();
        int cont = 0;
        for (int f = 0; f < ficherosExistentes.length; f++) {
            if (ficherosExistentes[f].isFile()) {
                cont++;
            }
        }
        return cont;
    }
}