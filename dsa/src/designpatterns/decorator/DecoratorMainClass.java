package designpatterns.decorator;

public class DecoratorMainClass {

	public static void main(String[] args) {
		Beverage beverage = new Expresso();
		BuilderForDecorator decorator = new BuilderForDecorator(beverage);
		beverage = decorator.addMocha().addWhip().serveItem();
		System.out.println(beverage.getDescription() + " It Costs : " + beverage.cost());

	}

}
