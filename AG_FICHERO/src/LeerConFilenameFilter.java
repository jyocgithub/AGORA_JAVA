import java.io.File;
import java.io.FilenameFilter;

public class LeerConFilenameFilter {

    public static void main(String[] args) {
        File fi = new File(".");
        leerDirectorio(fi);
    }

    public static void leerDirectorio(File origen) {
        if (origen.exists()) {
            if (origen.isDirectory()) {
                System.out.println("-------> ANALIZAMOS EL DIR : " + origen.getName());
                // Primero usamos FilanemaFilter para buscar lo que necesitamos
                leerConFilenameFilter(origen);

                // ahora buscamos los directorios que haya para meternos dentro de ellos
                File[] elementos = origen.listFiles();
                for (int i = 0; i < elementos.length; i++) {
                    if (elementos[i].isDirectory()) {
                        // si es un direcorio, lo leemos recursivamente
                        leerDirectorio(elementos[i]);
                    }
                }
            }
        }
    }

    public static void leerConFilenameFilter(File directorio){
        // FilenameFilter filtra los ficheros y directorios a parti de una direccion dada
        // sacando los nombres solo de ciertos ficheros que cumplan cierta condicion
        // los nombres de los ficheros van a parar a un array de Strings
        String[] listaficheros = directorio.list(new FilenameFilter() {
            @Override
            // este método usa en su return la condicion de filtrado que deseamos
            public boolean accept(File dir, String name) {
//                return name.length() > 1;  // en este ejemplo, solo sacamos los ficheros cuyo nombre tenga mas de una letra
                return name.toLowerCase().contains("3"); // en este ejemplo, solo sacamos los ficheros cuyo nombre contengo un 3
            }
        });

        // mostramos los ficheros seleccionados
        for (int i = 0; i < listaficheros.length; i++) {
            System.out.println(listaficheros[i]);
        }
    }

}
