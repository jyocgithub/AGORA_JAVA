package GR_Cripto;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

public class GR_Cripto {

    // *******************************************************************************
    // *******************************************************************************
    // *******************************************************************************

    /**
     * GR_Hash
     * Muestra un ejemplo de encriptacion de un String por algoritmo de resumen (HASH)
     *
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static void GR_Hash() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String original = "Hola mundo";

        // 1. Encriptar
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(original.getBytes("UTF-8"));

        //       --> mostrar resultado como un String
        String hashed = Base64.getEncoder().encodeToString(hashedBytes);
        System.out.println("Hashed: " + hashed);

    }

    // *******************************************************************************
    // *******************************************************************************
    // *******************************************************************************

    /**
     * GR_Simetricos
     * Muestra un ejemplo de encriptacion de un String por algoritmo Simetrico
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static void GR_Simetricos() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String original = "Hola mundo";

        // 1. Generar clave AES
        //   -- se usa un método para poder crearla de firmas diversas
        SecretKey secretKey = crearClaveSimetrica(1);

        // 2. Encriptar
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = encryptCipher.doFinal(original.getBytes());

        //       --> mostrar resultado como un String
        String encrypted = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted (AES): " + encrypted);

        // 3. Desencriptar
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encrypted));

        //       --> mostrar resultado como un String
        String decrypted = new String(decryptedBytes);
        System.out.println("Decrypted (AES): " + decrypted);

    }

    /**
     * crearClaveSimetrica()
     * <p>
     * Crea una clave Simetrica de muchas formas diferentes
     * Cuidado, si usamos AES, es un cifrado por bloques que trabaja con claves de longitud fija:
     * Longitud	        	Seguridad
     * 128 bits (16 bytes)	Básica pero segura hoy día
     * 192 bits (24 bytes)	Más segura (menos común)
     * 256 bits (32 bytes)	Alta seguridad (recomendado en muchos casos)
     * <p>
     * Opción	Métodos usados                              ¿Es reproducible?	                ¿Criptográficamente seguro?	¿Permite controlar la clave?	Comentario
     * 1	    KeyGenerator.generateKey()	                ❌ No	                            ✅ Sí	                    ❌ No	                        Crea una clave aleatoria distinta cada vez. Ideal para sesiones temporales.
     * 2	    new SecretKeySpec(texto.getBytes(), "AES")	✅ Sí (mismo texto = misma clave)	❌ No	                    ✅ Sí	                        Muy simple. No garantiza longitud adecuada ni entropía. Útil para pruebas o claves fijas.
     * 3	    KeyGenerator + SecureRandom.setSeed()       ✅ Sí (misma semilla = misma clave)	✅ Sí	                    ✅ Sí	                        Reproduce siempre la misma clave pero con generación más robusta. Ideal si necesitas reproducibilidad segura
     * 4        KeyGenerator + new SecureRandom(salt)	    ✅ Sí (misma semilla = misma clave)	✅ Sí	                    ✅ Sí	                        Reproduce siempre la misma clave pero con generación más robusta. Ideal si necesitas reproducibilidad segura.
     *
     * @return la clave generada
     */
    public static SecretKey crearClaveSimetrica(int opcion) throws NoSuchAlgorithmException {

        switch (opcion) {
            case 1:
                // OPCIÓN 1 – Clave completamente aleatoria
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128); // Tamaño de clave (128, 192, 256 si tienes el JCE Unlimited)
                return keyGenerator.generateKey();

            case 2:
                // OPCIÓN 2 – Clave basada directamente en un texto
                //     -- Hay que controlar que el texto sea de longitud correcta (16,24 o 32 bytes)
                //     -- Si confiamos en nuestra longitud de texto
                //  byte[] claveBytes = "Texto que vale como semilla".getBytes();
                //  return new SecretKeySpec(claveBytes, "AES");
                //     -- Si queremos asegurarnos de que tenga exactamente 16 bytes (para AES-128)
                byte[] claveBytes = "Texto que vale como semilla".getBytes();
                byte[] clave16 = new byte[16];
                System.arraycopy(claveBytes, 0, clave16, 0, Math.min(claveBytes.length, 16));
                return new SecretKeySpec(clave16, "AES");

            case 3:
                // OPCIÓN 3.1 – Usando SecureRandom con setSeed()
                //  -- no hace falta controlar que el texto tenga x bytes, lo convierte SecureRandom
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed("Texto que vale como semilla".getBytes());
                KeyGenerator keyGenerator2 = KeyGenerator.getInstance("AES");
                keyGenerator2.init(128, secureRandom);
                return keyGenerator2.generateKey();

            case 4:
                // OPCIÓN 3.2 – Usando SecureRandom con array de bytes (salt)
                //  -- no hace falta controlar que el texto tenga x bytes, lo convierte SecureRandom
                byte[] salt = new byte[16];
                String textoSemilla = "Texto que vale como semilla";
                System.arraycopy(textoSemilla.getBytes(), 0, salt, 0, Math.min(salt.length, textoSemilla.getBytes().length));
                SecureRandom secureRandom3 = new SecureRandom(salt);
                KeyGenerator keyGenerator3 = KeyGenerator.getInstance("AES");
                keyGenerator3.init(128, secureRandom3);
                return keyGenerator3.generateKey();

        }
        return null;

    }


    // *******************************************************************************
    // *******************************************************************************
    // *******************************************************************************

    /**
     * GR_Asimetricos
     * Muestra un ejemplo de encriptacion de un String por algoritmo Asimetrico
     *
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static void GR_Asimetricos() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String original = "Hola mundo";

        // 1. Generar par de claves
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        // 2. Encriptar con clave pública
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedBytes = encryptCipher.doFinal(original.getBytes());

        //       --> mostrar resultado como un String
        String encrypted = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted (RSA): " + encrypted);

        // 3. Desencriptar con clave privada
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encrypted));

        //       --> mostrar resultado como un String
        String decrypted = new String(decryptedBytes);
        System.out.println("Decrypted (RSA): " + decrypted);

    }

    // *******************************************************************************
    // *******************************************************************************
    // *******************************************************************************

    /**
     * GR_FirmaDigitalSimple
     * Muestra un ejemplo de verificacion de un String por Firma Digital
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static void GR_FirmaDigitalSimple() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String mensaje = "Este es un mensaje importante";

        // 1. Generar par de claves (pública y privada)
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey clavePrivada = keyPair.getPrivate();
        PublicKey clavePublica = keyPair.getPublic();

        // 2. Firmar el mensaje con la clave privada
        Signature firma = Signature.getInstance("SHA256withRSA");
        firma.initSign(clavePrivada);
        firma.update(mensaje.getBytes());
        byte[] firmaBytes = firma.sign();


        //       --> mostrar resultado como un String
        String firmaBase64 = Base64.getEncoder().encodeToString(firmaBytes);
        System.out.println("Firma digital: " + firmaBase64);

        // 3. Verificar la firma con la clave pública
        Signature verificador = Signature.getInstance("SHA256withRSA");
        verificador.initVerify(clavePublica);
        verificador.update(mensaje.getBytes());
        boolean esValida = verificador.verify(Base64.getDecoder().decode(firmaBase64));

        //       --> mostrar resultado
        System.out.println("¿Firma válida? " + esValida);

    }


    // *******************************************************************************
    // *******************************************************************************
    // *******************************************************************************
    // Método auxiliar para imprimir la clave en Base64
    public static void mostrarClave(SecretKey clave) {
        String base64 = Base64.getEncoder().encodeToString(clave.getEncoded());
        System.out.println("Clave: " + base64);
    }


    // ***************************************************
    // ***************************************************
    public static void main(String[] args) {
        try {

            GR_Hash();
            GR_Simetricos();
            GR_Asimetricos();
            GR_FirmaDigitalSimple();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


class GeneradorClave {

    public enum TipoClave {
        ALEATORIA,
        TEXTO_DIRECTO,
        SEMILLA_SEGURA
    }

    public static SecretKey obtenerClave(TipoClave tipo, String textoBase) throws Exception {
        switch (tipo) {
            case ALEATORIA:
                return generarClaveAleatoria();

            case TEXTO_DIRECTO:
                return generarClaveDesdeTextoPlano(textoBase);

            case SEMILLA_SEGURA:
                return generarClaveConSemillaSegura(textoBase);

            default:
                throw new IllegalArgumentException("Tipo de clave no soportado");
        }
    }

    private static SecretKey generarClaveAleatoria() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }

    private static SecretKey generarClaveDesdeTextoPlano(String texto) {
        byte[] bytes = texto.getBytes();
        byte[] clave16 = new byte[16]; // AES-128 = 16 bytes
        System.arraycopy(bytes, 0, clave16, 0, Math.min(bytes.length, 16));
        return new SecretKeySpec(clave16, "AES");
    }

    private static SecretKey generarClaveConSemillaSegura(String textoSemilla) throws NoSuchAlgorithmException {
        byte[] salt = new byte[16];
        byte[] textoBytes = textoSemilla.getBytes();
        System.arraycopy(textoBytes, 0, salt, 0, Math.min(salt.length, textoBytes.length));

        SecureRandom secureRandom = new SecureRandom(salt);
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, secureRandom);

        return keyGen.generateKey();
    }

}