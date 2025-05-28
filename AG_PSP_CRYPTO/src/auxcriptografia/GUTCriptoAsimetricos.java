package auxcriptografia;

import javax.crypto.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;

public class GUTCriptoAsimetricos {

    private final String NOMBRE_FICHERO_CLAVE_PRIVADA = "CLAVE_PRIVADA_ASIMETRICA.DAT";
    private final String NOMBRE_FICHERO_CLAVE_PUBLICA = "CLAVE_PUBLICA_ASIMETRICA.DAT";
    private PublicKey obClavePublica;
    private PrivateKey obClavePrivada;
    private Cipher encriptador;

    private final String ALGORITMO_ASIMETRICO_SOLICITADO;

    public GUTCriptoAsimetricos(String ALGORITMO_ASIMETRICO_SOLICITADO) {
        this.ALGORITMO_ASIMETRICO_SOLICITADO = ALGORITMO_ASIMETRICO_SOLICITADO;
        generarClavePrivadaYPublica();
    }

    private void generarClavePrivadaYPublica() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITMO_ASIMETRICO_SOLICITADO);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            obClavePublica = keyPair.getPublic();
            obClavePrivada = keyPair.getPrivate();
            guardarClavePrivadaEnFichero(obClavePrivada, NOMBRE_FICHERO_CLAVE_PRIVADA);
            guardarClavePublicaEnFichero(obClavePublica, NOMBRE_FICHERO_CLAVE_PUBLICA);
            encriptador = Cipher.getInstance(ALGORITMO_ASIMETRICO_SOLICITADO);
//            encriptador = Cipher.getInstance("DSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public byte[] encriptarString(String param_mensajeoriginal) {

        byte[] mensajeCifrado = null;
        try {
            obClavePublica = (PublicKey) leerClavePublicaDeFichero(NOMBRE_FICHERO_CLAVE_PUBLICA);
            encriptador.init(Cipher.ENCRYPT_MODE, obClavePublica);
            mensajeCifrado = encriptador.doFinal(param_mensajeoriginal.getBytes());
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return mensajeCifrado;
    }

    public String desencriptarString(byte[] param_mensajecifrado) {
        String solucion = null;
        try {
            obClavePrivada = (PrivateKey) leerClavePrivadaDeFichero(NOMBRE_FICHERO_CLAVE_PRIVADA);
            encriptador.init(Cipher.DECRYPT_MODE, obClavePrivada);
            byte[] mensajeDescifrado;
            mensajeDescifrado = encriptador.doFinal(param_mensajecifrado);
            solucion = new String(mensajeDescifrado);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return solucion;
    }

    // **************************************************************************
    // **************************************************************************
    // **                                                                      **
    // **      UTILIDADES PARA GUARDAR Y LEER LAS CLAVES EN FICHERO            **
    // **                                                                      **
    // **************************************************************************
    // **************************************************************************

    public void guardarClavePublicaEnFichero(PublicKey key, String fichero) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(key);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarClavePrivadaEnFichero(PrivateKey key, String fichero) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(key);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PrivateKey leerClavePrivadaDeFichero(String fichero) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            PrivateKey key = (PrivateKey) ois.readObject();
            ois.close();
            return key;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PublicKey leerClavePublicaDeFichero(String fichero) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            PublicKey key = (PublicKey) ois.readObject();
            ois.close();
            return key;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // **************************************************************************
    // **************************************************************************
    // **                                                                      **
    // **      UTILIDADES PARA GUARDAR Y LEER ARRAYS DE BYTES  EN FICHERO      **
    // **                                                                      **
    // **************************************************************************
    // **************************************************************************

    public static void guardarBytearrayEnFichero(byte[] pContenido, String pNombrefichero) {
        File fichero = new File(pNombrefichero);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fichero);
            fos.write(pContenido);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] leerBytearrayDeFichero(String pNombrefichero) {
        byte[] ficheroenbytes;
        try {
            ficheroenbytes = Files.readAllBytes(Paths.get(pNombrefichero));
//            ficheroenbytes = Files.readAllBytes(new File(pNombrefichero).toPath());
            return ficheroenbytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    // **************************************************************************
    // **************************************************************************
    // **                                                                      **
    // **      UTILIDADES PARA GUARDAR Y LEER TEXTO EN FICHERO                 **
    // **                                                                      **
    // **************************************************************************
    // **************************************************************************
    public static void escribirTextoEnFichero(String pTexto, String pNombrefichero) {
        File fichero = new File(pNombrefichero);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fichero);
            pw.println(pTexto);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    public static String leerTextoDeUnFichero(String pNombrefichero) {
        File fichero = new File(pNombrefichero);
        BufferedReader br = null;
        FileReader fr = null;
        String textoentero = "";
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                textoentero = textoentero + linea + "\n";
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return textoentero;
    }

       public byte[] leerArrayBytesDeSocket(DataInputStream dis) {
        try {
            byte[] recibido = new byte[1000];
            int tamano = dis.read(recibido);
            byte[] resp = new byte[tamano];
            for (int i = 0; i < tamano; i++) {
                resp[i] = recibido[i];
            }
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
