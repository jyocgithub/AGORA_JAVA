
import java.util.Scanner;

public class JavierCc4 {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        boolean vale = true;
        int numPartidos = 0, numEscanos = 0;
        int nummayordevotos = 0, partidoElegido = 0, columnaElegida = 0;

        //*********************************************************
        // VERSION FINAL CORRECTA; DESCOMENTAR AL ACABAR LAS PRUEBAS
        //        do {
        //            System.out.println("Indique numero de partidos");
        //            numPartidos = entrada.nextInt();
        //            if (numPartidos > 10) {
        //                vale = false;
        //                System.out.println("No puede haber mas de 10 partidos. Repita el valor.");
        //            }
        //        } while (vale == false);
        //
        //        System.out.println("Indique numero de escaños a repartir");
        //        numEscanos = entrada.nextInt();
        //
        //        String[] nombrePartidos = new String[numPartidos];
        //        int[] totVotos = new int[numPartidos];
        //
        //        for (int i = 0; i < numPartidos; i++) {
        //            System.out.println("Indique nombre del partido " + (i+1));
        //            nombrePartidos[i] = entrada2.nextLine();
        //            System.out.println("Indique numero de votos del partido " + nombrePartidos[i]);
        //            totVotos[i] = entrada.nextInt();
        //        }
        //*********************************************************


        //*********************************************************
        // VALE SOLO PARA PRUEBAS; COMENTAR AL ACABAR
        int[] totVotos = {340000, 280000, 160000, 60000, 15000};
        String[] nombrePartidos = {"pio", "guau", "cricri", "muuu", "miau"};
        numPartidos = 5;
        numEscanos = 7;
        //*********************************************************


        int[] escanosConseguidos = new int[numPartidos];
        int[][] votostroceados = new int[numPartidos][numEscanos];

        // repartir los votos en la matriz
        for (int partido = 0; partido < numPartidos; partido++) {
            for (int c = 0; c < numEscanos; c++) {
                votostroceados[partido][c] = totVotos[partido] / (c + 1);
            }
        }

        // pintar la matriz
        System.out.println("MATRIZ DE PREPARACION DE REPARTO DE ESCAÑOS");
        for (int partido = 0; partido < numPartidos; partido++) {
            for (int c = 0; c < numEscanos; c++) {
                System.out.print(votostroceados[partido][c] + "\t");
            }
            System.out.println();
        }

        System.out.println("REPARTO DE LOS ESCAÑOS");
        // hacer un bucle para cada uno de los escaños a asignar
        for (int escano = 0; escano < numEscanos; escano++) {
            nummayordevotos = 0;
            // buscar en la matriz el partido con mas votos, y guardar en que fila y columna esta
            for (int partido = 0; partido < numPartidos; partido++) {
                for (int c = 0; c < numEscanos; c++) {
                    if (nummayordevotos < votostroceados[partido][c]) {
                        nummayordevotos = votostroceados[partido][c];
                        partidoElegido = partido;
                        columnaElegida = c;
                    }
                }
            }
            // ya recorrida la matriz, guardamos el escaño para el partido elegido
            escanosConseguidos[partidoElegido]++;

            // informamos de la eleccion
            System.out.println("El partido " + nombrePartidos[partidoElegido] + " se lleva un escaño con " + votostroceados[partidoElegido][columnaElegida]);

            // y eliminamos la celda elegida
            votostroceados[partidoElegido][columnaElegida] = 0;

        }

        // resumen final, indica cuantos escaños tiene cada partido
        System.out.println("RESULTADOS FINALES");
        for (int partido = 0; partido < numPartidos; partido++) {
            System.out.print("El partido " + nombrePartidos[partido]);
            System.out.println(" ha obtenido " + escanosConseguidos[partido] + " escaños");
        }

    }
}
