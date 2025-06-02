package com.practice.in.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Method References and Constructor References
public class MethodRefernce_ConstructorRefernce {
	public static void main(String[]arggs) {

		Supplier<Employee>  object = Employee::get;
		System.out.println("Using Static method "+object.get());
		
		Supplier<Employee> supplyObject = Employee::new;
		System.out.println("Using Constructor refernce "+supplyObject.get());
		Employee e15 =  supplyObject.get();
		e15.setName("Arsh");
		Employee e12 = new Employee(123,"Byu");
		Supplier<Employee> sup = e12::getObject;
		System.out.println("Constructor refernce "+sup.get());
		

		BiFunction<Integer,String,Employee> func = Employee::new;
		System.out.println("BiFunctional Interface for 2 fields "+func.apply(120, "Arsh"));
		
		
		
		//Custom interface for n fields
		customInterfaceEmployee<Integer, String,Employee> inter = Employee::new;
		inter.apply(102, "Arsh");
		
		//using method refernce not to create a child
		List<Employee> list = Arrays.asList(object.get(),e15,inter.apply(123, "Arsh"));
		
		List<String> l =  list.stream().map(i->i.getName().toLowerCase())
					.filter(s->s.endsWith("sh")).collect(Collectors.toList());
		System.out.println(l);
		
		
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
class Employee {
	int id;
	String name;
	
	
	public static Employee get() {
		return new Employee(101,"Default-User");
		
	}
	
	public Employee getObject() {
		return new Employee(120,"Arsh");
		
	}
}


@FunctionalInterface
 interface customInterfaceEmployee<A,B,C> {
	C apply(A a,B b);
	
	public static void print() {
		System.out.println("This is functional Interface");
	}

}

