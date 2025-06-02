package com.practice.in.java.Collection;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//Sort a HashMap by Values
public class SortMapValues {
	
	public static void main(String[]args) {
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Deep");
		map.put(2, "Singh");
		map.put(3, "Arsh");
		
		
		List<Entry<Integer,String>> list =map.entrySet().stream().collect(Collectors.toList());		
		Collections.sort(list,(a,b)-> a.getValue().compareTo(b.getValue()));
		
		Map<Integer,String> resultMap = new LinkedHashMap<>();
		for(Entry<Integer, String> entry : list) {
			resultMap.put(entry.getKey(),entry.getValue());
		}
		System.out.println(resultMap);
		
		
		// Java 8 
		
		Map<Integer, String>result=map.entrySet().
						stream().
								sorted(Comparator.comparing(Entry<Integer,String>::getValue).reversed())
								.collect(Collectors.toMap
										(Entry::getKey,Entry::getValue,(e1,e2)->e1,LinkedHashMap<Integer, String>::new));
		System.out.println(result);
		
	}
	

}
