package auxcriptografia;

import java.io.*;
import java.nio.file.Files;
import java.security.*;

public class GUTCriptoFirmaDigital {

    // **********************************************
    // **********************************************
    // **                                          **
    // **              FIRMA DIGITAL               **
    // **                                          **
    // **********************************************
    // **********************************************

    //--------------------- AVISO -----------------------------------------------------------------------------------
    //  Desde la version JDK 8u151 (mediados 2017)  el tamaño de clave predeterminado cambió de 1024 a 2048 bits .
    //  Si se usan versiones dispares de JDK, se puede obtener una excepción:
    //    "InvalidKeyException: The security strength of SHA-1 digest algorithm is not sufficient for this key size"
    //  Puede que se haya creado una clave con longitud 1024 y se intente verificar con procesos que esperan 2048 bits
    //    El error probable que se produce es:
    //    "The security strength of SHA-1 digest algorithm is not sufficient for this key size"
    //  Por ello, NO SE DEBE MODIFICAR NI ELIMINARA LA LINEA QUE INDICA:      keygen.initialize(1024);
    //---------------------------------------------------------------------------------------------------------------
     private PrivateKey obClavePrivadaParaFirmaDigital;
     private PublicKey obClavePublicaParaFirmaDigital;

    public  void firmarDigitalmente_UnTexto(String param_mensajeAFirmar, String param_ficheroFirmaObtenido) {
        try {

            // crea un par de claves, y guardarlas. Una se usa al firmar y otra al verificar
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
            keygen.initialize(1024);
            KeyPair keypair = keygen.generateKeyPair();
            obClavePrivadaParaFirmaDigital = keypair.getPrivate();
            obClavePublicaParaFirmaDigital = keypair.getPublic();

            // crear un objeto Signature
            Signature signature = Signature.getInstance("DSA");

            // Construir un generador de números aleatorios (RNG) criptográficamente fuerte.
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

            // iniciar el proceso de firmar (initsign) aplicando la clave PRIVADA
            signature.initSign(obClavePrivadaParaFirmaDigital, random);

            // preparar el mensaje original para ser firmado
            signature.update(param_mensajeAFirmar.getBytes());

            // firmar el mensaje y obtener la firma
            byte[] firma = signature.sign();

            // guardar la firma en otro fichero
            File filedestino = new File(param_ficheroFirmaObtenido);
            FileOutputStream fos = new FileOutputStream(filedestino);
            fos.write(firma);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void verificarDigitalmente_UnTexto(String param_mensajeAVerificar,String param_ficheroFirma) {
        try {
            // NO debemos crear nuevas claves, sino usar la clave PUBLICA del par de claves que se creo al firmar

            // crear objeto Signature
            Signature signature = Signature.getInstance("DSA");

            // iniciar el proceso de verificacion (initVerify) aplicando la clave PUBLICA
            signature.initVerify(obClavePublicaParaFirmaDigital);

            // preparar el mensaje original para ser verificado
            signature.update(param_mensajeAVerificar.getBytes());

            // leer fichero firma para ser verificado
            File fileFirma = new File(param_ficheroFirma);
            byte[] contenidoFicheroFirma = Files.readAllBytes(fileFirma.toPath());

            // verificamos el mensaje original contra la firma creada para el previamente

            if (signature.verify(contenidoFicheroFirma)) {
                System.out.println("El mensaje es auténtico :-)");
            } else {
                System.out.println("El mensaje no se ha confirmado como original !!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  void firmarDigitalmente_UnFichero(String param_ficheroAFirmar, String param_ficheroFirma) {
        try {

            // crea un par de claves, y guardarlas. Una se usa al firmar y otra al verificar
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
            keygen.initialize(1024);
            KeyPair keypair = keygen.generateKeyPair();
            obClavePrivadaParaFirmaDigital = keypair.getPrivate();
            obClavePublicaParaFirmaDigital = keypair.getPublic();

            // crear un objeto Signature
            Signature signature = Signature.getInstance("DSA");

            // Construir un generador de números aleatorios (RNG) criptográficamente fuerte.
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

            // iniciar el proceso de firmar (initsign) aplicando la clave PRIVADA
            signature.initSign(obClavePrivadaParaFirmaDigital, random);

            // leer el fichero y prepararlo para ser firmado
            File file = new File(param_ficheroAFirmar);
            byte[] contenidoFichero = Files.readAllBytes(file.toPath());
            signature.update(contenidoFichero);

            // firmar el mensaje y obtener la firma
            byte[] firma = signature.sign();

            // guardar la firma en otro fichero
            File filedestino = new File(param_ficheroFirma);
            FileOutputStream fos = new FileOutputStream(filedestino);
            fos.write(firma);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void verificarDigitalmente_UnFichero(String param_ficheroParaVerificar, String param_ficheroFirma) {
        try {
            // NO debemos crear nuevas claves, sino usar la clave PUBLICA del par de claves que se creo al firmar

            // crear objeto Signature
            Signature signature = Signature.getInstance("DSA");

            // iniciar el proceso de verificacion (initVerify) aplicando la clave PUBLICA
            signature.initVerify(obClavePublicaParaFirmaDigital);

            // leer fichero a verificar y prepararlo para ser verificado
            File file = new File(param_ficheroParaVerificar);
            byte[] contenidoFichero = Files.readAllBytes(file.toPath());
            signature.update(contenidoFichero);

            // leer fichero firma para ser verificado
            File fileFirma = new File(param_ficheroFirma);
            byte[] contenidoFicheroFirma = Files.readAllBytes(fileFirma.toPath());

            // verificamos el mensaje original contra la firma creada para el previamente
            if (signature.verify(contenidoFicheroFirma)) {
                System.out.println("El fichero es auténtico :-)");
            } else {
                System.out.println("El fichero no se ha confirmado como original !!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
