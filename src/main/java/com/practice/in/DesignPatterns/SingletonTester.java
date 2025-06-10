package com.practice.in.DesignPatterns;

//Singleton (Lazy and Eager)
 class Singleton{
	private static Singleton obj;   // this is lazy init , means create only when required.
	// private static singleton obj = new Singleton();     this is eager init
	
	private Singleton(){
		
	}
	public static Singleton getConfig() {
		if(obj==null) {
			synchronized (Singleton.class) {
				if(obj==null)
					obj = new Singleton();
			}
		}
		return obj;
	}
	
	
}

public class SingletonTester {
	public static void main(String[]args) {
		Singleton singleton = Singleton.getConfig();
		System.out.println(singleton);
		Singleton singleton1 = Singleton.getConfig();
		System.out.println(singleton1);
		Singleton singleton2 = Singleton.getConfig();
		System.out.println(singleton2);
		
	}
}
