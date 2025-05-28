package sax.sax_con_defaulthandler;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PruebaSAX {
    public static void main(String[] args) {

        try {
            MiHandlerDeSax miHandler = new MiHandlerDeSax();
            // Creamos un analizador de XML con una fábrica de analizadores
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            // Añadimos nuestro handler al analizador
            xmlreader.setContentHandler(miHandler);
            // Analizamos con el analizador el xml deseado
            xmlreader.parse(new InputSource(new FileInputStream("xml/gimnastas.xml")));

            // Probamos que el analizador ha leido el arraylist correctamente
            ArrayList<Gimnasta> listaGimnastas = miHandler.getListaGimnastas();
            for (Gimnasta a : listaGimnastas) {
                System.out.println(a);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}