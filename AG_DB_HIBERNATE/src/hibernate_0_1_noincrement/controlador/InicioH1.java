package hibernate_0_1_noincrement.controlador;

import hibernate_0_1_noincrement.daos.EmpleadoDAO;
import hibernate_0_1_noincrement.pojos.Empleado;

import java.util.ArrayList;

public class InicioH1 {

	public static void main(String[] args) {


		EmpleadoDAO empleadodao = new EmpleadoDAO();

		Empleado e1 = new Empleado(21123, "Ana", "Alvarez");
		Empleado e2 = new Empleado(21321, "Natalia", "Nieves");
		Empleado e3 = new Empleado(21456, "Pepa", "Porras");

//		// // --------- ALTA ------------
//		if (empleadodao.anadirEmpleado(e1)) {
//			System.out.println("--- ALTA CORRECTA");
//		}
//		if (empleadodao.anadirEmpleado(e2)) {
//			System.out.println("--- ALTA CORRECTA");
//		}
//		if (empleadodao.anadirEmpleado(e3)) {
//			System.out.println("--- ALTA CORRECTA");
//		}

		 // --------- BAJA ------------
		 if (empleadodao.borrarEmpleado(6662)) {
		 System.out.println("--- BORRADO CORRECTA");
		 }

		// // --------- LISTADO ------------
		ArrayList<Empleado> lista = empleadodao.listarEmpleados();
		for (Empleado emp : lista) {
			System.out.println(emp.getNombre() + " " + emp.getApellidos());
		}
		//
		// --------- CONSULTA ------------
		Empleado emp = empleadodao.consultarEmpleado(344);
		if (emp != null) {
			System.out.println(emp.getNombre() + " - " + emp.getApellidos());
		}

		 // --------- ACTUALIZAR ------------
		 e1.setNombre("Eva Maria");
		 if (empleadodao.actualizarEmpleado(e1)) {
		 System.out.println("--- MODIFICACION CORRECTA");
		 }

	}

}