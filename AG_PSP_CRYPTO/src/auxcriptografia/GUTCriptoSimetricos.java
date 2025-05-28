package auxcriptografia;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class GUTCriptoSimetricos {

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

    private SecretKey claveSecreta;
    private Cipher cifrador;
    private final String ALGORITMO_SIMETRICO_SOLICITADO;
    private final String NOMBRE_FICHERO_CLAVE = "CLAVESIMETRICA.DAT";
    private String semillaStringParaSecureRandom = "Texto para la seed de SecureRandom";
    private String algoritmoParaSecureRandom = "SHA1PRNG";

    public GUTCriptoSimetricos(String ALGORITMO_SIMETRICO_SOLICITADO) {
        this.ALGORITMO_SIMETRICO_SOLICITADO = ALGORITMO_SIMETRICO_SOLICITADO;
        crearClave();
    }

    private void crearClave() {
        try {
            cifrador = Cipher.getInstance(ALGORITMO_SIMETRICO_SOLICITADO);
            File file = new File(NOMBRE_FICHERO_CLAVE);
            if (!file.exists()) {

                KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITMO_SIMETRICO_SOLICITADO);

                // OPCIÓN 1 – Clave completamente aleatoria
                keyGenerator.init(128); // Tamaño de clave (128, 192, 256 si tienes el JCE Unlimited)
                claveSecreta = keyGenerator.generateKey();

                // OPCIÓN 2 – Clave basada directamente en un texto
                //     -- Hay que controlar que el texto sea de longitud correcta (16,24 o 32 bytes)
                //     -- Si confiamos en nuestra longitud de texto
//                byte[] claveBytes = "Texto que vale como semilla".getBytes();
//                claveSecreta = new SecretKeySpec(claveBytes, "AES");
                //     -- Si queremos asegurarnos de que tenga exactamente 16 bytes (para AES-128)
//                byte[] claveBytes = "Texto que vale como semilla".getBytes();
//                byte[] clave16 = new byte[16];
//                System.arraycopy(claveBytes, 0, clave16, 0, Math.min(claveBytes.length, 16));
//                claveSecreta = new SecretKeySpec(clave16, "AES");


                // OPCIÓN 3.1 – Usando SecureRandom con setSeed()
                //  -- no hace falta controlar que el texto tenga x bytes, lo convierte SecureRandom
//                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
//                secureRandom.setSeed("Texto que vale como semilla".getBytes());
//                keyGenerator.init(128, secureRandom);
//                claveSecreta = keyGenerator.generateKey();


                // OPCIÓN 3.2 – Usando SecureRandom con array de bytes (salt)
                //  -- no hace falta controlar que el texto tenga x bytes, lo convierte SecureRandom
//                byte[] salt = new byte[16];
//                String textoSemilla = "Texto que vale como semilla";
//                System.arraycopy(textoSemilla.getBytes(), 0, salt, 0, Math.min(salt.length, textoSemilla.getBytes().length));
//                SecureRandom secureRandom = new SecureRandom(salt);
//                keyGenerator.init(128, secureRandom);
//                claveSecreta = keyGenerator.generateKey();


                // -- SI SE DECIDE GUARDAR LA CLAVE EN FICHERO, AQUI HAY QUE GUARDARLA, SI NO, COMENTAR ESTA LINEA
                guardarKeyEnFichero(claveSecreta, NOMBRE_FICHERO_CLAVE);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }


    public byte[] encriptarString(String param_mensajeoriginal) {
        byte[] mensajeCifrado = null;
        try {
            // -- SI SE DECIDE GUARDAR LA CLAVE EN FICHERO, AQUI HAY QUE LEERLA, SI NO, COMENTAR ESTA LINEA
            SecretKey claveComun = leerKeyDeFichero(NOMBRE_FICHERO_CLAVE);
            cifrador.init(Cipher.ENCRYPT_MODE, claveComun);
            mensajeCifrado = cifrador.doFinal(param_mensajeoriginal.getBytes());
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return mensajeCifrado;
    }

    public String desencriptarString(byte[] param_mensajecifrado) {
        String solucion = null;
        try {
            // -- SI SE DECIDE GUARDAR LA CLAVE EN FICHERO, AQUI HAY QUE LEERLA, SI NO, COMENTAR ESTA LINEA
            SecretKey claveComun = leerKeyDeFichero(NOMBRE_FICHERO_CLAVE);
            cifrador.init(Cipher.DECRYPT_MODE, claveComun);
            byte[] mensajeDescifrado = cifrador.doFinal(param_mensajecifrado);
            solucion = new String(mensajeDescifrado);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return solucion;
    }

    // **************************************************************************
    // **************************************************************************
    // **                                                                      **
    // **      UTILIDADES PARA GUARDAR Y LEER LA CLAVE EN FICHERO              **
    // **                                                                      **
    // **************************************************************************
    // **************************************************************************
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
