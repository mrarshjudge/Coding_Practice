package com.pracitce.in.advance.java;

//Static Block Execution Order
public class Static_Block_Execution {
	static int ab = 10;
	int total;
	static{
		System.out.println("initializing static block ");
		System.out.println("Database properties are added");
		System.out.println("Network properties are added");
		System.out.println("Configurations are ready and done!!!");
		
		
	}
	public static void main(String[]args) {
		System.out.println("Started Execution of main block");
		Static_Block_Execution.print();
		System.out.println("Main is done!!!");
		Static_Block_Execution sb = new Static_Block_Execution();
		// so the static flow will be done one time  but instance will run for all  objects
		sb.printInstanceMethod();
		Static_Block_Execution sb1 = new Static_Block_Execution();
		sb1.printInstanceMethod();
		
	}
	public static  void print() {
		System.out.println("Static method print");
		System.out.println("Static value: "+ab);
	}
	public void printInstanceMethod() {
		System.out.println("Started Instance method ");
		System.out.println(total+" value of instance variable");
		System.out.println("Instance area is done");
	}
}
