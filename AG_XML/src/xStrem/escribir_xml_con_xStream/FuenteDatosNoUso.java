package xStrem.escribir_xml_con_xStream;

import java.util.ArrayList;

public class FuenteDatosNoUso {
	
	
	
	//// ARRAY, RELLENO EN CONTRUCTOR, GETLISTA
		ArrayList<Jugador> listaJ;
		
		
		

		public FuenteDatosNoUso() {
			
			/// PRIMERO LO CREO NEW
			
			
		listaJ = new ArrayList<Jugador>();
			
			/// AQUI RELLENO MI ARRAY 
		
			listaJ.add(new Jugador("Rafela Nadal", "Espa�ol", 35, 10, 2985, new Entrenador("Carlos moya", "espa�ol", 45)));
			listaJ.add(new Jugador("Novak Djokovi", "Serbio", 34, 1, 9970, new Entrenador("Marian Vajda", "Eslovaco", 56)));
			listaJ.add(new Jugador("	Roger Federer", "Suizo", 40, 16, 2385, new Entrenador("YO moya", "Suizo", 45)));
			
			
		
			
		}


		public ArrayList<Jugador> getListaJ() {
			return listaJ;
		}
		
		
		





}
