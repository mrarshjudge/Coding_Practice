package com.practice.in.OOPS;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Cloning {
	public static void main(String[]args) {
		Company c = new Company("Infosys","Pune");
		Employee e = new Employee(1, "Arsh", c);
		Employee e1 = e.ShallowClone();
		Employee e2 = e.DeepClone();
		c.setAddress("Mysore");
		System.out.println("Original "+e.toString());
		System.out.println("Shallow Clone "+e1.toString());
		System.out.println("Deep Clone "+e2.toString());
		
	}
}

@Data
@AllArgsConstructor
class Employee{
	private int id;
	private String name;
	private Company company;
	
	public Employee ShallowClone() {
		return new Employee(this.getId(), this.getName(), this.getCompany());
	}
	public Employee DeepClone() {
		Company c1 = new Company(this.getCompany().getName(), this.getCompany().getAddress());
		return new Employee(this.getId(), this.getName(), c1);
	}
}
@Data
@AllArgsConstructor
class Company{
	private String name;
	private String address;
	
}