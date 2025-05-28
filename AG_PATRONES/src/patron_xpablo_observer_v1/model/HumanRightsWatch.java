package patron_xpablo_observer_v1.model;

import patron_xpablo_observer_v1.util.IObservable;
import patron_xpablo_observer_v1.util.IObserver;

public class HumanRightsWatch implements IObserver {
	private final String name;

	public HumanRightsWatch(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public synchronized void update(IObservable subject) {
		System.out.print(this.getName() + " says: ");
		System.out.print("Status of " + subject.getName() + " changed to");
		if (subject.isCruel()) {
			System.out.println(" cruel.");
		}
		else {
			System.out.println(" mild.");
		}
	}
}
