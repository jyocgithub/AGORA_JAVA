package comunicacion_entre_procesos;

import java.io.*;

// Este programa solo lee lineas, efectua unos calculos y devuelve un resultado
// Las lineas las lee de su entrada estandar y escribe resultados por su salida estandar
// Si se ejecuta en un IDE como Eclipse, lee normalmente de teclado (su entada estandar) y escribe en consola (su salida estandar)
// Sin embargo, si se ejecuta como hijo de otro proceso, y este apunta a sus entradas estandar y salidas estandar,
// cuando este proceso escriba lo hara EN EL OTRO PROCESO, no en la consola,
// y cuando este proceso lea lo hara DE LO QUE ENVIE EL OTRO PROCESO, no del teclado.
public class ComunicacionEntreProcesos_Hijo {
    public static void main(String[] args) {
        String linea;
        int letras = 0, palabras = 0, lineas = 0;

        try {
            // =================================================================================
            //     CREAR UN CANAL PARA LEER LO QUE SE LE ENVIE (TECLADO O PROCESO O LO QUE SEA)
            // =================================================================================
            // 1.- Creo un stream (canal) para que LEA DE LA ENTRADA ESTANDAR de mi programa,
            InputStream streamLeerDeEstandar = System.in;
            // 2.- Con el objeto stream, creo un canal y una puerta para usar sus metodos y leer datos.
            InputStreamReader canalLeerDeEstandar = new InputStreamReader(streamLeerDeEstandar);
            BufferedReader maquinaLeerDeEstandar = new BufferedReader(canalLeerDeEstandar);

            // =================================================================================
            //      LEO por la entrada estandar (TECLADO O PROCESO O LO QUE SEA)lo que se envia
            // =================================================================================
            linea = maquinaLeerDeEstandar.readLine();
            while (!linea.equals("FIN")) {

                // Incrementar contador de lineas.
                lineas++;

                // Recorro todos los caracteres de la linea y se mira si son numeros/letras
                for (int i = 0; i < linea.length(); i++) {
                    char cadaChar = linea.charAt(i);
                    if (Character.isLetter(cadaChar) || Character.isDigit(cadaChar)) {
                        // Incrementar contador de letras.
                        letras++;
                    }
                }
                // Parto la linea usando split con token " "
                // y habra entonces en la linea tantas palabras como elementos tenga el array resultante
                String[] elementos = linea.split(" ");
                palabras = palabras + elementos.length;

                // leemos nueva linea
                linea = maquinaLeerDeEstandar.readLine();
            }

            // =================================================================================
            //   Tras leer las lineas, envio resultados a su salida estandar (CONSOLA O PROCESO O LO QUE SEA)
            // =================================================================================
            System.out.println("Se han encontrado " + lineas + " líneas, que en total contienen " + palabras
                    + " palabras y " + letras + " letras.");

        } catch (Exception e) {
            // Cuando sucede algun error, tambien se envía a la salida (CONSOLA O PROCESO O LO QUE SEA)
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

    }
}
