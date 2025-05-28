package condicionDeCarrera_no_sincronizado;

public class Principal {

	public static void main (String[] args) throws InterruptedException {

		ContadorCC objetoContadorUnicoParaAmbosHilos = new ContadorCC (0);



		Hilo1 hilo1 = new Hilo1 ("Hilo1", objetoContadorUnicoParaAmbosHilos);
		Hilo2 hilo2 = new Hilo2 ("Hilo2", objetoContadorUnicoParaAmbosHilos);
		hilo1.start ();
		hilo2.start ();
//		hilo1.join();
//		hilo2.join();



		System.out.println ("Valor final de variable: " + objetoContadorUnicoParaAmbosHilos.getValor ());

	}
}
