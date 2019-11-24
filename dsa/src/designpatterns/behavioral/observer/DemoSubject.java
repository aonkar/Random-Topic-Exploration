package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class DemoSubject implements Subject {

	List<Observer> observerList = new ArrayList<>();
	Integer currentValue = 0;

	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
		System.out.println("Added observer");
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
		System.out.println("removed observer");
	}

	@Override
	public void notifyObserver() {
		observerList.stream().forEach(observer -> observer.update(currentValue));

	}

	public void incrementNumber() {
		while (currentValue <= 100) {
			if (currentValue % 10 == 0) {
				this.notifyObserver();
			}
			currentValue++;
		}
	}

}
