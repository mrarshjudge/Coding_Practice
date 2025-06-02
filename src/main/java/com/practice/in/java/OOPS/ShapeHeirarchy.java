package com.practice.in.java.OOPS;


abstract class Shape {
	private String color;
	
	 Shape(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}

	
	public void setColor(String c) {
		this.color = c;
	}
	public abstract double getArea();
	
}
 
 class Square extends Shape{
	 private int side;
	 
	 Square(int side, String color){
		 super(color);
		 this.side = side;
		 
	 }

	@Override
	public double getArea() {
		return side*side;
	}
	 
	
	public int getSide() {
		return this.side;
	}
	public void setSide(int side) {
		this.side = side;
	}

	
 }
 
 
 
 class Circle extends Shape{
	 private int radius;
	 
	 Circle(int radius, String color){
		 super(color);
		 this.radius = radius;
	}	
	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}
	public int getRadius() {
		return this.radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
 }
	 
 
class ShapeHeirarchy{
	public static void main(String[]args) {
		Shape s = new Square(5, "Red");
		Shape s1 = new Circle(12, "Blue");
		System.out.println(s.getArea());
		System.out.println(s1.getArea());
	}
	
}



