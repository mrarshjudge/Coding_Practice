package com.practice.in.java.OOPS.Library;

import java.util.List;

import lombok.Data;

@Data
public class Member {
	private String name;
	private int id;
	private List<Book> bookList;
	
	public Member(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public void borrowBook(Book b) {
		b.borrowBook();
		bookList.add(b);
	}
	public void returnBook(Book b) {
		b.returnBook();
		bookList.remove(b);
	}
	
}
