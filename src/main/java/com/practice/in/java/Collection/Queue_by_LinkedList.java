package com.practice.in.java.Collection;

import java.util.LinkedList;


//Use LinkedList to Implement a Queue
public class Queue_by_LinkedList {
	
	public static void main(String[]args) {
		ProductQueue productQueue = new ProductQueue();
		productQueue.enQueue("Apple");
		productQueue.enQueue("Samsung");
		productQueue.enQueue("OPPO");
		productQueue.enQueue("VIVO");
		
		System.out.println(productQueue);
		System.out.println(productQueue.deQueue());
		System.out.println(productQueue.deQueue());
		System.out.println(productQueue.deQueue());
		System.out.println(productQueue.deQueue());
		
	}
}

class ProductQueue {
	
	private LinkedList<String> list = new LinkedList<>();
	
	public void enQueue(String product) {
		 list.addLast(product);
	}
	
	public String deQueue() {
		return list.removeFirst();
	}
	
	public String toString() {
		return list.toString();
	}
}
