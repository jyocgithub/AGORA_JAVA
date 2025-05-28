package ej_psp_4_a_15_consumidorMensajes;

public class Inicio {
	public static void main(String args[]) throws InterruptedException {
		
	    // CONSTRUIR EL OBJETO DE LA CLASE QUE COMPARTEN TODOS
		Monitor miMonitor = new Monitor();

		// CREAR OBJETOS (TANTOS COMO SEA) DE CONSUMIDOR Y PASAR A CADA UNO EL OBJETO COMUN CREADO
		ConsumidorMensajes conMen = new ConsumidorMensajes(miMonitor);
		// CREAR OBJETOS (TANTOS COMO SEA) DE PRODUCTOR Y PASAR A CADA UNO EL OBJETO COMUN CREADO
		ProductorMensajes proMen = new ProductorMensajes(miMonitor);
		
		// LANZAR LOS HILOS
		conMen.start();
		proMen.start();
		
		// PUEDE QUE SE DEBA ESPERAR A QUE TODOS LOS HILOS ACABEN
		
		conMen.join();
		conMen.join();
		
		
	}
}
