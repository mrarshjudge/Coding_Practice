package com.practice.in.java.OOPS.Library;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Library {
	 private  List<Book> bookList = new ArrayList<>();
	 private  List<Member> memberList= new ArrayList<>();
	

		
	public void addBook(Book b) {
		this.bookList.add(b);
	}
	public void removeBook(Book b) {
		this.bookList.remove(b);
	}
	
	public void addMember(Member m) {
		memberList.add(m);
	}
	public boolean removeMember(Member m) {
		if(memberList.contains(m)){
			memberList.remove(m);
			return true;
		}
		return false;
	}
	public void displayBooks() {
		for(Book b:bookList) System.out.println(b);
	}
	
	
}
