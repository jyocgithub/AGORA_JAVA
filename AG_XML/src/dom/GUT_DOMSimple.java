package dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class GUT_DOMSimple {
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


    }

    // ***********************************************************************
    // *********************    CREAR XML   **********************************
    // ***********************************************************************
    public static void crearFicheroXML(ArrayList<Alumno> alumnos) throws Exception {
        // ------------------------------------------ CREAMOS Y RELLENAMOS EL OBJETO DOCUMENT
        String nombreDelElementoRaiz = "Alumnos";
        String nombreFicheroXml = "xml/alumnos.xml";

        // - Asi se crea el objeto document vacio, Y  le añade el elemento raiz (el padre unico)
        Document document; // Objeto Document que almacena el DOM del XML seleccionado.

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();

        document = implementation.createDocument(null, nombreDelElementoRaiz, null);


        // Necesito un objeto que me represente el nodo raiz (para luego meter dentro los demas elementos)
        // Esto me da el elemento raiz , y me lo guardo en elementoRaiz
        Node nodo_raiz = document.getDocumentElement();

        // vamos a ir metiendo uno a uno los alumnos en el document
        for (Alumno unalumno : alumnos) {  // recorro el array de alumnos

            // Creamos una etiqueta llamada <alumno> que es donde vamos a meter todos sus hijos
            Node nodo_alumno = document.createElement("alumno");


            // -- Crear los nodos de todas las etiquetas del alumno
            Node nodo_nombre = document.createElement("nombre");
            Node nodo_apellidos = document.createElement("apellidos");
            Node nodo_curso = document.createElement("curso");
            Node nodo_sexo = document.createElement("sexo");

            // -- Crear los nodos de texto con los valores de cada cliente
            Node nodo_nombre_texto = document.createTextNode(unalumno.getNombre());
            Node nodo_apellidos_texto = document.createTextNode(unalumno.getApellido());
            Node nodo_curso_texto = document.createTextNode(unalumno.getCurso());
            Node nodo_sexo_texto = document.createTextNode(unalumno.getSexo()+"");

            // -- Añadir cada nodo_texto a su padre
            nodo_nombre.appendChild(nodo_nombre_texto);
            nodo_apellidos.appendChild(nodo_apellidos_texto);
            nodo_curso.appendChild(nodo_curso_texto);
            nodo_sexo.appendChild(nodo_sexo_texto);

            // Añadimos el atributo al nodo alumno
            // necesitamos convertir antes el node en un Element
            Element elemento_alumno = (Element) nodo_alumno;
            elemento_alumno.setAttribute("edad", unalumno.getEdad()+"");

            //Añadir al nodo_elemento padre
            nodo_alumno.appendChild(nodo_nombre);
            nodo_alumno.appendChild(nodo_apellidos);
            nodo_alumno.appendChild(nodo_curso);
            nodo_alumno.appendChild(nodo_sexo);

            //-- Añadir cada nodo al raíz
            nodo_raiz.appendChild(nodo_alumno);
        }

        // Toma el documento creado y lo meto en un objeto DOMSource
        // (que indica que vamos a construir a partir un document de DOM)
        Source source = new DOMSource(document);
        Result result = new StreamResult(new File(nombreFicheroXml));
        // TransformerFactory nos permite instanciar la clase Transformer,
        // que crea una "fabrica" para convertir un DOcument en Xml
        Transformer transformar = TransformerFactory.newInstance().newTransformer();
        // Con estas dos lineas decimos que el XML debe tener formato,
        // y que las etiquetas esten bien tabuladas, y cuanto se tabulan
        transformar.setOutputProperty(OutputKeys.INDENT, "yes");
        transformar.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        // Se transforma con la "fábrica" la información de source
        // (nuestro document) en el result (el fichero XML)
        transformar.transform(source, result);

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
        Node valorNodo;
        NodeList hijos;
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        String nombreFicheroXml = "xml/alumnos.xml";
        String nombreDeCadaElemento = "alumno";


        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(new FileInputStream(nombreFicheroXml));

        document.getDocumentElement().normalize();  // quita espacios innecesario en el xml, entre otras cosas

        // cogemos una rererencia al nodo raiz ya creado
        Element elementoRaiz = document.getDocumentElement();

        // RECORREMOS EL OBJETO DOCUMENT Y EXTRAEMOS SU CONTENIDO
        // cogemos todos los nodos de tipo Alumno, que sean hjos del nodo raiz
        NodeList listaHijosRaiz = elementoRaiz.getElementsByTagName(nombreDeCadaElemento);

        // recorremos el array de nodos Alumno
        for (int t = 0; t < listaHijosRaiz.getLength(); t++) {
            // cogemos un elementoAlumno en cada vuelta del bucle
            elementoAlumno = (Element) listaHijosRaiz.item(t);

            hijos = elementoAlumno.getElementsByTagName("nombre").item(0).getChildNodes();
            valorNodo = hijos.item(0);   // NODO CON EL TEXTO
            nombre = valorNodo.getNodeValue();

            hijos = elementoAlumno.getElementsByTagName("apellidos").item(0).getChildNodes();
            valorNodo = hijos.item(0);   // NODO CON EL TEXTO
            apellido = valorNodo.getNodeValue();

            hijos = elementoAlumno.getElementsByTagName("curso").item(0).getChildNodes();
            valorNodo = hijos.item(0);   // NODO CON EL TEXTO
            curso = valorNodo.getNodeValue();

            hijos = elementoAlumno.getElementsByTagName("sexo").item(0).getChildNodes();
            valorNodo = hijos.item(0);   // NODO CON EL TEXTO
            sexo = valorNodo.getNodeValue().charAt(0);


            // cogemos los atributos de los nodos que tengan atributo
            Node attr = elementoAlumno.getAttributes().getNamedItem("edad");
            String edadcomoestring = attr.getNodeValue();
            edad = Integer.parseInt(edadcomoestring);

            // el otro atributo lo sacamos en solo una linea
            String nacionalidad = elementoAlumno.getElementsByTagName("nombre").item(0).getAttributes().getNamedItem("nacionalidad").getNodeValue();

            // con lo que hemos sacado, creamos un Alumno y lo añadirmo a la lista de alumnos
            Alumno alumno = new Alumno(nombre, apellido, curso, edad, sexo);
            listaAlumnos.add(alumno);
        }
        return listaAlumnos;
    }

}





