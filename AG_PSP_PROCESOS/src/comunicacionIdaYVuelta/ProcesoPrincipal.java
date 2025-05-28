package comunicacionIdaYVuelta;
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

import java.io.*;
import java.util.Scanner;

public class ProcesoPrincipal {


  public ProcesoPrincipal() {

    try {
      Process proceso;
      OutputStream stdin;
      InputStream stderr;
      InputStream stdout;

      BufferedReader reader;
      BufferedWriter writer;
      Scanner sc=new Scanner(System.in);

      while(true) {
        proceso = Runtime.getRuntime().exec("java -jar ProcesoHijo.jar");

//        ProcessBuilder maquina = new ProcessBuilder("CMD","/c","java", "-jar","C:\\Users\\Rizti\\Desktop\\Hijo3.jar");
//        proceso = maquina.start();

        stdin = proceso.getOutputStream ();
        stdout=proceso.getInputStream();
        reader = new BufferedReader(new InputStreamReader(stdout));
        writer = new BufferedWriter(new OutputStreamWriter(stdin));
        System.out.println("Introduzca una línea:");
        String lineaLeida = sc.nextLine();
        writer.write(lineaLeida);
        writer.flush();
        writer.close();
        String cadena;

        while((cadena=reader.readLine())!=null){

          System.out.println(cadena);
        }

      }
      //proceso.destroy();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
     new ProcesoPrincipal();
  }


}



