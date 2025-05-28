package ejercicio3mainCrearXMLdesdeFicheroBinario.main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;


import ejercicio3.javabeansPojo.Fecha;
import ejercicio3.javabeansPojo.Festival;
import ejercicio3.javabeansPojo.ListaObjetos;

public class CrearXMLFestival {

	public static void main(String[] args) {
		
		
		
		generXmlXtream();
		
		leerXmlDOM();
		
		leerXMLXstream();

	}

	private static void leerXMLXstream() {
		
			

		//LEER MI XTREAM
		
		
		// TODO Auto-generated method stub
		try {
			
		XStream xs = new XStream();
		
		xs.addPermission(NoTypePermission.NONE);
		xs.addPermission(NullPermission.NULL);
		xs.addPermission(PrimitiveTypePermission.PRIMITIVES);

		
		Class[] clases = {ListaObjetos.class, Festival.class, Fecha.class};
		xs.allowTypes(clases);                

		/// aqui le digo las clases que se van a utilizar, y listo los paquetes 
		xs.allowTypesByWildcard(new String[] {"ejercicio3.javabeansPojo.*"});
		
		/// elemento nodo raiz agencia-----PADRE SUPREMO DIOSSSSSSSSSSSSSSSSSSSSSSS-------------------
		xs.alias("Festivales_Europa_2021",ListaObjetos.class);
		
		///-----NODO PADRE-------
		xs.alias("festival",Festival.class);
		
		
		/// NO QUIERE QUE ME SALGA EL NOMBRE D ELA LISTA DE MI VIAJE ES DECIR MI POJO 
		/// QUIERO QUE ME SALGA MI NOMBRE AGENCIA PERO NO LA PALABRA LISTAVIAJES
		xs.addImplicitCollection(ListaObjetos.class,"listaFestivales");
	
		ListaObjetos lista = (ListaObjetos) xs.fromXML(new FileInputStream("FestivalesEur21.xml"));
			
			for (Festival festival: lista.getListaFestivales()) {
				
				System.out.println(festival.toString());
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                


	
		
	
	}

	
	///-----LEO UN XML MEDIANTE DOM-------------------
	private static void leerXmlDOM() {
		
		
		try {
			
			//Creamos una instancia que va a ser donde fabriquemos los ficheros xml.
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//Creamos el procesador de XML o parser
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//Con esta sentencia realizamos la lectura del fichero
			Document document = builder.parse(new File("FestivalesEur21.xml"));
			
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
	
	
	
	//METODO RECURSIVO PARA LEER FICHEROS XML ----------------ESTO ES DE MI LECTURA DE DOM-----------------
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
	
	
	
	
	

	private static void generXmlXtream() {
		
		ListaObjetos listaobjetos = new ListaObjetos();
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FestivalesEur21.dat"))){
			
			Festival fes;
			/*
			 * while ((fes = (Festival) ois.readObject()) != null) {
			 * 
			 * System.out.println(fes); // le paso lo que recorre mi for
			 * listaobjetos.addListafestivales(fes);
			 * 
			 * }
			 */
			
			
			boolean continuar = true;
			while (continuar) {
				try {
					fes = (Festival) ois.readObject();
					listaobjetos.addListafestivales(fes);
				} catch (EOFException e) {
					continuar = false;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			
			///Crear una instancia de la clase XStream
			
			
			///XStream xstream = new XStream();----DE NORMAL ESTE SE PONE 
			
			
			XStream xstream = new XStream(new DomDriver("UTF-8"));
			
				//7Las etiquetas XML se corresponden con el nombre de los atributos de la clase,
				///pero se pueden cambiar usando el método alias()
			
			
			///// NODO RAIZ
			xstream.alias("Festivales_Europa_2021",ListaObjetos.class);
			/// NODO PADRE
			xstream.alias("festival",Festival.class);
			
			
			///Para que no aparezca el atributo lista de la clase ListaObjetos 
			///en el XML utilizamos el método addImplicitCollection();
			///"listaAlum" será el nombre del atributo de tipo ArrayList de la clase ListaAlumnos.  
			
			xstream.addImplicitCollection(ListaObjetos.class, "listaFestivales"); 
			
			/// TODO: rellenarLista(); no lo necesito proque lo hice con mi addListafestivales.
			
		
			//7Para terminar, se genera el fichero objetos.xml a partir de la lista de objetos 
			////mediante el método toXML(objeto, OutputStream();
		
		
			xstream.toXML(listaobjetos, new FileOutputStream("FestivalesEur21.xml"));
			
			System.out.println("fichero generado ");
				
			
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
