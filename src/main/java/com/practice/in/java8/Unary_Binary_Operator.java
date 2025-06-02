package com.practice.in.java8;

import java.util.function.BinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

//Use of UnaryOperator and BinaryOperator
public class Unary_Binary_Operator {
	public static void main(String[]args) {
		
		//Unary Operator
		 UnaryOperator<Integer> fun =a-> -a;
		 System.out.println(fun.apply(12));
		 
		 IntUnaryOperator fun1 =a -> ++a;
		 System.out.println(fun1.applyAsInt(12));
		 
		DoubleUnaryOperator fun2 = a-> --a;
		 System.out.println( fun2.applyAsDouble(12));
		 
		 UnaryOperator<String> stringOp = s->s.concat("Appended");
		 System.out.println(stringOp.apply("Arsh "));
		 
		 
		 //BinaryOperator
		 BinaryOperator<Integer> bo = (a,b)->a*b;
		 System.out.println(bo.apply(12, 14));
		 
		 BinaryOperator<String> bs = (a,b)->a+b;
		 System.out.println(bs.apply("Arsh", " Judge"));
		 
	}
}
