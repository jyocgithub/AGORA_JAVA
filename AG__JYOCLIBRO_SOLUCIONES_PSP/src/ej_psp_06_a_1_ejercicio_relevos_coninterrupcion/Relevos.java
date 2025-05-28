package ejercicio1;

public class Relevos {

	public static void main(String[] args) {

		Corredor mihilo1 = new Corredor("EVA");
		Corredor mihilo2 = new Corredor("ANA");
		Corredor mihilo3 = new Corredor("MARIA");
		Corredor mihilo4 = new Corredor("YESI");
		mihilo1.start();
		mihilo2.start();
		mihilo3.start();
		mihilo4.start();

		try {
			mihilo1.arrancar();
			mihilo1.join();
			mihilo2.arrancar();
			mihilo2.join();
			mihilo3.arrancar();
			mihilo3.join();
			mihilo4.arrancar();
			mihilo4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Soy hilo main y la carrera ha terminado");
	}

}

