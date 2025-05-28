package xStrem.escribir_xml_con_xStream;

import java.util.ArrayList;




public class ListaDeObjetos {
	
	
	//// mi clase lista de objetos tiene mi lista vaciaaaaaaaaaaaaa
	
	
	ArrayList<Jugador>listaJugadores;
	
	

	public ListaDeObjetos() {
		
		
		listaJugadores = new ArrayList<Jugador>();
		
		
		
		
	}
	
	
	
	public void addlistaJugador(Jugador jugador) {
		
		listaJugadores.add(jugador);
		
		
	}
	
	

	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	
	
	
	
	
	

}
