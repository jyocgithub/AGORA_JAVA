package streams1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumnos a1 = new Alumnos("Miguel", 20, 8.0f);
		Alumnos a2 = new Alumnos("Juan", 23, 5.0f);
		List<Alumnos> alumnos1 = new ArrayList<>();
		alumnos1.add(a1);
		alumnos1.add(a2);

		Alumnos a3 = new Alumnos("Luis", 30, 4.0f);
		Alumnos a4 = new Alumnos("Antonio", 43, 5.0f);
		List<Alumnos> alumnos2 = new ArrayList<>();
		alumnos2.add(a3);
		alumnos2.add(a4);

		Alumnos a5 = new Alumnos("Felipe", 22, 5.0f);
		Alumnos a6 = new Alumnos("Pedro", 23, 6.0f);
		List<Alumnos> alumnos3 = new ArrayList<>();
		alumnos3.add(a5);
		alumnos3.add(a6);

		Alumnos a7 = new Alumnos("Angel", 25, 9.0f);
		Alumnos a8 = new Alumnos("Abel", 26, 6.0f);
		List<Alumnos> alumnos4 = new ArrayList<>();
		alumnos3.add(a7);
		alumnos3.add(a8);

		Grupo g1 = new Grupo("DAM1", alumnos1);
		Grupo g2 = new Grupo("DAM2", alumnos2);
		Grupo g3 = new Grupo("ASIR1", alumnos3);
		Grupo g4 = new Grupo("ASIR2", alumnos4);

		List<Grupo> instituto = new ArrayList<>();

		instituto.add(g1);
		instituto.add(g2);
		instituto.add(g3);
		instituto.add(g4);

		//Stream<Grupo>centro=instituto.stream();
	
		//Mostrar todos los Alumnos del centro
		
		instituto.stream().flatMap(c -> c.getAlumnos().stream()).forEach(System.out::println);
//		Stream<Alumnos>alumnos=centro.flatMap(c -> c.getAlumnos().stream());
//		alumnos.forEach(System.out::println);
	
		//Mostrar todos los Alumnos del centro ordenados por nombre
	
	//	instituto.stream().flatMap(c -> c.getAlumnos().stream()).map(Alumnos::getNombre).sorted().forEach(System.out::println);
	
	}

}
