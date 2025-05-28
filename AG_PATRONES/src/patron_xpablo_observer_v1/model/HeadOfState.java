package patron_xpablo_observer_v1.model;

import patron_xpablo_observer_v1.util.IObservable;
import patron_xpablo_observer_v1.util.IObserver;

import java.util.ArrayList;
import java.util.List;
public class HeadOfState implements IObservable {
	private Thread innerThread;
	private boolean cruel;
	private String name;
	List<IObserver> observers;

	public HeadOfState(String name) {
		observers = new ArrayList<IObserver>();
		this.cruel = false;
		this.name = name;
		Runnable r = new Runnable() {
			public void run() {
				doWork();
			}
		};
		innerThread = new Thread(r);
		innerThread.start();
	}
	

	public boolean isCruel() {
		return cruel;
	}

	public synchronized void setCruel(boolean cruel) {
		boolean oldStatus = this.cruel;
		this.cruel = cruel;
		if (oldStatus != cruel) {
			sendUpdates(this);
		}
	}

	@Override
	public boolean attach(IObserver observer) {
		boolean present = false;
		for (IObserver presentObserver: observers) {
			if (presentObserver == observer) {
				present = true;
			}
		}
		if (!present) {
			observers.add(observer);
			System.out.println("Attached " + observer.getName() + " to " + this.getName());
		}
		// Mmmm, this looks suspicious.....
		return !present;
	}

	@Override
	public boolean detach(IObserver observer) {
		boolean present = observers.remove(observer);
		if (present) {
			System.out.println("Detached " + observer.getName() + " from " + this.getName());
		}
		return present;
	}

	@Override
	public void sendUpdates(IObservable subject) {
		for (IObserver presentObserver: observers) {
			presentObserver.update(this);
		}
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	private void doWork() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Math.random() > 0.85) {
				this.setCruel(true);
			}
			else {
				this.setCruel(false);
			}
		}
	}
}
