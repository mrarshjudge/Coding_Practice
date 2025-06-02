package com.practice.in.java.Problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import lombok.Data;

public class Comparator_Comparable {
	
	public static void main(String[]args) {
		Employee e1 = new Employee(4,"Arsh","Canada",1000l);
		Employee e4 = new Employee(3,"Singh","Canada",1000l);

		Employee e2 = new Employee(3,"Judge","Ferozepur",230l);
		Employee e3 = new Employee(1,"Deep","Canada",12200L);
		
		List<Employee> list = new ArrayList<>();
		list.addAll(Stream.of(e1,e2,e3,e4).toList());
		Comparator<Employee> myOwnComparator = Comparator.comparing(Employee::getId).thenComparing(Employee::getName);
		list.sort(myOwnComparator);
		System.out.println(list);
		
		
		
		
	}
}

@Data
class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private String address;
	private Long salary;
	
	Employee(int id, String name, String address, Long salary){
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		return Integer.compare(this.id, o.getId());
	}
	
}

/*
 * class MyOwnComparator implements Comparator<Employee>{
 * 
 * @Override public int compare(Employee o1, Employee o2) {
 * if(o1.getId()>o2.getId())return 1; else if(o1.getId()<o2.getId())return -1;
 * else return o1.getName().compareTo(o2.getName()); }
 * 
 * }
 */

