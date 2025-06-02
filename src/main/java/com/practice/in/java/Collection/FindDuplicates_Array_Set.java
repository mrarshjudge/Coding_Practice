package com.practice.in.java.Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

//Find Duplicates in an Array using Set
public class FindDuplicates_Array_Set {
	public static void main(String[]args) {
		int[]arr = {1,1,2,4,1,1,4,3,4,};
		Set<Integer>set = new HashSet<>();
		Set<Integer> duplicate = new HashSet<>();
		for(int i:arr) {
			if(set.contains(i)) duplicate.add(i);
			set.add(i);
		}
		
		System.out.println("Arsh "+duplicate);
		
		// Java 8 
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toMap(i->i, val->1,(val1,val2)->val1+val2)).entrySet().stream().filter(i->i.getValue()>1).map(Entry::getKey).collect(Collectors.toSet()));
	}
}