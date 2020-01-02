package designpatterns.creational.builder;

public class PersonWorkBuilder extends PersonBuilder {

	PersonWorkBuilder(Person person) {
		this.person = person;
	}

	PersonWorkBuilder at(String companyName) {
		person.companyName = companyName;
		return this;
	}

	PersonWorkBuilder as(String position) {
		person.position = position;
		return this;
	}
}
