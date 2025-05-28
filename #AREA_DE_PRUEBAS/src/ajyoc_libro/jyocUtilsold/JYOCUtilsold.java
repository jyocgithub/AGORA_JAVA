package ajyoc_libro.jyocUtilsold;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

/**
 * @author IMS
 * <p>
 * INDICE DE METODOS
 * <p>
 * stringToBoolean () - Devuelve true si el parametro es T, TRUE, S o SI
 * leerIntScanner () - Devuelve un int leido por Scanner por System.in
 * leerStringTeclado (String mens) - Lee String por teclado (BufferedReader)
 */
public class JYOCUtilsold {

    /**
     * Devuelve true si el parametro es T, TRUE, S o SI
     *
     * @param m cadena a evaluar
     * @return true si el parametro es T, TRUE, S o SI
     */
    public static boolean stringToBoolean(String m) {
        String reg = "T|TRUE|S|SI";
        return m.toUpperCase().trim().matches(reg);
    }


    /**
     * Devuelve un int leido por Scanner por System.in
     *
     * @param
     * @author IMS
     */
    public int leerIntScanner() {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        res = sc.nextInt();
        return res;
    }

    // *********************************************************** leerStringTeclado
    static public String leerStringTeclado(String mens) {
        System.out.println(mens);
        String resultado = "";
        try {
            InputStreamReader fr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(fr);
            resultado = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    } // fin leerStringTeclado

    // *********************************************************** leerBooleanTeclado
    static public boolean leerBooleanTeclado(String mens) {
        boolean seguir;
        Boolean resultado;
        String res;
        do {
            seguir = false;
            System.out.println(mens);
            resultado = null;
            try {
                InputStreamReader fr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(fr);
                res = br.readLine();
                if (res.equalsIgnoreCase("SI") || res.equalsIgnoreCase("S") || res.equalsIgnoreCase("TRUE")) {
                    resultado = true;
                } else if (res.equalsIgnoreCase("NO") || res.equalsIgnoreCase("N") || res.equalsIgnoreCase("FALSE")) {
                    resultado = false;
                } else {
                    seguir = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (seguir)
                System.out.println("El valor introducido no es un valor booleano (SI,NO,FALSE,TRUE,S,N). Pruebe de nuevo.");

        } while (seguir);

        return resultado;
    } // fin leerBooleanTeclad

    // *********************************************************** leerIntTeclado
    static public int leerIntTeclado(String mens) {
        boolean seguir;
        String resultado;
        do {
            seguir = false;
            System.out.println(mens);
            resultado = "";
            try {
                InputStreamReader fr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(fr);
                resultado = br.readLine();
                for (int i = 0; i < resultado.length() && !seguir; i++) {
                    if (!(Character.isDigit(resultado.charAt(i)))) {
                        seguir = true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (seguir) System.out.println("El valor introducido no es un numero entero. Pruebe de nuevo.");

        } while (seguir);
        return Integer.parseInt(resultado);
    } // fin leerIntTeclad

    // *********************************************************** esUnNumero
    // Propuesta: hecerlo por regexp
    static public boolean esUnNumero(String strDato) {
        boolean res = true;
        for (int i = 0; i < strDato.length(); i++) {
            if (!(Character.isDigit(strDato.charAt(i)))) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * Metodo que valida un mail de modo sencillo
     */
    static public boolean validarCorreo(String strDni) {
        boolean res = true;
        if (strDni.substring(0, 1).equals("@")) return false;
        if (strDni.substring(0, 1).equals(".")) return false;
        if (!strDni.contains("@")) return false;
        if (!strDni.contains(".")) return false;
        if (strDni.indexOf('@') > strDni.indexOf('.')) return false;
        if (strDni.split(".").length > 2) return false;
        if (strDni.split("@").length > 2) return false;
        return res;
    }

    /**
     * Devuelve un String leido por Scanner por System.in
     *
     * @param
     * @author IMS
     */
    static public String leerStringScanner() {
        String res = "";
        res = new Scanner(System.in).nextLine();
        return res;
    }

    /**
     * RELLENAR CON BLANCOS
     * <p>
     * Rellena con blancos a la derecha una cadena , hasta el tamaño indicado parametro. Si la el tamaño es mas pequeño que la
     * cadena original recorta esta dejando solo el tamaño solicitado
     * <p>
     * Ejemplos rellenar("hola",4) -> da "hola    " rellenar("",3) -> da "   " rellenar("1234567",4) -> da "1234"
     *
     * @param cadenaARellenar cadena que se desea ampliar tamano
     * @param tamano          tamaño de la cadena final
     */
    static public String rellenarConBlancos(String cadenaARellenar, int tamano) {
        String resultado = cadenaARellenar;
        int cuantos = tamano - cadenaARellenar.length();
        if (cuantos < 1 || tamano < 1) return cadenaARellenar;
        if (cadenaARellenar.length() > tamano) return cadenaARellenar.substring(tamano);
        for (int i = 0; i < cuantos; i++)
            resultado += " ";
        return resultado;
    }


    /**
     * CREA UNA CADENA DE UN CARACTER ESPECIFICO
     * <p>
     * Devuelve un String resultante de repetir n veces un mismo caracter
     * <p>
     * Ejemplos rellenar("hola",4) -> da "hola    " rellenar("",3) -> da "   " rellenar("1234567",4) -> da "1234"
     *
     * @param relleno    caracter que se desea repetir
     * @param tamano tamaño de la cadena final
     */
    static public String stringDeAlgo(char relleno, int tamano) {
        String resultado = "";
        for (int i = 0; i < tamano; i++)
            resultado += relleno;
        return resultado;
    }


    /**
     * RELLENAR CON PATRON
     * <p>
     * Rellena con UN CARACTER definido a la derecha una cadena , hasta el tamaño indicado parametro. Si la el tamaño es mas pequeño
     * que la cadena original recorta esta dejando solo el tamaño solicitado
     * <p>
     * Ejemplos rellenar("hola",4) -> da "hola    " rellenar("",3) -> da "   " rellenar("1234567",4) -> da "1234"
     *
     * @param cadenaARellenar -> cadena que se desea ampliar
     * @param tamano          -> tamaño de la cadena final
     * @param patron          -> cadena de relleno
     * @param orientacion     -> true rellena por delante de la cadena parametro, false rellena por el final
     * @author Iñaki Martin
     */
    static public String rellenarConPatron(String cadenaARellenar, int tamano, String patron, boolean orientacion) {
        int cuantos = tamano - cadenaARellenar.length();
        if (cuantos < 1 || tamano < 1 || patron.length() > 1) return cadenaARellenar;
        if (cadenaARellenar.length() > tamano) return cadenaARellenar.substring(tamano);
        String relleno = "";
        for (int i = 0; i < cuantos; i++)
            relleno += patron;
        return (orientacion ? relleno + cadenaARellenar : cadenaARellenar + relleno);
    }

    /**
     * LEER STRING DE UN FICHERO RANDOMFILE
     * <p>
     * Lee una cadena de caractreeres de un fichero RandomAccessFile desde la posicion en la que se encuentre el puntero (no se
     * controla la posicion inicial en el metodo) Devuelve la excepcion al metodo llamante.
     *
     * @param raf -> fichero RandomAccessFile donde leer tamano -> cuantos caracteres ha de leer seguidos
     */
    static public String leerStringDeRandomFile(RandomAccessFile raf, int tamano) throws IOException {
        String bloqueleido = "";
        for (int i = 0; i < tamano; i++) {
            char c = raf.readChar();
            bloqueleido = bloqueleido + c;
        }
        return bloqueleido;
    }

    static public String leerStringDeFileBinario(DataInputStream di, int tamano) throws IOException {
        String bloqueleido = "";
        for (int i = 0; i < tamano; i++) {
            char c = (char) di.readByte();
            bloqueleido = bloqueleido + c;
        }
        return bloqueleido;
    }

    /**
     * Devuelve el array ordenado ascendentemente si el valor de direccion es 0,
     * o descendientemiente, si el valor de ordenacion es 1
     * TODO añadir direccion
     *
     * @param m array de integers a ordenar
     * @author IMS
     */
    static public void ordenarArrayIntPorBurbuja(int[] m) {
        // variable auxiliar utilizada para el
        // intercambio de datos en el array
        int aux;

        // recorre todas las posiciones del array
        for (int i = 0; i < m.length; i++) {
            // el segundo for se utiliza para comparar el
            // valor de la posición actual con las siguientes
            for (int j = i + 1; j < m.length; j++) {
                // si uno de los siguientes valores es inferior
                // al actual, procede al intercambio de las
                // posiciones del array
                if (m[j] < m[i]) {
                    aux = m[i];
                    m[i] = m[j];
                    m[j] = aux;
                }
            }
        }

    }

    /**
     * Metodo para ordenar un List de Arrays de String
     *
     * @param listaDeArr el ArrayList<String[]> ordenar
     * @param indice     el indice del array que representa el campo por el que se ordena la lista
     */
    static public void burbujaConListDeArray(ArrayList<String[]> listaDeArr, int indice) {
        // recorre todas las posiciones del array
        for (int i = 0; i < listaDeArr.size(); i++) {
            // este for anidado se usa para comparar el valor de la posición actual
            // con todas las siguientes
            for (int j = i + 1; j < listaDeArr.size(); j++) {
                // si uno de los siguientes valores es inferior al actual,
                // procede al intercambio de las posiciones del array
                String[] aux;
                if (listaDeArr.get(i)[indice].compareTo(listaDeArr.get(j)[indice]) < 0) {
                    aux = listaDeArr.get(i);
                    listaDeArr.set(i, listaDeArr.get(j));
                    listaDeArr.set(j, aux);

                }

            }
        }
    }

    /**
     * Metodo para leer un fichero de texto en que cada linea es un grupo de datos
     * Devuelve un arrayList de arrays de String, por lo que cada elemento del arraylist es
     * un array de string resultante de trocear cada linea del fichero
     * los arraya de cada linea pueden no tener el mismo tamaño
     * el parametro separador es el token que separa los campos
     * (datos) en cada linea del fichero.
     */
    static public ArrayList<String[]> LeerFicheroTextoConSeparadorDeCampo(File ruta, String pFichero, String separador) {

        ArrayList<String[]> datos = null;
        try {
            datos = new ArrayList<>();

            File filres = new File(ruta.getAbsolutePath(), pFichero);

            FileInputStream fis = new FileInputStream(filres);
            // para ficheros con símbolos propios del español,
            // utilizar la codificación "ISO-8859-1"
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            BufferedReader br = new BufferedReader(isr);

            String linea = br.readLine();
            while (linea != null) {
                datos.add(linea.split(separador));
                linea = br.readLine();
            }

            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datos;

    }

    /**
     * Metodo para leer un fichero de texto en que cada linea es un UNICO dato Devuelve un arrayList de String
     */
    static public ArrayList<String> LeerFicheroTexto(String fichero_a_leer)

            throws IOException {

        ArrayList<String> datos = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fichero_a_leer);
        // para ficheros con símbolos propios del español,
        // utilizar la codificación "ISO-8859-1"
        InputStreamReader isr = new InputStreamReader(fis, "UTF8");
        BufferedReader br = new BufferedReader(isr);

        String linea = br.readLine();
        while (linea != null) {
            datos.add(linea);
            linea = br.readLine();
        }

        br.close();
        isr.close();
        fis.close();

        return datos;
    }


    /**
     * booleanAleatorio
     * <p>
     * DEVUELVEN UN BOOLEAN ALEATORIO
     */
    static public boolean booleanAleatorio() {
        // mantenemos la formula aunque sea sin operar operandos, para recordarla
        if ((int) (Math.random() * (1 - 0 + 1) + 0) == 0) return false;
        else return true;
    }

    /**
     * Metodo que devuelve la fecha de hoy en String "DD/MM/AA"
     */
    static public String fechaDeHoy() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia + "/" + (mes + 1) + "/" + año;
    }

    ;

    /**
     * Metodo que devuelve la hora actual en String "HH:MM:SS"
     */
    static public String horaDeHoy() {
        Calendar fecha = new GregorianCalendar();

        int hora = fecha.get(Calendar.HOUR);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        return hora + ":" + minuto + ":" + segundo;
    }

    ;

    /**
     * Metodo que devuelve un numero con ceros por delante
     *
     * @param : numero original - el numero que se desea convertir
     * @param : numeroDeCharTamanoFinal - el tamaño final de la cadena a devolver, con ceros a la izquierda
     * @author: Iñaki Martin
     * @return: String con el numero con ceros por delante
     * <p>
     * Si el numero a convertir es mayor que el tamaño de la cadena solicitada, devuelve el numero original Ejemplos:
     * stringConCeros(3, 5) -> 00003 stringConCeros(3234, 8)); -> 00003234 stringConCeros(322, 2) -> 322
     */
    static public String stringConCeros(int numeroOriginal, int numeroDeCharTamanoFinal) {
        int intMaximo = (int) Math.pow(10, numeroDeCharTamanoFinal);
        if (numeroOriginal > intMaximo) return Integer.toString(numeroOriginal);
        return Integer.toString(numeroOriginal + (intMaximo)).substring(1);
    }

    /**
     * Metodo que convierte un Date en un String
     *
     * @param : Objeto Date - Objeto date a convertir
     * @author: Iñaki Martin
     * @return: String - el date en formato dd/MM/yyyy
     */
    static public String dateToString(Date dateFecha) {
        SimpleDateFormat miFormato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEnTexto = miFormato.format(dateFecha);
        return fechaEnTexto;
    }

    /**
     * Metodo que convierte un String en un Date
     *
     * @param : String - el String en formato dd/MM/yyyy. Se valida que sea asi.
     * @author: Iñaki Martin
     * @return: Objeto Date - Objeto date creado
     */
    static public Date stringToDate(String strFecha) {
        SimpleDateFormat miFormato2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha2 = miFormato2.parse(strFecha);
            return fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public int diferenciaEnDiasEntreDates(Date fechaMayor, Date fechaMenor) {
        long diferenciaEnMilisegs = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEnMilisegs / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    static public int diferenciaEnAnosEntreDates(Date fechaMayor, Date fechaMenor) {
        long diferenciaEnMilisegs = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEnMilisegs / (1000 * 60 * 60 * 24);
        return (int) (dias / 356) - 1;
    }


    /**
     * intAleatorio
     * <p>
     * DEVUELVEN UN ENTERO ALEATORIO EN UN RANGO DETERMINADO
     */
    static public int intAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Cambia un color a una imagen, toda ella del mismo color
     * El color es un parametro de tipo Color
     * Para elegir un color aleatorio, usar true en el tercer parámetro
     *
     * @param image      imagen a modificar
     * @param nuevocolor objeto Color, el nuevo color, de todos los pixeles no transparentes, para la imagen
     * @param aleatorio  si se desea usar un color aleatorio, el parametro nuevocolor puede ser en este caso null
     * @return imagen modificada
     */
    private static BufferedImage colorImage(BufferedImage image, Color nuevocolor, boolean aleatorio) {
        int width = image.getWidth();
        int height = image.getHeight();
        int rojo, verde, azul;
        WritableRaster raster = image.getRaster();
        if (aleatorio) {
            rojo = new Random().nextInt(255);
            verde = new Random().nextInt(255);
            azul = new Random().nextInt(255);
        } else {
            rojo = nuevocolor.getRed();
            verde = nuevocolor.getGreen();
            azul = nuevocolor.getGreen();

        }
        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = rojo;
                pixels[1] = verde;
                pixels[2] = azul;
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }


    // ****************************************************************
    // ZONA DE PRUEBAS DE LOS METODOS
    String bloqueleido = "";

    public static void main(String[] s) {
        Random ran = new Random();
//        JYOCUtils jyocUtils = new JYOCUtils();
        for (int i = 0; i < 100; i++) {
            int valor = (int) (ran.nextDouble() * (15 - 12 + 1) + 12);
            System.out.println(valor);
        }
    }

    public void testdemetodos() {
        System.out.println(stringDeAlgo('1', 12));
        System.out.println(rellenarConBlancos("cada", 8) + "/");
        System.out.println(stringConCeros(322, 2));

        Date f = new Date();
        Date fm = stringToDate("20/09/1964");
        System.out.println(f);

        System.out.println(diferenciaEnDiasEntreDates(f, fm));
        System.out.println(diferenciaEnAnosEntreDates(f, fm));
        // ArrayList<String> LeerFicheroTexto(String fichero_a_leer)
        leerIntTeclado("holla");
    }
}
