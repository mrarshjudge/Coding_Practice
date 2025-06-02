package com.practice.in.java.Collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;

//Use TreeMap to Sort by Keys
public class TreeMaps  {
	
	public static void main(String[]args) {
		Map<Student, String> map = new TreeMap<>();
		Map<Student, String> map1 = new TreeMap<>(Comparator.comparing(Student::getName));
		
		
		map.put(new Student(101, "Judge"),"Pre-Nursery");
		Student s1 = new Student(191, "Deep");
		map.put(s1, "Nursery");
		map.put(s1, null);
		System.out.println(map);
		
		map1.put(new Student(1, "Judge"),"Six");
		map1.put(new Student(190, "Arsh"),"Seven");
		map1.put(new Student(2, "Singh"),"Seven");
		map1.put(new Student(2, "Deep"),"Seven");
		
		System.out.println(map1);
		
	}
}

@Data
@AllArgsConstructor
class Student implements Comparable<Student>{
	int id;
	String name;
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(this.getId(), o.getId());
		
	}
	
}