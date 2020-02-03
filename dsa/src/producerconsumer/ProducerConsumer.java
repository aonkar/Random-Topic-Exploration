package producerconsumer;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {

		ProducerConsumerDS pc = new ProducerConsumerDS();
		Thread producer = new Thread(pc::addElement);
		Thread consumer = new Thread(pc::getElement);
		Thread consumer2 = new Thread(pc::getElement);
		Thread consumer3 = new Thread(pc::getElement);
		Thread consumer4 = new Thread(pc::getElement);

		consumer.start();
		consumer2.start();
		consumer3.start();
		consumer4.start();
		
		Thread.sleep(10000);
		producer.start();
	}

}
