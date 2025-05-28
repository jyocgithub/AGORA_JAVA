package patron_xpablo_observer_v1.main;

import patron_xpablo_observer_v1.model.HeadOfState;
import patron_xpablo_observer_v1.model.HumanRightsWatch;
import patron_xpablo_observer_v1.util.IObservable;
import patron_xpablo_observer_v1.util.IObserver;

import java.util.ArrayList;
import java.util.List;



public class MainObserver {

	public static void main(String[] args) throws Exception {
		List<IObservable> allHeads = new ArrayList<IObservable>();
		allHeads.add(new HeadOfState("Hassan al Boom"));
		allHeads.add(new HeadOfState("Barack Obama"));
		allHeads.add(new HeadOfState("Mark Rutte"));
		allHeads.add(new HeadOfState("Angela Merkel"));
		allHeads.add(new HeadOfState("Mother Theresa"));
		
		IObserver observer = new HumanRightsWatch("Amnesty International");
		IObserver anotherObserver = new HumanRightsWatch("United Nations");
		IObserver yetAnotherObserver = new HumanRightsWatch("Partij voor de Dieren");
		
		for (IObservable subject: allHeads) {
			subject.attach(observer);
			subject.attach(anotherObserver);
		}
		
		Thread.sleep(15000);
		
		for (IObservable subject: allHeads) {
			subject.detach(observer);
			subject.detach(anotherObserver);
			subject.attach(yetAnotherObserver);
		}
		
		Thread.sleep(15000);
		
	}
}
