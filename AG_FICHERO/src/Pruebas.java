
import java.util.List;

public class Pruebas {

    public static void main(String[] args) {
        MiFileWriter mfw = new MiFileWriter("ejemplo.txt", false);
        if (mfw.open()) {
            mfw.writeln("cosas");
            mfw.writeln("mias");
            mfw.writeln("en");
            mfw.writeln("cada linea");
            mfw.close();
        }


        MiFileReader mfr = new MiFileReader("ejemplo.txt");
        if (mfr.open()) {
            List<String> lista = mfr.readAllLines();
            for (String s : lista) {
                System.out.println(s);
            }
            mfr.close();
        }

    }
}