package ejercicio3.javabeansPojo;

import java.util.ArrayList;

public class ListaObjetos {
	
	
	
	ArrayList<Festival> listaFestivales;

	public ListaObjetos() {
		
		/// aqui lo inicializo
		listaFestivales = new ArrayList<Festival>();
		
		
	}

	/// mi metodo a�adir un objeto a lista 
	public void addListafestivales(Festival festival){
		
		listaFestivales.add(festival);
		
	}
	
	
	public ArrayList<Festival> getListaFestivales() {
		return listaFestivales;
	}
	
	
	
	

}
