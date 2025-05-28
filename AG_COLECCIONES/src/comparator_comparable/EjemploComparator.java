package comparator_comparable;

import java.util.*;

public class EjemploComparator {
	public static void main (String[] args) {
		//
		Comparator modcom3 = new Comparator ();

		System.out.println ("-- Ordenando un array por objetos");
		Humano[] lis = new Humano[4];
		lis[0] = (new Humano ("Luis", 23));
		lis[1] = (new Humano ("Pablo", 22));
		lis[2] = (new Humano ("Alberto", 18));
		lis[3] = (new Humano ("Cesar", 34));
		Arrays.sort (lis, modcom3);
		for (Humano h : lis)
			System.out.println (h.nombre);



//		List<Humano> p = new ArrayList<Humano> ();
//		p.add (new Humano ("Luis", 23));
//		p.add (new Humano ("Pablo", 22));
//		p.add (new Humano ("Alberto", 18));
//		p.add (new Humano ("Cesar", 34));
//		ModeloComparador modcom = new ModeloComparador ();
//		Collections.sort (p, modcom);
//		for (Humano serhumano : p)
//			System.out.println (serhumano.nombre);
//
//
//
		System.out.println ("-- Ordenando un HashMap por claves primitivas");
		// no hace falta usar Collections.sort()
		// ya que el conjunto de claves es un set autoordenado
		Map<Integer, String> p2 = new HashMap<> ();
		p2.put (4, "Luis");
		p2.put (2, "Pablo");
		p2.put (3, "Alberto");
		for (int nombre : p2.keySet ())
			System.out.println (nombre);


//		// Map<Humano, String> ppp = new TreeMap<Humano, String> ();  // ESTO DA ERROR
//		// pues intenta autoordenar la clave, que no es de orden natural
//		ModeloComparador modcom2 = new ModeloComparador ();
//		Map<Humano, String> pp = new HashMap<Humano, String> (modcom2);
//		pp.put (new Humano ("Luis", 23), "Ruiz");
//		pp.put (new Humano ("Pablo", 22), "Martinez");
//		pp.put (new Humano ("Alberto", 18), "Lopez");
//		pp.put (new Humano ("Cesar", 34), "Perez");
//		for (Humano h : pp.keySet ())
//			System.out.println (h.edad);

//		// Map<Humano, String> ppp = new TreeMap<Humano, String> ();  // ESTO DA ERROR
//		// pues intenta autoordenar la clave, que no es de orden natural
//		ModeloComparador modcom2 = new ModeloComparador ();
//		Map<Humano, String> pp = new TreeMap<Humano, String> (modcom2);
//		pp.put (new Humano ("Luis", 23), "Ruiz");
//		pp.put (new Humano ("Pablo", 22), "Martinez");
//		pp.put (new Humano ("Alberto", 18), "Lopez");
//		pp.put (new Humano ("Cesar", 34), "Perez");
//		for (Humano h : pp.keySet ())
//			System.out.println (h.edad);

//
//		ModeloComparador modcom3 = new ModeloComparador ();
//		Set<Humano> ppp = new TreeSet<Humano> (modcom3);
//		ppp.add (new Humano ("Luis", 23));
//		ppp.add (new Humano ("Pablo", 22));
//		ppp.add (new Humano ("Alberto", 18));
//		ppp.add (new Humano ("Cesar", 34));
//		for (Humano serhumano : ppp)
//			System.out.println (serhumano.nombre);

//		ModeloComparador modcom4 = new ModeloComparador ();
//		Set<Humano> ppppp = new HashSet<Humano> (modcom3);
//		ppppp.add (new Humano ("Luis", 23));
//		ppppp.add (new Humano ("Pablo", 22));
//		ppppp.add (new Humano ("Alberto", 18));
//		ppppp.add (new Humano ("Cesar", 34));
//		for (Humano serhumano : ppppp)
//			System.out.println (serhumano.nombre);


		Comparator modcom4 = new Comparator ();
		Set<String> ppppp = new HashSet<> ();
		ppppp.add ("Luis");
		ppppp.add ("Pablo");
		ppppp.add ("Alberto");
		ppppp.add ("Cesar");
		for (String nom : ppppp)
			System.out.println (nom);

//		Map<Integer, Humano> pppp = new TreeMap<> ();
//		pppp.put (23, new Humano ("Luis", 23));
//		pppp.put (22, new Humano ("Pablo", 22));
//		pppp.put (18, new Humano ("Alberto", 18));
//		pppp.put (34, new Humano ("Cesar", 34));
//		for (Integer ele : pppp.keySet ())
//			System.out.println (ele);

	}
}


class Comparator implements Comparator<Humano> {
	@Override
	public int compare (Humano p1, Humano p2) {
		return (p1.edad - p2.edad);
	}
}

class Humano {
	public String	nombre;
	public int		edad;

	public Humano (String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}


	@Override
	public String toString () {
		return (nombre + " " + edad);
	}

}

class LengthComparator implements Comparator<Persona> {

	@Override
	public int compare (Persona p1, Persona p2) {
		if (p1.toString ().length () < p2.toString ().length ()) return 1;
		else if (p1.toString ().length () > p2.toString ().length ()) return -1;
		else return 0;
	}

	public static void main (String[] args) {
		List<Persona> p = new ArrayList<Persona> ();
		p.add (new Persona ("Ana", 12));
		p.add (new Persona ("Hector", 35));
		p.add (new Persona ("Ana", 54));
		p.add (new Persona ("Carlitos", 63));
		Collections.sort (p, new LengthComparator ());
		for (Persona person : p)
			System.out.println (person);
	}
}
