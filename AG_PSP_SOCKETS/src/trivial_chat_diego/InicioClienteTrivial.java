import java.util.Scanner;

public class InicioClienteTrivial {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre :");
		String nombre = sc.nextLine();

		ClienteTrivial ct = new ClienteTrivial(nombre);

	}
}
