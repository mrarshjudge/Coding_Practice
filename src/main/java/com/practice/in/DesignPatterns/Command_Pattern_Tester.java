package com.practice.in.DesignPatterns;
//Command Pattern for Task Execution
public class Command_Pattern_Tester {
	public static void main(String[]args) {
		Light light= new Light();
		
		Command com1 = new LightOnCommand(light);
		Command com2 = new LightOffCommand(light);
		
		ExecutorTask task = new ExecutorTask(com1);
		task.pressButton();
		ExecutorTask task1 = new ExecutorTask(com2);
		task1.pressButton();
	}
}


interface Command{
	void execute();
}

class Light {
	void on() {System.out.println("Light On!!!");}
	void off() {System.out.println("Light off!!!");}
}

class LightOnCommand implements Command{
	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	@Override
	public void execute() {
		light.on();
	}
	
}
class LightOffCommand implements Command{
	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	@Override
	public void execute() {
		light.off();
	}
	
}

class ExecutorTask{
	Command command;
	
	ExecutorTask(Command command){
		this.command = command;
	}
	public void pressButton() {
		command.execute();
	}
}