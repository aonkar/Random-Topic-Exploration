package designpatterns.decorator;

public class Whip extends BeverageDecorator{

	Beverage beverage;
	
	public Whip(Beverage beverage){
		this.beverage = beverage;
	}
	
	@Override
	public int cost() {
		return beverage.cost() + 5;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " with Whip";
	}

}
