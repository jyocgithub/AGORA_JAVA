package xStrem.leer_con_xStream;

import java.util.ArrayList;

public class Agencia {

	
	/// la agencia NODO RAIZ, LLEVA SIEMPRE UN ARRAYLIST, CONRTCUTOR POR DEFECTO, METODO ADD Y UN GET
	
	//// POR QUE USAMOS XTREAMMMM
	//// LIBRERIAS
	//// IMPLENS SERIALIZABLES
	
	
	
	ArrayList<Viaje> listaViajes;

	
	/// contructor
	public Agencia() {
		
				
		/// aqui inicialilzo mi arraylists
		
		listaViajes= new ArrayList<Viaje>();
		
	}

	/// este es mi metodo ADD
	/// a�ado una lista y dentro meto un pojo 
	
	public void addLista(Viaje viaje) {
		
		listaViajes.add(viaje);		
	}
	
	
	
	/// mi get

	public ArrayList<Viaje> getListaViajes() {
		return listaViajes;
	}
	
	
	
	
	
	
	
	
}
