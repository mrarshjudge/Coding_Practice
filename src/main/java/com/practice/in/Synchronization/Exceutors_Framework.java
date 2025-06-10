package com.practice.in.Synchronization;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Exceutors_Framework {
	
	public static void main(String[]args) {
		
		 fixedThreadPool(3);
		 singleThread();
		 sheduledThreadPool(3);
		 
	}
	
	public static void fixedThreadPool(int size) {
		ExecutorService service = Executors.newFixedThreadPool(size);
		
		try{
			for( int i=0;i<10;i++) {
				final int b =i;
				System.out.println(service.submit(()->{
					System.out.println(Thread.currentThread().getName());
					return Math.multiplyExact(b,b);
					
				}).get());
			}
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		finally {
			service.shutdown();
		}
	}
	
	public static void singleThread() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		try{
			for( int i=0;i<10;i++) {
				final int b =i;
				System.out.println(service.submit(()->{
					System.out.println(Thread.currentThread().getName());
					return Math.multiplyExact(b,b);
					
				}).get());
			}
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		finally {
			service.shutdown();
		}
	}
	
	public static void sheduledThreadPool(int size) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
		
		service.schedule(()->System.out.println("Running one time at a certain time"),100,TimeUnit.MILLISECONDS);
		
		service.scheduleAtFixedRate(()->System.out.println("Running continously "),1000,100,TimeUnit.MILLISECONDS);
		
		service.schedule(()->service.shutdown(),10000,TimeUnit.MILLISECONDS);
		
	}
	
}
