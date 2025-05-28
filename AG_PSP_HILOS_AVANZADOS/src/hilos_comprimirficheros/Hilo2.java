package hilos_comprimirficheros;

import java.io.File;

public class Hilo2 extends Thread {

	@Override
	public void run() {

		File f = new File("C:\\Users\\AlumnoM\\Acceso a Datos\\adrian-workspace");

		if (f.exists()) {
			if (f.isDirectory()) {

				// CALCULAR NUM FICHEROS
				long numfinal = numeroFichs(f);
				System.out.printf("Numero de ficheros del workspace: %d\n", numfinal);

			}
		}

	}

	public long numeroFichs(File f) {
		long suma = 0;

		if (f.isFile()) {
			return 1;
		} else {
			File[] lista = f.listFiles();
			for (int i = 0; i < lista.length; i++) {
				File cadacosa = lista[i];
				suma = suma + numeroFichs(cadacosa);
			}
		}
		return suma;

	}

}
