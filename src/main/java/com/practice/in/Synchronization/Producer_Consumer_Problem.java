package com.practice.in.Synchronization;

import java.util.ArrayDeque;
import java.util.Deque;


public class Producer_Consumer_Problem {
	public static void main(String[]args) {
		Loader load = new Loader(5);
		
		Thread producer = new Thread(()->{
			for(int i=0;i<30;i++)
				load.producer();
		},"Producer");
		
		Thread consumer = new Thread(()->{
			for(int i=0; i<30;i++)
				load.consumer();
		},"Consumer");
		producer.start();
		consumer.start();
	}
}

class Loader{
	
	private Deque<String> stack;
	private int capacity;
	
	public Loader(int capacity) {
		stack = new ArrayDeque<>(capacity);
		this.capacity = capacity;
	}
	
	public synchronized void producer() {
		while(stack.size()==capacity) {
			System.out.println("stack is already having values , So producer waiting "+Thread.currentThread().getName() );
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		stack.push("Value added");
		notify();
		try {
		    Thread.sleep(500); // simulate time taken to produce/consume
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		}
		
	}
	public synchronized void consumer() {
		while(stack.isEmpty()) {
			try {
				System.out.println("Dont have a value : so consumer waiting "+Thread.currentThread().getName() );
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		System.out.println("Value is consumed by consumer " +stack.pop());
		notify();	
		try {
		    Thread.sleep(500); // simulate time taken to produce/consume
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		}
	}
}

