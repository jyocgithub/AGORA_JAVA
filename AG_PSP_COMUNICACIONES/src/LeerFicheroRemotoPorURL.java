import java.io.*;
import java.net.URL;

public class LeerFicheroRemotoPorURL {


    public void leer() {
        try {

            // Leyendo bytes y enviando a fichero
            URL url = new URL("http://ftp.rediris.es/debian/README.mirrors.txt");
            //conecta a esa URL
            url.openConnection();
            //Asocia un flujo de entrada a la conexi�n URL
            InputStream flujoIn = url.openStream();
            //Crea flujo de salida asociado a destino
            FileOutputStream flujoOutFile = new FileOutputStream("copiafichero.txt");
            //mientras hay bytes
            int bytesleidos = 0, totalBytesLeidos = 0;
            byte[] buffer = new byte[512];
            while ((bytesleidos = flujoIn.read(buffer)) > 0) {
                //almacena lo que lee en el buffer
                flujoOutFile.write(buffer, 0, bytesleidos);
                totalBytesLeidos += bytesleidos;
            }

            // Leyendo lineas de stringy enviando a consola
            URL oracle = new URL("http://www.oracle.com/");
            BufferedReader in = new BufferedReader( new InputStreamReader(oracle.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
