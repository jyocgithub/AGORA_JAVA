package leer_url_y_ficheros_internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeeUrl {

   public static void main(String[] args) throws IOException {

      try {
         URL oracle = new URL("https://dl.dropboxusercontent.com/u/60823340/C%C3%B3mo%20usar%20la%20carpeta%20p%C3%BAblica.txt?dl=1");
         BufferedReader in = new BufferedReader( new InputStreamReader(oracle.openStream()));

         String inputLine;
         while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
         }
         in.close();
      } catch (MalformedURLException ex) {
         Logger.getLogger(LeeUrl.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

}
