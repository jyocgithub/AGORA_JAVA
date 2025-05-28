package varios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

// import jyoc.utils.JYOCUtils;

public class Pruebas {

	public static void main(String[] args) throws FileNotFoundException {

		// Creamos un ArrayList y algunos elementos para el
		ArrayList<String> miArrayList = new ArrayList<>();
		miArrayList.add("HOLA");
		miArrayList.add("ADIOS");
		miArrayList.add("BUENAS");
		miArrayList.add("HELLO");
		miArrayList.add("CIAO");

		// Listamos el contenido con un iterator sin tipo
		Iterator iter = miArrayList.iterator();
		while (iter.hasNext()) {
			String unElemento = (String) iter.next(); // necesita casting
			System.out.println(" -> " + unElemento);
		}
		// Listamos el contenido con un iterator tipado
		Iterator<String> iter2 = miArrayList.iterator();
		while (iter.hasNext()) {
			String unElemento = iter2.next(); // ya no necesita casting
			System.out.println(" -> " + unElemento);
		}

		// Cambiamos los valores del ArrayList segun los leemos
		// Podemos usar ListIterator al ser un ArrayList la coleccion inicial
		ListIterator<String> liter = miArrayList.listIterator();
		while (liter.hasNext()) {
			String unElemento = liter.next();
			liter.set(unElemento + " con esto de apellido");
		}

		// Tratandose de un ListIterator, tengo metodos para recorrer la lista al revés
		ListIterator<String> liter2 = miArrayList.listIterator();
		while (liter2.hasPrevious()) {
			Object element = liter2.previous();
			System.out.print(element + " ");
		}

		// Sin embargo, no puedo borrar elementos con un for-each, esto DA ConcurrentModificationException
		// for (String st : miArrayList) {
		// miArrayList.remove(st);
		// }

		// Aunque si solo quiero borrar un elemento, sí puede hacerse con for-each,
		// siempre que abandone el bucle tras borrar
		System.out.println("El array tiene antes de borrar " + miArrayList.size() + " elementos");
		int kk = 0;
		for (String st : miArrayList) {
			if (st.equals("HELLO con esto de apellido")) {
				miArrayList.remove(st);
				break;
			}
		}
		System.out.println("El array tiene ahora " + miArrayList.size() + " elementos");

		// Pero la manera mas correcta de eliminar elementos es usando Iterator, aqui con un ArrayList
		Iterator<String> ite8 = miArrayList.iterator();
		while (ite8.hasNext()) {
			ite8.next();
			ite8.remove();
		}
		System.out.println("El array tiene ahora " + miArrayList.size() + " elementos");

		// Y aqui con un Map.
		HashMap<Integer, String> miMapa = new HashMap<>();
		miMapa.put(10, "Ana");
		miMapa.put(20, "Mercedes");
		miMapa.put(30, "Maria");

		// Vemos que con for-each nos da error nuevamente por ConcurrentModificationException, esto no vale
		// Set<Integer> lasClaves = miMapa.keySet();
		// for (Integer jk : lasClaves) {
		// System.out.println("Borrando " + miMapa.get(jk));
		// miMapa.remove(jk);
		// }

		// pero no con iterator
		Set<Integer> lasClaves = miMapa.keySet();
		Iterator<Integer> ite4 = lasClaves.iterator();
		while (ite4.hasNext()) {
			ite4.next();
			ite4.remove();
		}
		System.out.println("El mapa tiene ahora " + miMapa.size() + " elementos");

		// int totalH, s, d, h;
		// totalH = 25 + (24 * 7);
		// s = totalH / (24 * 7);
		// d = totalH % (24 * 7) / 24;
		// h = totalH % 24;
		// System.out.println("El total de " + totalH + " horas");
		// System.out.println("se convierte a:");
		// System.out.println(s + " semanas");
		// System.out.println(d + " dias");
		// System.out.println(h + " horas");

		// JYOCUtils jy = new JYOCUtils();
		//
		// int n[] = { 3, 6, 2, 7, 8, 3, 4, 6 };
		// jy.ordenarArrayIntPorBurbuja(n);
		//
		// for (int i = 0; i < 8; i++) {
		// System.out.println("xx:" + n[i]);
		// }

		//
		// fichRandom();
		// fichTexto();

		//
		// // FICHERO DE TEXTO
		// // ESCRIBIR
		// try {
		// File fich = new File("fichero.txt");
		// PrintStream escriptor = new PrintStream(fich);
		// escriptor.print(" " + 345);
		// escriptor.print(" Juan Perez");
		// escriptor.print(" Director Marketing");
		// escriptor.close();
		// } catch (Exception e) {
		// System.out.println("Error: " + e);
		// }
		//
		// // LEER
		// try {
		// File fich2 = new File("fichero.txt");
		// Scanner lector = new Scanner(fich2);
		// int numeroLeido = lector.nextInt();
		// String cadenaLeida = lector.next();
		// String cadenaLeida2 = lector.nextLine();
		// System.out.println("+" + numeroLeido + "-" + cadenaLeida + "-" +
		// cadenaLeida2 + "+");
		// lector.close();
		// } catch (Exception e) {
		// System.out.println("Error: " + e);
		// }
		//
		// // FICHERO BINARIO
		// // ESCRIBIR
		// try {
		// File fich3 = new File("fichero.bin");
		// RandomAccessFile raf = new RandomAccessFile(fich3, "rw");
		//
		// int posicion = 0; // La primera posicion para escribir es la 0
		// raf.seek(posicion);
		// raf.writeChars("Primo");
		// posicion = posicion + 5; //el texto "Primo" son 5 bytes
		//
		// raf.seek(posicion);
		// raf.writeInt(342);
		// posicion = posicion + 4; //un int son 4 bytes
		//
		// raf.seek(posicion);
		// raf.writeChars("Abuelo");
		//
		// raf.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// // LEER
		// try {
		// File fich4 = new File("fichero.bin");
		// RandomAccessFile raf2 = new RandomAccessFile(fich4, "rw");
		//
		// int posicion2 = 0; // La primera posicion para leer es la 0
		// raf2.seek(posicion2);
		//
		// // leo el primer dato que es un string de 5 char;
		// String sNombre = "";
		// char c = raf2.readChar();
		// while (c != 0x0000) {
		// sNombre = sNombre + c;
		// c = raf2.readChar();
		// }
		// posicion2 = posicion2 + 5;
		//
		// // leo el tercer dato que es un int;
		// int num = raf2.readInt();
		// posicion2 = posicion2 + 4; //un int son 4 bytes
		//
		// // leo el tercer dato que es un string de 6 char;
		// String sNombre2 = "";
		// char c2 = raf2.readChar();
		// while (c2 != 0x0000) {
		// sNombre = sNombre + c2;
		// c2 = raf2.readChar();
		// }
		// raf2.close();
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// }
		//
		// public static void fichTexto() {
		//
		// // CON BufferedWriter Y BufferedReader
		// String ruta = "ejemploTexto.txt";
		// File archivo = new File(ruta);
		// BufferedWriter bw;
		//
		// //--------------ESCRIBIR
		// try {
		// bw = new BufferedWriter(new FileWriter(archivo));
		// bw.write("linea 1");
		// bw.write("linea 2");
		// bw.write("linea 3");
		// bw.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// //--------------LEER
		// String cadena;
		// try {
		// if (archivo.exists()) {
		// FileReader f = new FileReader(archivo);
		//
		// BufferedReader b = new BufferedReader(f);
		// cadena = b
		// ..readLine();
		// while (cadena != null) {
		// System.out.println(cadena);
		// cadena = b.readLine();
		// }
		// b.close();
		// }
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// //****************************************************************
		// // CON FileOutputStream/ printStream Y BufferedReader
		// String ruta2 = "ficheroTexto2.txt";
		// File archivo2 = new File(ruta2); // solo lo uso para ver si existe el
		// fichero
		//
		// //--------------ESCRIBIR
		// try {
		// FileOutputStream fo = new FileOutputStream(ruta2, true);
		// PrintStream out = new PrintStream(fo);
		// out.println("cadena 1");
		// out.println("cadena 2");
		// out.close();
		// } catch (FileNotFoundException ex) {
		// ex.printStackTrace();
		// }
		//
		// //--------------LEER
		// try {
		// if (archivo2.exists()) {
		// FileReader fr = new FileReader(ruta2);
		//
		// BufferedReader bf = new BufferedReader(fr);
		// String linea;
		// while ((linea = bf.readLine()) != null) {
		// System.out.println(linea);
		// }
		// bf.close();
		// }
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// //****************************************************************
		// // CON FileWriter Y FileReader
		// // sirve para leer caracter a caracter, o un grupo especifico de
		// caracteres
		// try {
		// //--------------ESCRIBIR
		// // Abro stream, crea el fichero si no existe
		// FileWriter fw = new FileWriter("ficheroTexto3.txt");
		//
		// // FileWriter escribe caracteres unicamente
		// // Si le digo que escriba un numero me escribe el char de ese numero
		// // en este caso, una char 'a'
		// fw.write(97);
		// // Si le digo que escriba Strings los escribe tal cual
		// fw.write("Otra linea de prueba 1");
		// fw.write("Otra linea de prueba 2");
		// // Tambien puede escribir un array de char directamente
		// char[] arra = {'h', 'o', 'l', 'a'};
		// fw.write(arra);
		// //Guardamos los cambios del fichero
		// fw.flush();
		// //Cierro el stream
		// fw.close();
		//
		// //--------------LEER
		// // FileReader lee caracteres unicamente
		// //Abro el stream, el fichero debe existir
		// FileReader fr = new FileReader("ficheroTexto3.txt");
		//
		// //el método read de FileReader, este método no tiene parámetros
		// //pero devuelve un número que si le hacemos un casting a char este
		// sera legible
		// // read() puede leer solo char, aunque lee realmente el ascii del
		// char
		// // Si se guarda en un int guarda dicho ascii
		// int valor = fr.read();
		// System.out.print(valor); // imprime 97
		//
		// // read() puede leer en un bucle char a char, hasta leer -1
		// // Como devuelve un número ascii se le pued hacer un casting a char
		// while (valor != -1) {
		// valor = fr.read();
		// System.out.print((char) valor); // el Bucle imprime "Otra linea..."
		// }
		//
		// // puede leer todo un grupo de char, de tamaño fijo,
		// // y decuelve un array de char
		// char[] arra2 = new char[4];
		// fr.read(arra2);
		// // Se pueden imprimir los char uno a uno
		// for (char c : arra2) {
		// System.out.print(c);
		// }
		//
		// //Cerramos el stream
		// fr.close();
		// } catch (IOException e) {
		// System.out.println("Error: " + e); // el Bucle imprime "Hola"
		// }
		//
		// }
		//
		// public static void fichRandom() {
		//
		// // Creo 3 contactos de prueca y los meto en el array de contactos
		// Contacto c0 = new Contacto("Pepe", "Barcelona", 20);
		// Contacto c1 = new Contacto("Juan", "Soria", 22);
		// Contacto c2 = new Contacto("Luis", "Cuenca", 45);
		// Contacto[] arrayContactos = new Contacto[3];
		// arrayContactos[0] = c0;
		// arrayContactos[1] = c1;
		// arrayContactos[2] = c2;
		//
		// // ATRIBUTOS GENERICOS
		// // NOMBRE DEL FICHERO
		// String fichero = "ejemploRandom.dat";
		// // OBJETO FILE QUE HACE REFERENCIA AL FICHERO
		// // Lo usamos para saber si el fichero existe,
		// // y para construir con esta refecencia el stream de escritura
		// File ficheroParaEscribir;
		// // OBJETO RANDOMACCESSFILE
		// // Es el objeto que tiene los métodos para escribir, leer y moverse
		// por el fichero
		// RandomAccessFile raf = null;
		//
		// // ESCRITURA EN FICHERO ALEATORIO
		// // ==================================
		// // ABRIR FICHERO
		// try {
		// // Creo el objeto File
		// ficheroParaEscribir = new File(fichero);
		// // Creo el objeto RandomAccessFile
		// // La opcion "r" ES SOLO PARA LEER, "rw" LECTURA Y ESCRITURA
		// // Si el fichero existe, lo abre, si no existe, lo crea
		// raf = new RandomAccessFile(ficheroParaEscribir, "rw");
		//
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		//
		// // ESCRIBIR EN EL FICHERO ALEATORIO
		// // !EL FICHERO HA DE ESTAR ABIERTO PREVIAMENTE!
		// // La primera posicion del fichero es la posicion 0
		// int posicion = 0;
		//
		// // EL BUCLE VA A IR RECORRIENDO UN SUPUESTO ARRAY DE CONTACTOS
		// -arrayContactos-
		// // PARA CADA CONTACTO VA A ESCRIBIR SU
		// // - nombre (commo String de 20 ),
		// // - direccion (String de 30) y
		// // - edad (como int)
		// // Suponemos que el array ya esta creado y con datos anteriormente
		// for (int i = 0; i < arrayContactos.length; i++) {
		//
		// // cada registro completo ocupa 54 chars
		// // (20 del nombre + 30 de la direccion + 4 del int)
		// // calculo la posicion inicial de cada registro a grabar
		// // como i empieza en 0 la primera sera 0*54 = 0 ,
		// // cuando i valga 1, i*54 = 54 , etc
		// posicion = i * 54;
		//
		// try {
		// // me coloco en la posicion deseada
		// raf.seek(posicion);
		// // escribo un string, usando el metodo writechars del objeto raf
		// raf.writeChars(arrayContactos[i].getNombre());
		// // avanzo 20 posiciones para colocarme en la nueva posicion
		// // (20 es la longitud de lcampo que acabo de escribir)
		// posicion = posicion + 20;
		//
		// // me coloco en la posicion deseada
		// raf.seek(posicion);
		// // escribo un string, usando el metodo writechars del objeto raf
		// raf.writeChars(arrayContactos[i].getDireccion());
		// // avanzo 30 posiciones para colocarme en la nueva posicion
		// // (30 es la longitud de lcampo que acabo de escribir)
		// posicion = posicion + 30;
		//
		// // me coloco en la posicion deseada
		// raf.seek(posicion);
		// // escribo un int, usando el metodo writeInt del objeto raf
		// raf.writeInt(arrayContactos[i].getEdad());
		// // avanzo 4 posiciones para colocarme en la nueva posicion
		// // (4 es la longitud de un int , el campo que acabo de escribir)
		// posicion = posicion + 4;
		//
		// System.out.println("posicion :" + posicion);
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// System.out.println("indice de i:" + i);
		// return;
		// }
		//
		// }
		//
		// // Al acabar de escribir , cierro el fichero
		// // CERRAR FICHERO
		// try {
		// raf.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// // LECTURA EN FICHERO ALEATORIO
		// // ==================================
		// // ATRIBUTOS GENERICOS (PUEDEN SER LOS MISMOS QUE SE USARON EN LA
		// ESCRITURA)
		// // NOMBRE DEL FICHERO
		// String nombreFicheroAEscribir = "ejemploRandom.dat";
		// // OBJETO FILE QUE HACE REFERENCIA AL FICHERO
		// // Lo usamos para saber si el fichero existe,
		// // y para construir con esta refecencia el stream de escritura
		// File ficheroParaLeer;
		// // OBJETO RANDOMACCESSFILE
		// // Es el objeto que tiene los métodos para escribir, leer y moverse
		// por el fichero
		// RandomAccessFile raf2 = null;
		//
		// // ABRIR FICHERO
		// // Creo el objeto File
		// ficheroParaLeer = new File(nombreFicheroAEscribir);
		// // Antes de crear el objeto RandomAccessFile, como es para leer el
		// fichero,
		// // necesito estar seguro de que el fichero existe
		// if (ficheroParaLeer.exists()) {
		// //Aqui estoy ya seguro de que el fichero existe
		//
		// // Creo el objeto RandomAccessFile
		// // La opcion "r" ES SOLO PARA LEER
		// try {
		// raf2 = new RandomAccessFile(ficheroParaLeer, "r");
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		//
		// int pos, iEdad, caracteresLeidos, indiceDeArray;
		// String sNombre, sDireccion;
		// char c;
		//
		// // La primera posicion para leer es la 0
		// pos = 0;
		//
		// // Uso un sumador llamado caracteresLeidos para ver cuantos
		// // caracteres llevo leidos y poder controlar que llegue al fin de
		// fichero
		// caracteresLeidos = 0;
		//
		// // Uso un contador para controlar que indice de array he de crear
		// // cada vez que lea un Contacto
		// indiceDeArray = 0;
		// do {
		// try {
		// // LEER DATOS
		//
		// // Me coloco en la posicion para leer
		// raf2.seek(pos);
		// // leo el primer dato que es un string de 20 char;
		// sNombre = "";
		// c = raf2.readChar();
		// while (c != 0x0000) {
		// sNombre = sNombre + c;
		// c = raf2.readChar();
		// }
		// // calculo nueva posicion
		// pos = pos + 20;
		//
		// // Me coloco en la posicion para leer
		// raf2.seek(pos);
		// // leo el segundo dato que es un string de 30 char;
		// sDireccion = "";
		// c = raf2.readChar();
		// while (c != 0x0000) {
		// sDireccion = sDireccion + c;
		// c = raf2.readChar();
		// }
		//
		// // calculo nueva posicion
		// pos = pos + 30;
		//
		// // Me coloco en la posicion para leer
		// raf2.seek(pos);
		// // leo el tercer dato que es un int;
		// iEdad = raf2.readInt();
		// // calculo nueva posicion
		// pos = pos + 4;
		//
		// // incremento el contador de caracteres leidos en 54
		// caracteresLeidos = caracteresLeidos + 54;
		//
		// // CREAR CONTACTO DE DATOS LEIDOS
		// // Creo un contacto nuevo con los caracteres leidos
		// Contacto con = new Contacto(sNombre, sDireccion, iEdad);
		// // añado el contacto creado al array, en la posicion que
		// // indice indiceArray
		// arrayContactos[indiceDeArray] = con;
		//
		// // aumento el contador del indice del array
		// indiceDeArray++;
		//
		// } catch (IOException e) {

		// e.printStackTrace();
		// }
		// } while (caracteresLeidos < ficheroParaLeer.length());
		//
		// }
		//
		// // Al acabar de leer , cierro el fichero
		// // CERRAR FICHERO
		// try {
		// raf2.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// for (int i = 0; i < 3; i++) {
		// System.out.println(arrayContactos[i].getNombre());
		// System.out.println(arrayContactos[i].getDireccion());
		// System.out.println(arrayContactos[i].getEdad());
		// }
		//
		// }
		//
		// public static void fichRandomSinComentarios() {
		//
		// // Creo 3 contactos de prueca y los meto en el array de contactos
		// Contacto c0 = new Contacto("Pepe", "Barcelona", 20);
		// Contacto c1 = new Contacto("Juan", "Soria", 22);
		// Contacto c2 = new Contacto("Luis", "Cuenca", 45);
		// Contacto[] arrayContactos = new Contacto[3];
		// arrayContactos[0] = c0;
		// arrayContactos[1] = c1;
		// arrayContactos[2] = c2;
		//
		// // ESCRITURA EN FICHERO ALEATORIO
		// // ==================================
		// String fichero = "ejemploRandom.dat";
		// File ficheroParaEscribir;
		// RandomAccessFile raf = null;
		// try {
		// ficheroParaEscribir = new File(fichero);
		// raf = new RandomAccessFile(ficheroParaEscribir, "rw");
		//
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		// int posicion = 0;
		//
		// for (int i = 0; i < arrayContactos.length; i++) {
		// posicion = i * 54;
		// try {
		// raf.seek(posicion);
		// raf.writeChars(arrayContactos[i].getNombre());
		// posicion = posicion + 20;
		//
		// raf.seek(posicion);
		// raf.writeChars(arrayContactos[i].getDireccion());
		// posicion = posicion + 30;
		//
		// raf.seek(posicion);
		// raf.writeInt(arrayContactos[i].getEdad());
		// posicion = posicion + 4;
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// System.out.println("indice de i:" + i);
		// return;
		// }
		// }
		// try {
		// raf.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// // LECTURA EN FICHERO ALEATORIO
		// String nombreFicheroAEscribir = "ejemploRandom.dat";
		// File ficheroParaLeer;
		// RandomAccessFile raf2 = null;
		// ficheroParaLeer = new File(nombreFicheroAEscribir);
		//
		// if (ficheroParaLeer.exists()) {
		// try {
		// raf2 = new RandomAccessFile(ficheroParaLeer, "r");
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		//
		// int pos, iEdad, caracteresLeidos, indiceDeArray;
		// String sNombre, sDireccion;
		// char c;
		//
		// pos = 0;
		// caracteresLeidos = 0;
		// indiceDeArray = 0;
		//
		// do {
		// try {
		// raf2.seek(pos);
		// sNombre = "";
		// c = raf2.readChar();
		// while (c != 0x0000) {
		// sNombre = sNombre + c;
		// c = raf2.readChar();
		// }
		// pos = pos + 20;
		//
		// raf2.seek(pos);
		// sDireccion = "";
		// c = raf2.readChar();
		// while (c != 0x0000) {
		// sDireccion = sDireccion + c;
		// c = raf2.readChar();
		// }
		// pos = pos + 30;
		//
		// raf2.seek(pos);
		// iEdad = raf2.readInt();
		// pos = pos + 4;
		//
		// caracteresLeidos = caracteresLeidos + 54;
		//
		// Contacto con = new Contacto(sNombre, sDireccion, iEdad);
		// arrayContactos[indiceDeArray] = con;
		//
		// indiceDeArray++;
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// } while (caracteresLeidos < ficheroParaLeer.length());
		//
		// }
		// try {
		// raf2.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

}
