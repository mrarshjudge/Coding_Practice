package com.practice.in.Synchronization;

import java.util.concurrent.CountDownLatch;

//Use CountDownLatch for Thread Coordination
public class CountDownLatchDemo {
	
	public static void main(String[]args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		MyCall thread1 = new MyCall("Worker-1",latch);
		MyCall thread2 = new MyCall("Worker-2",latch);
		MyCall thread3 = new MyCall("Worker-3",latch);
		
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		System.out.println("Main thread: All worker threads have finished.");

	
	}

}

class MyCall extends Thread{
	
	final CountDownLatch latch;
	
	MyCall(String name,CountDownLatch latch){
		super(name);
		this.latch = latch;
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("My Call is running by: "+Thread.currentThread().getName());
		}
		latch.countDown();
	}
}
