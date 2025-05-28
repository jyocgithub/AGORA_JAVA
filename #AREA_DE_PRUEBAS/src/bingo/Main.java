package bingo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] cartonArray = { { 2, 0, 24, 35, 46, 0, 0, 0, 86 }, { 0, 0, 0, 37, 0, 51, 61, 73, 88 },
				{ 9, 11, 0, 0, 47, 0, 68, 75, 0 } };
		Carton carton = new Carton(cartonArray);

		if (carton.esValido(cartonArray) == true) {
			System.out.println("Es valido");
		}
		carton.pintarCarton();

		boolean cantaronlinea = false;
		boolean seguir = true;
		while (seguir) {

			System.out.println("di un numero");
			int num = sc.nextInt();
			carton.tacharNumero(num);

			System.out.println("ELLLL " + num + " !!!!!!");

			if (!cantaronlinea) {
				if (carton.hayLinea()) {
					System.out.println("LINEAAAAA");
					cantaronlinea = true;
				}
			}

			if (carton.hayBingo()) {
				System.out.println("BINGOOOOOO");
				seguir = false;
			}

			carton.pintarCarton();

		}
		System.out.println("FFFFIIINNNN");

	}
}
