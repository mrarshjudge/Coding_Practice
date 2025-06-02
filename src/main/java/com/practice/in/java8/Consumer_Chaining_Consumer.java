package com.practice.in.java8;

import java.util.function.Consumer;

//Consumer and Chaining Consumers
public class Consumer_Chaining_Consumer {
	public static void main(String[]args) {
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = s->System.out.println(s.length());
		Consumer<String> c3 = s->System.out.println(s.charAt(1));
		
		c1.andThen(c2).andThen(c3).accept("VIVO");
	}

}
