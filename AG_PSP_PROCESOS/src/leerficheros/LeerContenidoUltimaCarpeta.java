package leerficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerContenidoUltimaCarpeta {


    public static void main(String[] args) throws Exception{
        String ultimacarpeta = ultimaCarpeta();
        System.out.println("La ultima carpeta es "+ ultimacarpeta);
//        Process p = Runtime.getRuntime().exec("cmd /c dir c:\\"+ultimacarpeta+"\\./b"); // en windows
        Process p = Runtime.getRuntime().exec("ls .\"+ultimacarpeta"); // en unix / mac
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String carpetas;
        while((carpetas= br.readLine()) != null){
            System.out.println(carpetas);
        }
    }
    public static String ultimaCarpeta() throws IOException{
//        Process p = Runtime.getRuntime().exec("cmd /c dir c:\\*./b");  // en windows
        Process p = Runtime.getRuntime().exec("ls -d */");  // en unix / mac
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String carpeta;
        String CarpetaGuardada = "";
        while((carpeta= br.readLine()) != null){
            System.out.println(carpeta);
            CarpetaGuardada = carpeta;
        }
        return CarpetaGuardada;
    }



}
