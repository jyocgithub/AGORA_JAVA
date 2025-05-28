import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ClaseFileAdrian {

	public static void main(String[] args) throws IOException {

	}

	public void metodosFileArchivo() throws IOException {
		// --------------------------------------------------------------
		// NOTA : PARA SIMPLIFICAR, ESTE METODO PROPAGA (THROWS) IOEXCEPTION
		// Y SIMPLIFICAR ASI LOS EJEMPLOS, PUES VARIOS DE LOS MÉTODOS EXIGEN
		// CONTROL DE EXCEPCIONES
		// --------------------------------------------------------------

		// Crear un fichero
		File fich1 = new File("unoDeTexto.txt");
		fich1.createNewFile();

		// Crear un Direcoriro, igual que crear un fichero pero sin try-catch obligado
		File dir1 = new File("dirCosas");
		dir1.mkdir();

		// Saber si un fichero existe
		File fich2 = new File("unoDeTexto.txt");
		if (fich2.exists()) {
			System.out.println("unoDeTexto.txt SI existe");
		} else {
			System.out.println("unoDeTexto.txt NO existe");
		}

		// Saber el path completo de un fichero
		String path = fich1.getPath();

		// Borrar un fichero
		File fich3 = new File("ficheroABorrar.txt");
		fich3.createNewFile(); // lo creamos primero
		if (fich3.exists()) {
			System.out.println("ficheroABorrar.txt SI existe"); // vemos que SI existe
		}
		fich3.delete();
		if (!fich3.exists()) {
			System.out.println("ficheroABorrar.txt YA NO existe"); // vemos que YA NO existe
		}

		// Renombrar un fichero
		File fichInicial = new File("ficheroARenombrar.txt");
		fichInicial.createNewFile(); // lo creamos primero
		File fichNuevo = new File("ficheroNuevoNombre.txt");
		fichInicial.renameTo(fichNuevo);
		if (!fich3.exists()) {
			System.out.println(fichInicial.getName()); // vemos que YA NO existe
			System.out.println("ficheroABorrar.txt YA NO existe"); // vemos que YA NO existe
		}
		// CUIDADO. el objeto fichInicial SE SIGUE LLAMANDO ficheroARenombrar.txt
		// (se puede ver ejecutando: System.out.println(fichInicial.getName()); )
		// pero el fichero EN EL DISCO, YA NO SE LLAMA ASI, ese SI ha cambiado
		// Para hacer referencia la fichero con su nombre nuevo,
		// usemos el objeto fichNuevo

		// Copiar un fichero
		File fichOrigen = new File("ficheroOrigen.txt");
		File fichDestino = new File("ficheroOrigen.txt");
		fichOrigen.createNewFile(); // lo creamos primero
		Files.copy(fichOrigen.toPath(), fichDestino.toPath());

		// Mover un fichero
		File fichPrimerSitio = new File("ficheroMovible.txt");
		fichPrimerSitio.createNewFile(); // lo creamos primero
		File fichSegundoSitio = new File("dirCosas/ficheroMovible.txt");
		fichPrimerSitio.renameTo(fichSegundoSitio);

		if (fichSegundoSitio.exists()) {
			System.out.println("ficheroMovible.txt esta en nuevo sitio"); // vemos que se ha movido
		}

	}

}
