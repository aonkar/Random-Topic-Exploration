package designpatterns.decorator;

public class BuilderForDecorator {
	
	Beverage beverage;
	
	BuilderForDecorator(Beverage beverage){
		this.beverage = beverage;
	}
	public BuilderForDecorator addMocha() {
		this.beverage = new Mocha(this.beverage);
		return this;
	}
	
	public BuilderForDecorator addWhip() {
		this.beverage = new Whip(this.beverage);
		return this;
	}
	
	public Beverage serveItem() {
		return this.beverage;
	}
}
