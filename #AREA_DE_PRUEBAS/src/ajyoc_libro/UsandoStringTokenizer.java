import java.util.StringTokenizer;

public class UsandoStringTokenizer {

    public static void main(String[] args) {

        // ---- USANDO STRING TOKENIZER SEPARADOR POR DEFECTO (ESPACIO)
        String nombre = "Pepe lopez ruiz";

        // cogete nombre y me lo das troceado dentro de algo llamado nombreTroceado
        // cada trozo se llama token
        // nombreTroceado es un objeto donde guardo los trozos de nombre
        // y el constructor de stringtokenizer lleva el string que quiero trocear (nombreTroceado)
        // La cadena la ha troceado usando como separador un espacio (" ")
        // Es lo que hace StringTokenizer por defecto
        StringTokenizer nombreTroceado = new StringTokenizer(nombre);

        // me cuenta cuantos trozos hay en nombreTroceado y me lo guarda en numeroDeTrozos
        int numeroDeTrozos = nombreTroceado.countTokens();

        // creo un array de String donde luego guardare cada trozo
        // el array tiene como tamaño en numero de trozos
        String[] arrayDeTokens = new String[numeroDeTrozos];

        // Al empezar hay un puntero que esta apuntando ANTES del primer token
        int i = 0;
        while (nombreTroceado.hasMoreTokens()) {
            // avanza el puntero hasta un nuevo token ,
            // y devuelve el token a una variable
            String untrozo = nombreTroceado.nextToken();

            // el token que acabo de sacar, lo meto en un array
            arrayDeTokens[i] = untrozo;
            i++;
        }

        // pinto el array normalmente, en orden ascendente
        for (int j = 0; j < arrayDeTokens.length; j++) {
            System.out.println(arrayDeTokens[j]);

        }

        // pinto el array hacia atras, en orden descendente
        for (int j = arrayDeTokens.length - 1; j >= 0; j--) {
            System.out.println(arrayDeTokens[j]);
        }

        // ---- USANDO STRING TOKENIZER CON UN SEPARADOR A GUSTO
        String fecha = "13-11-2017";

        // La cadena la troceo ahora usando como separador un gui0n ("- ")
        // Para ello en el constructor de StringTokenizer, ademas de la
        // cadena a trocear, le digo que caracter uso para separar
        StringTokenizer fechaTroceada = new StringTokenizer(fecha, "-");

        // me cuenta cuantos trozos hay en nombreTroceado y me lo guarda en numeroDeTrozos
        int numTrozosDefechaTroceada = fechaTroceada.countTokens();

        // creo un array de String donde luego guardare cada trozo
        // el array tiene como tamaño en numero de trozos
        String[] arrayDefecha = new String[numTrozosDefechaTroceada];

        // Al empezar hay un puntero que esta apuntando ANTES del primer token
        int k = 0;
        while (fechaTroceada.hasMoreTokens()) {
            // avanza el puntero hasta un nuevo token ,
            // y devuelve el token a una variable
            String untrozo = fechaTroceada.nextToken();

            // el token que acabo de sacar, lo meto en un array
            arrayDefecha[k] = untrozo;
            k++;
        }

        // pinto el array normalmente, en orden ascendente
        for (int j = 0; j < arrayDeTokens.length; j++) {
            System.out.println(arrayDefecha[j]);

        }

        // pinto el array hacia atras, en orden descendente
        for (int j = arrayDeTokens.length - 1; j >= 0; j--) {
            System.out.println(arrayDefecha[j]);
        }

        // ---- USANDO SPLIT CON UN SEPARADOR A GUSTO

        // CUIDADO CON SPLIT; NO PUEDO USAR COMO SEPARADOR CIERTOS CARACTERES
        // COMO POR EJEMPLO / \ $ . [ ]
        // (si se pueden usar, pero se usan algo diferente)
        String lista = "Pepe,Luis,Felix,Juan";

        // split trocea directamente una cadena y devuelve
        // ya creado un array DE STRING
        String[] arrayLista = lista.split(",");

        for (int j = 0; j < arrayLista.length; j++) {
            System.out.println(arrayLista[j]);
        }

        // --------------- SPLIT PARA CREAR ARRAY DE NUMEROS
        String numeros = "4-5-3-5-3-6";
        String[] arrayNumerosEnString = numeros.split("-");
        // Si quiero usar los elementos del array como numeros
        // como son String, hay que convertirlos

        // creo el array de int que voy a construir
        int[] arrayEnInt = new int[arrayNumerosEnString.length];
        // recorro el array de strings
        for (int j = 0; j < arrayNumerosEnString.length; j++) {
            // convierto cada elemento del array de string en un int
            // y lo meto en el nuevo array numerosEnInt
            arrayEnInt[j] = Integer.parseInt(arrayNumerosEnString[j]);
        }

        // ------------- CONVERTIR UN STRING EN UN ARRAY DE STRING
        String minombre = "Felix";
        System.out.println(minombre); // ASI PINTA SOLO EL NOMBRE
        System.out.println(minombre.length()); // DICE EL TAMAÑO DEL STRING

        String[] arrayMiNombre = new String[minombre.length()]; // CREO EL ARRAY DESTINO
        int tamanoDelArray = arrayMiNombre.length; // DICE EL TAMAÑO DEL ARRAY
        for (int j = 0; j <= tamanoDelArray - 1; j++) {
            arrayMiNombre[j] = minombre.substring(j, j + 1);
        }

        // ------------ EJERCICIO DE SUMA DE CADENAS

        String a = "5678";
        String b = "93";

        int tamanoMasPequeno;
        if (a.length() < b.length()) {
            tamanoMasPequeno = a.length();
        } else {
            tamanoMasPequeno = b.length();
        }

        int[] arrayFinal = new int[tamanoMasPequeno];

        for (int h = 0; h < tamanoMasPequeno; h++) {
            char aaa = a.charAt(h);
            char bbb = b.charAt(h);
            int suma = aaa + bbb;
            arrayFinal[h] = suma;
        }

    }

}
