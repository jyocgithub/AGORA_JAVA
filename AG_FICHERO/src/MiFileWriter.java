import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MiFileWriter {

    FileWriter fw = null;
    BufferedWriter bw = null;
    boolean anadiendo;
    String nombreficherostring;

    public MiFileWriter(String nombreficherostring, boolean anadiendo) {
        this.nombreficherostring = nombreficherostring;
        this.anadiendo = anadiendo;
    }

    public boolean open() {
        try {
            fw = new FileWriter(nombreficherostring, anadiendo);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void close() {
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean write(String linea) {
        try {
            bw.write(linea);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean writeln(String linea) {
        try {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
