package com.practice.in.Synchronization;

//ThreadLocal Example
public class ThreadLocal_Demo extends Thread {
	
	String transactionId;
	static final ThreadLocal<String> local = ThreadLocal.withInitial(()->"Default Value");
	public static void main(String[]args) {
		ThreadLocal_Demo tld1 = new ThreadLocal_Demo();
		ThreadLocal_Demo tld2 = new ThreadLocal_Demo();
		ThreadLocal_Demo tld3 = new ThreadLocal_Demo();
		tld1.start();
		tld2.start();
		tld3.start();
	}
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		local.set("Value Changed "+ Thread.currentThread().getName());

		System.out.println(Thread.currentThread().getName() +" "+local.get());
	}
}
