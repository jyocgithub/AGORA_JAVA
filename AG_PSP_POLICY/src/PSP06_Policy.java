import java.io.*;
import java.util.Scanner;

public class PSP06_Policy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.setProperty("java.security.policy", "./poderleerfichero.policy");

        System.setSecurityManager(new SecurityManager());

        boolean vale;
        String nombre;
        String fichero;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Dame tu nombre de usuario");
            nombre = sc.nextLine();
            vale = nombre.matches("^[a-z]{6}$");
            if(vale==false){
                System.out.println("Nombre noe valido, debe tener siempre 6 letras minusculas");
            }
        } while (vale == false);

        do {
            System.out.println("Dame  nombre del fichero (debe estar en ./DATOS, y no ponga el directorio aqui):");
            fichero = sc.nextLine();
            vale = fichero.matches("^[a-zA-Z0-9]{1,5}\\.[a-zA-Z]{3}$");
            if(vale==false){
                System.out.println("Nombre noe valido, debe tener maxiom 8 letras y una extension de 3");
            }
        } while (vale == false);

        File f = new File( "c:/datos"  ,  fichero);

        if (f.exists()) {

            try {
                BufferedReader lector = null;
                lector = new BufferedReader(new FileReader(f));

                System.out.println("Comienzo de lectura de fichero:");
                String linea = lector.readLine();
                while (linea != null) {

                    System.out.println(linea);

                    linea = lector.readLine();
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Error leyendo el fichero, no existe");
            } catch (IOException ex) {
                System.out.println("Error leyendo el fichero, revise los permisos");
            }

        } else {
            System.out.println("El fichero solicitado no existe");
        }

    }

}
