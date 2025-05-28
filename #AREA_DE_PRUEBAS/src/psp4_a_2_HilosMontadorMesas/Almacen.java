package psp4_a_2_HilosMontadorMesas;

import java.util.ArrayList;

public class Almacen {

	ArrayList<String> arpatas = new ArrayList<>();
	ArrayList<String> artablas = new ArrayList<>();
	final int MAX_PATAS = 10;
	final int MAX_TABLAS = 5;
	
	public ArrayList<String> getArpatas() {
		return arpatas;
	}
	public void setArpatas(ArrayList<String> arpatas) {
		this.arpatas = arpatas;
	}
	public ArrayList<String> getArtableros() {
		return artablas;
	}
	public void setArtableros(ArrayList<String> artableros) {
		this.artablas = artableros;
	}
	
	public synchronized void producirPata(String nombreFabricante) {
		
		
		while(arpatas.size() >= MAX_PATAS) {
			System.out.println("NO PUEDO PRODUCIR  PATA, soy " + nombreFabricante);
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		arpatas.add("pata");
		System.out.println("Se ha producido una pata del fabricante " + nombreFabricante);
	
		notifyAll();

	}
	
	public synchronized void producirTabla(String nombreFabricante) {
		
		while(artablas.size() >= MAX_TABLAS) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		artablas.add("tabla");
		System.out.println("Se ha producido una tabla del fabricante " + nombreFabricante);
		
		notifyAll();
		
		
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public synchronized void producirMesa(String nombreEnsamblador) {
		
		while(arpatas.size()< 4 || artablas.size()<1) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		arpatas.remove(0);
		arpatas.remove(0);
		arpatas.remove(0);
		arpatas.remove(0);
		artablas.remove(0);
		System.out.println("he contruido una mesa del ensamblador " +nombreEnsamblador);
		
		notifyAll();
	}
	
	
	
	
	
	
}

