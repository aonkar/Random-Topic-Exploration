package designpatterns.creational.builder;

public class BuilderDemoClass {

	public static void main(String[] args) {
		Person person = new PersonBuilder()
				.lives().at("K.R Puram").in("Bangalore").withPostCode("560036")
				.works().at("Deloitte").as("Consultant").build();
		System.out.println(person);
	}

}
