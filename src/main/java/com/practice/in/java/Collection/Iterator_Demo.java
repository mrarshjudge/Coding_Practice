package com.practice.in.java.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Remove Elements from List While Iterating (Iterator Demo)
public class Iterator_Demo {
	
	public static void main(String[]args) {
		List<String> list = new ArrayList<>(Arrays.asList("Apple","Apple","Mango","Apple","Peach","APPLE"));
	
		
		/*
		 * Iterator<String> it = list.iterator(); while(it.hasNext()) { String value =
		 * it.next(); if(value.equalsIgnoreCase("Apple")) it.remove(); }
		 * System.out.println(list);
		 */
		list.removeIf(i->i.equalsIgnoreCase("Apple"));
		 System.out.println(list);

		}
}

