package designpatterns.behavioral.observer;

public class MainClass {

	public static void main(String[] args) {
		DemoSubject subject = new DemoSubject();
		DemoObserver observer = new DemoObserver(subject);
		observer.addObserver();
		subject.incrementNumber();
		observer.removeObserver();
	}

}
