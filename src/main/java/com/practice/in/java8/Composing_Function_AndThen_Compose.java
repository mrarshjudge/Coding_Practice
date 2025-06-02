package com.practice.in.java8;


import java.util.function.Function;


//Composing Functions using andThen() and compose()
public class Composing_Function_AndThen_Compose {
	
	public static void main(String[]args) {
		
		Function<String, String> append121 =(s)->s+121;
		Function<String, String> append122 =(s)->s+122;
		System.out.println("And Then Method evaluate first function and then inside - do this then that "+append121.andThen(append122).apply("Arsh"));
		
		System.out.println("Compose method evaluate inside function then outside"+ append121.compose(append122).apply("Arsh"));
	}
}
