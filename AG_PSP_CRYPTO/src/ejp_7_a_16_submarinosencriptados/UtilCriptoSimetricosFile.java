package ejp_7_a_16_submarinosencriptados;

import javax.crypto.*;
import java.io.*;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;


public class UtilCriptoSimetricosFile {

    // *******************************************************************
    // *******************************************************************
    // **                                                               **
    // **      CIFRADOS SIMETRICOS                                      **
    // **                                                               **
    // ** AL constructor se le pasa el algoritmo a usar, por ejemplo:   **
    // **   "DES"                                                       **
    // **   "AES"                                                       **
    // **   "AES/ECB/PKCS5Padding"                                      **
    // **                                                               **
    // *******************************************************************
    // *******************************************************************

    private SecretKey claveComun;
    private Cipher cifrador;
    private final String ALGORITMO_SIMETRICO;
    private final String NOMBRE_FICHERO_CLAVE = "CLAVESIMETRICA.DAT";

    //*************************************** constructor
    public UtilCriptoSimetricosFile(String ALGORITMO_SIMETRICO) {
        this.ALGORITMO_SIMETRICO = ALGORITMO_SIMETRICO;
        crearClave();
    }

    private void crearClave() {
        try {
            cifrador = Cipher.getInstance(ALGORITMO_SIMETRICO);
            File file = new File(NOMBRE_FICHERO_CLAVE);
            if (!file.exists()) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITMO_SIMETRICO);
                claveComun = keyGenerator.generateKey();
                guardarKeyEnFichero(claveComun, NOMBRE_FICHERO_CLAVE);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }


    public byte[] cifrarString(String param_mensajeoriginal) {
        byte[] mensajeCifrado = null;
        try {
            SecretKey claveComunLeida = leerKeyDeFichero(NOMBRE_FICHERO_CLAVE);
            cifrador.init(Cipher.ENCRYPT_MODE, claveComunLeida);
            mensajeCifrado = cifrador.doFinal(param_mensajeoriginal.getBytes());
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return mensajeCifrado;
    }

    public String descifrarString(byte[] param_mensajecifrado) {
        String solucion = null;
        try {
            SecretKey claveComunLeida = leerKeyDeFichero(NOMBRE_FICHERO_CLAVE);
            cifrador.init(Cipher.DECRYPT_MODE, claveComunLeida);
            byte[] mensajeDescifrado;
            mensajeDescifrado = cifrador.doFinal(param_mensajecifrado);
            solucion = new String(mensajeDescifrado);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return solucion;
    }

    // **********************************************
    // **********************************************
    // **                                          **
    // **      UTILIDADES VARIAS                   **
    // **                                          **
    // **********************************************
    // **********************************************

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
        File fichero = new File(pNombrefichero);
        byte[] ficheroenbytes;
        try {
            ficheroenbytes = Files.readAllBytes(fichero.toPath());
            return ficheroenbytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

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

    //++++++++++++++++++++++++++
    public void guardarKeyEnFichero(Key key, String fichero) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(key);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SecretKey leerKeyDeFichero(String fichero) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            SecretKey key = (SecretKey) ois.readObject();
            ois.close();
            return key;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
