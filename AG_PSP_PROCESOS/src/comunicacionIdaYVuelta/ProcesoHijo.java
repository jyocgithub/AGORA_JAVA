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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcesoHijo {

  public static void main(String[] args) {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    try {
      String lineaLeida = br.readLine();
      System.out.println(lineaLeida.toUpperCase());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
