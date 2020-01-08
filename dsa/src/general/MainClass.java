package general;

public class MainClass {

	public static void main(String[] args) {
		Thread t1 = new Thread(()-> {
			while(true) {
			}
		});
		t1.setName("Abhi");
		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
