package domain;

public class Dog implements IObedient {
	private String name;
	private IBarking barkMethod;
	
	public Dog(String name, int numberOfBarks) {
		this.name = name;
		this.barkMethod = new BarkWoof(this, numberOfBarks);
	}

	public String getName() {
		return name;
	}
	
	public void getNervous() {
		barkMethod.bark();
	}
	public void getVeryNervous() {
		barkMethod.setNumberOfBarks(10);
		this.getNervous();
	}
	
	@Override
	public void shush() {
		System.out.println("Kai!");
	}
}