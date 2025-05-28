package gr_java;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GR_05_PRINTF_STRINGFORMAT {

    public static void main(String[] args) {

        // =======================================
        //       System.out.PRINTF
        //       System.out.FORMAT
        //       String.FORMAT
        // =======================================

        int numEntero = 12345678;
        double numDouble = 3.14159265;
        String cadena = "CadenaEjemplo";
        Date hoy = Calendar.getInstance().getTime();

        /*
         * patrones base de cada tipo de dato  ---------------------------------------------------
         */
        System.out.printf("%d mascosas\n",numEntero );   // int
        System.out.printf("%f mascosas\n" ,numDouble );  // double
        System.out.printf("%s mascosas\n",cadena );      // string
        System.out.printf("%c mascosas\n", 'x'  );       // char
        System.out.printf("%b mascosas\n", true );       // boolean
        System.out.printf("%tT mascosas\n", hoy );       // Hora
        System.out.printf("%tD mascosas\n", hoy );       // Dia


        // =======================================
        // con INT
        // =======================================
        System.out.println("ª--------------int");
        System.out.printf("%d mascosas\n",numEntero );      // ESCRIBE SIMPLEMENTE EL INT
        System.out.printf("%20d mascosas\n",numEntero );    // JUSTIFICA A DERECHA EN UN BLOQUE DE 20 BLANCOS
        System.out.printf("%020d mascosas\n",numEntero );    // JUSTIFICA A DERECHA EN UN BLOQUE DE 20 CEROS
        System.out.printf("%-20d mascosas\n",numEntero );   // JUSTIFICA A IZQUIERDA EN UN BLOQUE DE 20 BLANCOS
        System.out.printf("%,d mascosas\n" ,numEntero );    // AÑADE PUNTOS EN LOS MILES

        // si no sale en el idioma correcto, a pesar de la config del S.O.:
        System.out.printf(Locale.US,"%,d mascosas\n" ,numEntero );    // AÑADE PUNTOS EN LOS MILES
        System.out.printf(Locale.ITALY,"%,d mascosas\n" ,numEntero );    // AÑADE PUNTOS EN LOS MILES


        // =======================================
        // con DOUBLE o FLOAT
        // =======================================
        System.out.println("ª--------------double");
        System.out.printf("%f mascosas\n" ,numDouble );     // ESCRIBE SIMPLEMENTE EL FLOAT O DOUBLE
        System.out.printf("%20f mascosas\n" ,numDouble );   // JUSTIFICA A DERECHA EN UN BLOQUE DE 20 BLANCOS
        System.out.printf("%+20f mascosas\n" ,numDouble );   // JUSTIFICA A DERECHA EN UN BLOQUE DE 20 BLANCOS Y PONE SIEMPRE EL SIGNO
        System.out.printf("%020f mascosas\n" ,numDouble );   // JUSTIFICA A DERECHA EN UN BLOQUE DE 20 CEROS
        System.out.printf("%20.3f mascosas\n" ,numDouble );  // JUSTIFICA A DERECHA EN UN BLOQUE DE 20 BLANCOS, Y SOLO 3 DECIMALES
        System.out.printf("%-20f mascosas\n" ,numDouble );  // JUSTIFICA A IZQUIERDA EN UN BLOQUE DE 20 BLANCOS
        System.out.printf("%,20f mascosas\n" ,numDouble );  // JUSTIFICA Y AÑADE PUNTOS EN LOS MILES


        // =======================================
        // con STRING
        // =======================================
        System.out.println("--------------string");
        System.out.printf("%s mascosas\n",cadena );      // ESCRIBE SIMPLEMENTE LA CADENA
        System.out.printf("%S mascosas\n",cadena );      // ESCRIBE SIMPLEMENTE LA CADENA EN MAYUSCULAS
        System.out.printf("%20s mascosas\n",cadena );    // JUSTIFICA A DERECHA EN UN BLOQUE DE 20 BLANCOS
        System.out.printf("%-20s mascosas\n",cadena );   // JUSTIFICA A IZQUIERDA EN UN BLOQUE DE 20 BLANCOS
        System.out.printf("%5.3s mascosas\n",cadena );   // JUSTIFICA A DERECHA EN UN BLOQUE DE 5 BLANCOS, SOLO LOS 3 PRIMEROS CHAR DE LA CADENA


        // =======================================
        // con CHAR
        // =======================================
        System.out.println("--------------char");
        System.out.printf("%c mascosas\n", 'x'  );       // ESCRIBE SIMPLEMENTE EL CHAR
        System.out.printf("%C mascosas\n", 'x'  );       // ESCRIBE SIMPLEMENTE EL CHAR EN MAYUSCULAS


        // =======================================
        // con DATE
        // =======================================
        System.out.println("--------------fechas");
        System.out.printf("%tT mascosas\n", hoy );       // ESCRIBE LA HORA CON FORMATO HH:MM:SS
        System.out.printf("%tD mascosas\n", hoy );       // ESCRIBE LA FECHA CON FORMATO MM/DD/AA
        System.out.printf("%tH mascosas\n", hoy );       // ESCRIBE SOLO LA HORA (NI MINUTOS NI SEGUNDOS)
        System.out.printf("%tM mascosas\n", hoy );       // ESCRIBE SOLO MINUTOS
        System.out.printf("%tS mascosas\n", hoy );       // ESCRIBE SOLO SEGUNDOS
        System.out.printf("%tp mascosas\n", hoy );       // ESCRIBE AM O PM
        System.out.printf("%tL mascosas\n", hoy );       // ESCRIBE LOS MILISEGUNDOS
        System.out.printf("%tN mascosas\n", hoy );       // ESCRIBE LOS NANOSEGUNDOS

        System.out.printf("%td mascosas\n", hoy );       // ESCRIBE DIA CON DOS DIGITOS
        System.out.printf("%tm mascosas\n", hoy );       // ESCRIBE MES CON DOS DIGITOS
        System.out.printf("%tB mascosas\n", hoy );       // ESCRIBE MES CON LETRAS
        System.out.printf("%ty mascosas\n", hoy );       // ESCRIBE AÑOS CON DOS DIGITOS
        System.out.printf("%tY mascosas\n", hoy );       // ESCRIBE AÑOS CON CUATRO DIGITOS


        // ================================================
        // MODIFICANDO EL ORDEN DE LOS PARAMETROS , con n$
        // =======================================
        int a = 100;
        int b = 200;
        int c = 300;
        System.out.printf("%2$d %3$d %1$d\n",a,b,c );

    }
}
