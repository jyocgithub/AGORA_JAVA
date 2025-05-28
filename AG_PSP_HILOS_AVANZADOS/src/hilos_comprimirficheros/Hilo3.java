package hilos_comprimirficheros;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Hilo3 extends Thread {
	ZipOutputStream output;

	@Override
	public void run() {
		try {
			FileOutputStream fos = new FileOutputStream("comprimido.zip");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			output = new ZipOutputStream(bos);

			File f = new File("C:\\Users\\AlumnoM\\Acceso a Datos\\adrian-workspace");

			if (f.exists()) {
				if (f.isDirectory()) {
					hacerZip(f); // HACER ZIP
				}
			}
			output.finish();
			output.close();
			System.out.println("Nuevo zip creado");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void hacerZip(File f) {
		if (f.isFile()) {
			anadirFicheroAlZip(f);
		} else {
			File[] lista = f.listFiles();
			for (int i = 0; i < lista.length; i++) {
				File cadacosa = lista[i];
				hacerZip(cadacosa);
			}
		}
	}

	public void anadirFicheroAlZip(File f) {
		try {
			byte[] buf = new byte[1024];
			ZipEntry zentry = new ZipEntry(f.getAbsolutePath());

			output.putNextEntry(zentry);
			FileInputStream fis = new FileInputStream(f);
			int len;
			while ((len = fis.read(buf)) > 0) {
				output.write(buf, 0, len);
			}
			fis.close();
			output.closeEntry();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
