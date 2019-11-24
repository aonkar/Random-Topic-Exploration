package designpatterns.behavioral.observer;

public class DemoObserver implements Observer {

	private final Subject subject;

	DemoObserver(final Subject subject) {
		this.subject = subject;
	}

	void addObserver() {
		this.subject.addObserver(this);
	}

	@Override
	public void update(Object arg) {
		System.out.println("Update Method called : " + arg );
	}
	
	public void removeObserver() {
		this.subject.removeObserver(this);
	}

}
