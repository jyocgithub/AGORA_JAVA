package sax.sax_con_XMLStreamReader;

import dom.Alumno;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class SaxConXMLStreamReader {

    public static void main(String[] args) {
        new SaxConXMLStreamReader();
    }

    public SaxConXMLStreamReader() {
        try {
            leeXMLSAX();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void leeXMLSAX() throws FileNotFoundException, XMLStreamException {
        ArrayList<Alumno> listaalumnos = new ArrayList<>();

        // Lo primero es leer el archivo y crear el objeto para manejarlo
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLStreamReader xml = xmlif.createXMLStreamReader(new FileReader("./xml/alumnos.xml"));

        String nombreEtiqueta = "";
        int evento;
        Alumno alumnoactual = null;

        // Una vez tengo el objeto que maneja los eventos de SAX empiezo a leer el documento XML
        while (xml.hasNext()) {
            evento = xml.next();
            // analizamos etiquetas de apertura
            if (evento == XMLEvent.START_ELEMENT) {
                /* Cargo el nombre de cada elemento para hacer lo que toque con cada uno */
                nombreEtiqueta = xml.getLocalName();
                switch (nombreEtiqueta) {
                    case "alumnos":
                        System.out.println("Elemento Raiz: " + nombreEtiqueta);
                        System.out.println("----------------------------------");
                        break;
                    case "alumno":
                        // creamos un nuevo alumno para meter ahi sus valores segun se lean
                        alumnoactual = new Alumno();
                        // como aqui hay atributos XML, los leemos y metemos en el objeto Alumno
                        alumnoactual.setEdad( Integer.parseInt(xml.getAttributeValue(0)));
                        alumnoactual.setNacionalidad( xml.getAttributeValue(1));
                        break;
                    case "nombre":
                        alumnoactual.setNombre(xml.getElementText());
                        break;
                    case "apellidos":
                        alumnoactual.setApellido(xml.getElementText());
                        break;
                    case "curso":
                        alumnoactual.setCurso(xml.getElementText());
                        break;
                    case "sexo":
                        char sex = xml.getElementText().charAt(0);
                        alumnoactual.setSexo(sex);
                        break;
                }
            }
            // analizamos etiquetas de cierre
            if (evento == XMLEvent.END_ELEMENT) {
                nombreEtiqueta = xml.getLocalName();
                switch (nombreEtiqueta) {
                    case "alumno":
                        // sabemos que ha acabado un alumno, asi que el que estamos leyendo
                        // lo metemos en la lista
                        listaalumnos.add(alumnoactual);
                        break;
                }
            }
        }

        for(Alumno cadaAlumno : listaalumnos){
            System.out.println(cadaAlumno);
        }

    }
}

//<Alumnos>
    //<alumno edad="20" nacionalidad="Española">
        //<nombre>Paco</nombre>
        //<apellidos>Gomez</apellidos>
        //<curso>Musica</curso>
        //<sexo>M</sexo>
    //</alumno>
    //<alumno edad="30" nacionalidad="Española">
        //<nombre>Maria</nombre>
        //<apellidos>Castillo</apellidos>
        //<curso>Pintura</curso>
        //<sexo>F</sexo>
    //</alumno>
    //<alumno edad="25" nacionalidad="Española">
        //<nombre>Alejandro</nombre>
        //<apellidos>Martin</apellidos>
        //<curso>Ajedrez</curso>
        //<sexo>M</sexo>
    //</alumno>
    //<alumno edad="50" nacionalidad="Española">
        //<nombre>Lisa</nombre>
        //<apellidos>Simpson</apellidos>
        //<curso>Musica</curso>
        //<sexo>F</sexo>
    //</alumno>
//</Alumnos>