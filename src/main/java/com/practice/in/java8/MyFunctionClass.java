package com.practice.in.java8;

import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Custom Functional Interface with Lambda
public class MyFunctionClass {
	public static void main(String[]rgs) {
		Myfunction<Integer,String,String,Emp> emp = Emp::new;
		Emp employee = emp.apply(134, "Judge", "Ferozepur");
		System.out.println(employee);
		
		
		
		//With Lambda
		
		Myfunction<Integer,String,String,Emp> emp1 = (A,B,C)-> new Emp(A,B,C);
	 	System.out.println(emp1.apply(102,"Arsh","India"));
	 	System.out.println(emp1.apply(112,"Meet","India"));
	 	
	 	Function<String,Integer> fun = (a)->a.length();
	 	System.out.println(fun.apply("Arsh"));
	 	
	}

}


@FunctionalInterface
interface Myfunction<A,B,C,D>{
	D apply(A a, B b ,C c);
}

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Emp{
	int id;
	String name;
	String address;
}



