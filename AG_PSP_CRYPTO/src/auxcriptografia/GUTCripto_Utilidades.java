package auxcriptografia;

import java.io.*;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.*;
import java.util.TreeSet;

public class GUTCripto_Utilidades {

    public static void mostrarAlgoritmosDisponibles() {
        TreeSet<String> algorithms = new TreeSet<>();
        for (Provider provider : Security.getProviders())
            for (Provider.Service service : provider.getServices())
                if (service.getType().equals("Signature"))
                    algorithms.add(service.getAlgorithm());
        for (String algorithm : algorithms)
            System.out.println(algorithm);
    }

    public static void mostrarProveedoresDisponibles() {
        Provider[] providers = Security.getProviders();
        System.out.println("Encontrados " + providers.length + " proveedores de seguridad.");
        for (Provider p : providers) {
            System.out.println(p.getInfo());
        }
    }


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

    private PublicKey leerClavePublica(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream (fileName);
        int numBtyes = fis.available ();
        byte[] bytes = new byte[numBtyes];
        fis.read (bytes);
        fis.close ();

        KeyFactory keyFactory = KeyFactory.getInstance ("RSA");
        KeySpec keySpec = new X509EncodedKeySpec(bytes);
        PublicKey keyFromBytes = keyFactory.generatePublic (keySpec);
        return keyFromBytes;
    }

    private PrivateKey leerClavePrivada(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream (fileName);
        int numBtyes = fis.available ();
        byte[] bytes = new byte[numBtyes];
        fis.read (bytes);
        fis.close ();

        KeyFactory keyFactory = KeyFactory.getInstance ("RSA");
        KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        PrivateKey keyFromBytes = keyFactory.generatePrivate (keySpec);
        return keyFromBytes;
    }

    private void guardarClave (Key key, String fileName) throws Exception {
        byte[] publicKeyBytes = key.getEncoded ();
        FileOutputStream fos = new FileOutputStream (fileName);
        fos.write (publicKeyBytes);
        fos.close ();
    }
}
