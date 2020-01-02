package designpatterns.creational.builder;

public class Person {

	public String streetAddress, postCode, city;
	public String companyName, position;
	public int annualIncome;
	@Override
	public String toString() {
		return "Person [streetAddress=" + streetAddress + ", postCode=" + postCode + ", city=" + city + ", companyName="
				+ companyName + ", position=" + position + ", annualIncome=" + annualIncome + "]";
	}
	
	
}
