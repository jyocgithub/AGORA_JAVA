package leer_salida_proceso;

import java.io.*;

public class LeerSalidaProceso {

    public static void main(String[] args) throws IOException {
        leer_salida_proceso_char_a_char();
        leer_salida_proceso_por_lineas();
    }

    public static void leer_salida_proceso_char_a_char() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "SacarMensaje");
        pb.directory(new File("C:\\ejercicios\\LecturaProcesosRepaso"));
        Process p = pb.start();
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void leer_salida_proceso_por_lineas() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "SacarMensaje");
        pb.directory(new File("C:\\ejercicios\\LecturaProcesosRepaso"));
        Process p = pb.start();
        InputStreamReader isr = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String linea= "";
        while (   (linea = br.readLine()) != null) {
            System.out.print(linea);
        }
    }
}
