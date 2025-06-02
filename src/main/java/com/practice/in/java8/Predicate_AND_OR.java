package com.practice.in.java8;

import java.util.function.BiPredicate;


import lombok.AllArgsConstructor;
import lombok.Data;

//52. Predicate Chaining with and(), or()
public class Predicate_AND_OR {
	public static void main(String[]aegs) {
		
		BiPredicate<Vkeel,Vkeel> pred =(a,b)-> a.getId()>b.getId();	
		
		BiPredicate<Vkeel,Vkeel> pred1 =(a,b)-> a.getName().compareTo(b.getName())<1;	
		
		Vkeel v = new Vkeel(12, "Arsh");
		Vkeel v1 = new Vkeel(102, "Deep");
		
		System.out.println(pred.and(pred1).test(v,v1));
		System.out.println(pred.or(pred1).test(v,v1));
		
		
		
	}
	
}

@Data
@AllArgsConstructor
class Vkeel{
	int id;
	String name;
}
