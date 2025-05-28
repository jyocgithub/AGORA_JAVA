package varios;

/**
 *
 * @author IMS
 */
public class ArraysSinRepeticion {

	public static void main(String[] args) {

		int[] a = { 2, 5, 3, 4, 5, 6, 3, 4, 2, 3, 1, 2 };
		int contador = a.length;

		// calculamos el tamaño del array definitivo
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					contador--;
					break;
				}
			}
		}

		// rellenamos el array definitivo
		int[] b = new int[contador];
		b[0] = a[0];
		int index = 1;
		for (int i = 1; i < a.length; i++) {
			contador = 0;
			for (int j = 0; j <= index - 1; j++) {
				if (a[i] == b[j]) {
					contador++;
				}
			}
			if (contador < 1) {
				b[index] = a[i];
				index++;
			}
		}

		// pintar resultados
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);

		}

	}
}
