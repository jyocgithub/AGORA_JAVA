package soluciones_ejercicicios.ims.jyoc.OLD.cap15;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JyocCap15 {

    public static void main(String[] args) {

//        System.out.println(numerotriangular(5));
//        File f = new File ("/Users/iniaski/Downloads/pruebasdeC2");
//        listarDirectorio(f);
//                System.out.println(cuantosDigitos(12345, 0));
//                
//                
//        ArrayList<Integer> lista = new ArrayList<>();
//        dondeEstaElTrozo("cococococvocvco" , "co", 0, lista);
//        System.out.println(lista);


//        doblarNumeros(new int[] {1,3,5,7}, 0);
//        doblarNumeros2("1,2,3,4", 0);
//        System.out.println(doblarNumeros3(new int[] {1,3,5,7}, 0, ""));

        List<Integer> numerosList = new ArrayList<>();
        numerosList.add(2);
        numerosList.add(9);
        numerosList.add(1);
        numerosList.add(7);
        System.out.println(mayorDeList(numerosList, 0, 0));

    }


    // Ejercicio 12.0 (esta en el propio temario)
    // factorial recursivo,  multiplica los valores menores de X por si mismos
    // (asumimos que X es siempre mayor que 0)
    // En modo no recursivo, seria algo asi:
    // static public int factorialIterativo(int X) {
    //   int res = 1;
    //    for (int i = 2; i <= X; i++) {
    //        res= res * i;
    //    }
    //    return res;
    // }
    //
    // Y con recursividad: 
    static public int factorialrecursivo(int X) {
        System.out.println("Paso con valor X=" + X);

        if (X == 1) {
            return X;
        }
        return X * factorialrecursivo(X - 1);
    }


    // Ejercicio 12.1
    // multiplicacion recursiva, suma b veces el valor de a
    // En modo no recursivo, seria algo asi:
    // static public int multiplicacionporsumas(int a, int b) {
    //    int res = 0;
    //    while (b > 0) {
    //        res = res + a;
    //        b--;
    //    }
    //    return res;
    // }
    //
    // Y con recursividad: 
    static public int multiplicacionrecursiva(int a, int b) {
        System.out.println("Paso con valor b=" + b);

        if (b == 1) {
            return a;
        } else {
            return a + multiplicacionrecursiva(a, b - 1);
        }
    }

    // Ejercicio 12.2
    // Listar los contenido de un directorio, si este contiene directorios
    // listar tambien su contenido, y si contiene mas directorios, igualmente
    // de modo recursivo
    private static void listarDirectorio(File directorioATratar) {
        for (File elementoEnDirectorio : directorioATratar.listFiles()) {
            if (elementoEnDirectorio.isFile()) {
                System.out.println(elementoEnDirectorio.getName());
            } else if (elementoEnDirectorio.isDirectory()) {
                listarDirectorio(elementoEnDirectorio);
            }
        }
    }

    // Ejercicio 12.3
    // numerotriangular recursivo,  multiplica los valores menores de X por si mismos
    // (asumimos que X es siempre mayor que 0)
    static public int numerotriangular(int X) {
        System.out.println("Paso con valor X=" + X);

        if (X == 1) {
            return X;
        }
        return X + numerotriangular(X - 1);
    }

    // Ejercicio 12.4
    // método recursivo que escribe al revés la cadena que se le pasa como parámetro.
    public static void escribeAlReves(String texto, int indice) {
        if (indice == texto.length()) {
            return;
        }
        System.out.println(texto.charAt(texto.length() - indice - 1));
        indice++;
        escribeAlReves(texto, indice);
    }

    // Ejercicio 12.5
    // método recursivo que recibae un número positivo n y devuelva la cantidad de dígitos que tiene.
    public static int cuantosDigitos(int numero, int contador) {
        contador++;
        if (numero < 10) {
            return contador;
        }
        numero = (int) numero / 10;
        return cuantosDigitos(numero, contador);

    }


    // Ejercicio 12.6
    // Escribir un método recursivo que reciba como parámetros, al menos, dos strings, 
    // y devuelva una lista con las posiciones en donde se encuentra el segundo dentro del primero. 
    // Ejemplo: Al ejecutar el metodo con esta llamada:   
    // dondeEsta(“Un coco y coco sin Coco", "co")
    // da como salida : [3, 5, 10, 12, 21]
    public static List dondeEstaElTrozo(String texto, String trozo, int indice, List lista) {

        if (indice == texto.length()) {
            return lista;
        }
        int desde = indice;
        int hasta = indice + trozo.length();
        if (texto.substring(desde, hasta).equals(trozo)) {
            lista.add(indice);
        }
        System.out.println(texto.charAt(texto.length() - indice - 1));
        indice++;
        return dondeEstaElTrozo(texto, trozo, indice, lista);
    }


    // Ejercicio 12.7
    // Escribir un método recursivo para doblar los elementos de una lista dos veces. 
    // Por ejemplo,
    //    doblar (“1, 3, 3, 7”) da como resultado “1, 1, 3, 3, 3, 3, 7, 7”
    // (se puede usar un array como dato de entrada en vez de una String)

    // Version 1, que recibe un String
    public static void doblarNumeros(int[] numeros, int indice) {
        if (indice == numeros.length) {
            return;
        }
        System.out.print("\t" + numeros[indice] + "\t" + numeros[indice]);
        indice++;
        doblarNumeros(numeros, indice);
    }

    // Version 2, que recibe un String
    public static void doblarNumeros2(String numeros, int indice) {
        String[] unarray = numeros.split(",");
        if (indice == unarray.length) {
            return;
        }
        System.out.print("\t" + unarray[indice] + "\t" + unarray[indice]);
        indice++;
        doblarNumeros2(numeros, indice);
    }

    // Version 3, que devuelve un String (recibiendo un array)
    public static String doblarNumeros3(int[] numeros, int indice, String cad) {
        if (indice == numeros.length) {
            return cad;
        }
        cad = cad + "\t" + numeros[indice] + "\t" + numeros[indice];
        indice++;
        return doblarNumeros3(numeros, indice, cad);
    }

    public static int mayorDeList(List<Integer> numeros, int indice, int mayor) {
        if (indice == numeros.size()) {
            return mayor;
        }
        if (numeros.get(indice) > mayor) {
            mayor = numeros.get(indice);
        }
        indice++;
        return mayorDeList(numeros, indice, mayor);
    }

    // Ejercicio 12.8 
    // Escribir un método recursivo  que encuentre el elemento mayor de un ArrayList.


    // Ejercicio 12.9
    // Calcular secuencia fibonacci, estos son ejemplos:
    // numero :         0	1	2	3	4	5	6	7	8	9	10	11	…
    // Fibonacci:	0	1	1	2	3	5	8	13	21	34	55	89	…
    static public int fibonacci(int X) {
        System.out.println("Paso con valor X=" + X);
        if (X <= 1) {
            return X;
        } else {

            return fibonacci(X - 1) + fibonacci(X - 2);
        }
    }


}
