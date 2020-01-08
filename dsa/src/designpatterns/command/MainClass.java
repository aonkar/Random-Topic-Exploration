package designpatterns.command;

public class MainClass {

	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
		Light light = new Light();
		LightsOn lightsOn = new LightsOn(light);
		remoteControl.setCommand(lightsOn);
		remoteControl.buttonPressed();
	}
}
