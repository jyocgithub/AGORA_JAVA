package hibernate_1_1_noincrement_biidir_primarykeyjoin.controlador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import hibernate_1_1_noincrement_biidir_primarykeyjoin.daos.ViviendaDAO;
import hibernate_1_1_noincrement_biidir_primarykeyjoin.pojos.Direccion;
import hibernate_1_1_noincrement_biidir_primarykeyjoin.pojos.Vivienda;

/*
 * RELACION 1:1 NO INCREMENTAL
 * --------------------------------
 * USANDO @PrimaryKeyJoinColumn 
 *  - No necesita ninguna FK aunque no molesta que exista
 * USANDO @JOINCOLUMN
 *  - Si es unidireccional, necesita FK, de una tabla a otra
 *  - Si es bidireccional, necesita las 2 FK, de una tabla a otra y viceversa 
 *  
 *  La clase de prueba es valida en todos los casos no incrementales
 */
public class PruebaHibernate_1_1_Noincrement_todosloscasos {

	public static void main(String[] args) {

		try {
			// con estas lineas se puede ver en el log las consultas SQL que ejecuta Hibernate
			Logger log = Logger.getLogger("org.hibernate");
			log.setLevel(Level.SEVERE);

			ViviendaDAO viviendadao = new ViviendaDAO();

			// BORRAMOS TODO PARA PARTIR DE CERO
			System.out.println("Borrados :" + viviendadao.borrarTodo("VIVIENDA"));
			System.out.println("Borrados :" + viviendadao.borrarTodo("DIRECCION"));

			//			// CREAMOS UN PAR DE EJEMPLOS 
			Direccion d1 = new Direccion(1, "CALLE DEL PEZ 12");
			Vivienda v1 = new Vivienda(1, "CHALET", d1);
			Direccion d2 = new Direccion(33, "CALLE DEL BARRIO ANCHO 55");
			Vivienda v2 = new Vivienda(33, "PISO", d2);
			Direccion d3 = new Direccion(56, "CARRETERA CAPITAL, KM 23.2");
			Vivienda v3 = new Vivienda(56, "FINCA", d3);
			//
			//			// // --------- ALTA ------------
			//
			if (viviendadao.anadirVivienda(v1)) {
				System.out.println("--- ALTA CORRECTA");
			}
			if (viviendadao.anadirVivienda(v2)) {
				System.out.println("--- ALTA CORRECTA");
			}
			if (viviendadao.anadirVivienda(v3)) {
				System.out.println("--- ALTA CORRECTA");
			}
			//
			// --------- BAJA ------------
			// CUIDADO QUE EL ELEMENTO A BORRAR NO PUEDE BORRAR EN CASCADA EL OBJETO
			// REFERENCIADO SI EL OBJETO, ADEMAS, ESTA ADREFERENCIADO CON ALGUNA OTRO REGISTRO
			// EN ESTE CASO NO SE PUEDE BORRAR LA VIVIENDA 121 Y CON ELLA SU DIRECCION,
			// DIGAMOS LA 144, SI LA DIRECCION 144 ESTA ASOCIADA A ALGUNA OTRA VIVIENDA
			// ADEMAS, SE INTENTA BORRAR EL ELEMENTO v1 QUE HA DE TENER ASOCIADA LA DIRECCION CORRECTA, LA 144
			if (viviendadao.borrarVivienda(33)) {
				System.out.println("--- BAJA CORRECTA");
			}
			//
			//			// // --------- LISTADO ------------
			System.out.println("--- LISTADO");
			ArrayList<Vivienda> lista = viviendadao.listarViviendas();
			for (Vivienda v : lista) {
				System.out.println(v.getId_vivienda() + " ----- " + v.getTipo() + " -- " + v.getDireccion().getCalle());
			}
			//
			//			// --------- CONSULTA ------------
			System.out.println("--- CONSULTA");
			Vivienda v = viviendadao.consultarVivienda(1);
			if (v != null) {
				System.out.println(v.getId_vivienda() + " ----- " + v.getTipo());
			}
			//
			//			// // --------- ACTUALIZAR ------------
			Direccion d4 = new Direccion(1, "CALLE DEL PEZ DE LUJO 12");
			Vivienda v4 = new Vivienda(1, "CHALET DE LUJO", d4);
			if (viviendadao.actualizarVivienda(v4)) {
				System.out.println("--- MODIFICACION CORRECTA");
			}

		} catch (Exception e) {
			System.out.println("error... ================================== ");
			e.printStackTrace();
		}

	}
}