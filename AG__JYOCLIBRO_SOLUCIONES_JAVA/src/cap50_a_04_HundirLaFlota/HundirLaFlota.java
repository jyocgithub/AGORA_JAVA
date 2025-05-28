package cap50_a_04_HundirLaFlota;

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
import java.util.Scanner;

public class HundirLaFlota {
    static int numFilas = 5;
    static int numCol = 5;
    static char[][] casillas;
    static Tablero tablero;
    static int filapedida;
    static String colpedida;
    static int iColpedida, iFilaPedida;
    static char simboloVacio = ' ';
    static char simboloAgua = '~';
    static char simboloTocado = '.';
    static char simboloHundido = '#';
    static boolean pintamosLosBarcos = true;
    static boolean finalizado = false;
    static int numBarcosDeDosPiezasHorizontales = 2;
    static int numBarcosDeTresPiezasHorizontales = 2;
    static int numBarcosDeDosPiezasVerticales = 2;
    static int numBarcosDeTresPiezasVerticales = 2;
    static int numbarcos;
    static int numIntentosDeColocarUnBarco = 0;

    // *******************************************************
    public static void main(String[] args) {

        int opcion;
        do {
            System.out.println("\n\n==============");
            System.out.println("MENU PRINCIPAL");
            System.out.println("==============");
            System.out.println("1.- Elegir dimension tablero");
            System.out.println("2.- Elegir simbolos");
            System.out.println("3.- Elegir numero de barcos y disposicion");
            System.out.println("4.- Jugar partida");
            System.out.println("0.- Salir");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    elegirDimension();
                    break;
                case 2:
                    elegirSimbolos();
                    break;
                case 3:
                    elegirNumeroBarcos();
                    break;
                case 4:
                    jugar();
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
        System.out.println("FIN DE JUEGO");
    }

    // *******************************************************
    public static void elegirDimension() {
        System.out.println("Elige numero de filas:");
        numFilas = new Scanner(System.in).nextInt();
        System.out.println("Elige numero de columnas:");
        numCol = new Scanner(System.in).nextInt();
    }

    // *******************************************************
    public static void elegirSimbolos() {
        System.out.println("Escribe un simbolo para disparo en el agua:");
        String simboloAgua_enstring = new Scanner(System.in).nextLine();
        simboloAgua = simboloAgua_enstring.charAt(0);
        System.out.println("Escribe un simbolo para disparo tocado:");
        String simboloTocado_enstring = new Scanner(System.in).nextLine();
        simboloTocado = simboloTocado_enstring.charAt(0);
        System.out.println("Escribe un simbolo para disparo hundido:");
        String simboloHundido_enstring = new Scanner(System.in).nextLine();
        simboloHundido = simboloHundido_enstring.charAt(0);

    }

    // *******************************************************
    public static void elegirNumeroBarcos() {
        System.out.println("Elige cuantos barcos horizontales de dos piezas quieres colocar:");
        numBarcosDeDosPiezasHorizontales = new Scanner(System.in).nextInt();
        System.out.println("Elige cuantos barcos horizontales de tres piezas quieres colocar:");
        numBarcosDeTresPiezasHorizontales = new Scanner(System.in).nextInt();
        System.out.println("Elige cuantos barcos verticales de dos piezas quieres colocar:");
        numBarcosDeDosPiezasVerticales = new Scanner(System.in).nextInt();
        System.out.println("Elige cuantos barcos verticales de tres piezas quieres colocar:");
        numBarcosDeTresPiezasVerticales = new Scanner(System.in).nextInt();
    }


    // *******************************************************
    public static void jugar() {

        // preparar tablero y otras condiciones
        tablero = new Tablero(numFilas, numCol);
        casillas = tablero.celdas;
        rellenarTableroInicio();
        numIntentosDeColocarUnBarco = 0;
        numbarcos = 0;

        for (int i = 0; i < numBarcosDeTresPiezasHorizontales; i++) {
            if (!hayHuecoHorizontal(3)) {
                System.out.println("No hay hueco para colocar un barco horizontal de 3 posiciones. ");
                return;
            } else {

                char letradelbarco = (char) ('A' + (numbarcos));
                colocarBarcoHorizontal(casillas, 3, letradelbarco);
                numbarcos++;
            }
        }

        for (int i = 0; i < numBarcosDeTresPiezasVerticales; i++) {
            if (!hayHuecoVertical(3)) {
                System.out.println("No hay hueco para colocar un barco vertical de 3 posiciones. ");
                return;
            } else {
                char letradelbarco = (char) ('A' + (numbarcos));
                colocarBarcoVertical(casillas, 3, letradelbarco);
                numbarcos++;
            }
        }


        for (int i = 0; i < numBarcosDeDosPiezasHorizontales; i++) {
            if (!hayHuecoHorizontal(2)) {
                System.out.println("No hay hueco para colocar un barco horizontal de 2 posiciones. ");
                return;
            } else {
                char letradelbarco = (char) ('A' + (numbarcos));
                colocarBarcoHorizontal(casillas, 2, letradelbarco);
                numbarcos++;
            }
        }

        for (int i = 0; i < numBarcosDeDosPiezasVerticales; i++) {
            if (!hayHuecoVertical(2)) {
                System.out.println("No hay hueco para colocar un barco vertical de 2 posiciones. ");
                return;
            } else {
                char letradelbarco = (char) ('A' + (numbarcos));
                colocarBarcoVertical(casillas, 2, letradelbarco);
                numbarcos++;
            }
        }
        // jugamos una partida
        finalizado = false;
        do {
            // pintamos el tablero
            pintarTablero();
            boolean valecomonumero = false;
            do {
                System.out.println("Elige una fila para disparo:");
                String filastring = new Scanner(System.in).nextLine();
                valecomonumero = esUnNumero(filastring);
                if (!valecomonumero) {
                    System.out.println("No se ha escrito un valor numerico. Pruebe otra vez.");
                } else {
                    filapedida = Integer.parseInt(filastring);
                }
            } while (!valecomonumero);

            System.out.println("Elige una columna para disparo:");
            colpedida = new Scanner(System.in).nextLine();
            // convertir a un numero de columna valido la primera letra introducida como columna
            iColpedida = (colpedida.charAt(0)) - 65;
            // la letra la podemos escribir en minusculas o mayusculas, aqui la cambiamos a mayusculas
            if (iColpedida >= 32) {
                iColpedida -= 32;
            }
            iFilaPedida = filapedida - 1;


            if (iFilaPedida >= 0 && iFilaPedida < numFilas && iColpedida >= 0 && iColpedida < numCol) {
                tablero.numIntentos++;
                // vemos si hemos acertado en barco
                if (casillas[iFilaPedida][iColpedida] >= 'A' && casillas[iFilaPedida][iColpedida] <= 'Z') {
                    System.out.println("!! ACERTASTE !!");

                    // mirar si esta el barco hundido
                    char trozoPillado = casillas[iFilaPedida][iColpedida];
                    casillas[iFilaPedida][iColpedida] = simboloTocado;
                    boolean hayMasDeEseBarco = false;
                    for (int f = 0; f < numFilas; f++) {
                        for (int c = 0; c < numCol; c++) {
                            if (casillas[f][c] == trozoPillado) {
                                hayMasDeEseBarco = true;
                            }
                        }
                    }
                    if (hayMasDeEseBarco) {
                        System.out.println("Sigue probando, aun queda algo de ese barco por ahi...");
                        casillas[iFilaPedida][iColpedida] = simboloTocado;
                    } else {
                        System.out.println("!!!! HUNDIDOOOOO !!!!");
                        tablero.numHundidos++;
                        // quitar las marcas de tocado y poner hundido
                        quitarTocados();
                    }

                    // mirar si se ha acabado ya el juego
                    if (tablero.numHundidos == numbarcos) {
                        System.out.println("FLOTA HUNDIDA!!!!");
                        finalizado = true;
                    }
                } else if (casillas[iFilaPedida][iColpedida] ==  simboloTocado || casillas[iFilaPedida][iColpedida] ==  simboloHundido) {  // estaba ya tocado o hundido
                    System.out.println("¡Ese disparo ya dio en el blanco hace tiempo... ! Prueba otra vez");
                } else {  // es agua
                    System.out.println("Agua... lo siento, prueba otra vez");
                    tablero.numAguas++;
                    casillas[iFilaPedida][iColpedida] = simboloAgua;
                }
            } else { // es fuera de coordenadas
                System.out.println("Disparaste fuera del tablero. Prueba otra vez.");
            }
        } while (!finalizado);
    }

    // *******************************************************
    public static void quitarTocados() {
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                if (casillas[f][c] == simboloTocado) {
                    casillas[f][c] = simboloHundido;
                }
            }
        }
    }

    // *******************************************************
    public static void colocarBarcoHorizontal(char[][] casillas, int tamano, char id) {
        int fprueba = 0;
        int cprueba = 0;

        // vemos si hay sitio libre
        boolean estaOcupada;
        do {
            estaOcupada = false;
            fprueba = numAzar(0, numFilas);
            cprueba = numAzar(0, numCol - tamano + 1);
            for (int j = 0; j < tamano; j++) {
                if (casillas[fprueba][cprueba + j] != simboloVacio) {
                    estaOcupada = true;
                }
            }
            numIntentosDeColocarUnBarco++;
        } while (estaOcupada);

        // colocamos el barco ahora que se sabe que esta libre el sitio
        for (int j = 0; j < tamano; j++) {
            casillas[fprueba][cprueba + j] = id;
        }
    }

    // *******************************************************
    public static void colocarBarcoVertical(char[][] casillas, int tamano, char id) {
        int fprueba = 0;
        int cprueba = 0;
        // vemos si hay sitio libre
        boolean estaOcupada;
        do {
            estaOcupada = false;
            fprueba = numAzar(0, numFilas - tamano + 1);
            cprueba = numAzar(0, numCol);
            for (int j = 0; j < tamano; j++) {
                if (casillas[fprueba + j][cprueba] != simboloVacio) {
                    estaOcupada = true;
                }
            }
            numIntentosDeColocarUnBarco++;
            if (numIntentosDeColocarUnBarco % 1000000 == 0) {

                System.out.println("Parece que me cuesta encontrar hueco para meter los barcos....");
                System.out.println(numIntentosDeColocarUnBarco + "-" + numbarcos);
                pintarTablero();
            }
        } while (estaOcupada);

        // colocamos el barco ahora que se sabe que esta libre el sitio
        for (int j = 0; j < tamano; j++) {
            casillas[fprueba + j][cprueba] = id;
        }
    }

    // *******************************************************
    public static int numAzar(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    // *******************************************************
    public static void pintarTablero() {

        // escribir cabecera
        System.out.print("    ");
        for (int i = 0; i < numCol; i++) {
            char letraTablero = (char) ('A' + (i));
            System.out.print(letraTablero + "   ");
        }
        System.out.println();
        // escribir linea superior
        System.out.print("  -");
        for (int i = 0; i < numCol; i++) {
            System.out.print("----");
        }
        System.out.println("  ");

        // escribir cada fila del tablero
        for (int f = 0; f < numFilas; f++) {
            System.out.print((f + 1) + " ");
            for (int c = 0; c < numCol; c++) {
                if (pintamosLosBarcos) {
                    System.out.print("| " + casillas[f][c] + " ");
                } else {
                    System.out.print("| ");
                    if (casillas[f][c] >= 65 && casillas[f][c] < 91) {
                        System.out.print(" ");
                    } else {
                        System.out.print(casillas[f][c]);
                    }
                    System.out.print(" ");

                }

            }
            System.out.print("|\n");
        }
        // escribir linea inferior
        System.out.print("  -");
        for (int i = 0; i < numCol; i++) {
            System.out.print("----");
        }
        // escribir informacion final
        System.out.println("");
        System.out.println("Numero de intentos   : " + tablero.numIntentos);
        System.out.println("Numero de fallos     : " + tablero.numAguas);
        System.out.println("Barcos hundidos      : " + tablero.numHundidos);
        System.out.println("Barcos aun escondidos: " + (numbarcos - tablero.numHundidos));
    }

    // *******************************************************
    public static void rellenarTableroInicio() {
        // rellenamos la matriz inicialmente con el simbolo que sea
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                casillas[f][c] = simboloVacio;
            }
        }
    }


    // *******************************************************
    public static boolean hayHuecoHorizontal(int tamano) {
        boolean resultado = false;
        int tot = 0;
        int mayorHueco = 0;
        for (int f = 0; f < numFilas; f++) {
            tot = 0;
            for (int c = 0; c < numCol; c++) {
                if (casillas[f][c] == simboloVacio) {
                    tot++;
                    if (tot > mayorHueco) {
                        mayorHueco = tot;
                    }
                } else {
                    tot = 0;
                }
            }
        }
        if (mayorHueco >= tamano) {
            resultado = true;
        }
        return resultado;
    }

    // *******************************************************
    public static boolean hayHuecoVertical(int tamano) {
        boolean resultado = false;
        int tot = 0;
        int mayorHueco = 0;
        for (int c = 0; c < numCol; c++) {
            tot = 0;
            for (int f = 0; f < numFilas; f++) {
                if (casillas[f][c] == simboloVacio) {
                    tot++;
                    if (tot > mayorHueco) {
                        mayorHueco = tot;
                    }
                } else {
                    tot = 0;
                }
            }
        }
        if (mayorHueco >= tamano) {
            resultado = true;
        }
        return resultado;
    }

    // *******************************************************
    // *********************************************************** esUnNumero
    static public boolean esUnNumero(String strDato) {
        boolean res = true;
        for (int i = 0; i < strDato.length() && res; i++) {
            if (!(Character.isDigit(strDato.charAt(i)))) {
                res = false;
            }
        }
        return res;
    }

}




