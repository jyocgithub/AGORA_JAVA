package stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerXmlConSTAX {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            leerXMLSTAX("libros.xml"); // Lee en STAX
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // Método para leer XML usando STAX
    public static void leerXMLSTAX(String Fichero) throws Exception {

        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader maquinaDeLeerEtiquetas = xmlif.createXMLStreamReader(new FileInputStream(Fichero));

        String nombreEtiqueta;
        int tipoEtiqueta;

        String autorApellido ;
        String autorNombre ;

        System.out.println("------------ COMIENZO LEER STAX --------------");

        while (maquinaDeLeerEtiquetas.hasNext()) {

            tipoEtiqueta = maquinaDeLeerEtiquetas.next();

            switch (tipoEtiqueta) {

                case XMLEvent.START_ELEMENT:

                    nombreEtiqueta = maquinaDeLeerEtiquetas.getLocalName();

                    if (nombreEtiqueta.equals("libro")) {
                        System.out.println("\nElemento: libro");
                        System.out.println("Año :  " + maquinaDeLeerEtiquetas.getAttributeValue(0));
                    }

                    if (nombreEtiqueta.equals("titulo")) {
                        System.out.println("Título :  " + maquinaDeLeerEtiquetas.getElementText());
                    }

                    if (nombreEtiqueta.equals("apellido")) {
                        System.out.println("Autor : Apellido " + maquinaDeLeerEtiquetas.getElementText());
                    }

                    if (nombreEtiqueta.equals("nombre")) {
                        System.out.println("Autor : Nombre " + maquinaDeLeerEtiquetas.getElementText());
                    }

                    if (nombreEtiqueta.equals("editorial")) {
                        System.out.println("Editorial :  " + maquinaDeLeerEtiquetas.getElementText());
                    }

                    if (nombreEtiqueta.equals("precio")) {
                        System.out.println("Precio :  " + maquinaDeLeerEtiquetas.getElementText());
                    }

                    break;

                case XMLEvent.END_DOCUMENT:
                    System.out.println("\n------------ FIN LEER STAX --------------");
                    break;
            }

        }

    }


}

