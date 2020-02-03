package producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDS {

	private List<Integer> list = new ArrayList<>(10);

	public void addElement() {
		Integer count = 0;
		while (true) {

			synchronized (this) {
				while (this.list.size() == 10) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				list.add(count++);
				notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getElement() {
		while (true) {
			synchronized (this) {
				while (this.list.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(list.remove(0));
				notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
