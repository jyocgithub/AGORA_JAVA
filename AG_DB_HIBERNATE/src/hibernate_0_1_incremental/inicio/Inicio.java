package hibernate_0_1_incremental.inicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Inicio {
	static String t, g, a;
	static int d;

	public static void main(String[] args) {

		GestionDBHibernate gdbh = new GestionDBHibernate();
		int opcion = 0;
		do {

			System.out.println("MENU");
			System.out.println("1.- Alta nueva pelicula");
			System.out.println("2.- Baja pelicula");
			System.out.println("3.- Consulta una pelicula");
			System.out.println("4.- Consulta todas las peliculas");
			System.out.println("5.- Modificacion de una pelicula");
			System.out.println("0.- Salir");
			opcion = leerInt("");
			switch (opcion) {
			case 1:
				System.out.println("ALTA DE PELICULA");

				t = leerString("Indique el titulo de la pelicula");
				g = leerString("Indique el genero de la pelicula");
				d = leerInt("Indique la duracion de la pelicula");
				a = leerString("Indique el actor principal de la pelicula");
				Tablapeliculas tablapeli = new Tablapeliculas(0,t, g, d, a);
				gdbh.anadirPelicula(tablapeli);
				break;
			case 2:
				System.out.println("BAJA DE PELICULA");

				t = leerString("Indique el titulo de la pelicula");
				boolean sepudoborrar = gdbh.bajaPelicula(t);
				if (!sepudoborrar) {
					System.out.println("Titulo inexistente");

				}
				break;

			case 3:
				System.out.println("CONSULTA UNA PELICULA");
				t = leerString("Indique el titulo de la pelicula");
				Tablapeliculas pel = gdbh.consultaPelicula(t);
				if (pel == null) {
					System.out.println("Titulo inexistente");
				} else {
					unaPeliculaPorConsola(pel);
				}
				break;
			case 4:
				System.out.println("LISTA DE PELICULAS");
				ArrayList<Tablapeliculas> listapelis = gdbh.listapelis();
				Iterator<Tablapeliculas> iterator = listapelis.iterator();
				while (iterator.hasNext()) {
					Tablapeliculas pel2 = iterator.next();
					unaPeliculaPorConsola(pel2);
				}
				break;
			case 5:
				System.out.println("MODIFICACION DE PELICULA");
				t = leerString("Indique el titulo de la pelicula a modificar");
				Tablapeliculas pel5 = gdbh.consultaPelicula(t);
				if (pel5 == null) {
					System.out.println("Titulo inexistente");
				} else {
					System.out.println("Datos actuales de la pelicula:");
					unaPeliculaPorConsola(pel5);
					System.out.println("Nuevos datos:");
					g = leerString("Indique nuevo el genero de la pelicula");
					d = leerInt("Indique la nueva duracion de la pelicula");
					a = leerString("Indique el nuevo actor principal de la pelicula");
					Tablapeliculas ta = new Tablapeliculas(0, t, g, d, a);
					gdbh.actualizaPelicula(ta);
				}
				break;
			}

		} while (opcion != 0);
		System.out.println("Fin del programa");
	}

	public static void unaPeliculaPorConsola(Tablapeliculas pel) {
		System.out.println("Titulo: " + pel.getTitulo());
		System.out.println("   Genero:" + pel.getGenero());
		System.out.println("    Duracion: " + pel.getDuracion());
		System.out.println("    Actor principal: " + pel.getActorprincipal());
		System.out.println("------------------------------------");
	}

	public static String leerString(String mensaje) {
		System.out.println(mensaje);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public static int leerInt(String mensaje) {
		System.out.println(mensaje);
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}
}
