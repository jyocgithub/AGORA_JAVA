import java.io.*;

import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppProperties {

    public static void main(String[] args) {

        new AppProperties().leerPropertiesDeFichero("acceso_basededatos.properties");
        new AppProperties().leerPropertiesDeFichero("acceso_basededatos_properties.xml");

        new AppProperties().guardarProperties("acceso_remoto.properties", false);

    }

    /**
     * ESTE METODO EXPLICA COMO ACCEDER A FICHEROS DE PROPIEDADES DESDE JAVA
     * HEMOS ELEGIDO DE EJEMPLO UN FICHERO CON PROPIEDADES DE ACCESO A UNA BBDD
     * EL FICHERO PUEDE SER DE DOS TIPOS
     * de TEXTO, con extension .PROPERTIES
     * de XML, con extension .XML
     * ESTOS SON LOS CONTENIDOS DE AMBOS FICHEROS:
     * --------------------------------------------- acceso_basededatos.properties
     * URL=jdbc:mysql://localhost/
     * BASEDEDATOS=mibasedatos
     * USUARIO=root
     * PASSWORD=12345
     * OPCIONES=useSSL=false
     * --------------------------------------------- acceso_basededatos_properties.xml
     * <?xml version="1.0" encoding="utf-8" ?>
     * <!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
     * <properties>
     * <entry key="URL">jdbc:mysql://localhost/</entry>
     * <entry key="BASEDEDATOS">mibasedatos</entry>
     * <entry key="USUARIO">root</entry>
     * <entry key="PASSWORD">12345</entry>
     * <entry key="OPCIONES">useSSL=false</entry>
     * </properties>
     * -----------------------------------------------------------------------------
     *
     * @param nombrefichero
     */

    public void leerPropertiesDeFichero(String nombrefichero) {

        Properties properties = new Properties();
        File file = new File(nombrefichero);

        if (file.exists()) {

            try {
                if (nombrefichero.toLowerCase().endsWith("properties")) {
                    properties.load(new FileInputStream(file));
                } else if (nombrefichero.toLowerCase().endsWith("xml")) {
                    properties.loadFromXML(new FileInputStream(file));
                } else {
                    System.out.println("Fichero de formato no reconocido, debe acabar en .properties o .xml");
                    return;
                }


                // se pide una propiedad por su nombre y se declara ademas un valor por defecto
                String url = properties.getProperty("URL", "localhost");
                String basededatos = properties.getProperty("BASEDEDATOS", "");
                String usuario = properties.getProperty("USUARIO", "root");
                String clave = properties.getProperty("PASSWORD", "");
                String opciones = properties.getProperty("OPCIONES", "");


                System.out.println(url + ", " + basededatos + "," + usuario + ", " + url + ", " + clave + ", " + opciones);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Fichero de propiedades inexistente");
        }


        // las propiedades son un MAP, con lo que podemos recorrerlas por sus claves y sus valores....
        // pero cuidado que el tipo base de ambos no es String, sino Object
        for(Object cla: properties.keySet()){
            String clave = cla.toString();
            Object val = properties.get(cla);
            String valor = val.toString();

            Logger.getLogger("JYOC").log(Level.INFO, clave + " - " + valor);
        }


    }

    /**
     * ESTE METODO EXPLICA COMO ESCRIBIR EN UN FICHERO DE PROPIEDADES DESDE JAVA
     * HEMOS ELEGIDO DE EJEMPLO UN FICHERO CON PROPIEDADES DE ACCESO REMOTO
     * Si el segundo parámetro es TRUE  AÑADE AL FINAL; NO BORRA EL FICHERO SI EXISTIA; AÑADE AL FINAL DEL FICHERO EXISTENTE
     * Si el segundo parámetro es FALSE BORRA EL FICHERO SI EXISTIA Y ESCRIBE DESDE EL PRINCIPIO
     *
     * @param nombrefichero
     * @param añadiralfinal
     */
    public void guardarProperties(String nombrefichero, boolean añadiralfinal) {


        Properties prop = new Properties();
        // abrimos en este caso el fichero con un try-with_resources
        try (OutputStream fos = new FileOutputStream(nombrefichero, añadiralfinal)) {

            // creamos las claves y valores deseados
            prop.setProperty("ip", "localhost");
            prop.setProperty("puerto", "3443");
            prop.setProperty("tiempoespera", "12");

            prop.store(fos,"Propiedades de acceso remoto");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    public void leerPropertiesDeFichero_Properties() {
//
//        Properties properties = new Properties();
//        File file = new File("acceso_basededatos.properties");
//
//        if (file.exists()) {
//
//            try {
//                properties.load(new FileInputStream(new File("acceso_basededatos.properties")));
//
//                // se pide una propiedad por su nombre y se declara ademas un valor por defecto
//                String url = properties.getProperty("URL", "localhost");
//                String basededatos = properties.getProperty("BASEDEDATOS", "");
//                String usuario = properties.getProperty("USUARIO", "root");
//                String clave = properties.getProperty("PASSWORD", "");
//                String opciones = properties.getProperty("OPCIONES", "");
//
//
//                System.out.println(url + ", " + basededatos + "," + usuario + ", " + url + ", " + clave + ", " + opciones);
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            System.out.println("Fichero de propiedades inexistente");
//        }
//    }
//
//
//    public void leerPropertiesDeFichero_XML() {
//
//        Properties properties = new Properties();
//        File file = new File("acceso_basededatos.properties");
//
//        if (file.exists()) {
//
//            try {
//                properties.loadFromXML(new FileInputStream(new File("acceso_basededatos_properties.xml")));
//
//                // se pide una propiedad por su nombre y se declara ademas un valor por defecto
//                String url = properties.getProperty("URL", "localhost");
//                String basededatos = properties.getProperty("BASEDEDATOS", "");
//                String usuario = properties.getProperty("USUARIO", "root");
//                String clave = properties.getProperty("PASSWORD", "");
//                String opciones = properties.getProperty("OPCIONES", "");
//
//
//                System.out.println(url + ", " + basededatos + "," + usuario + ", " + url + ", " + clave + ", " + opciones);
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            System.out.println("Fichero de propiedades inexistente");
//        }
//    }

}






