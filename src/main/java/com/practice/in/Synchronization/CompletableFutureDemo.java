package com.practice.in.Synchronization;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
	
	public static void main(String[]args){
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
			for(int i=0;i<10;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();

					e.printStackTrace();
				}
			}return "OK";
		});
		
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
		
			for(int i=0;i<10;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}return "OK";
		}).orTimeout(10, TimeUnit.MILLISECONDS).exceptionally((e)-> "Time out Exception Occured");
		CompletableFuture<Void> cf3 =  CompletableFuture.allOf(cf,cf1);
		CompletableFuture<String> cf4 = cf1.thenCombine(cf,(x,y)->x+y);
		CompletableFuture<String> cf5 = cf1.thenCompose(result->CompletableFuture.supplyAsync(()->result+" Arsh"));
		System.out.println(cf5.join());
		System.out.println(cf4.join());
		cf3.join();
		System.out.println(cf.join());
		try {
			System.out.println(cf1.get());
		} catch (InterruptedException | ExecutionException e) {
			Thread.currentThread().interrupt();

			e.printStackTrace();
		}
		
		System.out.println("Main is done");
	}
	

}
