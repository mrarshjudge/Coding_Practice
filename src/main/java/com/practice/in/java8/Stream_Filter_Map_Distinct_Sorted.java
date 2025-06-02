package com.practice.in.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

//Stream Filter and Map on Product List
public class Stream_Filter_Map_Distinct_Sorted {
	public static void main(String[]args) {
		
		  List<String> list = new
		  ArrayList<>(Arrays.asList("Apple","Samsung","appo","aVIVO","aXIOMI"));
		  System.out.println(list.stream().filter(i->i.toLowerCase().startsWith("a")).
		  map(i->i.concat("find")).collect(Collectors.toList()));
		  
		  list.add("Samsung"); 
		  list.add("Apple");
		  list.add("Apple");
		  System.out.println(list.stream().distinct().sorted().toList());
		 
		
		Product p = new Product(134, "Apple");
		Product p1 = new Product(114, "Apple");
		Product p2 = new Product(104, "Main");
		Product p3 = new Product(14, "TVS");
		Product p4 = new Product(114, "Samsung");
		List<Product> listProduct = new ArrayList<Product>(Arrays.asList(p,p1,p2,p3,p4));
		System.out.println(listProduct.stream().sorted(Comparator.comparing(Product::getId)).collect(Collectors.toList()));
		System.out.println(listProduct.stream().sorted(Comparator.comparing(Product::getId).reversed()).collect(Collectors.toList()));
		System.out.println(listProduct.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList()));
		System.out.println(listProduct.stream().sorted(Comparator.comparing(Product::getName).reversed()).collect(Collectors.toList()));
		System.out.println(listProduct.stream().sorted((a,b)->a.getName().compareToIgnoreCase(b.getName())).collect(Collectors.toList()));
		System.out.println(listProduct.stream().sorted((a,b)->b.getName().compareToIgnoreCase(a.getName())).collect(Collectors.toList()));
		System.out.println("---------------------------------------");
		
		System.out.println(listProduct.stream().sorted((a,b)->Integer.compare(a.getId(), b.getId())).collect(Collectors.toList()));
		System.out.println(listProduct.stream().sorted((a,b)->Integer.compare(b.getId(), a.getId())).collect(Collectors.toList()));
		
	}
}

@Data
@AllArgsConstructor
class Product{
	int id;
	String name;
}