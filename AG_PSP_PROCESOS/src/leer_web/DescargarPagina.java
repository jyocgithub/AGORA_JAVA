package leer_web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DescargarPagina {


	public static void main(String[] args) {

		String strUrl; // URL del parámetro (cadena)
		URL url;	// Objeto URL 


		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe la web que deseas leer. Debe comenzar por http://   , por ejemplo, http://www.google.es  :");
		strUrl = entrada.nextLine();

		// Si la URL es incorrecta (por ejemplo no empieza por http:// o similar)
		// saltará una  excepción de URL mal formada.
		try {
			url = new URL(strUrl);
		} catch (MalformedURLException e) {
			System.err.println("Dirección inválida: " + e.getLocalizedMessage());
			return;
		}

		// Le pedimos a la URL que nos de un stream de bytes con el
		// contenido. Ese stream lo envolvemos en un Reader para que
		// se haga la conversión a char con el formato predefinido
		// (confiemos que el servidor tenga el mismo que nosotros, que
		// quizá sea mucho decir) y luego lo metemos en un BufferedReader
		// para sacar linea a linea.
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
		}
		catch (IOException ioe) {
			System.err.println("No pude obtener el canal de lectura");
			return;
		}

		// Leemos todas las líneas que nos llega como contenido de la URL
		// y las escribimos por pantalla.
		String inputLine;
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();
		}
		catch(IOException ioe) {
			System.err.println("Error leyendo el contenido de la URL.");
		}

	}

}