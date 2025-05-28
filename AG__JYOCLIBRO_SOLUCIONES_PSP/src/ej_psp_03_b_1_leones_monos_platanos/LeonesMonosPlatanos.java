package ej_psp_3_b_1_leones_monos_platanos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class LeonesMonosPlatanos {

	static Jaula jaula;
	static final int CAPACIDADJAULA = 10;
	static final int NUMCUIDADORES = 3;

	public static void main(String[] args) {

		jaula = new Jaula(CAPACIDADJAULA);
		Thread[] cuidadores = new Thread[NUMCUIDADORES];

		for (int i = 0; i < cuidadores.length; i++) {
			Cuidador c = new Cuidador(i + "");
			Thread t = new Thread(c);
			cuidadores[i] = t;
		}
		for (int i = 0; i < cuidadores.length; i++) {
			cuidadores[i].start();
		}
		for (int i = 0; i < cuidadores.length; i++) {
			try {
				cuidadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("------ Jaula completa ------");

	}

	static class Cuidador implements Runnable {
		String nombre;
		int x;

		public Cuidador(String nombre) {
			super();
			this.nombre = nombre;
		}

		@Override
		public void run() {
			while (jaula.elementos.size() < CAPACIDADJAULA) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				jaula.meterenjaula(nombre, new Random().nextInt(3));
			}
		}
	}
}

class Jaula {
	private int capacidad;
	ArrayList<Integer> elementos;
	boolean hayunleon, hayunmono;

	// loqueentra puede ser 0:mono, 1:platano, 2:leon
	public synchronized void meterenjaula(String nombre, int loqueentra) {
		if (elementos.size() < capacidad) {
			System.out.println("Soy cuidador " + nombre + " e intento meter un " + quiensoy(loqueentra));
			if (elementos.size() == 0) {
				elementos.add(loqueentra);
			} else {
				Iterator<Integer> it = elementos.iterator();
				while (it.hasNext()) // recorre todos los elementos de la jaula para que mono coma platanos y leon monos
				{
					int cadaelemento = it.next();
					if (loqueentra == 0 && cadaelemento == 1) {
						it.remove();
					}
					if (loqueentra == 2 && cadaelemento == 0) {
						it.remove();
					}
				}

				// miro si hay leones o monos en la jaula
				for (Integer cadaelemento : elementos) {
					if (cadaelemento == 0) {
						hayunmono = true;
					}
					if (cadaelemento == 2) {
						hayunleon = true;
					}
				}

				// si aun hay monos e intento meter un platano, no lo meto
				// si aun hay leones e intento meter un mono, no lo meto
				// si lo que entra es un leon, lo meto en cualquier caso

				if (loqueentra == 1 && !hayunmono) {
					elementos.add(loqueentra);
				} else if (loqueentra == 0 && !hayunleon) {
					elementos.add(loqueentra);
				} else if (loqueentra == 2) {
					elementos.add(loqueentra);
				}

			}

			System.out.println("-- asi queda la jaula tras el intento -------");
			for (Integer integer : elementos) {
				System.out.print(quiensoy(integer));
			}
			System.out.println("\n-------------------");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public String quiensoy(int x) {
		if (x == 0) return "Mono ";
		if (x == 1) return "Platano ";
		if (x == 2) return "Leon ";
		return "Bicho raro ";
	}

	public Jaula(int capacidad) {
		super();
		this.capacidad = capacidad;
		elementos = new ArrayList<>();
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}