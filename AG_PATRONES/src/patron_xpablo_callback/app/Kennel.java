package patron_xpablo_callback.app;

import domain.Dog;

public class Kennel {

	public static void main(String[] args) {
		Dog dog = new Dog("Fikkie", 4);
		System.out.println("A car drives by");
		dog.getNervous();
		System.out.println("Another car drives by");
		dog.getNervous();
		System.out.println("The children are making a lot of noise");
		dog.getNervous();
		dog.getVeryNervous();
		dog.getNervous();
		dog.getNervous();
	}

}
