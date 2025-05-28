package hilos_comprimirficheros;

import java.io.File;

public class Hilo11 extends Thread {

	@Override
	public void run() {

		File f = new File("C:\\Users\\AlumnoM\\Acceso a Datos\\adrian-workspace");

		if (f.exists()) {
			if (f.isDirectory()) {

				// CALCULAR TAMANO
				long tamfinal = tamanodir(f);
				float x = 1024;
				float megas = tamfinal / x / x;
				System.out.printf("Tamano del workspace: %d KB = %.2f MB", tamfinal, megas);
				System.out.println("");
			}
		}

	}

	public long tamanodir(File f) {
		long suma = 0;

		if (f.isFile()) {
			suma = f.length();
		} else {
			File[] lista = f.listFiles();
			for (int i = 0; i < lista.length; i++) {
				File cadacosa = lista[i];
				suma = suma + tamanodir(cadacosa);
			}
		}
		return suma;

	}

}
