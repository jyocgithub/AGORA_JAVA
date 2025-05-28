package ejercicio3mainCrearXMLdesdeFicheroBinario.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ejercicio3.javabeansPojo.Fecha;
import ejercicio3.javabeansPojo.Festival;


public class GenerarFestivalesObj {

	public static void main(String[] args) {
		ArrayList<Festival> listaFestivales = new ArrayList<Festival>();
		listaFestivales.add(new Festival("Primavera Sound",new Fecha(23,"Junio",2021),"Barcelona","España",
				"The Strokes, Gorillaz, Tame Impala, FKA Twigs, Tyler, the Creator, Jorja Smith, Iggy Pop, Disclosure"));
		listaFestivales.add(new Festival("Ultra Europe",new Fecha(27,"Julio",2021),"Split","Croacia",
				"David Guetta, Afrojack, Pendulum – TRINITY, Armin van Buuren, DJ Snake, Marshmello, Richie Hawtin, Steve Aoki"));
		listaFestivales.add(new Festival("Sziget Festival",new Fecha(8,"Agosto",2021),"Budapest","Hungría",
				"Calvin Harris, Dua Lipa, The Strokes, Kings Of Leon, Major Lazer, A$AP Rocky, Stormzy"));
		listaFestivales.add(new Festival("Wireless Festival",new Fecha(7,"Julio",2021),"Londres","Reino Unido",
				"A$AP Rocky, Lil Uzi Vert, D-Block Europe, Skepta, Meek Mill, AJ Tracey, Burna Boy, Young Thug"));
		listaFestivales.add(new Festival("Tomorrowland",new Fecha(21,"Julio",2021),"Boom","Bélgica",
				"Martin Garrix, David Guetta, Dimitri Vegas & Like Mike, Marshmello, Amelie Lens, Adam Beyer, Eric Prydz, NERVO"));
		listaFestivales.add(new Festival("Rock in Rio Lisboa",new Fecha(26,"Junio",2021),"Lisboa","Portugal",
				"Foo Fighters, Jason Derulo, Post Malone, Anitta, Duran Duran, A-ha, Liam Gallagher, Black Eyed Peas"));
		listaFestivales.add(new Festival("Mad Cool Festival",new Fecha(17,"Julio",2021),"Madrid","España",
				"The Killers, Twenty One Pilots, Deftones, Red Hot Chili Peppers, Mumford & Sons, Faith No More, Pixies, Royal Blood"));
		listaFestivales.add(new Festival("Download Festival",new Fecha(6,"Junio",2021),"Derby","Reino Unido",
				"KISS, Iron Maiden, System of a Down, Deftones, Korn, The Offspring, Disturbed, Gojira"));
		
		try (ObjectOutputStream outStr = new ObjectOutputStream(
				new FileOutputStream("FestivalesEur21.dat"));) {

			for (Festival festival : listaFestivales) {
				outStr.writeObject(festival);
			}
			
			System.out.println("FICHERO GENERADO");

			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
