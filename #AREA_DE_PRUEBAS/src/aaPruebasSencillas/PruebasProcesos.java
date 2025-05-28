package aaPruebasSencillas;

import java.io.*;

public class PruebasProcesos {

    public static void main(String[] args) throws IOException {

        OutputStreamWriter osr = new OutputStreamWriter(System.out);
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("JAJAJAJ");
        pw.flush();
        try {
            ProcessBuilder maquina = new ProcessBuilder("CMD", "/c", "java", "-jar", "C:\\Users\\Rizti\\Desktop\\Hijo3.jar");
            Process elprocesolanzado = maquina.start();
            //	int res = elprocesolanzado.waitFor();

            OutputStream os = elprocesolanzado.getOutputStream();
            OutputStreamWriter osr3 = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osr3);

            InputStream is = elprocesolanzado.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            bw.write("cascaras");


            String resp = br.readLine();
            System.out.println("la resopuesta es: " + resp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
        }

//        new PruebasCLases();
    }

    public PruebasProcesos() {

    }


}














