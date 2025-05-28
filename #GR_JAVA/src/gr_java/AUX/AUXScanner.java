package gr_java.AUX;
import java.util.*;

/*
#######################################################################################
############################  GUIA DE CONTENIDOS ######################################
#######################################################################################
#                                                                                     #
# SCANNER SIMPLIFICADO                                                                #
# ####################                                                                #
#     - leerInt     (String mensaje)                                                  #
#     - leerDouble  (String mensaje)                                                  #
#     - leerString  (String mensaje)                                                  #
#                                                                                     #
###################################### (fin) ##########################################
 */

/**
 * JYOCUtilsJavaScanner
 * <p>
 * Utilidades para despedirse de usar siempre Scanner con la consola de un IDE
 *
 * @author Iñaki Martin
 * @version 2
 */
public class
AUXScanner {

    /**
     * leerInt Lee con scanner un numero int, precio envio de un mensaje a usuario
     *
     * @param mensaje se muestra al usuario antes de que este escribe el valor
     *                pedido
     * @return el valor int que el usuario introduce por teclado
     */
    public static int leerInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        int numero = 0;
        while (seguir) {
            try {
                System.out.println(mensaje);
                numero = sc.nextInt();

                seguir = false;
            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.println("Debe indicar un valor numerico entero");
                sc.next();  // limpiar sc para que lea otra vez
            }
        }
        return numero;
    }

    /**
     * leerDouble Lee con scanner un numero double, precio envio de un mensaje a
     * usuario
     *
     * @param mensaje se muestra al usuario antes de que este escribe el valor
     *                pedido
     * @return el valor double que el usuario introduce por teclado
     */
    public static double leerDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(mensaje);
                double numero = sc.nextDouble();
                return numero;
            } catch (NumberFormatException  | InputMismatchException  ex) {
                System.out.println("Debe indicar un valor numerico double");
                sc.next();  // limpiar sc para que lea otra vez
            }
        }
    }

    /**
     * leerString Lee con scanner un string, precio envio de un mensaje a usuario
     *
     * @param mensaje se muestra al usuario antes de que este escribe el valor
     *                pedido
     * @return el valor String que el usuario introduce por teclado
     */
    public static String leerString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        String res = sc.nextLine();
        return res;
    }

    public static void main(String[] args) {
        int m = leerInt("dame algo");
    }


}
