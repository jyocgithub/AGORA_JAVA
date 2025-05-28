import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MiFileReader {

    FileReader fr = null;
    BufferedReader br = null;
    String nombreficherostring;

    public MiFileReader(String nombreficherostring) {
        this.nombreficherostring = nombreficherostring;
    }

    public boolean open() {
        File f = new File(nombreficherostring);
        if (f.exists()) {
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Fichero inexistente");
            return false;
        }
        return true;
    }

    public void close() {
        try {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String readln() {
        String linea = "";
        try {
            linea = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linea;
    }

    public List<String> readAllLines() {
        List<String> lista = new ArrayList<>();
        String linea;
        try {
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
