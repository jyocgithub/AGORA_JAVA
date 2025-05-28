package adivinanumero;
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
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainPadreAdivinaNumero {


  public static void main(String[] args) throws Exception {

    adivinarNumerodeUnJarPropio();
  }

  public static void adivinarNumerodeUnJarPropio() throws Exception {
    ProcessBuilder maquinadehacerprocesos = new ProcessBuilder("CMD", "/C", "java", "-jar", "C:\\Users\\carlo\\OneDrive\\Escritorio\\Proceso_jar.jar");
    Process elprocesolanzado = maquinadehacerprocesos.start();
    //  int codigosalida = elprocesolanzado.waitFor();
    //   System.out.println(codigosalida);

    BufferedReader lector = new BufferedReader(new InputStreamReader(elprocesolanzado.getInputStream()));
    BufferedWriter escritor = new BufferedWriter (new OutputStreamWriter(elprocesolanzado.getOutputStream()));

    Scanner sc = new Scanner(System.in);

    System.out.println("Dime un numero a ver si pillo el del otro pollo...");
    int num = sc.nextInt();

    escritor.write(num);
    escritor.flush();

    String mensaje = lector.readLine();
    System.out.println(mensaje);

  }

}
