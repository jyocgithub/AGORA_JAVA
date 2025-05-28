import java.util.Scanner;

public class MenuOperacionesSimples {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);		     
		int n1=0;
		int n2=0;
		double r=0.0;
		int operacion;

		System.out.println("ESCRIBE EL PRIMER NUMERO ");
		n1 =sc.nextInt();
		System.out.println("ESCRIBE EL SEGUNDO NUMERO ");
		n2 =sc.nextInt();
		System.out.println("Indica la operacion a realizar");
		System.out.println("1 Suma");
		System.out.println("2 Resta");
		System.out.println("3 Multiplicacion");
		System.out.println("4 Division");
	
		operacion = sc.nextInt();
		switch(operacion)
		{
		case 1:
			r=n1+n2;
			System.out.println("LA SUMA ES "+ r);
			break;

		case 2:
			r=n1-n2;
			System.out.println("LA RESTA ES "+ r);
			break;

		case 3:
			r=n1*n2;
			System.out.println("LA MULTIPLICACION ES "+ r);
			break;

		case 4:
			r=((double)n1)/n2;
					
			// fijarse que no vale la opcion
			// 		r= n1 /n2;
			// pues al dividir dos enteros, el resultado es entero, 
			// con lo que no nos da nunuca decimales (probar a dividir 20 entre 3)
			// por eso hemos de convertir alguno de los operandos en double 
			// para que el resultado de la operacion sea double
			// el cast se puede hacer de otra manera tambien:
			//		r= (n1 * 1.0) /n2;	
			
			System.out.println("LA DIVISION ES "+ r);
			
			// Si queremos que el resultado salga redondeado a solo 3 decimales,
			// podemos usar un printf:
			// 		System.out.printf("%8.3f", r );
			
			break;

		default:
			System.out.println("Error al introducir la operacion");
			break;
		}

	}

}
