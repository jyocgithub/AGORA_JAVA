package lauracripto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		/*
		 * Realizar un metodo que pida varias l�neas de texto por consola, las encripsta
		 * AES y guarde en un arraylist, y luego escriba el arraylist en consola Crear
		 * posteriormente n metodo que descentripte lso mensaje s del array y lso
		 * muestre
		 */

		List<byte[]> listaBytes = new ArrayList<>();

		System.out.println("Escriba mensajes por consola:");
		Scanner sc = new Scanner(System.in);

		int n = 0;
		
 		UtilCriptoSimetricosFile cr = new UtilCriptoSimetricosFile("AES");
		while (n < 5) {
			String texto = sc.nextLine();
			byte[] x = cr.cifrarString(texto);
			listaBytes.add(x);
			String pru2 = cr.descifrarString(x);
			String pru1 = cr.descifrarString(listaBytes.get(n));
			System.out.println(pru1);
			System.out.println(pru2);
			n++;
		}


		for(int i = 0; i<listaBytes.size();i++) {
			String texto= cr.descifrarString(listaBytes.get(i));
			System.out.println(texto);
		}
		
		

	}

}
