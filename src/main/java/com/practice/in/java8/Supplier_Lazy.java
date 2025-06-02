package com.practice.in.java8;

import java.util.Optional;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//54. Supplier Interface for Lazy Initialization
public class Supplier_Lazy {
	
	public static void main(String[]args) {
		Supplier<Company> sup = ()->null;
	
		Supplier<Company> sup12 = ()-> new Company("Infosys", 9845);
		
		Optional<Company> c1 = Optional.ofNullable(sup.get());
		Optional<Company> c2 = Optional.ofNullable(sup12.get());
		
		// this is lazy init of supplier. 	
		System.out.println(c1.orElseGet(()->new Company("Govt company",123)
				));
		System.out.println(c2.get());		

		System.out.println(c1.orElseThrow());
		System.out.println(c1.orElseThrow(IllegalArgumentException::new));
		
		
	}

}
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
class Company{
	private String name;
	private int ISBN;
}
