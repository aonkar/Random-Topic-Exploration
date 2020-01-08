package designpatterns.command;

public class LightsOn implements Command {

	Light light;

	public LightsOn(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

}
