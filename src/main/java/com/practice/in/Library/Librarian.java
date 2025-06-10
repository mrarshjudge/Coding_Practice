package com.practice.in.Library;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {
	private int id;
	private String name;
	

	public void addBook(Library l,Book book) {
		l.addBook(book);
	}
	public void removeBook(Library l,Book book) {
		l.removeBook(book);
	}
	
}
