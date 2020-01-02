package designpatterns.creational.builder;

public class PersonBuilder {

	protected Person person = new Person();

	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(person);
	}

	public PersonWorkBuilder works() {
		return new PersonWorkBuilder(person);
	}

	public Person build() {
		return person;
	}
}
