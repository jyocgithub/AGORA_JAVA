package aaPruebasSencillas;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ProbandoLog {
     Logger milog = Logger.getLogger(ProbandoLog.class.getName());  // usando el nombre de la clase en el log
//     Logger loggermio = Logger.getLogger("unNombreCualquiera");  // usando un nombre propio en el log

     Logger miLogFile;

    public static void main(String[] args) {
        new ProbandoLog();
    }
    public ProbandoLog() {

        milog.severe("ESTO ES UN ERROR");
        milog.warning("MENUDO AVISO QUE ESCRIBO");
        milog.info("SOLO INFORMATIVO");
        milog.log(Level.WARNING, "Mensaje de aviso en el log");

        crearFicheroLog();
        miLogFile.severe("ESTO ES UN ERROR");
        miLogFile.warning("MENUDO AVISO QUE ESCRIBO");
        miLogFile.info("SOLO INFORMATIVO");
        miLogFile.log(Level.WARNING, "Mensaje de aviso en el log");

    }


    public  void crearFicheroLog() {
        miLogFile = Logger.getLogger(ProbandoLog.class.getName());
        FileHandler fileHandler;
        try {
            String nombrelog = "MiLog_" + new SimpleDateFormat("YYYY-M").format(Calendar.getInstance().getTime()) + ".log";
            fileHandler = new FileHandler(nombrelog, true);
            miLogFile.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter(); // para que los mensajes no salgan como XML
            fileHandler.setFormatter(simpleFormatter);
            miLogFile.setUseParentHandlers(false); //Para que no salgan los mensajes por la consola

            miLogFile.setLevel(Level.ALL);
//            miLogFile.setLevel(Level.OFF);   // se usaria para inahabilitar los mensajes de log

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



