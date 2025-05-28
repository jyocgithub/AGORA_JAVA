package domain;
	
public class BarkWoof implements IBarking {
	private IObedient dog;
	private int numberOfBarks;
	
	public BarkWoof(IObedient dog, int numberOfBarks) {
		this.dog = dog;
		this.numberOfBarks = numberOfBarks;
	}
	
	public int getNumberOfBarks() {
		return numberOfBarks;
	}

	public void setNumberOfBarks(int numberOfBarks) {
		this.numberOfBarks = numberOfBarks;
	}

	@Override
	public void bark() {
		if (numberOfBarks > 0) {
			System.out.print("Woof ");
			for (int i=1; i<numberOfBarks; i++) {
				System.out.print("woof ");
			}
			System.out.println();
			if (numberOfBarks >= 10 ) {
				dog.shush();
				numberOfBarks = 0;
			}
		}
		else {
			System.out.println("..... silence ......");
		}
	}
}