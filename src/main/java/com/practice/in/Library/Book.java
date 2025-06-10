package com.practice.in.Library;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private String title;
	private String author;
	private boolean isAvailable;
	
	
	
	public void borrowBook() {
		if(this.isAvailable()) {
			this.isAvailable=false;
			System.out.println("Book has been borrowed");
			
		}
		System.out.println("Sorry book is not available");
	}
	public void returnBook() {
		this.isAvailable= true;
		System.out.println("The book has been returned Thanks!!!! ");
	}
}
