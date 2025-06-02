package com.practice.in.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Chaining Multiple Stream Operations
public class Chaining_Stream {
	
	public static void main(String[]args) {
		List<String> list = new ArrayList<String>(
				Arrays.asList("CApple","Java","Python","C++","CApple","CApple")
				);
		
		System.out.println(list.stream().filter(i->i.toLowerCase().startsWith("c"))
				.map(i->i.toLowerCase().concat(" String")).collect(Collectors.groupingBy(i->i,Collectors.counting())));
	}
}
