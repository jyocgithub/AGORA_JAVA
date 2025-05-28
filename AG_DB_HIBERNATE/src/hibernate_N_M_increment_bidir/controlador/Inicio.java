package hibernate_N_M_increment_bidir.controlador;

import hibernate_N_M_increment_bidir.daos.ViviendaDAO;
import hibernate_N_M_increment_bidir.pojos.Persona;
import hibernate_N_M_increment_bidir.pojos.Vivienda;

import java.util.ArrayList;

public class Inicio {

	public static void main(String[] args) {
		// Para ver en el log las consultas SQL que ejecuta Hibernate
//		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		ViviendaDAO dao = new ViviendaDAO();

		// BORRAMOS TODOS LOS REGISRTOS PREVIOS PARA PARTIR DE CERO
		System.out.println("Borrados :" + dao.borrarTodo("VIVIENDA"));
		System.out.println("Borrados :" + dao.borrarTodo("PERSONA"));

		// CREAMOS EJEMPLOS
		Persona p11 = new Persona("111111A", "Ana");
		Persona p12 = new Persona("222222b", "Eva");
		Persona p13 = new Persona("333333n", "Marta");
		Persona p21 = new Persona("444444n", "Maria");
		Persona p22 = new Persona("555555k", "Pepa");
		Persona p31 = new Persona("666666l", "Isabel");

		Vivienda v1 = new Vivienda("Piso");
		Vivienda v2 = new Vivienda("Atico");
		Vivienda v3 = new Vivienda("Entresuelo");

		v1.agregarPersona(p11);
		v1.agregarPersona(p12);
		v1.agregarPersona(p13);
		v2.agregarPersona(p21);
		v2.agregarPersona(p22);
		// no hace falta hacerlo todas las cosas en las dos direcciones pues cada metodo hace lo suyo
		// ambos permiten actualizar en ambas direcciones 
		p11.agregarVivienda(v3);
		p31.agregarVivienda(v3);

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
		v1.quitarPersona(p11);
		v1.agregarPersona(p21);
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

		// --------- LISTADO ------------
		System.out.println("--- LISTADO");
		ArrayList<Vivienda> lista1 = dao.listarViviendas();
		for (Vivienda vV : lista1) {
			System.out.println(vV);
		}
	}

}
