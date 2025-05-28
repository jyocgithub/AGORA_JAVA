package streams2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("52886326b", "Pepe");
		Cliente c2 = new Cliente("52886326c", "Ana");
		Cliente c3 = new Cliente("33654566b", "Eva");
		Cliente c4 = new Cliente("46464564g", "Pedro");
		Cliente c5 = new Cliente("88787777j", "Carmen");

		List<Cliente> clientes1 = new ArrayList<>();
		clientes1.add(c1);
		clientes1.add(c2);

		List<Cliente> clientes2 = new ArrayList<>();
		clientes2.add(c3);
		clientes2.add(c4);

		List<Cliente> clientes3 = new ArrayList<>();
		clientes3.add(c5);

		Cuenta cu1 = new Cuenta(543545, clientes1, 2000);
		Cuenta cu2 = new Cuenta(454545, clientes2, 1000);
		Cuenta cu3 = new Cuenta(987787, clientes3, 200);

		List<Cuenta> cuentas = new ArrayList<>();
		cuentas.add(cu1);
		cuentas.add(cu2);
		cuentas.add(cu3);

		Banco b1 = new Banco("BBVA", cuentas);

		// Consultar los numeros de cuenta de las cuentas del banco
		List<Cuenta> lascuentas = b1.getCuentas();
		Stream<Cuenta> stream1 = lascuentas.stream();
		stream1.forEach(c -> System.out.println(c.getN_cuenta()));
		System.out.println("---------------------------------------------");

		// ----- EXTRAER DATOS SIMPLES ----------------------------------- CON MAP
		// Otra manera de sacar los numeros de cuenta, ahora con map()
		stream1 = lascuentas.stream();
		Stream<Integer> stream2 = stream1.map(cc -> cc.getN_cuenta());
		stream2.forEach(System.out::println);   // otra forma de indicar al forEach el labmda de un syso
		System.out.println("---------------------------------------------");

		// Obtener saldo
		stream1 = lascuentas.stream();
		Stream<Double> stream3 = stream1.map(cc -> cc.getSaldo());
		stream3.forEach(System.out::println);
		System.out.println("---------------------------------------------");

		// ----- EXTRAER DATOS DE LISTAS INTERNAR ------------------------ CON FLATMAP
		// Obtener Clientes
		stream1 = lascuentas.stream();
		Stream<Cliente> stream4 = stream1.flatMap(cc -> cc.getClientes().stream());
		stream4.forEach(System.out::println);
		System.out.println("---------------------------------------------");

		// Cuentas con saldo mayor de 500, aplicando filter y luego foreach
		stream1 = lascuentas.stream();
		Predicate<Cuenta> p1 = (Cuenta p) -> p.getSaldo() > 500;
		Stream<Cuenta> stream5 = stream1.filter(p1);
		stream5.forEach(System.out::println);
		System.out.println("---------------------------------------------");

		// ----- FILTRAR DATOS   ------------------------------------------ CON FILTER
		// igual que antes, pero aplicando filter y luego foreach encadenados el la misma instrucción
		stream1 = lascuentas.stream();
		Predicate<Cuenta> p2 = (Cuenta p) -> p.getSaldo() > 500;
		stream1.filter(p2).forEach(System.out::println);
		System.out.println("---------------------------------------------");


		// ----- ORDENAR DATOS   ------------------------------------------ CON SORTED
		stream1 = lascuentas.stream();
		Stream<Double> stream6 = stream1.map(cc -> cc.getSaldo()).filter(dd -> dd > 500);
//		Stream<Double>stream7= stream6.sorted( (  comp1,  comp2) -> (int)(comp1-comp2));
//		Stream<Double>stream7= stream6.sorted( (  comp1,  comp2) -> comp1.compareTo(comp2) );
		Stream<Double>stream7= stream6.sorted();
		stream7.forEach(System.out::println);
		System.out.println("---------------------------------------------");

		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(33);
		lista.add(76);
		lista.add(4);
		lista.add(12);

//		IntStream strInt1 = lista.stream();


	}

}
