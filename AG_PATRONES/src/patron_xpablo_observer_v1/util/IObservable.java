package patron_xpablo_observer_v1.util;

public interface IObservable {
	boolean attach(IObserver observer);
	boolean detach(IObserver observer);
	void sendUpdates(IObservable subject); // Cannot use notify, as that is an existing method in the class Object
	String getName();
	boolean isCruel();
}
