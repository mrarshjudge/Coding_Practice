package com.practice.in.DesignPatterns;

import lombok.ToString;

//Decorator Pattern for Adding Features
public class Decorator_Pattern {
	public static void main(String[]args) {
		Decorator d = new FloorDecorator("Floor Decorator");
		Decorator d1 = new RoofDecorator(d);
		System.out.println(d);
		System.out.println(d1);
	}
}


interface Decorator {
	String getDescription();
}

@ToString
class FloorDecorator implements Decorator{

	String name;
	
	public FloorDecorator(String name) {
		this.name = name;
	}
	
	@Override
	public String getDescription() {
		return name;
	}
	
}

@ToString
class RoofDecorator implements Decorator{
	
	Decorator decorator;
	
	RoofDecorator(Decorator decorator) {
		this.decorator = decorator;

	}
	
	@Override
	public String getDescription() {
		return this.decorator.getDescription() +" Roof Decorator";
	}
	
}