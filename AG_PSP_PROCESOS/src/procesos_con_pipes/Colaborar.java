package procesos_con_pipes;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Colaborar {

    public static void main(String[] args) {

        String fich = "PALABROS.TXT";
        File f = new File(fich);
        if (f.exists()) {
            f.delete();
        }

        for (int i = 0; i < 10; i++) {
            try {
                Process proceso = Runtime.getRuntime().exec("powershell.exe java -jar Lenguaje.jar " + (i * 10 + 10) + " " + fich);
////                Process proceso = Runtime.getRuntime().exec("cmd.exe java -jar Lenguaje.jar '20' 'PALABROS.TXT'");

                int codigosalida = proceso.waitFor();
                System.out.println("Vuelta " + i + " CODIGO devuelto: " + codigosalida);
            } catch (IOException ex) {
                Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
