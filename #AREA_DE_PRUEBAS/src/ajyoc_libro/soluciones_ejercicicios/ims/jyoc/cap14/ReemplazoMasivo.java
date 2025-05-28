package soluciones_ejercicicios.ims.jyoc.cap14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ReemplazoMasivo {

    String directorioOrigen;
    boolean recursivo;


    public static void main(String[] args) {
        double a = 2;
        String men = "hola";
        DosValoresCualesquiera dvq = metodoTonto(a, men);
        System.out.println(dvq.getPrimero());
        System.out.println(dvq.getSegundo());

    }


    public static String dateJava_a_STRINGMYSQL(java.util.Date fechaJava) {
        SimpleDateFormat miFormato = new SimpleDateFormat("dd/MM/yyyy");
        String hoyEnString = miFormato.format(fechaJava);
        String hoyEnStringSql = "STR_TO_DATE('" + hoyEnString + "','%d/%m/%Y')";
        return hoyEnStringSql;
    }


    public static String hoy_a_STRINGSQL() {
        Calendar cc = Calendar.getInstance();
        Date hoyEnDate = cc.getTime();
        SimpleDateFormat miFormato = new SimpleDateFormat("dd/MM/yyyy");
        String hoyEnString = miFormato.format(hoyEnDate);
        String hoyEnStringSql = "STR_TO_DATE('" + hoyEnString + "','%d/%m/%Y')";
        return hoyEnStringSql;
    }

    /**
     * de_MILISEGUNDOS_a_EUROPEANSTRING
     * Dado un numero de milisegundos, calcula la fecha que le corresponde en un String
     *
     * @param milisegundos milisegundos a calcular
     * @param miFormato    formato de la fecha
     * @return String con la fecha formateada
     */
    public static String de_MILISEGUNDOS_a_EUROPEANSTRING(long milisegundos, SimpleDateFormat miFormato) {
        Date date = new Date(milisegundos);
        String fechaEnString = miFormato.format(date);
        return fechaEnString;
    }

    /**
     * de_EUROPEANSTRING_a_MILISEGUNDOS
     * Dada un String con una fecha , devuelve los milisegundos que le corresponden
     *
     * @param fechaEnString String con la fecha
     * @param miFormato     formato de fecha que tiene el String
     * @return el numero de milisegundos que corresponden a dicha fecha
     */
    public static long de_EUROPEANSTRING_a_MILISEGUNDOS(String fechaEnString, SimpleDateFormat miFormato) {
        Date fechaenjava = null;
        long millis = 0;
        try {
            fechaenjava = miFormato.parse(fechaEnString);
            millis = fechaenjava.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return millis;
    }


    public static DosValoresCualesquiera metodoTonto(double d, String mensaje) {
        d = d + 1;
        mensaje = mensaje.toUpperCase();
        return new DosValoresCualesquiera(d, mensaje);
    }

}


class DosValoresCualesquiera<R, S> {

    private final R primero;
    private final S segundo;

    public DosValoresCualesquiera(R primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public R getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }
}