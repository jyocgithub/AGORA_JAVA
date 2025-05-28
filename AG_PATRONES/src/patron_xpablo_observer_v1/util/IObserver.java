package patron_xpablo_observer_v1.util;

public interface IObserver {
	void update(IObservable subject);
	String getName();
}
