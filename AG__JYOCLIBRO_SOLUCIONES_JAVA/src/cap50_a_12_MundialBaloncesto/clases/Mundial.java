package cap50_a_12_MundialBaloncesto.clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mundial {

	private ArrayList<Seleccion> selecciones;
	Seleccion sgana4,sgana3,sgana2,sgana1;

	public void crearEquipos() {
		selecciones = new ArrayList<Seleccion>();
		// creamos las 16 selecciones. Se llaman todas igual pero tienen id distinto
		for (int s = 1; s < 17; s++) {
			Seleccion s1 = new Seleccion(s, "Roja", "España", 1909, 0);
			// creamos los 20 jugadores de la seleccion. Se llaman todos igual pero tienen
			// id y dorsal distinto
			for (int i = 1; i < 21; i++) {
				Jugador j1 = new Jugador(i, "pepe", "perez", 20 + 1, s1, i, "Portero", 0);
				s1.getComponentes().add(j1);
			}

			// añadimos un entrenado y un masjista a lso componentes
			Entrenador e = new Entrenador(202, "paco", "lopez", 20 + 1, s1, 123, "Primer entrenador");
			Masajista m = new Masajista(111, "luis", "martinez", 20 + 1, s1, 12, "cap50_a_12_MundialBaloncesto.clases.Masajista profesional");
			s1.getComponentes().add(e);
			s1.getComponentes().add(m);

			selecciones.add(s1);
		}
	}

	public void convocar() {
		for (int s = 0; s < 16; s++) {
			selecciones.get(s).elegirConvocados();
		}
	}
	
	public void listarConvocados() {
		for (Seleccion sel  : selecciones) {
			for (Componente j : sel.getConvocados()) {
				 System.out.println(j);
			}
		}
	}
	
	
	public void jugarpartido(Seleccion s1, Seleccion s2) {
		
		Random r = new Random();
		int x = r.nextInt(2);
		if( x==1) {
			int puntos = s1.getPuntos();
			s1.setPuntos(puntos+3);
			int puntos2 = s2.getPuntos();
			s2.setPuntos(puntos2+1);
		}else {
			int puntos = s1.getPuntos();
			s1.setPuntos(puntos+1);
			int puntos2 = s2.getPuntos();
			s2.setPuntos(puntos2+3);			
		}
	}
	
	
	public void clasificacion() {
		Seleccion s1 = selecciones.get(0);
		Seleccion s2 = selecciones.get(1);
		Seleccion s3 = selecciones.get(2);
		Seleccion s4 = selecciones.get(3);
		jugarpartido(s1,s2);
		jugarpartido(s1,s3);
		jugarpartido(s1,s4);
		jugarpartido(s2,s3);
		jugarpartido(s2,s4);
		jugarpartido(s3,s4);
		s1 = selecciones.get(4);
		s2 = selecciones.get(5);
		s3 = selecciones.get(6);
		s4 = selecciones.get(7);
		jugarpartido(s1,s2);
		jugarpartido(s1,s3);
		jugarpartido(s1,s4);
		jugarpartido(s2,s3);
		jugarpartido(s2,s4);
		jugarpartido(s3,s4);
		
		s1 = selecciones.get(8);
		s2 = selecciones.get(9);
		s3 = selecciones.get(10);
		s4 = selecciones.get(11);
		jugarpartido(s1,s2);
		jugarpartido(s1,s3);
		jugarpartido(s1,s4);
		jugarpartido(s2,s3);
		jugarpartido(s2,s4);
		jugarpartido(s3,s4);
		 s1 = selecciones.get(12);
		 s2 = selecciones.get(13);
		 s3 = selecciones.get(14);
		 s4 = selecciones.get(15);
		jugarpartido(s1,s2);
		jugarpartido(s1,s3);
		jugarpartido(s1,s4);
		jugarpartido(s2,s3);
		jugarpartido(s2,s4);
		jugarpartido(s3,s4);
		
	}
	
	public void clasificar() {
		
		// meto los 4 equipos de cada grupo en un array nuevo 
		ArrayList<Seleccion> grupo = new ArrayList();
		Seleccion s1 = selecciones.get(0);
		Seleccion s2 = selecciones.get(1);
		Seleccion s3 = selecciones.get(2);
		Seleccion s4 = selecciones.get(3);
		grupo.add(s1);
		grupo.add(s2);
		grupo.add(s3);
		grupo.add(s4);
		// ordenar los 4
		Collections.sort(grupo);
		// cojo el ultimo que es el campeon
		 sgana1 = grupo.get(3);
		
		// meto los 4 equipos de cada grupo en un array nuevo 
		grupo = new ArrayList();
		s1 = selecciones.get(4);
		s2 = selecciones.get(5);
		s3 = selecciones.get(6);
		s4 = selecciones.get(7);
		grupo.add(s1);
		grupo.add(s2);
		grupo.add(s3);
		grupo.add(s4);
		// ordenar los 4
		Collections.sort(grupo);
		// cojo el ultimo que es el campeon
		 sgana2 = grupo.get(3);
		
		
		// meto los 4 equipos de cada grupo en un array nuevo 
		grupo = new ArrayList();
		s1 = selecciones.get(8);
		s2 = selecciones.get(9);
		s3 = selecciones.get(10);
		s4 = selecciones.get(11);
		grupo.add(s1);
		grupo.add(s2);
		grupo.add(s3);
		grupo.add(s4);
		// ordenar los 4
		Collections.sort(grupo);
		// cojo el ultimo que es el campeon
		 sgana3 = grupo.get(3);
		
		
		// meto los 4 equipos de cada grupo en un array nuevo 
		 grupo = new ArrayList();
		 s1 = selecciones.get(12);
		 s2 = selecciones.get(13);
		 s3 = selecciones.get(14);
		 s4 = selecciones.get(15);
		grupo.add(s1);
		grupo.add(s2);
		grupo.add(s3);
		grupo.add(s4);
		// ordenar los 4
		Collections.sort(grupo);
		// cojo el ultimo que es el campeon
		 sgana4 = grupo.get(3);
		
		
	}
	
	public void pintarClasificadosGrupo() {
		System.out.println("Ganador 1" + sgana1);
		System.out.println("Ganador 2" + sgana2);
		System.out.println("Ganador 3" + sgana3);
		System.out.println("Ganador 4" + sgana4);
		
	}
	
	public void fasefinal() {
		
		Seleccion final1, final2, campeon;
		
		
		jugarpartido(sgana1,sgana2);
		if(sgana1.getPuntos()> sgana2.getPuntos()) {
			final1 = sgana1;
		}else {
			
			final1 = sgana2;
		}
		System.out.println("Semifinalista 1 " + final1);
		
		
		jugarpartido(sgana3,sgana4);
		if(sgana3.getPuntos()> sgana4.getPuntos()) {
			final2 = sgana3;
		}else {
			
			final2 = sgana4;
		}
		System.out.println("Semifinalista 3 " + final2);
		
		
		jugarpartido(final1,final2);
		if(final1.getPuntos()> final2.getPuntos()) {
			campeon = final1;
		}else {
			
			campeon = final2;
		}
		System.out.println("Campeon 1 " + campeon);
		
		
		
		
		
	}
	
	public ArrayList<Seleccion> getSelecciones() {
		return selecciones;
	}

	public void setSelecciones(ArrayList<Seleccion> selecciones) {
		this.selecciones = selecciones;
	}

}
