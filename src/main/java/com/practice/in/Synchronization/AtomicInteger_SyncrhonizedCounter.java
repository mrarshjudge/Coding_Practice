package com.practice.in.Synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger_SyncrhonizedCounter {
	static AtomicInteger atomicInt = new AtomicInteger();
	static int simpleVariable;
	public static void main(String[]args) {
		Thread t1 = new Thread(()->{
			for(int i =0;i<3;i++) {
				atomicInt.addAndGet(i);
				simpleVariable++;
			}
		});
		Thread t2 = new Thread(()->{
			for(int i =0;i<4;i++) {
				atomicInt.addAndGet(i);
				simpleVariable++;

			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(atomicInt);
		System.out.println(simpleVariable);
		
	}
}
