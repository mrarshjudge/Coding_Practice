package com.practice.in.Synchronization;

//Volatile Keyword Use Case
public class Volatile_Keyword extends Thread{
	
	 boolean flag;
	String sessionId;
	
	public static void main(String[]args) {
		Volatile_Keyword demo = new Volatile_Keyword();
		Thread writer = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            	Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            demo.flag = true;
            System.out.println("Writer thread set flag to true");
        });

        Thread reader = new Thread(() -> {
            System.out.println("Reader thread waiting for flag...");
            while (!demo.flag) {
                
            }
            System.out.println("Reader thread detected flag change!");
        });

        reader.start();
        writer.start();
    }
}


