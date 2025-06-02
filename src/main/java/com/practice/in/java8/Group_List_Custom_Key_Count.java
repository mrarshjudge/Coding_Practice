package com.practice.in.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Group List by Custom Key and Count
public class Group_List_Custom_Key_Count {
	
	public static void main(String[]args) {
		List<String> list = Arrays.asList("Apple","Apple","Apple","VIVO","Apple","Apple","VIVO","Samsung","Apple","Eamsung","Samsung");
		
		System.out.println(list.stream().collect(Collectors.groupingBy(i->i.toLowerCase().matches("^[aeiou].*")?"Vowel":"Consonant",Collectors.counting())));
		System.out.println(list.stream().collect(Collectors.groupingBy(i->i.toLowerCase(),Collectors.counting())));
		System.out.println(list.stream().collect(Collectors.groupingBy(i->i.toLowerCase(),Collectors.partitioningBy(i->i.endsWith("ple"),Collectors.counting()))));
		
		
		// so create custom keys using i->i.startswith, endswith, vowel check , charAt ,lenght etc 
		
	}
}
