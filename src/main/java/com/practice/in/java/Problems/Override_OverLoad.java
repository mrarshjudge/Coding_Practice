package com.practice.in.java.Problems;

public class Override_OverLoad {
	public static void main(String[]args) {
		Parent p = new Parent();
		Child c = new Child();
		Parent p1 = new Child();
		System.out.println(c +" "+p);
		
		p1.print();
		p1.print(13);
	}
}


class Parent{
	
	public void print() {
		for(int i=0;i<10;i++) {
			System.out.println("Parent Printing "+i);
		}
	}
	public void print(int n) {
		for(int i=0;i<n;i++) {
			System.out.println("Parent Printing "+i);
		}
	}
}

class Child extends Parent{
	
	@Override
	 public void print() {
		for(int i=0;i<10;i++) {
			System.out.println("Child printing"+i);
		}
	}
	public void print(String s) {
		for(char c : s.toCharArray()) {
			System.out.println("Child class overloaded "+c);
		}
	}
}
