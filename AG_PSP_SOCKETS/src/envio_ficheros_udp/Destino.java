package envio_ficheros_udp;


public class Destino {
    public static void main(String[] args) {
        System.out.println("Esperando recepcion de ficheros...");
        String directorioDestinio = "./copia";

        // leemos primero cuantos ficheros vamos a recibir
        int cuantos = (int) ProcesarUDP.recibirObjectUDP("localhost", 8000);
        System.out.println("Recibido: numero de ficheros a recoger: " + cuantos);

        // recibimos todos esos ficheos,
        for (int i = 0; i < cuantos; i++) {
            // primero recibimos el nombre
            String nombreDelFichero = (String) ProcesarUDP.recibirObjectUDP("localhost", 8000);
            System.out.println("Recibido: nombre del fichero" + (i + 1) + " : " + nombreDelFichero);
            // luego el contenido
            byte[] archivoEnBytes1 = (byte[]) ProcesarUDP.recibirObjectUDP("localhost", 8000);
            ProcesarFicherosConBytes.escribirArchivoConBytes(directorioDestinio, nombreDelFichero, archivoEnBytes1);
            System.out.println("Recibido: fichero " + nombreDelFichero + " guardado");
        }
    }
}


