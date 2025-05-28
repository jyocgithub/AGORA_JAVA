package patron_xpablo_nestedClasses;

public class Dog {
	private String name;
	private IBarking barkMethod;
	private int numberOfBarks;
	
	public Dog(String name, int numberOfBarks) {
		this.name = name;
		this.barkMethod = new Dog.BarkWoof();
		this.numberOfBarks = numberOfBarks;
	}

	public String getName() {
		return name;
	}
	
	public void getNervous() {
		barkMethod.bark();
	}

	
	public int getNumberOfBarks() {
		return numberOfBarks;
	}

	private final class BarkWoof implements IBarking {
		@Override
		public void bark() {
			System.out.print("Woof ");
			for (int i=1; i<Dog.this.getNumberOfBarks(); i++) {
				System.out.print("woof ");
			}
			System.out.println();
		}
	}
}