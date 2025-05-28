package xStrem.leer_con_xStream;

import java.util.ArrayList;

public class FuenteDatos {
	
	/// siempre me creo el Arraylist de mi POJO DEL ELEMNTO PADRE viajeeeeee
	
	/// aqui relleno y solo tengo mi metodo get
	
	
	ArrayList<Viaje>listavia;

	public FuenteDatos() {
		
		/// inicializo mi variable mi arraylist
		
		listavia = new ArrayList<Viaje>();
		
		listavia.add(new Viaje(1234, "samana santa en riviera maya" , new Ciudad("PCN", "PLAYA DEL CARMEN", "MEXICO"), 7, 845));
		listavia.add(new Viaje(1235, "NAVIDAD EN NY" , new Ciudad("NY", "NEW YORK", "EEUU"), 8, 1050));
	
		
		
	}

	public ArrayList<Viaje> getListavia() {
		return listavia;
	}
	
	
	
	
	
	
	
	
	

}
