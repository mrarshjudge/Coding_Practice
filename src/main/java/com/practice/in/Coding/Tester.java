package com.practice.in.Coding;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[]args) {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("mango");
		list.add("kiwi");
		list.add("berry");
		list.add("fig");
		
		// Using contains method 
		System.out.println(list.stream().filter(str->str.contains("a")).map(String::toUpperCase).toList());
		
		
		// Using regex pattern
		System.out.println(list.stream().filter(str->str.matches(".+a.*")).map(String::toUpperCase).toList());
		System.out.println(list.stream().filter(str->str.matches(".*a.*")).map(String::toUpperCase).toList());
		

	}
}





/*You are given an ArrayList<String> containing names of fruits. Write a Java method that iterates through the list, and if a fruit name contains the letter "a" (case-insensitive), convert that fruit name to uppercase. Finally, return the updated list.
RS
Raman Singh7:07am["apple", "mango", "kiwi", "berry", "fig"]
RS
Raman Singh7:07am["APPLE", "MANGO", "kiwi", "berry", "fig"]
RS
Raman Singh
*/