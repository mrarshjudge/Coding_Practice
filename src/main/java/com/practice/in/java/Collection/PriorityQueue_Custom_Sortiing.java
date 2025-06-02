package com.practice.in.java.Collection;

import java.util.Comparator;
import java.util.PriorityQueue;

import lombok.AllArgsConstructor;
import lombok.Data;

//PriorityQueue for Custom Object Sorting
public class PriorityQueue_Custom_Sortiing {
	public static void main(String[]args) {
		PriorityQueue<Empl> pq = new PriorityQueue<>();
		pq.offer(new Empl(99, "Arsh", "HR"));
		pq.offer(new Empl(99, "Arsh", "HR"));
		pq.offer(new Empl(12, "Deep", "Java"));
		pq.offer(new Empl(0, "Judge", "C++"));
		pq.offer(new Empl(1, "arsh", "Linux"));
		while(!pq.isEmpty())
			System.out.println(pq.poll());
		
		System.out.println("-----------------------------------");
		
		PriorityQueue<Empl> pq1 = new PriorityQueue<>(Comparator.comparing(Empl::getName));
		pq1.add(new Empl(99, "Arsh", "HR"));
		pq1.add(new Empl(99, "Arsh", "HR"));
		pq1.add(new Empl(12, "Deep", "Java"));
		pq1.add(new Empl(0, "Judge", "C++"));
		pq1.add(new Empl(1, "arsh", "Linux"));
		while(!pq1.isEmpty())
			System.out.println(pq1.poll());
	}
}

@Data
@AllArgsConstructor
class Empl implements Comparable<Empl>{
	private int id;
	private String name;
	private String projectName;
	
	@Override
	public int compareTo(Empl e) {
		return Integer.compare(this.getId(), e.getId());
	}
}
