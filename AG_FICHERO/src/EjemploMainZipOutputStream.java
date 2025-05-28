package ADRIAN_creando_zip;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Clase de ejemplo de uso de ZipOutputStream
 * @author Profesor
 *
 */

public class EjemploMainZipOutputStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos;
		ZipOutputStream zos = null;
		try {
			//Creamos el fichero comprimido
			fos = new FileOutputStream("ficheroComprimido.Zip");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			zos = new ZipOutputStream(bos);
		    for (int i = 0; i < 10; i++) {
		    	//Nuevo fichero a incluir en el comprimido
		        zos.putNextEntry(new ZipEntry("ficheroCreado." + i + ".txt"));
		        //Aqu� habr�a que leer cada fichero y escribirlo con el m�todo write
		        zos.write("Texto del fichero".getBytes());
		        zos.closeEntry();
		    }

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		    zos.close();
		}

	}

}
