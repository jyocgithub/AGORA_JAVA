package cap50_a_02_fabricadetrajes.utilidades;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author IMS
 * <p>
 * INDICE DE METODOS
 * <p>
 * leerIntScanner () - Devuelve un int leido por Scanner por System.in
 * leerStringTeclado (String mens) - Lee String por teclado (BufferedReader)
 */
public class Utilidades {

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

            if (seguir)
                System.out.println("El valor introducido no es un numero entero. Pruebe de nuevo.");

        } while (seguir);
        return Integer.parseInt(resultado);
    } // fin leerIntTeclado


    static public int leerDoubleTeclado(String mens) {
        boolean erroneo;
        int numpuntosdecimales = 0;
        String resultado;
        do {
            erroneo = false;
            System.out.println(mens);
            resultado = "";
            try {
                InputStreamReader fr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(fr);
                resultado = br.readLine();
                for (int i = 0; i < resultado.length() && !erroneo; i++) {

                    if (resultado.charAt(i) == '.') {
                        numpuntosdecimales++;
                    } else if (!(Character.isDigit(resultado.charAt(i)))) {
                        erroneo = true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (numpuntosdecimales > 1) {
                System.out.println("El valor intriducido tiene mas de un punto decimal. Pruebe de nuevo.");

            } else if (erroneo) {
                System.out.println("El valor introducido no es un numero double. Pruebe de nuevo.");
            }
        } while (erroneo);
        return Integer.parseInt(resultado);
    } // fin leerIntTeclad

    static public int intAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }


    //	// ****************************************************************
    //	// ZONA DE PRUEBAS DE LOS METODOS
    //	String bloqueleido = "";
    //
    //	public static void main (String[] s) {
    //		Random ran = new Random ();
    //		JYOCUtils jyocUtils = new JYOCUtils ();
    //		for (int i = 0; i < 100; i++) {
    //			int valor = (int) (ran.nextDouble () * (15 - 12 + 1) + 12);
    //			System.out.println (valor);
    //		}
    //	}
    //
    //	public void testdemetodos () {
    //		System.out.println (stringDeAlgo ('1', 12));
    //		System.out.println (rellenarConBlancos ("cada", 8) + "/");
    //		System.out.println (stringConCeros (322, 2));
    //
    //		Date f = new Date ();
    //		Date fm = stringToDate ("20/09/1964");
    //		System.out.println (f);
    //
    //		System.out.println (diferenciaEnDiasEntreDates (f, fm));
    //		System.out.println (diferenciaEnAnosEntreDates (f, fm));
    //		// ArrayList<String> LeerFicheroTexto(String fichero_a_leer)
    //		leerIntTeclado ("holla");
    //	}
}
