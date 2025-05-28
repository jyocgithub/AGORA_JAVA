package censura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

public class InicioCensura {


    public static void main(String[] args) {
        /*
         * Ejercicio Censura en ficheros: Se necesita crear una clase censura con un
         * metodo 'aplicaCensura()' que modifique ciertas palabras de una fichero. El
         * metodo recibe como par�metros: un nombre de un fichero de texto (que ya debe
         * estar creado) y un array de palabras prohibidas. El metodo buscas las
         * palabras prohibidas en el fichero, y si encuentra una palabra prohibida, la
         * sustituye por �*******�. El metodo devuelve un nuevo fichero creado con la
         * censura aplicada. Cread una clase Prueba que compruebe el uso del metodo. No
         * se pueden usar los m�todos contains() ni replace().
         */

        crearFicheroTexto();
        crearFicheroFinal();
        aplicarCensura();
        System.out.println("\nSaliendo");
    }

    public static void aplicarCensura() {
        FileWriter fw = null;
        PrintWriter pw = null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] insultos = {"mamon", "idiota", "tonto"};

        try {
            fr = new FileReader("textoSinCensura.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("textoConCensura.txt");
            pw = new PrintWriter(fw);

            String linea = br.readLine();

            while (linea != null) {
                String[] palabras = linea.split(" ");

                // miro palabra a palabra
                for (String palab : palabras) {

                    boolean esta = false;
                    // y miro si la palabra esta entre los insultos
                    for (String insult : insultos) {
                        // COMPRUEBO SI ESTA
                        if (insult.equals(palab)) {
                            esta = true;
                        }
                    }

                    // si la palabra  esta en los insultos...
                    if (esta) {
                        pw.print("****** ");   /// .. escribo asteriscos
                    } else {
                        pw.print(palab+" ");    // y si no escribo la propia palabra
                    }
                }

               linea =  br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fw.close();
                pw.close();
                fr.close();
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void crearFicheroFinal() {
        // TODO Auto-generated method stub

        FileWriter fw = null;
        PrintWriter pw = null;

        try {

            fw = new FileWriter("textoConCensura.txt");
            pw = new PrintWriter(fw);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                pw.close();
                fw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void crearFicheroTexto() {
        // TODO Auto-generated method stub

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("textoSinCensura.txt");
            pw = new PrintWriter(fw);

            pw.print(
                    "Este es un fichero mamon, espero que apruebes cacho de idiota, \nsi no accedes con tus datos correctos eres tonto , \nel otro dia te vi y confirmado eres idiota");

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                fw.close();
                pw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}

