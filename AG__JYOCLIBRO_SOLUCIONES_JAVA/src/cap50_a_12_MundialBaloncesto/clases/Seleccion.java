package cap50_a_12_MundialBaloncesto.clases;

import java.util.ArrayList;
import java.util.Collections;

public class Seleccion implements Comparable <Seleccion>{

	private int Identificador;
	private String Apodo;
	private String País;
	private int AnoFundación;
	private int puntos;
	private ArrayList<Componente> componentes ;
	private ArrayList<Jugador> jugadores ;
	private ArrayList<Componente> convocados ;
	
	public Seleccion(int identificador, String apodo, String país, int anoFundación, int puntos) {
		super();
		Identificador = identificador;
		Apodo = apodo;
		País = país;
		AnoFundación = anoFundación;
		puntos = puntos;
		componentes = new ArrayList<Componente>();
		jugadores = new ArrayList<Jugador>();
		convocados = new ArrayList<Componente>();
	}
	
	public int getIdentificador() {
		return Identificador;
	}
	public void setIdentificador(int identificador) {
		Identificador = identificador;
	}
	public String getApodo() {
		return Apodo;
	}
	public void setApodo(String apodo) {
		Apodo = apodo;
	}
	public String getPaís() {
		return País;
	}
	public void setPaís(String país) {
		País = país;
	}
	public int getAnoFundación() {
		return AnoFundación;
	}
	public void setAnoFundación(int anoFundación) {
		AnoFundación = anoFundación;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	
    public void convocacion() {
    	//  hacemos entrenar a los jugadores
    	for(Componente c : componentes) {
    		if(c instanceof Jugador) {
    			Jugador j = (Jugador) c;
    			j.entrenar();
    		}
    	}
    }

    public ArrayList<Componente> elegirConvocados() {
    	// pasamos solo los jugadores a otro sitio para ordenarlos 
    	for(Componente c : componentes) {
    		if(c instanceof Jugador) {
    			Jugador j = (Jugador) c;
    			jugadores.add(j);
    		}
    	}
    	// ordenamos la coleccion
    	Collections.sort(jugadores);
    	
    	//paso los 12 primeros a convocados
    	for (int i = 0; i < 12; i++) {
    		Jugador j = jugadores.get(i);
    		convocados.add(j);
		}
    	return convocados;
    }
    
	public ArrayList<Componente> getConvocados() {
		return convocados;
	}

	public void setConvocados(ArrayList<Componente> convocados) {
		this.convocados = convocados;
	}
	
	@Override
	public int compareTo(Seleccion o) {
		if( this.puntos > o.puntos) {
			return 1;
		} else if( this.puntos > o.puntos) {
			return -1;
		}
		else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "cap50_a_12_MundialBaloncesto.clases.Seleccion [Identificador=" + Identificador + ", Apodo=" + Apodo + ", País=" + País + ", AnoFundación="
				+ AnoFundación + ", puntos=" + puntos + "]";
	}
	
	
}
