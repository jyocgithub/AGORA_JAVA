package cap50_a_12_MundialBaloncesto.clases;

import java.util.Random;

public class Jugador extends Componente implements Comparable <Jugador>{

	private int dorsal;
	private String posición;
	private double rendimiento;

	public Jugador(int identificador, String nombre, String apellidos, int edad, Seleccion seleccion, int dorsal,
			String posición, double rendimiento) {
		super(identificador, nombre, apellidos, edad, seleccion);
		this.dorsal = dorsal;
		this.posición = posición;
		this.rendimiento = rendimiento;
	}

	@Override
	public void concentrarse() {
	}

	@Override
	public void entrenar() {
		// al entrenar hacemos que cada jugador aumente su rendimiento al azar
		Random r = new Random();
		int aumento = r.nextInt(30);
		rendimiento = aumento;
	}

	@Override
	public void viajar() {
	}

	@Override
	public void jugarPartido() {
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosición() {
		return posición;
	}

	public void setPosición(String posición) {
		this.posición = posición;
	}

	public double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(double rendimiento) {
		this.rendimiento = rendimiento;
	}

	@Override
	public int compareTo(Jugador o) {
		if( this.rendimiento > o.rendimiento) {
			return 1;
		} else if( this.rendimiento > o.rendimiento) {
			return -1;
		}
		else {
			return 0;
		}
	}


}
