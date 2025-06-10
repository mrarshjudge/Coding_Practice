package com.practice.in.Synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//CyclicBarrier for Barrier Tasks
public class CyclicBarrier_Barrier_Tasks {

	public static void main(String[]args) {
		Runnable barrierTask = ()->System.out.println("All Systems are up and running");
		CyclicBarrier barrier = new CyclicBarrier(3,barrierTask);
		
		Components database = new Components("Database",barrier);
		Components server = new Components("Server",barrier);
		Components browser = new Components("Browser",barrier);
		Thread databseThread = new Thread(database);
		Thread serverThread = new Thread(server);
		Thread browserThread = new Thread(browser);
		databseThread.start();
		serverThread.start();
		browserThread.start();
		
		
		
	}
}

class Components implements Runnable{
	String name;
	final CyclicBarrier barrier;
	public Components(String name,CyclicBarrier barrier) {
		this.name= name;
		this.barrier = barrier;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		System.out.println(name+" component is up and running!!");
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}