package com.practice.in.java.OOPS.Library;

import java.util.Date;

import lombok.Data;

@Data
public class Transaction {
	private Book book;
	private Member member;
	private Date date;
	private String type;
	
	public Transaction(Book book, Member member, Date date) {
		super();
		this.book = book;
		this.member = member;
		this.date = date;
	}
	 public void execute() {
	        if (type.equals("borrow")) {
	            member.borrowBook(book);
	        } else if (type.equals("return")) {
	            member.returnBook(book);
	        }
	    }
	
	 public static void main(String[]args) {
		 
		        // Create library
		        Library library = new Library();

		        // Create librarian
		        Librarian librarian = new Librarian(101,"Alice");

		        // Create books
		        Book book1 = new Book("Effective Java", "Joshua Bloch",true);
		        Book book2 = new Book("Clean Code", "Robert C. Martin",true);

		        // Librarian adds books
		        librarian.addBook(library, book1);
		        librarian.addBook(library, book2);

		        // Create member
		        Member member = new Member("John", 1);
		        library.addMember(member);

		        // Member borrows a book
		        member.borrowBook(book1);

		        // View available books
		        System.out.println("Available books:");
		       
		        // Member returns the book
		        member.returnBook(book1);

		        // View available books again
		        System.out.println("Available books after return:");
		        
	 }

}
