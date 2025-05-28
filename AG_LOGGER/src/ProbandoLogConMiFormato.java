
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

public class ProbandoLogConMiFormato {
    static Logger milog = Logger.getLogger(ProbandoLogSimple.class.getName());  // usando el nombre de la clase en el log
    static Logger loggermio = Logger.getLogger("unNombreCualquiera");  // usando un nombre propio en el log
    static Logger miLogFile;

    public static void main(String[] args) {

        // ahora log en consola
        milog.severe("ESTO ES UN ERROR");
        milog.warning("MENUDO AVISO QUE ESCRIBO");
        milog.info("SOLO INFORMATIVO");
        milog.log(Level.WARNING, "Mensaje de aviso en el log");

        // ahora con log en fichero y formato propio de mensaje
        crearFicheroLog();

        miLogFile.severe("ESTO ES UN ERROR");
        miLogFile.warning("MENUDO AVISO QUE ESCRIBO");
        miLogFile.info("SOLO INFORMATIVO");
        miLogFile.log(Level.WARNING, "Mensaje de aviso en el log");
    }


    public static void crearFicheroLog() {
        miLogFile = Logger.getLogger(ProbandoLogSimple.class.getName());
        FileHandler fileHandler;

        // -- esto funcionaria si no fuera un metodo static
        // String nombreclase = this.getClass().getSimpleName();
        String nombreclase = MethodHandles.lookup().lookupClass().getSimpleName();

        try {
            String hoy = new SimpleDateFormat("dd-MM-YYYY").format(Calendar.getInstance().getTime());
            String nombrelog = "Log_" + nombreclase + " - " + hoy + ".log";

            fileHandler = new FileHandler(nombrelog, true);
            miLogFile.addHandler(fileHandler);

            // para que los mensajes no salgan como XML, y con el formato estandar
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            // para que los mensajes salgan como XML, y con el formato propio
            MiFormatoDeLog miformato = new MiFormatoDeLog();
            fileHandler.setFormatter(miformato);

            //Para que no salgan los mensajes por la consola
            miLogFile.setUseParentHandlers(false);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MiFormatoDeLog extends Formatter {
    @Override
    public String format(LogRecord record) {
        String hoy = new SimpleDateFormat("dd-MM-YYYY_hh:mm:ss ").format(Calendar.getInstance().getTime());
        StringBuilder sb = new StringBuilder();
        sb.append(hoy).append(' ').append(record.getLevel()).append(":\t");
        // este if es para tabylar bien los mensajes INFO que son mas pequeños
        if(record.getLevel().toString().equals("INFO"))   {
            sb.append("\t");
        }
        sb.append(record.getMessage()).append('\n');
        return sb.toString();
    }
}

