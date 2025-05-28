
import java.util.Random;

public class Bonoloto {

	public static void main(String[] args) {

		int [] a = new int [6];
		Random rnd = new Random();
		boolean existia;
		int nuevo;
		
		int c=0;
		
		while(c<6)	{

			nuevo = (rnd.nextInt(49) + 1);
			existia= false;
			for (int k=0; k<=c; k++){
				if (a[k]==nuevo) {
					existia=true;
				}
			}
			if (!existia){
				a[c] = nuevo;
				System.out.println(a[c]);
				c++;
			}
		}
	}

}
