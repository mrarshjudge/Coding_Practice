package com.practice.in.java.Collection;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Find Union and Intersection of Two Arrays
public class Union_InterSection_Arrays {
	public static void main(String[]args) {
		int[] a = {1,2,5,6};
		int []b  = {1,2,12,14,6};
		
		//Union
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		set.addAll(Arrays.stream(b).boxed().collect(Collectors.toSet()));
		System.out.println("Union "+Arrays.toString(set.toArray()));
		
		//Intersection
		Set<Integer> set1 =Arrays.stream(a).boxed().collect(Collectors.toSet());
		List<Integer> list = Arrays.stream(b).boxed().filter(set1::contains).toList();
		System.out.println("Intersection "+Arrays.toString(list.toArray()));
		
	}
}
