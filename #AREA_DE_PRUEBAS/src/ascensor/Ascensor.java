package ascensor;

import java.util.Scanner;

public class Ascensor {

	private int numeroDelAscensor;  // creo un campo para poder ponerle un numero al ascensor
	
	private int capacidad;
	private int ocupacion;
	private int consumo = 0; //no se incluye en constructor
	private int pisoActual;

	


//////////////////////////////////////////////////////////////////////////	
	public Ascensor(int capacidad, int ocupacion, int pisoActual) {
		this.capacidad = capacidad;
		this.ocupacion = ocupacion;
		this.pisoActual = pisoActual;
	}
//////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////	
	public int getCapacidad() {
		return capacidad;
	}
	public int getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
	}
	public int getConsumo() {
		return consumo;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	public int getPisoActual() {
		return pisoActual;
	}
	public void setPisoActual(int pisoActual) {
		this.pisoActual = pisoActual;
	}

	public int getNumeroDelAscensor() {
		return numeroDelAscensor;
	}

	public void setNumeroDelAscensor(int numeroDelAscensor) {
		this.numeroDelAscensor = numeroDelAscensor;
	}
///////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////
	public void mover(int nuevopiso) {
		int diferenciaPisos ;

		if(nuevopiso>pisoActual){
			diferenciaPisos = nuevopiso-pisoActual;
		}else {
			diferenciaPisos = pisoActual-nuevopiso;
		}
		consumo = consumo + (diferenciaPisos * ocupacion);
		pisoActual= nuevopiso;
	}
////////////////////////////////////////////////////////////////////////////	

	@Override
	public String toString() {
		return "Ascensor numero "+ numeroDelAscensor+": capacidad=" + capacidad + ", ocupacion=" + ocupacion + ", consumo=" + consumo + ", pisoActual=" + pisoActual;
	}	
}
