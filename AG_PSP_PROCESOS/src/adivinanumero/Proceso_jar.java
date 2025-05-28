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
import java.util.Random;



// esta clase ha de compilarse independientemente para crear un jar !!!


public class Proceso_jar {


    public static void main(String[] args) throws Exception {

        Random r = new Random();
        int azar = r.nextInt(10) + 1;

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out));

        int numeroleido = lector.read();

        if (numeroleido == azar) {
            escritor.write("ACERTASTE \n");
        } else {
            escritor.write("Fallo.... era un  " + azar + " \n");
        }

        escritor.flush();

    }


}
