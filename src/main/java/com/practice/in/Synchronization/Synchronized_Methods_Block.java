package com.practice.in.Synchronization;


//Use of synchronized Method and Block
public class Synchronized_Methods_Block {

	public static void main(String[]args) {
		Synchronized_Methods_Block sb = new Synchronized_Methods_Block();
		Thread t = new Thread() {			
			public void run() {
				sb.block();
				sb.printMe();
			}
		};
		
		
		Runnable r =()->{
			sb.block();
			sb.printMe();
		};
		Thread t1 = new Thread(r);
		t.setName("Thread creation");
		t1.setName("Runnable Creation");
		t.start();
		t1.start();
	}
	
	public synchronized void printMe() {
		System.out.println("This is a method Synchronized "+Thread.currentThread().getName());
	}
	
	public void block() {
		System.out.println("Entered in the method");
		for(int i=0;i<10;i++) System.out.println("For Loop "+i);
		
		synchronized(this) {
			System.out.println("Print line 1 by one "+Thread.currentThread().getName());
			System.out.println("Printed");
			System.out.println("End here");
		}
	}
}
