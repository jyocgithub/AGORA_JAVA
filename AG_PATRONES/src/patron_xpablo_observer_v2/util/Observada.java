package patron_xpablo_observer_v2.util;

import java.util.HashSet;
import java.util.Set;

public abstract class Observada {
	private Set<IObservador> observers;
	private boolean changed;
	
	public Observada() {
		observers = new HashSet<>();
		changed = false;
	}
	
	public boolean addObserver(IObservador o) {
		return observers.add(o);
	}

	public boolean deleteObserver(IObservador o) {
		return observers.remove(o);
	}

	public void notifyObservers() {
		notifyObservers(null);
	}

	public void notifyObservers(Object arg) {
		if (hasChanged()) {
			for (IObservador observer: observers) {
				observer.update(this, arg);
			}
			clearChanged();
		}
	}

	public void deleteObservers() {
		observers.clear();
	}

	protected void setChanged() {
		changed = true;
	}

	protected void clearChanged() {
		changed = false;
	}

	public boolean hasChanged() {
		return changed;
	}

	public int countObservers() {
		return observers.size();
	}
}
