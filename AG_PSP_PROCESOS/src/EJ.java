
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EJ {

    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      String palabra = "";
      while(!palabra.equalsIgnoreCase("FIN")) {
        System.out.println("Fin para terminar");
        palabra = sc.nextLine();
        if( ! palabra.equalsIgnoreCase("FIN")) {
          try {
            ProcessBuilder maquina = new ProcessBuilder("jar", "-j", "prueba.jar");
            Process elprocesolanzado = maquina.start();
            elprocesolanzado.waitFor();
            InputStream is = elprocesolanzado.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
//					String numero  = br.readLine();
            System.out.println("El numero es: ");

            int c;
            while ((c = is.read()) != -1) {

              System.out.println("....");
              System.out.print((char) c);
            }
            is.close();

          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }







        }



      }


    }


}
