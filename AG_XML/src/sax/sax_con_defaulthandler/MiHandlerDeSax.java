package sax.sax_con_defaulthandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MiHandlerDeSax  extends DefaultHandler {        // CREA EL HANDLER QUE SE USA LUEGO PARA PARSEAR EL XML
    ArrayList<Gimnasta> listaGimnastas = new ArrayList<>();
    Gimnasta unGimnasta;
    String etiquetaActual = "";

    @Override
    public void startDocument() throws SAXException { }        // esto se ejecuta al comenzar a leer el documento.
    @Override
    public void endDocument() throws SAXException { }          // esto se ejecuta al finalizar de leer el documento
    @Override
    public void startElement(String uri, String localName, String qname, Attributes attributes) throws SAXException {
        // debemos guardarnos qué etiqueta estamos leyendo en cada momento
        etiquetaActual = qname;
        // al emplezar a leer cada elemento, solo me interesan los elementos que tienen atributos
        if (qname.equalsIgnoreCase("gimnasta")) {
            unGimnasta = new Gimnasta();          	 // como es comienzo de gimnasta, creo un nuevo alumno para darle datos
            String elId = attributes.getValue("id"); // la etiqueta tiene atributo, asi que lo leo
            if (elId != null)  unGimnasta.setId(elId); // nos aseguramos que el atributo tiene valor
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // aquí entra en cuanto empieza a leerse un texto dentro de una etiqueta,
        // sabemos que etiqueta estamos leyendo, así que cogemos el texto...
        String texto = new String(ch, start, length);
        texto = texto.replaceAll("[\n\t]","").trim();  // eliminamos los caracteres raros y espacios
        // y lo asignamos al atributo del gimnasta que corresponde...
        if (etiquetaActual.equalsIgnoreCase("nombre")) {
            unGimnasta.setNombre(texto);
        }
        if (etiquetaActual.equalsIgnoreCase("id")) {
            unGimnasta.setId(texto);
        }
        if (etiquetaActual.equalsIgnoreCase("apellido")) {
            unGimnasta.setApellidos(texto);
        }
        if (etiquetaActual.equalsIgnoreCase("nota")) {
            unGimnasta.setNota(Double.parseDouble(texto));
            listaGimnastas.add(unGimnasta); // como la nota es la ultima etiqueta de un gimnasta, añadimos el alumno ya creado al arraylist
        }
        etiquetaActual = "";
    }

    @Override
    public void endElement(String uri, String localName, String name){ } // aqui entra en cuanto se lee una etiqueta de fin

    public ArrayList<Gimnasta> getListaGimnastas() {
        return listaGimnastas;
    }
}
