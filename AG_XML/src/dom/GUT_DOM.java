package dom;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class GUT_DOM {


    public static void main(String[] args) {

        ArrayList<Alumno> alumnos = new ArrayList<>();
        Alumno alumno1 = new Alumno("Paco", "Gomez", "Musica", 20, 'M');
        alumnos.add(alumno1);
        Alumno alumno2 = new Alumno("Maria", "Castillo", "Pintura", 30, 'F');
        alumnos.add(alumno2);
        Alumno alumno3 = new Alumno("Alejandro", "Martin", "Ajedrez", 25, 'M');
        alumnos.add(alumno3);
        Alumno alumno4 = new Alumno("Lisa", "Simpson", "Musica", 50, 'F');
        alumnos.add(alumno4);


        // CREAMOS EL XML A PARTIR DEL ARRAYLIST
        try {
            crearFicheroXML(alumnos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // CREAMOS EL ARRAYLIST A PARTIR DE UN FICHERO XML
        try {
            ArrayList<Alumno> alumnosleidos = leerFicheroXML();
            for (Alumno al : alumnosleidos) {
                System.out.println(al);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // MODIFICAMOS UN ELEMENTO DE UN FICHERO XMLYA EXISTENTE
        // en nuestro ejemplo, se modifica el curso de algun alumno con un nuevo curso
        try {
            modificarFicheroXML("Alejandro", "Bricolaje");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // ***********************************************************************
    // *********************    CREAR XML   **********************************
    // ***********************************************************************



    public static void crearFicheroXML(ArrayList<Alumno> alumnos) throws Exception {
        // ------------------------------------------ CREAMOS Y RELLENAMOS EL OBJETO DOCUMENT
        String nombreDelElementoRaiz = "Alumnos";
        String nombreFicheroXml = "xml/alumnos.xml";

        // - Asi se crea el objeto document vacio, Y  le añade el elemento raiz (el padre unico)
        Document miDocumentDom = crearDocumentVacio(nombreDelElementoRaiz);

        // Necesito un objeto que me represente el nodo raiz (para luego meter dentro los demas elementos)
        // Esto me da el elemento raiz , y me lo guardo en elementoRaiz
        Element elementoRaiz = miDocumentDom.getDocumentElement();

        // vamos a ir metiendo uno a uno los alumnos en el document
        for (Alumno unalumno : alumnos) {  // recorro el array de alumnos

            // Creamos una etiqueta llamada <alumno> que es donde vamos a meter todos sus hijos
            Element elementoAlumno = miDocumentDom.createElement("alumno");

            // -- añadimos los elementos hijos de cada alumno. Cuando se crea un elemento me lo puedo guardar en un
            // objeto Element, o no guardarlo, como prefiera. <nombre> si me lo guardo, por que luego le voy a poner un atributo
            Element elementonombre = crearElemento("nombre",  // nombre del elemento que se va a crear
                    unalumno.getNombre(),                     // contenido de texto del nuevo elemento
                    elementoAlumno,                           // elemento padre del nuevo elemento
                    miDocumentDom);                           // objeto document que estamos usando
            crearElemento("apellidos", unalumno.getApellido(), elementoAlumno, miDocumentDom);
            crearElemento("curso", unalumno.getCurso(), elementoAlumno, miDocumentDom);
            crearElemento("sexo", unalumno.getSexo() + "", elementoAlumno, miDocumentDom);

            // -- añadimos los atributos
            crearAtributo("edad",                  // nombre del atributo
                    unalumno.getEdad() + "",         // contenido del atributo
                    elementoAlumno);         // elemento donde se añade el atributo
            crearAtributo("nacionalidad", "española", elementonombre);

            // metemos finalmente el nuevo elemento alumno (ya relleno) dentro del elemento raiz
            elementoRaiz.appendChild(elementoAlumno);
        }

        // ------------------------------------------- ESCRIBIR EN EL FICHERO XML EL CONTENIDO DEL DOCUMENT
        // Toma el documento creado y lo meto en un objeto DOMSource (que indica que vamos a construir a partir un document de DOM)
        crearXMLDesdeDocument(miDocumentDom, nombreFicheroXml);

        System.out.println("Fin de la conversion");
    }


    // ***********************************************************************
    // *********************    LEER XML    **********************************
    // ***********************************************************************
    public static ArrayList<Alumno> leerFicheroXML() throws Exception {
        Element elementoAlumno;
        String nombre, apellido, curso;
        int edad;
        char sexo;
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        String nombreFicheroXml = "xml/alumnos.xml";
        String nombreDeCadaElemento = "alumno";

        // leemos el XML y lo metemos en un objeto Document
        Document miDocDom = crearDocumentDesdeXML(nombreFicheroXml);

        // cogemos una rererencia al nodo raiz ya creado
        Element elementoRaiz = miDocDom.getDocumentElement();

        // RECORREMOS EL OBJETO DOCUMENT Y EXTRAEMOS SU CONTENIDO
        // cogemos todos los nodos de tipo Alumno, que sean hjos del nodo raiz
        NodeList listaHijosRaiz = elementoRaiz.getElementsByTagName(nombreDeCadaElemento);

        // recorremos el array de nodos Alumno
        for (int t = 0; t < listaHijosRaiz.getLength(); t++) {
            // cogemos un elementoAlumno en cada vuelta del bucle
            elementoAlumno = (Element) listaHijosRaiz.item(t);

            // cogemos los valores de cada uno de los nodos hijos de un alumno
            nombre = getTextoDeUnElemento("nombre", elementoAlumno);
            apellido = getTextoDeUnElemento("apellidos", elementoAlumno);
            curso = getTextoDeUnElemento("curso", elementoAlumno);
            sexo = getTextoDeUnElemento("sexo", elementoAlumno).charAt(0); // para convertie el String en char

            // cogemos los atributos de los nodos que tengan atributo
            String edadcomoestring = getAtributo("edad", elementoAlumno);
            edad = Integer.parseInt(edadcomoestring);

            // con lo que hemos sacado, creamos un Alumno y lo añadirmo a la lista de alumnos
            Alumno alumno = new Alumno(nombre, apellido, curso, edad, sexo);
            listaAlumnos.add(alumno);
        }
        return listaAlumnos;
    }

    // ***********************************************************************
    // *********************    AÑADIR NODO A UN  XML  ***********************
    // ***********************************************************************
    public static void anadirNodoXML(Alumno alumnonuevo) throws Exception {
        Element elementoRaiz;
        String nombreFicheroXml = "xml/alumnos.xml";
        String nombreDeCadaElemento = "alumno";

        //-----------------  LEEMOS EL XML Y LO METEMOS EN UN OBJETO DOCUMENT
        Document miDocumentDom = crearDocumentDesdeXML(nombreFicheroXml);

        //-----------------  CREAMOS LOS ELELENTOS DEL NUEVO ALUMNO Y LOS AÑADIMOS AL RAIZ
        // cogemos el nodo raiz
        elementoRaiz = miDocumentDom.getDocumentElement();

        // Creamos una etiqueta llamada <alumno> que es donde vamos a meter todos sus hijos
        Element elementoAlumno = miDocumentDom.createElement("alumno");

        // -- añadimos los elementos hijos de cada alumno. Cuando se crea un elemento me lo puedo guardar en un
        // objeto Element, o no guardarlo, como prefiera. <nombre> si me lo guardo, por que luego le voy a poner un atributo
        Element elementonombre = crearElemento("nombre",  // nombre del elemento que se va a crear
                alumnonuevo.getNombre(),                     // contenido de texto del nuevo elemento
                elementoAlumno,                           // elemento padre del nuevo elemento
                miDocumentDom);                           // objeto document que estamos usando
        crearElemento("apellidos", alumnonuevo.getApellido(), elementoAlumno, miDocumentDom);
        crearElemento("curso", alumnonuevo.getCurso(), elementoAlumno, miDocumentDom);
        crearElemento("sexo", alumnonuevo.getSexo() + "", elementoAlumno, miDocumentDom);

        // -- añadimos los atributos
        crearAtributo("edad",                  // nombre del atributo
                alumnonuevo.getEdad() + "",         // contenido del atributo
                elementoAlumno);         // elemento donde se añade el atributo
        crearAtributo("nacionalidad", "española", elementonombre);

        // metemos finalmente el nuevo elemento alumno (ya relleno) dentro del elemento raiz
        elementoRaiz.appendChild(elementoAlumno);


        // ------------------------------------------- ESCRIBIR EN EL FICHERO XML EL CONTENIDO DEL DOCUMENT
        // Toma el documento creado y lo meto en un objeto DOMSource (que indica que vamos a construir a partir un document de DOM)
        crearXMLDesdeDocument(miDocumentDom, nombreFicheroXml);

    }

    // ***********************************************************************
    // *********************    MODIFICAR UN  XML   **************************
    // ***********************************************************************
    public static boolean modificarFicheroXML(String nombrebuscado, String nuevocurso) throws Exception {
        Element elementoRaiz, elementoAlumno;
        String nombre, apellido, curso;
        int edad;
        char sexo;
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        String nombreFicheroXml = "xml/alumnos.xml";
        String nombreDeCadaElemento = "alumno";

        //-----------------  LEEMOS EL XML Y LO METEMOS EN UN OBJETO DOCUMENT
        Document miDocumentDom = crearDocumentDesdeXML(nombreFicheroXml);

        //-----------------  RECORREMOS EL OBJETO DOCUMENT Y EXTRAEMOS SU CONTERNIDO
        // cogemos el nodo raiz
        elementoRaiz = miDocumentDom.getDocumentElement();
        boolean alumnoEncontrado = false;

        // cogemos todos los nodos de tipo Alumno, que sean hjos del nodo raiz
        NodeList listaHijosRaiz = elementoRaiz.getElementsByTagName(nombreDeCadaElemento);

        // recorremos el array de nodos Alumno
        for (int t = 0; t < listaHijosRaiz.getLength(); t++) {
            // cogemos un elementoAlumno en cada vuelta del bucle
            elementoAlumno = (Element) listaHijosRaiz.item(t);

            // cogemos los valores de necesitamos de  los nodos hijos de un alumno
            nombre = getTextoDeUnElemento("nombre", elementoAlumno);
            curso = getTextoDeUnElemento("curso", elementoAlumno);

            // vemos si es el alumno buscado
            if (nombre.equalsIgnoreCase(nombrebuscado)) {
                // al ser el que buscamos, modificamos el curso con el nuevo texto
                modificarElemento("curso", nuevocurso, elementoAlumno);
                alumnoEncontrado = true;
                System.out.println("Alumno modificado");
            }
        }

        if (!alumnoEncontrado) {
            System.out.println("No se ha modificado ningun alumno, nombre no encontrado");
        } else {
            // ------------------------------------------- ESCRIBIR EN EL FICHERO XML EL CONTENIDO DEL DOCUMENT
            // Toma el documento creado y lo meto en un objeto DOMSource (que indica que vamos a construir a partir un document de DOM)
            crearXMLDesdeDocument(miDocumentDom, nombreFicheroXml);

        }
        return alumnoEncontrado;
    }


    //========================================================================================
    //========================================================================================
    //============                    METODOS DE APOYO                         ===============
    //============                    ( NO MODIFICAR )                         ===============
    //========================================================================================
    //========================================================================================

    public static void crearXMLDesdeDocument(Document miDocumentDom, String nombreFicheroXml) throws Exception {
        // Toma el documento creado y lo meto en un objeto DOMSource
        // (que indica que vamos a construir a partir un document de DOM)
        Source source = new DOMSource(miDocumentDom);
        Result result = new StreamResult(new File(nombreFicheroXml));
        // TransformerFactory nos permite instanciar la clase Transformer,
        // que crea una "fabrica" para convertir un DOcument en Xml
        Transformer transformar = TransformerFactory.newInstance().newTransformer();
        // Con estas dos lineas decimos que el XML debe tener formato,
        // y que las etiquetas esten bien tabuladas, y cuanto
        transformar.setOutputProperty(OutputKeys.INDENT, "yes");
        transformar.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        // Se transforma con la "fábrica" la información de source
        // (nuestro document) en el result (el fichero XML)
        transformar.transform(source, result);
    }


    public static Document crearDocumentDesdeXML(String nombreFicheroXml) throws Exception {
        //-----------------  LEEMOS EL XML Y LO METEMOS EN UN OBJETO DOCUMENT
        Document miDocumentDom = null;
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        miDocumentDom = builder.parse(new FileInputStream(nombreFicheroXml));
        miDocumentDom.getDocumentElement().normalize();  // quita espacios innecesario en el xml, entre otras cosas

        return miDocumentDom;
    }


    public static Document crearDocumentVacio(String nombreDelElementoRaiz) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document miDocumentDom = implementation.createDocument(null, nombreDelElementoRaiz, null);
        miDocumentDom.setXmlVersion("1.0");
        return miDocumentDom;
    }


    public static Element crearElemento(String dato, String valor, Element nodopadre, Document document) {
        Element elem = document.createElement(dato);
        Text text = document.createTextNode(valor);
        nodopadre.appendChild(elem);
        elem.appendChild(text);
        return elem;
    }

    public static void crearAtributo(String dato, String valor, Element nodopadre) {
        nodopadre.setAttribute(dato, valor);
    }


    public static String getTextoDeUnElemento(String etiquetaABuscar, Element elementoPadre) {
        // sacar una lista de todos los nodo-etiqueta que se llame "etiquetaABuscar" y sea hijo de "elementoPadre"
        // con el ejemplo, esto da una lista de elementos <nombre>
        NodeList listaNodosHijos = elementoPadre.getElementsByTagName(etiquetaABuscar);
        // sacar el unico nodo-etiqueta que tiene esa lista (se supone que el nodo es simple)
        Node nodo = listaNodosHijos.item(0);
        // sacar y devolver del nodo-etiqueta su CONTENIDO:
        return nodo.getTextContent();
        // si no se quiere usar el método se puede hacer la busqueda con
        //    String valor =  elementoPadre.getElementsByTagName(etiquetaABuscar).item(0).getTextContent();
    }

    public static Element getElemento(String etiquetaABuscar, Element elementoPadre) {
        // sacar una lista de todos los nodo-etiqueta que se llame "etiquetaABuscar" y sea hijo de "elementoPadre"
        // con el ejemplo, esto da una lista de elementos <nombre>
        NodeList listaNodosHijos = elementoPadre.getElementsByTagName(etiquetaABuscar);
        // sacar el unico nodo-etiqueta que tiene esa lista (se supone que el nodo es simple)
        // sacar y devolver del nodo-etiqueta su CONTENIDO:
        return (Element) listaNodosHijos.item(0);
    }


    public static String getAtributo(String atributoABuscar, Element nodoPadre) {
        // sacar el nodo-atrinbuto a partir de todos los atributos de un nodo
        Node attr = nodoPadre.getAttributes().getNamedItem(atributoABuscar);
        // sacr y devoler el contenido del nodo atributo (su valor)
        return attr.getNodeValue();
        // si no se quiere usar el método se puede hacer la busqueda con
        //   String valor =  nodoPadre.getAttributes().getNamedItem(atributoABuscar).getNodeValue();
    }


    public static void modificarElemento(String etiquetaABuscar, String nuevovalor, Element elementoPadre) {
        NodeList listaNodosHijos = elementoPadre.getElementsByTagName(etiquetaABuscar);
        Node nodo = listaNodosHijos.item(0);
        nodo.setTextContent(nuevovalor);
    }

    // METODO RECURSIVO PARA LEER COMPLETAMENTE UN FICHERO XML
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





