package ProdConsum_Plantilla;

public class Inicio {
	public static void main(String args[]) throws InterruptedException {
		
	    // CONSTRUIR EL OBJETO DE LA CLASE QUE COMPARTEN TODOS
		Monitor miMonitor = new Monitor();

		// CREAR OBJETOS (TANTOS COMO SEA) DE CONSUMIDOR Y PASAR A CADA UNO EL OBJETO COMUN CREADO
		Consumidor conMen = new Consumidor("juan", miMonitor);
		// CREAR OBJETOS (TANTOS COMO SEA) DE PRODUCTOR Y PASAR A CADA UNO EL OBJETO COMUN CREADO
		Productor proMen = new Productor("pepe", miMonitor);
		
		// LANZAR LOS HILOS
		conMen.start();
		proMen.start();
		
		// PUEDE QUE SE DEBA ESPERAR A QUE TODOS LOS HILOS ACABEN
		
		conMen.join();
		conMen.join();
		
		
	}
}
