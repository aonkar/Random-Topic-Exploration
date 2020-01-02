package designpatterns.decorator;

public class Mocha extends BeverageDecorator{

	Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	@Override
	public int cost() {
		return beverage.cost() + 10;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " with Mocha";
	}

}
