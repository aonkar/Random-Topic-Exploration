package designpatterns.creational.prototype;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		SerializableClass sc = new SerializableClass();
		sc.setCompany("Deloitte");
		sc.setEmailId("aonkar@deloitte.com");
		sc.setName("Abhishek");

		FileOutputStream file = new FileOutputStream("serializable.txt");
		try (ObjectOutputStream output = new ObjectOutputStream(file)) {
			output.writeObject(sc);
		}

		FileInputStream fileInput = new FileInputStream("serializable.txt");
		try (ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
			SerializableClass sc2 = (SerializableClass) objectInput.readObject();
			System.out.println(sc2);
			System.out.println(sc == sc2);
		}
	}

}
