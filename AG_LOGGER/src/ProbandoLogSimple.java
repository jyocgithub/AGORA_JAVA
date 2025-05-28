
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

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.*;

public class ProbandoLogSimple {
    static Logger milog = Logger.getLogger(ProbandoLogSimple.class.getName());  // usando el nombre de la clase en el log
    static Logger loggermio = Logger.getLogger("unNombreCualquiera");  // usando un nombre propio en el log
    static Logger miLogFile;

    public static void main(String[] args) {

        // ASI SOLO log en consola
        milog.severe("ESTO ES UN ERROR");
        milog.warning("MENUDO AVISO QUE ESCRIBO");
        milog.info("SOLO INFORMATIVO");
        milog.log(Level.WARNING, "Mensaje de aviso en el log");

        // ASI LOG en consola y en fichero
        crearFicheroLog();

        miLogFile.severe("ESTO ES UN ERROR");
        miLogFile.warning("MENUDO AVISO QUE ESCRIBO");
        miLogFile.info("SOLO INFORMATIVO");
        miLogFile.log(Level.WARNING, "Mensaje de aviso en el log");

        // ASI quitamos los log en consola
        miLogFile.setUseParentHandlers(false);

    }


    public static void crearFicheroLog() {

        // -- esto funcionaria si no fuera un metodo static
        // String nombreclase = this.getClass().getSimpleName();
        String nombreclase = MethodHandles.lookup().lookupClass().getSimpleName();


        miLogFile = Logger.getLogger(ProbandoLogSimple.class.getName());
        FileHandler fileHandler;
        try {
            String hoy = new SimpleDateFormat("dd-MM-YYYY").format(Calendar.getInstance().getTime());

            String nombrelog = "Log_" + nombreclase + " - " + hoy + ".log";
            fileHandler = new FileHandler(nombrelog, true);
            miLogFile.addHandler(fileHandler);

            // para que los mensajes no salgan como XML, y con el formato estandar
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            // Para que no salgan los mensajes por la consola
            miLogFile.setUseParentHandlers(false);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


