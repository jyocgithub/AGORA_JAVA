package hibernate_1_N_increment_bidir.controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import hibernate_1_N_increment_bidir.pojos.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import hibernate_1_N_increment_bidir.daos.ViviendaDAO;

public class Inicio {

	public static void main(String[] args) {
		// Para ver en el log las consultas SQL que ejecuta Hibernate
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.CONFIG);

		ViviendaDAO dao = new ViviendaDAO();

		// BORRAMOS TODOS LOS REGISRTOS PREVIOS PARA PARTIR DE CERO
		System.out.println("Borrados :" + dao.borrarTodo("PLAZAGARAGE"));
		System.out.println("Borrados :" + dao.borrarTodo("VIVIENDA"));

		// CREAMOS EJEMPLOS
		PlazaGarage pg1 = new PlazaGarage( "11A", 1000);
		PlazaGarage pg2 = new PlazaGarage( "23B", 1000);
		PlazaGarage pg3 = new PlazaGarage( "33A", 1000);
		PlazaGarage pg4 = new PlazaGarage( "41B", 1000);
		PlazaGarage pg5 = new PlazaGarage( "51A", 1000);
		PlazaGarage pg6 = new PlazaGarage( "66C", 1000);

		Vivienda v1 = new Vivienda("Piso");
		Vivienda v2 = new Vivienda("Atico");
		Vivienda v3 = new Vivienda("Entresuelo");
		
		v1.agregarPlazaGarage(pg1);
		v1.agregarPlazaGarage(pg2);
		v1.agregarPlazaGarage(pg3);
		v2.agregarPlazaGarage(pg4);
		v2.agregarPlazaGarage(pg5);


		// --------- ALTA ------------
		if (dao.anadirVivienda(v1))
			System.out.println("--- ALTA CORRECTA");
		if (dao.anadirVivienda(v2))
			System.out.println("--- ALTA CORRECTA");
		if (dao.anadirVivienda(v3))
			System.out.println("--- ALTA CORRECTA");

		// --------- LISTADO ------------
		System.out.println("--- LISTADO");
		ArrayList<Vivienda> lista = dao.listarViviendas();
		for (Vivienda v : lista) {
			System.out.println(v);
		}

	    // --------- ACTUALIZAR ------------
		v1.setTipo("PISO DE LUJO");
		v1.quitarPlazaGarage(pg1);
		v1.agregarPlazaGarage(pg6);
		if (dao.actualizarVivienda(v1))
			System.out.println("--- MODIFICACION CORRECTA");
		
		// --------- CONSULTA ------------
		System.out.println("--- CONSULTA");
		Vivienda v = dao.consultarVivienda(lista.get(0).getId_vivienda());
		if (v != null)
			System.out.println(v);

		// --------- BAJA ------------
		if (dao.borrarVivienda(lista.get(2).getId_vivienda()))
			System.out.println("--- BAJA CORRECTA");

	}

}