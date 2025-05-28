package sax.sax_con_defaulthandler;

import org.xml.sax.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.FileInputStream;
import java.io.IOException;

public class Saxtodoenuno {

    public static void main(String[] args) {

        String ficheroXML = "alumnos.xml";

        try {
            ManejadorDeSax manejadorDeSax = new ManejadorDeSax();
            // Creamos un analizador de XML con una fábrica de analizadores
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            // Añadimos nuestro handler al analizador
            xmlreader.setContentHandler(manejadorDeSax);
            // Analizamos con el analizador el xml deseado
            xmlreader.parse(new InputSource(new FileInputStream(ficheroXML)));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ManejadorDeSax extends DefaultHandler {        // CREA EL HANDLER QUE SE USA LUEGO PARA PARSEAR EL XML
    String etiquetaActual = "";

    @Override
    public void startDocument() throws SAXException {
    }        // esto se ejecuta al comenzar a leer el documento.

    @Override
    public void endDocument() throws SAXException {
    }          // esto se ejecuta al finalizar de leer el documento

    @Override
    public void startElement(String uri, String localName, String qname, Attributes attributes) throws SAXException {
        // debemos guardarnos qué etiqueta estamos leyendo en cada momento
        etiquetaActual = qname;

        for (int i = 0; i <attributes.getLength() ; i++) {
            String atributo =  attributes.getQName(i);
            String val =  attributes.getValue(i);
            System.out.println(atributo + ":" + val);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // aquí entra en cuanto empieza a leerse un texto dentro de una etiqueta,
        // sabemos que etiqueta estamos leyendo, así que cogemos el texto...
        String texto = new String(ch, start, length);
        texto = texto.replaceAll("[\n\t]", "").trim();  // eliminamos los caracteres raros y espacios
        if (!texto.isEmpty()) {
            System.out.println( etiquetaActual + ": " +  texto);
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) {
    } // aqui entra en cuanto se lee una etiqueta de fin

}