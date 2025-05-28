import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;

public class PRUEBAS {


    public PRUEBAS() throws FileNotFoundException {
    }


    public static void main(String[] args) throws Exception {
//        try {
//            // Carga del fichero que tiene los certificados de los servidores en
//            // los que confiamos.
//            InputStream fileCertificadosConfianza = new FileInputStream(new File(
//                    ".mialmacenkeystore"));
//            KeyStore ksCertificadosConfianza = KeyStore.getInstance(KeyStore
//                    .getDefaultType());
//            ksCertificadosConfianza.load(fileCertificadosConfianza,
//                    "123456".toCharArray());
//            fileCertificadosConfianza.close();
//
//            // Ponemos el contenido en nuestro manager de certificados de
//            // confianza.
//            TrustManagerFactory tmf = TrustManagerFactory
//                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            tmf.init(ksCertificadosConfianza);
//
//            // Creamos un contexto SSL con nuestro manager de certificados en los
//            // que confiamos.
////            SSLContext context = SSLContext.getInstance("TLS");
////            context.init(null, tmf.getTrustManagers(), null);
////            SSLSocketFactory sslSocketFactory = context.getSocketFactory();
//
//            // Abrimos la conexión y le pasamos nuestro contexto SSL
//            URL url = new URL("https://www.openbank.es/");
//            URLConnection conexion = url.openConnection();
////            ((HttpsURLConnection) conexion).setSSLSocketFactory(sslSocketFactory);
//
//            // Ya podemos conectar y leer
//            conexion.connect();
//            InputStream is = conexion.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            char[] buffer = new char[1000];
//            int leido;
//            while ((leido = br.read(buffer)) > 0) {
//                System.out.println(new String(buffer, 0, leido));
//            }
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
////        } catch (KeyManagementException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
//        }

//        URL url = new URL("http://www.google.es");
//        URLConnection urlConnection = url.openConnection();
//        urlConnection.connect();
//
//        System.out.println("Fecha: " + urlConnection.getDate());
//        System.out.println("Tipo: " + urlConnection.getContentType());
//        System.out.println("Expiracion: " + urlConnection.getExpiration());
//        System.out.println("Ultima modificacion: " + urlConnection.getLastModified());
//        System.out.println("Modificado desde: " + urlConnection.getIfModifiedSince());
//        System.out.println("Longitud: " + urlConnection.getContentLength());
//        System.out.println("Codificacion: " + urlConnection.getContentEncoding());
//        System.out.println("Contenido: " + urlConnection.getContent());
//        System.out.println("URL: " + urlConnection.getURL());

//        Fecha: 1671721437000
//        Tipo: text/html; charset=ISO-8859-1
//        Expiracion: 0
//        Ultima modificacion: 0
//        Modificado desde: 0
//        Longitud: -1
//        Codificacion: null
//        Contenido: sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@6767c1fc
//        URL: http://www.google.es


//        InputStream is = urlConnection.getInputStream();
//        OutputStream os = urlConnection.getOutputStream();

//        URL url = new URL("http://www.google.es");
//        URLConnection urlConnection = url.openConnection();
//        HttpURLConnection connection = null;
//        if (urlConnection instanceof HttpURLConnection) {
//            connection = (HttpURLConnection) urlConnection;
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String contenidohtml = "";
//            String linea;
//            while ((linea = in.readLine()) != null) {
//                contenidohtml += linea;
//            }
//            System.out.println(contenidohtml);
//        } else {
//            System.out.println("No es una HTTP URL.");
//        }
//
//










        String urlDestino= "https://www.google.com";
        String nombreDeMiAlmacen = ".mialmacenkeystore";
        String passwordDeMiAlmacen = "123456";

//        System.setProperty("javax.net.ssl.trustStore", ".mialmacenkeystore");
//        System.setProperty("javax.net.ssl.trustStorePassword", passwordDeMiAlmacen);
//        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        // Abrimos la conexión y le pasamos nuestro contexto SSL
        URL url = new URL(urlDestino);
        URLConnection urlConnection = url.openConnection();

        // Creamos el ssl socket y lo agregamos a la conexión
        SSLSocketFactory sslSocketFactory = getPersonalSSLSocketFactory(nombreDeMiAlmacen, passwordDeMiAlmacen);
        ((HttpsURLConnection) urlConnection).setSSLSocketFactory(sslSocketFactory);

        // Ya podemos conectar y leer
        urlConnection.connect();
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        char[] buffer = new char[1000];
        int leido;
        while ((leido = br.read(buffer)) > 0) {
            System.out.println(new String(buffer, 0, leido));
        }


    }

    public static SSLSocketFactory getPersonalSSLSocketFactory(String nombrealmacen, String passwordDeMiAlmacen) throws Exception {
        // Carga del fichero que tiene los certificados de los servidores en los que confiamos.
        InputStream fileMisCertificados = new FileInputStream(nombrealmacen);
        KeyStore miAlmacen = KeyStore.getInstance(KeyStore.getDefaultType());
        miAlmacen.load(fileMisCertificados, passwordDeMiAlmacen.toCharArray());
        fileMisCertificados.close();

        // Ponemos el contenido en nuestro manager de certificados de confianza.
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(miAlmacen);

        // Creamos un contexto SSL con nuestro manager de certificados en en los que confiamos.
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, trustManagerFactory.getTrustManagers(), null);
        SSLSocketFactory sslSocketFactory = sslcontext.getSocketFactory();

        return sslSocketFactory;

    }


    public static void escribirFicheroTexto() {
        BufferedWriter bw = null;

        try {
            FileWriter fw = new FileWriter("textoPrueba.txt", true);
            bw = new BufferedWriter(fw);
            bw.write("buenas pollo !!!!!!!!");
            bw.newLine();
            bw.write("fin de mi escritura");
            bw.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {

            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
}
