package com.practice.in.java.Collection;

import java.util.ArrayDeque;
import java.util.Deque;


//Stack Operations using Deque
public class Stack_Using_Dequeue {
	public static void main(String[]args) {
		ProductStack ps = new ProductStack();
		ps.push("Apple");
		ps.push("Samsung");
		ps.push("OPPO");
		ps.push("VIVO");
		System.out.println(ps.toString());
		System.out.println(ps.pop());
		System.out.println(ps.pop());
		System.out.println(ps.pop());
		System.out.println(ps.pop());
		
	}
	
}

class ProductStack {
	private Deque<String> deq = new ArrayDeque<>();
	
	public void push(String product) {
		deq.addLast(product);
	}
	public String pop() {
		return deq.removeLast();
	}
	
	public String peek() {
		return deq.peekLast();
	}
	
	@Override
	public String toString() {
		return deq.toString();
	}
}