package gr_java;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.*;

public class GR_24_LOGGING {

    static Logger milog = Logger.getLogger(GR_24_LOGGING.class.getName());  // usando el nombre de la clase en el log
    static Logger loggermio = Logger.getLogger("unNombreCualquiera");  // usando un nombre propio en el log
    static Logger miLogFile;

    public static void main(String[] args) {

        // ahora log en consola
        milog.severe("ESTO ES UN ERROR");
        milog.warning("MENUDO AVISO QUE ESCRIBO");
        milog.info("SOLO INFORMATIVO");
        milog.log(Level.WARNING, "Mensaje de aviso en el log");

        // ahora con log en fichero
        crearFicheroLog();
        miLogFile.severe("ESTO ES UN ERROR");
        miLogFile.warning("MENUDO AVISO QUE ESCRIBO");
        miLogFile.info("SOLO INFORMATIVO");
        miLogFile.log(Level.WARNING, "Mensaje de aviso en el log");
    }


    public static void crearFicheroLog() {
        miLogFile = Logger.getLogger(GR_24_LOGGING.class.getName());
        FileHandler fileHandler;
        try {
            String nombrelog = "MiLog_" + new SimpleDateFormat("YYYY-M").format(Calendar.getInstance().getTime()) + ".log";
            fileHandler = new FileHandler(nombrelog, true);
            miLogFile.addHandler(fileHandler);

            // para que los mensajes no salgan como XML, y con el formato estandar
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            // para que los mensajes salgan como XML, y con el formato propio
            MiFormatoDeLog miformato = new MiFormatoDeLog();
            fileHandler.setFormatter(miformato);



            miLogFile.setUseParentHandlers(false); //Para que no salgan los mensajes por la consola
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MiFormatoDeLog extends Formatter {
        @Override
        public String format(LogRecord record) {
            String fecha = new SimpleDateFormat("dd-MM-YYYY_hh:mm:ss ").format(Calendar.getInstance().getTime());
            String formato = fecha + " " + record.getLevel() + ":" + record.getMessage() +"\n";
            return formato;
        }
//        @Override
//        public String format(LogRecord record) {
//            StringBuilder sb = new StringBuilder();
//            sb.append(fecha).append(' ');
//            sb.append(record.getLevel()).append(':');
//            sb.append(record.getMessage()).append('\n');
//            return sb.toString();
//        }
    }


}

