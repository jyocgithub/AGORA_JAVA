package xStrem.leer_con_xStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class CrearXMLviajes {
	
		
	/*
	 * 1. Crea un paquete ejercicio1.main y dentro una clase CrearXMLViajes que a
	 * partir de un ArrayList de objetos, y utilizando DOM, genere un archivo
	 * agencia.xml y a continuaci�n lo muestre por pantalla mediante Xstream, para
	 * ello crea las clases necesarias en un paquete ejercicio1.javabean.
	 * 
	 * El fichero agencia.xml debe tener el siguiente aspecto:
	 * 
	 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<agencia>
<viaje>
	 <id>1234</id>
    <nombre>Semana Santa en Riviera Maya</nombre>
    <ciudad>
        <codigo>PCN</codigo>
        <nombreCiudad>Playa del Carmen</nombreCiudad>
        <pais>Mexico</pais>
    </ciudad>
    <dias>7</dias>
    <precio>845</precio>
</viaje>
<viaje>
<id>1235</id>
    <nombre>Navidad en NY</nombre>
    <ciudad>
        <codigo>NY</codigo>
        <nombreCiudad>Nueva York</nombreCiudad>
        <pais>EEUU</pais>
    </ciudad>
    <dias>8</dias>
    <precio>1050</precio>
</viaje>
<viaje>
<id>1236</id>
    <nombre>Punte de diciembre en Roma</nombre>
    <ciudad>
        <codigo>ROM</codigo>
        <nombreCiudad>Roma</nombreCiudad>
        <pais>Italia</pais>
    </ciudad>
    <dias>4</dias>
    <precio>462</precio>
</viaje>
</agencia>

	 * 
	 * 
	 */


	public static void main(String[] args) {

		
		generarXMLdOM();
		
		
		leerXMLxTREAM();

		
	}

	private static void leerXMLxTREAM() {
		//LEER MI XTREAM

		// TODO Auto-generated method stub
		try {
			
		XStream xs = new XStream();
		
		xs.addPermission(NoTypePermission.NONE);
		xs.addPermission(NullPermission.NULL);
		xs.addPermission(PrimitiveTypePermission.PRIMITIVES);

		
		Class[] clases = {Agencia.class, Viaje.class, Ciudad.class};
		xs.allowTypes(clases);                

		/// aqui le digo las clases que se van a utilizar, y listo los paquetes 
		xs.allowTypesByWildcard(new String[] {"ejercicio1.javabeanPojos.*"});
		
		/// elemento nodo raiz agencia
		xs.alias("agencia",Agencia.class);
		xs.alias("viaje",Viaje.class);
		
		
		/// NO QUIERE QUE ME SALGA EL NOMBRE D ELA LISTA DE MI VIAJE ES DECIR MI POJO 
		/// QUIERO QUE ME SALGA MI NOMBRE AGENCIA PERO NO LA PALABRA LISTAVIAJES
		xs.addImplicitCollection(Agencia.class,"listaViajes");
	
			Agencia lista = (Agencia) xs.fromXML(new FileInputStream("agencia.xml"));
			
			for (Viaje viaje: lista.getListaViajes()) {
				
				System.out.println(viaje.toString());
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                





	}
		
	

	private static void generarXMLdOM() {
		//GENERO UN XML CON DOM 
		
		/// CREAMOS UNA INSTANCIA DEL DOCUMENTO :
		///---esto es un write-----

		try {
			
			///  PASO 1 CREAMOS UNA INSTANCIA DEL DOCUMENTO : 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						
			/// PASO 2 BUILDER  CREAMOS no permite crear el implementacion
			DocumentBuilder builder =factory .newDocumentBuilder();
			
			/// PASO  3 IMPLEMENTACION ----para crear un documento XML
			DOMImplementation implementation = builder.getDOMImplementation();
			
			/// paso 4 especificas el nombre del elemento raiz del fichero--elemento raiz eseste
			Document document = implementation.createDocument(null, "agencia",null);
			
			/// paso 5 la version expecificamos copias la version.
			document.setXmlVersion("1.0");
			
			/// generamos mi obejto de mi paquete pojoooo

			/// Objeto del Pojo donde relleno el ArrayList en el constructor
			/// cuando hago en new rrelleno el arraylist

			FuenteDatos datos = new FuenteDatos();
			
			ArrayList<Viaje> listaDondeTengomiArrayRelleno= datos.getListavia();
			
			///declaro mis variables porque en el for no pueden estAR
			Element elementPadre;
			Element elementHijo;
			
			for (Viaje v: datos.getListavia()) {

		
		
		/// paso 6 lo creaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa-----
		/// dentro del elemto raiz,---elento final  
		 
		//-- AQUI ESTA DECLARADA MI VARIABLE A FUERA 
		elementPadre = document.createElement("viaje"); 
		
		// paso 7 para a�adir al nodo raiz el elemento 	para los cajones
		document.getDocumentElement().appendChild(elementPadre);

		generarElementoFinal(document, elementPadre, "id", String.valueOf(v.getId()));

		generarElementoFinal(document, elementPadre, "nombre", v.getNombre());
	

	

		/// CREAMOS LA FECHA QUE ESTA LLENA DE OSTROS CONTENEDORES DE INFORMACION
		 elementHijo = document.createElement("ciudad");
		elementPadre.appendChild(elementHijo);

		/// creamos dia
		generarElementoFinal(document, elementHijo, "codigo", v.getCiudad().getCodigo());

	

		generarElementoFinal(document, elementHijo, "nombreCiudad", v.getCiudad().getNombreCiudad());
		generarElementoFinal(document, elementHijo, "pais", v.getCiudad().getPais());


		generarElementoFinal(document, elementPadre, "dias", String.valueOf(v.getDias()));
		generarElementoFinal(document, elementPadre, "precio", String.valueOf(v.getPrecio()));
		
		
		
	
			}
		

		/// ANADIR LOS PASOS PARA LA GENERACION DEL FICHERO XML 
		
		Source source = new DOMSource(document);
		
		Result result = new StreamResult(new File("agencia.xml"));
		
		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
		transformer.setOutputProperty(OutputKeys.METHOD, "xml"); //          
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");/// tabula 4 estapcios
		
		transformer.transform(source,  result);
		
		//7 para mostrar or consola 
		Result console = new StreamResult(System.out);
		transformer.transform(source, console);
	
		
		
		
		
		
	} catch (ParserConfigurationException e) {
		// estas son de la linea que produce las excepciones 
		e.printStackTrace();
	} catch (TransformerConfigurationException e) {
		// estas son de la linea que produce las excepciones 
		e.printStackTrace();
	} catch (TransformerFactoryConfigurationError e) {
		// estas son de la linea que produce las excepciones 
		e.printStackTrace();
	} catch (TransformerException e) {
		// esta es de trasnformer.transform(source, result)
		e.printStackTrace();
	}

		
		
	}
	
	
	private static void generarElementoFinal(Document document, Element element, String nombre, String contenido) {
		//7 paso 8
		Element childElement = document.createElement(nombre);
		
		///paso 9
		Text text = document.createTextNode(contenido);
		
		//paso 10	
		childElement.appendChild(text);
		
		///paso 11
		element.appendChild(childElement);
	}
	
	

}
