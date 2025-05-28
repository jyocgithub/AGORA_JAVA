package MiClaseDiario;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.*;

public class MiDiario  {
    private static  class MIFormato extends Formatter {
        @Override
        public String format(LogRecord record) {
            String fecha = new SimpleDateFormat("dd-MM-YYYY_hh:mm:ss ").format(Calendar.getInstance().getTime());
            String formato = nombredelaclase + " \\ " + fecha + " " + record.getLevel() + " : " + record.getMessage() +"\n";
            return formato;
        }
    }
    static String nombredelaclase;
    static 	Logger milog ;
    public static Logger crearLog(String nombre , boolean conMensajeEnConsola) {

        nombredelaclase = nombre;
        try {
            milog = Logger.getLogger("MILOG");
            String fecha = new SimpleDateFormat("dd-MM-YYYY_").format(Calendar.getInstance().getTime());

            String nombreDelFicheroDeLog  ="LOG_"+ fecha + ".log";
            FileHandler gestorDeFicherosDeLog = new FileHandler(nombreDelFicheroDeLog, true);

            MIFormato miformato = new MIFormato();
            gestorDeFicherosDeLog.setFormatter(miformato);
            milog.addHandler(gestorDeFicherosDeLog);

            milog.setUseParentHandlers(conMensajeEnConsola);

            return milog;
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void logError(String mensaje) {
        milog.log(Level.SEVERE,mensaje);
    }
    public static void logInfo(String mensaje) {
        milog.log(Level.INFO,mensaje);
    }
    public static void logWarning(String mensaje) {
        milog.log(Level.WARNING, mensaje);
    }

}