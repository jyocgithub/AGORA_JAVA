package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOArma;
import dao.DAONave;
import dao.DAOPersistencia;
import dao.DAOPiloto;
import dao.DAOPlaneta;
import model.Arma;
import model.Nave;
import model.Piloto;
import model.Planeta;

public class MainMenuParte2 {

	private static Scanner sc = new Scanner(System.in);
	private static DAOPlaneta daoplaneta = new DAOPlaneta();
	private static DAOPiloto daopiloto = new DAOPiloto();
	private static DAOArma daoarmas = new DAOArma();
	private static DAONave daonaves = new DAONave();

	public static void main(String[] args) {

		borrarTodo();

		// ==================== PLANETAS
		Planeta p1 = new Planeta("VERIGIN-2", "MARRONES", 12000);
		Planeta p2 = new Planeta("CALANDRA-7", "AZULES", 23000);
		Planeta p3 = new Planeta("SUVRINWE-HAS-3", "MARRONES", 4000);

		// agregar planetas
		daoplaneta.altaPlaneta(p1);
		daoplaneta.altaPlaneta(p2);
		daoplaneta.altaPlaneta(p3);

		// ==================== PILOTOS
		Piloto pl1 = new Piloto("LOLO", 23, "Manolo Mugica", p1);
		Piloto pl2 = new Piloto("MUELAS", 21, "Pepe Payaso", p1);
		Piloto pl3 = new Piloto("VIEJO", 39, "Jose Gimenez", p2);
		Piloto pl4 = new Piloto("RASTAS", 39, "Ginés Cuevas", p2);
		Piloto pl5 = new Piloto("PELLEJO", 25, "Miguel Lopera", p3);
		Piloto pl6 = new Piloto("MALAMULA", 23, "Carlos Lagartijo", p3);

		// asociar planetas a pilotos y viceversa
		p1.addPiloto(pl1);
		p1.addPiloto(pl3);
		p2.addPiloto(pl3);
		p2.addPiloto(pl4);
		p3.addPiloto(pl5);
		p3.addPiloto(pl6);

		// asociar pilotos a naves y viceversa
		Nave n1 = new Nave("NVJ22", "TORMENTAS", 122);
		Nave n2 = new Nave("VXXQ8", "AMANECE TARDE", 322);
		ArrayList<Piloto> listapilotos1 = new ArrayList<>();
		listapilotos1.add(pl1);
		listapilotos1.add(pl2);
		listapilotos1.add(pl3);
		listapilotos1.add(pl4);
		ArrayList<Piloto> listapilotos2 = new ArrayList<>();
		listapilotos2.add(pl5);
		listapilotos2.add(pl6);
		n1.setPilotos(listapilotos1);
		n2.setPilotos(listapilotos2);

		// guardar pilotos
		daopiloto.altaPiloto(pl1);
		daopiloto.altaPiloto(pl2);
		daopiloto.altaPiloto(pl3);
		daopiloto.altaPiloto(pl4);
		daopiloto.altaPiloto(pl5);
		daopiloto.altaPiloto(pl6);

		// ==================== ARMAS
		Arma a1 = new Arma("XVB67888", 12, pl1);
		Arma a2 = new Arma("KJL/87", 10, pl2);
		Arma a3 = new Arma("KJHS8854", 2, pl3);
		Arma a4 = new Arma("WWA44", 14, pl4);
		Arma a5 = new Arma("ABKJC672", 8, pl5);
		Arma a6 = new Arma("8767HGH", 9, pl6);

		// asociar armas a pilotos y viceversa
		pl1.setArmas(a1);
		pl2.setArmas(a2);
		pl3.setArmas(a3);
		pl4.setArmas(a4);
		pl5.setArmas(a5);
		pl6.setArmas(a5);

		// guardar armas
		daoarmas.altaArma(a1);
		daoarmas.altaArma(a2);
		daoarmas.altaArma(a3);
		daoarmas.altaArma(a4);
		daoarmas.altaArma(a5);
		daoarmas.altaArma(a6);

		// ==================== NAVES

		// guardar naves
		daonaves.altaNave(n1);
		daonaves.altaNave(n2);

		// ==================== BORRADO SELECTIVO
		daopiloto.bajaPiloto(pl3);

		// ==================== CONSULTAS
		System.out.println("---- LAS NAVES ----");
		for (Nave n : daonaves.consularTodasLasNaves()) {
			System.out.println(n);
		}

		System.out.println("---- LOS PLANETAS ----");
		for (Planeta p : daoplaneta.consularTodosLasPlanetas()) {
			System.out.println(p);
		}

		System.out.println("---- LAS ARMAS ----");
		for (Arma a : daoarmas.consularTodasLasArmas()) {
			System.out.println(a);
		}

		System.out.println("---- LOS PILOTOS ----");
		for (Piloto p : daopiloto.consularTodosLosPilotos()) {
			System.out.println(p);
		}

		// cierre
		DAOPersistencia.closeEntityManager();

	}

	public static void borrarTodo() {
//		// borramos todos los datos previos de otras ejecuciones
		daopiloto.borrarTodosLosPilotos();
		daoplaneta.borrarTodosLasPlanetas();
		daoarmas.borrarTodasLasArmas();
		daonaves.borrarTodasLasNaves();
	}

}
