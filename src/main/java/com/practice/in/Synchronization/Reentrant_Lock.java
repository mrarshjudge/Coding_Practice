package com.practice.in.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock and tryLock() Example
public class Reentrant_Lock {
	
	private final Lock lock = new ReentrantLock();
	
	public static void main(String[]args) {
		Reentrant_Lock rl = new Reentrant_Lock();
		Thread t = new Thread(()->{
				rl.printMe();
		});
		
		t.start();
		rl.printMe();
	}
	public void printMe() {
		if(lock.tryLock()){   //or lock.lock()   // but we dont need else as it will lock or wait for lock
			System.out.println("Entered in locking area: "+Thread.currentThread().getName() );
			try {
				System.out.println("Am Sleeping "+Thread.currentThread().getName());
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}else {
			System.out.print("Havenot recieved lock, so doing safe operations");
			for(int i=0;i<10;i++)System.out.println("Operating safe operations using "+Thread.currentThread().getName());
		}
	}
	
	
}
