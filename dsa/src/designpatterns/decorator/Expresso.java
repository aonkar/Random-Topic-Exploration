package designpatterns.decorator;

public class Expresso extends Beverage{

	@Override
	public int cost() {
		return 20;
	}
	@Override
	public String getDescription() {
		return "Expresso";
	}

}
