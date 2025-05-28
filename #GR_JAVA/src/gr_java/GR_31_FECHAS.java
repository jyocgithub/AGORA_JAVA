package src.gr_java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GR_31_FECHAS {

// ******************************************************************************
// *******************    LOCALDATE  ********************************************
// ******************************************************************************

    public static void operacionesBasicasConLocaldate(String fechaEnString) {
        LocalDate fecha1 = LocalDate.of(2020, 5, 15);
        LocalDate fecha2 = LocalDate.now();

        // ver cual de las dos es mayor
        if (fecha1.isBefore(fecha2)) {
            System.out.println("La fecha mayor es la fecha 2");
        } else {
            System.out.println("La fecha mayor es la fecha 1");
        }

        // mostrar los dias y los meses de diferencia entre ambas fechas
        long diasdediferencia = ChronoUnit.DAYS.between(fecha1, fecha2);
        long mesesdediferencia = ChronoUnit.MONTHS.between(fecha1, fecha2);
        System.out.println(diasdediferencia);

        // sumar 2 meses y 3 dias a la fecha2 y mostrar la fecha resultantes
        fecha2 = fecha2.plusMonths(2);
        fecha2 = fecha2.plusDays(3);

        System.out.println("La fecha 2 ahora es " + fecha2.toString());

        // mostrarlo en castellano
        String formatoCastellano = localdateToString(fecha2);
        System.out.println(formatoCastellano);


    }


    public static LocalDate stringToLocaldate(String fechaEnString) {
        if (fechaEnString == null) {
            return null;
        }
        return LocalDate.parse(fechaEnString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String localdateToString(LocalDate fechaEnlocaldate) {
        if (fechaEnlocaldate == null) {
            return null;
        }
        return fechaEnlocaldate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }


    public static LocalDate dateToLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // ******************************************************************
    // ************    GREGORIAN CALENDAR  ******************************
    // ******************************************************************
    public static void operacionesBasicasGregorian(String fechaEnString)  {

        // Crear una instancia de GregorianCalendar con la fecha actual
        GregorianCalendar today = new GregorianCalendar();

        // Obtener componentes de la fecha actual
        int year = today.get(Calendar.YEAR);
                 // Enero es 0, por eso sumamos 1
        int month = today.get(Calendar.MONTH) + 1;
        int day = today.get(Calendar.DAY_OF_MONTH);

        // Crear una instancia de GregorianCalendar con una fecha específica
        GregorianCalendar dia = new GregorianCalendar(1990, Calendar.JANUARY, 22);

        // Modificar la fecha - añadir 10 días
        dia.add(Calendar.DAY_OF_MONTH, 10);

        // Modificar la fecha - quitar 10 días
        dia.add(Calendar.DAY_OF_MONTH, -10);

        // Convertir Date a Gregorian Calendar
        Date otrodia = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(otrodia);

        // Convertir GregorianCalendar a Date
        GregorianCalendar undia = new GregorianCalendar(1990, GregorianCalendar.JANUARY, 22);
        Date date = undia.getTime();
    }
    public static void stringtoGregorianCalendar() throws ParseException {

        // String to Gregorian Calendar
        String dateTimeString = "22/01/1990"; // Fecha en formato String

        // Definir el formato de fecha y hora
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Convertir el String a un objeto Date
        Date dateTime = dateTimeFormat.parse(dateTimeString);

        // Crear un objeto GregorianCalendar y establecer la fecha y hora
        GregorianCalendar gcalendar = new GregorianCalendar();
        gcalendar.setTime(dateTime);
    }
    public static void diferenciaEnDiasGregorianCalendar() {
        // Crear dos objetos GregorianCalendar
        GregorianCalendar fecha1 = new GregorianCalendar(2023, 11, 25); // 25 de diciembre de 2023
        GregorianCalendar fecha2 = new GregorianCalendar(2024, 0, 1);   // 1 de enero de 2024

        // Obtener la diferencia en milisegundos
        long diferenciaMilisegundos = fecha2.getTimeInMillis() - fecha1.getTimeInMillis();

        // Convertir a días
        long diferenciaDias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);
    }
}
