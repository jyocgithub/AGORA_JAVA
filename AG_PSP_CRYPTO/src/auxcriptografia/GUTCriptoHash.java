package auxcriptografia;

import java.io.*;
import java.security.*;

public class GUTCriptoHash {

    // **********************************************
    // **********************************************
    // **                                          **
    // **      CIFRADOS RESUMEN (HASH)             **
    // **                                          **
    // **********************************************
    // **********************************************

    private final String ALGORITMO_RESUMEN_SOLICITADO;

    public GUTCriptoHash(String ALGORITMO_RESUMEN_SOLICITADO) {
        this.ALGORITMO_RESUMEN_SOLICITADO = ALGORITMO_RESUMEN_SOLICITADO;
    }

    public byte[] encriptarStringRapido(String param_mensajeOriginal) {
        try {
            return MessageDigest.getInstance("MD5").digest(param_mensajeOriginal.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] encriptarString(String param_mensajeOriginal, String param_nombreficherosalida) {
        // MD5 permite encriptar una frase, pero no permite desencriptarla.
        // Es útil para guardar password con encriptación MD5 en una base de datos.

        byte[] resumenCreadoComoByteArray = null;
        try {
            // Creamos un objeto MessageDigest asociado al algoritmo de encriptado a
            // utilizar (HASH-MD5 de 64 bits en este caso)
            // MessageDigest y las clases siguientes de procesado de encriptación son clases
            // que ofrece Java como parte de las Extensiones Criptográficas Java (JCE)

            // El primer parametro de getInstance() es el nombre del algoritmo digest a
            // usar:"MD5", "MD4", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512"...
            MessageDigest md = MessageDigest.getInstance(ALGORITMO_RESUMEN_SOLICITADO);

            // si se quiere se puede ver la informacion del gestor creado
//            System.out.println("Longitud del resumen: "+md.getDigestLength());
//            System.out.println("Algoritmo: "+md.getAlgorithm());
//            System.out.println("Proveedor: "+md.getProvider());

            // crear el resumen con el método digest();
            // el resumen es un array de 16 bytes
            resumenCreadoComoByteArray = md.digest(param_mensajeOriginal.getBytes());

            // Y guardamos por si lo queremos en un fichero el encriptado realizado:
            File fileSalida = new File(param_nombreficherosalida);
            FileOutputStream fosSalida = new FileOutputStream(fileSalida);
            fosSalida.write(resumenCreadoComoByteArray);
            fosSalida.close();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return resumenCreadoComoByteArray;

    }

    public void encriptarFicheroTexto(String param_nombreficheroentrada, String param_nombreficherosalida) {
        try {

            // Este modelo leee un fichero con varias lineas
            // y crea un resumen de todas ellas
            MessageDigest md = MessageDigest.getInstance(ALGORITMO_RESUMEN_SOLICITADO);

            // Abrimos un fichero para leer su contenido
            File file = new File(param_nombreficheroentrada);
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Leemos linea a linea el fichero,
            // y las vamos almacenando acumulándolas en el objeto MessageDigest
            String linea;
            linea = br.readLine();
            while (linea != null) {
                md.update(linea.getBytes());
                linea = br.readLine();
            }
            // Crear el resumen con el método digest();
            byte[] resumenCreadoComoByteArray = md.digest();

            // Y guardamos en un fichero el encriptado realizado:
            File fileSalida = new File(param_nombreficherosalida);
            FileOutputStream fosSalida = new FileOutputStream(fileSalida);
            fosSalida.write(resumenCreadoComoByteArray);
            fosSalida.close();

        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
