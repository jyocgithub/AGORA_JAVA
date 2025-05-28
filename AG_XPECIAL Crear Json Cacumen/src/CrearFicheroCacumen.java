import java.io.*;
import java.util.Scanner;

public class CrearFicheroCacumen {


    public static void main(String[] args) {

        System.out.println("Poner fichero origen en Descargas/Cacumen");
        System.out.println("Fichero origen");
        String nombrefichorigen = new Scanner(System.in).nextLine();

        System.out.println("Fichero JSON destino nuevo)");
        String nombrefichodestino = new Scanner(System.in).nextLine();

        File archivoorigen = new File("/Users/inaki/Downloads/Cacumen/", nombrefichorigen);
        File archivodestino = new File("/Users/inaki/Downloads/Cacumen/", nombrefichodestino);

        if (archivoorigen.exists()) {
            BufferedReader br = null;
            BufferedWriter bw = null;
            String basededatos = "BBDDPreguntas";
            String tablaelegida = "tabla_disney";
            String lista = "";
            try {

                br = new BufferedReader(new FileReader(archivoorigen));
                bw = new BufferedWriter(new FileWriter(archivodestino, false));


                String linea = br.readLine();
                while (linea != null) {
//                    System.out.println(linea);
                    if(!linea.trim().isEmpty()){
                        String pal = linea;
//                        String pal = linea.split("[\\s,]")[0];     // si solo se quier coger la primea palabra de la linea
                        lista += "\""+pal.trim().toUpperCase()+"\",";
                    }

                    linea = br.readLine();
                }

                lista = lista.substring(0,lista.length()-1);



                String cabeceraListaYPie = "{\n" +
                        "  \""+basededatos+"\" : {\n" +
                        "    \""+tablaelegida+"\" : [ null, "+lista+" ]\n" +
                        "  }\n" +
                        "}\n";

                bw.write(cabeceraListaYPie);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (br != null) br.close();
                    if (bw != null) bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }


    }

}
