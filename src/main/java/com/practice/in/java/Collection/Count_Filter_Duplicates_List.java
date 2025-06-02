package com.practice.in.java.Collection;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Count_Filter_Duplicates_List {
	public static void main(String[]args) {

		// To count &  filter the duplicates 
		
		List<String> list1 = List.of("Banana","Peach","Apple","Banana","Apple");
		
		System.out.println(list1.stream().collect(Collectors.toMap
							(str->str,
							val->1,
							(val1,val2)->val1+val2)).entrySet().stream().filter(i->i.getValue()>1).collect
							(Collectors.toMap(Entry::getKey, Entry::getValue)));
	}
}
