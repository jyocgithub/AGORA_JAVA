package xStrem.escribir_xml_con_xStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;


public class CrearXMLRankingATP {


    /*
     * 2. Crea un paquete ejercicio2.main y dentro una clase CrearXMLRankingATP que,
     * a partir de los datos obtenidos de un fichero de texto rankingATP.txt, y
     * utilizando XStream, genere un archivo rankingATP.xml y a continuaci�n lo
     * muestre por pantalla con DOM, para ello crea las clases necesarias en un
     * paquete ejercicio2.javabean. Crea un array con tres elementos de tipo Jugador
     * como fuente de datos.
     *
     * Crea el fichero txt con los siguientes datos:
     *
     * Rafael Nadal/Espa�ol/35/10/2985/Carlos Moy�-Espa�ol-45 Novak
     * Djokovic/Serbio/34/1/9970/Marian Vajda-Eslovaco-56 Roger
     * Federer/Suizo/40/16/2385/Severin Luthi-Suizo-45
     *
     * El fichero rankingATP.xml debe tener el siguiente aspecto:
     */


    public static void main(String[] args) {

        generaXmlConXStream();

        leerDom();

    }


    private static void generaXmlConXStream() {
        /// ESTAMOS DENTRO DEL BUFFER READER PORQUE ESTAMOS DENTRO CON LECTYURA TXT


        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("rankingATP.txt"), "UTF-8"));) {

            String linea;
            String[] listaJugadores;
            String[] listaEntrenador;

            /// creo mi obejto
            ListaDeObjetos listaObjetos = new ListaDeObjetos();
            Jugador jugador = null;//// lo pongo en null porque esta inicializado en la linea 131 donde pone jugador


            while ((linea = br.readLine()) != null) {
                // cuando no tengamos mas que leer nos delvovera un null, no comparamos lines acon lectura
                /// es la variable linea la que comparamos con null

                System.out.println(linea);

                listaJugadores = linea.split("/");
                listaEntrenador = listaJugadores[5].split("-");


                for (int i = 0; i < listaJugadores.length; i++) {

                    jugador = new Jugador(listaJugadores[0], listaJugadores[1], Integer.parseInt(listaJugadores[2]), Integer.parseInt(listaJugadores[3]),
                            Integer.parseInt(listaJugadores[4]), new Entrenador(listaEntrenador[0], listaEntrenador[1], Integer.parseInt(listaEntrenador[2])));
                }

                /// relleno mi lista
                listaObjetos.addlistaJugador(jugador);


            }


            /// aqui ya copio la clase generXMLSTREAM

            ///Crear una instancia de la clase XStream
            XStream xstream = new XStream();

            //7Las etiquetas XML se corresponden con el nombre de los atributos de la clase,
            ///pero se pueden cambiar usando el m�todo alias()

            /// MI CLASE QUE REPRESENTA MI NODO RAIZ ES DECIR MI RANKING
            xstream.alias("rankingATP", ListaDeObjetos.class);


            /// MI CLASE QUE REPRESENTA A MI PADRE
            xstream.alias("jugador", Jugador.class);


            ///Para que no aparezca el atributo lista de la clase ListaObjetos
            ///en el XML utilizamos el m�todo addImplicitCollection();
            ///"listaAlum" ser� el nombre del atributo de tipo ArrayList de la clase ListaAlumnos.

            xstream.addImplicitCollection(ListaDeObjetos.class, "listaJugadores");


            //7Para terminar, se genera el fichero objetos.xml a partir de la lista de objetos
            ////mediante el m�todo toXML(objeto, OutputStream();


            xstream.toXML(listaObjetos, new FileOutputStream("rankingATP.xml"));

            System.out.println("fichero generado ");


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    private static void leerDom() {

        try {
            //Creamos una instancia que va a ser donde fabriquemos los ficheros xml.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Creamos el procesador de XML o parser
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Con esta sentencia realizamos la lectura del fichero
            Document document = builder.parse(new File("rankingATP.xml"));

            //Con esto obtenemos el nodo raiz
            Node raiz = document.getFirstChild();
            String nomNodoRaiz = raiz.getNodeName();

            //A modo de traza mostramos el contenido del nodo raiz
            System.out.print("<" + nomNodoRaiz + ">");

            //Almacenamos en una variable todo lo que contiene el nodo raiz
            NodeList listaNodos = raiz.getChildNodes();

            gestionarNodosHijos(listaNodos);

            System.out.println("</" + raiz.getNodeName() + ">");
            System.out.println("fin archivo");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //METODO RECURSIVO PARA LEER FICHEROS XML
    private static void gestionarNodosHijos(NodeList listaNodos) {
        Node nodo;
        NodeList listaNodosHijo;

        for (int i = 0; i < listaNodos.getLength(); i++) {
            nodo = listaNodos.item(i);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                System.out.print("<" + nodo.getNodeName() + ">");
                listaNodosHijo = nodo.getChildNodes();

                gestionarNodosHijos(listaNodosHijo);

                System.out.print("</" + nodo.getNodeName() + ">");

            } else if (listaNodos.item(0).getNodeType() == Node.TEXT_NODE) {
                System.out.print(listaNodos.item(0).getNodeValue());
            }
        }
    }

}
