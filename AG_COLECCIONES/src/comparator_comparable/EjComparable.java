package comparator_comparable;

import java.util.*;
import java.util.stream.Collectors;


public class EjComparable {
	public static void main (String[] args) {
		Persona p1 = new Persona ("Scotty",56);
		Persona p2 = new Persona ("Kirk",33);
		Persona p3 = new Persona ("Spock",53);
		Persona p4 = new Persona ("McCoy",42);

		// creamos un array
		Persona[] arraypersonas = {p1,p2,p3,p4};

		// creamos un arraylist
		ArrayList<Persona> listapersonas = new ArrayList<Persona> ();
		listapersonas.add (p1);
		listapersonas.add (p2);
		listapersonas.add (p3);
		listapersonas.add (p4);

		// creamos un treeset
		TreeSet<Persona> setpersonas = new TreeSet<Persona> ();
		setpersonas.add (p1);
		setpersonas.add (p2);
		setpersonas.add (p3);
		setpersonas.add (p4);

		// creamos un hashset
		HashSet<Persona> hsetpersonas = new HashSet<Persona> ();
		hsetpersonas.add (p1);
		hsetpersonas.add (p2);
		hsetpersonas.add (p3);
		hsetpersonas.add (p4);

		// creamos un hashmap
		TreeMap<Integer, Persona> tmappersonas = new TreeMap<> ();
		tmappersonas.put (42,p1);
		tmappersonas.put (23,p2);
		tmappersonas.put (11,p3);
		tmappersonas.put (38,p4);

		// creamos un hashmap
		Map<Integer, Persona> hmappersonas = new HashMap<> ();
		hmappersonas.put (42,p1);
		hmappersonas.put (23,p2);
		hmappersonas.put (11,p3);
		hmappersonas.put (38,p4);


		// ****************************************************
		// COMPARABLE CON UN ARRAY
		// ****************************************************

		// recordar que la clase Persona debe implementar Comparable<Persona>.....
		Arrays.sort(arraypersonas);

		System.out.println("---------- array ------------");
		for (Persona p : arraypersonas)
			System.out.println (p);


		// ****************************************************
		// COMPARABLE CON UN ARRAYLIST
		// **************************************************

		// recordar que la clase Persona debe implementar Comparable<Persona>.....
		Collections.sort(listapersonas);

		System.out.println("---------- arraylist ------------");
		for (Persona p : arraypersonas)
			System.out.println (p);


		// ****************************************************
		// COMPARABLE CON UN TREESET
		// ****************************************************

		// no hace falta hacer nada, los treeset estan ya ordenados

		System.out.println("---------- treeset ------------");
		for (Persona p : setpersonas)
			System.out.println (p);


		// ****************************************************
		// COMPARABLE CON UN HASHSET
		// ****************************************************

		// no se puede ordenar un hashset (sin streams), hay que pasarlo a List
		ArrayList<Persona> personasDeHashset= new ArrayList<Persona> (hsetpersonas);

		Collections.sort(personasDeHashset);

		System.out.println("---------- hashset pasado a list ------------");
		for (Persona p : personasDeHashset)
			System.out.println (p);

		// se puede ordenar un hashset con streams...
		HashSet<Persona> sortedHashSet = hsetpersonas.stream()
				.sorted()
				.collect(Collectors.toCollection(LinkedHashSet::new));

		System.out.println("---------- hashset con streams ------------");
		for (Persona p : sortedHashSet)
			System.out.println (p);


		// ****************************************************
		// COMPARABLE CON UN TREEMAP
		// ****************************************************

		// no hay que hacer nada, esta ordenado POR CLAVE automaticamente

		System.out.println("---------- treemap  ------------");
		for (int x : tmappersonas.keySet())
			System.out.println (x);


		// ****************************************************
		// COMPARABLE CON UN HASHMAP
		// ****************************************************

        // no se puede ordenar un hashmap (sin streams), hay que pasarlo a Treemap
		Map<Integer, Persona> treemapsorted = new TreeMap<Integer,Persona>(hmappersonas);

		System.out.println("---------- hashmap pasado a treemap ------------");
		for (int x : treemapsorted.keySet())
			System.out.println (x);


	}
}

// Clase Persona
class Persona implements Comparable<Persona> {
	String	nombre;
	int		edad;

	public Persona (String n, int e) {
		this.nombre = n;
		this.edad = e;
	}

	@Override
	public int compareTo (Persona p) {			// metodo compareTo sencillo
		return nombre.compareTo (p.nombre);
	}

	@Override
	public String toString() {
		return "Persona{" +
				"nombre='" + nombre + '\'' +
				", edad=" + edad +
				'}';
	}
}