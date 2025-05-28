package gr_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GR_10_EXCEPCIONES {


    public static void main(String[] args) {
        // PROBANDO DIVIDIR ARRAY
        // ===========================================
        int[] arr = {0,6,2,120,1,4,8,10};
        double res = dividirArray(arr);
        System.out.println(res);

        // PROBANDO METODOS CON THROWS
        // ===========================================
        int x = 4;
        int y = 8;
        try {
            double suma = sumar(x,y);
            double resta  = restar(x,y);
            double multi  = multiplicar(x,y);
            double divid  = dividir(x,y);
            System.out.println("la suma es " + suma);
            System.out.println("la resta es " + resta);
            System.out.println("la multiu es " + multi);
            System.out.println("la divi es " + divid);

        } catch (  NumeroNoValidoException ex) {
            System.out.println("Error en algun parámetro");
            System.out.println(ex.getMessage());

        } catch (Exception ex) {
            System.out.println("Error en algun sitio");
            System.out.println(ex.getMessage());
        }
    }



    //  1.- Hacer un metodo que recibe un array, pide al usuario dos posiciones del mismo,
    // y devuelve la division de los numeros que estan en dichas posiciones en el array
    // Deben controlarse en el metodo estas circunstancias:
    // - debe controlar que al pedir el valor por teclado, sea realmente un numero
    // - debe controlar que las posiciones del array existen y tienen valor
    // - debe controlar que no se puede dividir por 0
    // Si se produce alguna de estas 3 circunstancias, el metodo devuelve 0;

    public static double dividirArray(int[] array) {
        Scanner entrada = new Scanner(System.in);
        try{
            System.out.println("Dime dos posiciones del array:");
            int pos1 = entrada.nextInt();
            int pos2 = entrada.nextInt();
            double res = array[pos1]/array[pos2];
            return res;

        }catch(InputMismatchException ex){
            System.out.println("Se solicita un numero, no puede haber nada que no sean digitos");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No existe esa posicion en el array");
        }catch(ArithmeticException ex){
            System.out.println("No se pude dividir por cero");
        }
        return 0;

    }


    //  2.- Hacer varios metodos sumar, restar, multiplicar y dividir, que reciben dos enteros por parametros
    // y devuyelven la operacion correspondiente con esos dos numeros.
    // Todos los métodos deben devolver una excepcion personalizada si alguno de los parámetros es negativo
    // El método dividir debe devolver una Exception (de la clase Java Exception) con mensaje personalizado, cuando
    // el divisor sea un 0


    // no hay por que lanzar las dos, con la segunda vale, pero ponemos ambas para ver que se usan ambas
    public static int sumar(int a, int b) throws NumeroNoValidoException, Exception {
        if (a < 0 || b < 0) {
            NumeroNoValidoException n = new NumeroNoValidoException("no valen numeros negativos");
            throw n;
//            throw new NumeroNoValidoException("no valen numeros negativos");
        }
        return a + b;
    }
    public static int restar(int a, int b) throws NumeroNoValidoException, Exception {
        if (a < 0 || b < 0) {
            NumeroNoValidoException n = new NumeroNoValidoException("no valen numeros negativos");
            throw n;
        }
        return a -b;
    }
    public static int multiplicar(int a, int b) throws NumeroNoValidoException, Exception {
        if (a < 0 || b < 0) {
            NumeroNoValidoException n = new NumeroNoValidoException("no valen numeros negativos");
            throw n;
        }

        return a *b;
    }
    public static double dividir(double a, double b) throws NumeroNoValidoException, Exception {
        if (a < 0 || b < 0) {
            NumeroNoValidoException n = new NumeroNoValidoException("no valen numeros negativos");
            throw n;
        }
        if ( b == 0) {
            Exception e = new Exception("El dividos no puede ser 0");
            throw e;
        }
        return a /b;
    }



}


class NumeroNoValidoException extends Exception {
    public NumeroNoValidoException(String mensaje) {
        super(mensaje);
    }
}
