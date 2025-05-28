package solucion.ejercicio_2;

import java.util.ArrayList;

public class Coches {
	// el acceso a este elemento es el que provocar� la indeterminaci�n
	private ArrayList<String> listaCoche = new ArrayList<>();

	private Object cerrojo = new Object();

	private boolean tocanMicancion(int id) {
		Boolean latocan = false;

		if (this.listaCoche.size() == 0) {
			return false;
		}
		if ((this.getCoche() == "Mercedes") && (id == 5)) {
			return true;
		}
		if ((this.getCoche() == "Renault") && (id == 4)) {
			return true;
		}
		if ((this.getCoche() == "BMW") && (id == 3)) {
			return true;
		}
		if ((this.getCoche() == "Seat") && (id == 2)) {
			return true;
		}
		if ((this.getCoche() == "Audi") && (id == 1)) {
			return true;
		}

		return latocan;

	}

	public void compro(int id) {
		// System.out.println("el comprador " + id + " va a entrar en el synchronized
		// del cerrojo");
		synchronized (cerrojo) {
			// System.out.println("el comprador " + id + " ha entrado en el cerrojo");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// la idea es que si no ocurre lo que yo estoy esperando me espero
			while (!tocanMicancion(id)) // es m�s conveniente hacer el cerrojo sobre el objeto en disputa osea
										// listaCoche
			{
				try {
					// System.out.println("el comprador " + id + " esta esperando en la cola del
					// wait");
					cerrojo.wait();// esperamos en una lista distinta a la del synchronized
					// System.out.println("El hilo " + id + " acaba de salir del wait ");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// System.out.println("El coche que hay ahora en el almacen es " +
			// (String)this.listaCoche.get(0) + " y el comprador es "+ id);

			System.out.println("El comprador " + id + " ha comprado un " + this.listaCoche.get(0));
			cerrojo.notifyAll();
			listaCoche.remove(0);

			// System.out.println("El comprador " + id + " ha entrado y listaCoche tiene " +
			// listaCoche.size());
		}
	}

	public void fabrico(String marcacoche)// como solo hay un fabricante no hay que hacer exclusi�n mutua aqu�
	{
		synchronized (cerrojo)// al hacer notify no libero a los que est�n esperando aqu�
		{
			if (this.listaCoche.size() == 0)// solo fabrica si no hay nada que vender
			{
				listaCoche.add(marcacoche);
				System.out.println("Coche recien fabricado " + marcacoche);
				cerrojo.notifyAll();// este notify es para los hilos que est�n esperando en un wait de cerrojo
			}
		}
	}

	public String getCoche() {
		return this.listaCoche.get(0);
	}

}
