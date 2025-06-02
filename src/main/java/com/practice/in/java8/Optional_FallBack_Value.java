package com.practice.in.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Optional Usage with Fallback Value
public class Optional_FallBack_Value {

	public static void main(String[]args) {
		List<String> strList = Arrays.asList("HP","Java","DIP",null,null,"DIE");
		
		System.out.println(strList.stream().map(i->Optional.ofNullable(i).orElse("FallBack Value")).collect(Collectors.toList()));
		
		
		Optional<String> result = strList.stream().filter(i->i.contains("P")).findFirst();
		System.out.println(result.orElse("FallBack"));
		
	}
}
