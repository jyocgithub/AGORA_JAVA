package condicionDeCarrera_Sincronizado;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		ContadorCCM objetoContadorUnicoParaAmbosHilos = new ContadorCCM(0);
		Hilo1 hilo1 = new Hilo1("Hilo1", objetoContadorUnicoParaAmbosHilos);
		Hilo2 hilo2 = new Hilo2("Hilo2", objetoContadorUnicoParaAmbosHilos);
		hilo1.start();
		hilo2.start();
		hilo1.join();
		hilo2.join();
		System.out.println("Valor final de variable: " + objetoContadorUnicoParaAmbosHilos.getValue());

	}
}

/*
 * Ejecucion del programa
 * ----------------------
 * Vuelta 0
 * Hilo1, tras -- pone 1
 * Vuelta 0
 * Hilo2, tras ++++ pone 1
 * Vuelta 1
 * Hilo1, tras -- pone 2
 * Vuelta 1
 * Hilo2, tras ++++ pone 2
 * Vuelta 2
 * Hilo1, tras -- pone 3
 * Vuelta 2
 * Hilo2, tras ++++ pone 3
 * Vuelta 3
 * Hilo2, tras ++++ pone 4
 * Vuelta 3
 * Hilo1, tras -- pone 4
 * Vuelta 4
 * Hilo2, tras ++++ pone 5
 * Vuelta 4
 * Hilo1, tras -- pone 5
 * Vuelta 5
 * Hilo2, tras ++++ pone 6
 * Vuelta 5
 * Hilo1, tras -- pone 6
 * Vuelta 6
 * Hilo1, tras -- pone 7
 * Vuelta 6
 * Hilo2, tras ++++ pone 7
 * Vuelta 7
 * Hilo2, tras ++++ pone 8
 * Vuelta 7
 * Hilo1, tras -- pone 8
 * Vuelta 8
 * Hilo2, tras ++++ pone 10
 * Vuelta 8
 * Hilo1, tras -- pone 9
 * Vuelta 9
 * Hilo2, tras ++++ pone 11
 * Vuelta 9
 * Hilo1, tras -- pone 10
 * Valor final de variable: 10
 */
