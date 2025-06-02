package com.practice.in.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


//Demonstration of partition By and SummingInt
public class Sum_Average_Limit {
	public static void main(String[]aegs) {
		List<Book> bookList = Arrays.asList(
				new Book("One way to Go", "Amit", 1200, 2012),
				new Book("World War", "Subodh", 1000, 2018),
				new Book("Marry One", "Subodh", 1800, 2017),
				new Book("Listen Life", "Amit", 1800, 2016),
				new Book("World War", "Sam", 1100, 2009),
				new Book("Marry One", "Subodh", 1900, 2007),
				new Book("Listen Life", "Sam", 1800, 2008)
			);
				
		Map<Boolean, List<Book>>map =bookList.stream().collect(Collectors.partitioningBy(i->i.getEdition()>2015));
		Map<Boolean, List<Book>>map1 =bookList.stream().collect(Collectors.partitioningBy(i->i.getAuthor().toLowerCase().startsWith("A")));
		System.out.println(map);
		System.out.println(map1);
		
		map.forEach((k,v)->System.out.println(k+" "+v.stream().collect(Collectors.summingInt(Book::getPrice))));
		
		 Map<String, Integer> map3=bookList.stream().collect(Collectors.groupingBy(Book::getAuthor,Collectors.summingInt(Book::getPrice)));
		System.out.println(map3);
		
		 Map<String, Map<Boolean, Integer>> map4=bookList.stream().collect
				 									(Collectors.groupingBy(Book::getAuthor,
				 											Collectors.partitioningBy(
				 															i->i.getEdition()>2015,
				 															
				 															Collectors.summingInt(Book::getPrice))));
		 
		 System.out.println(map4);
		 
}

}

@Data
@AllArgsConstructor
@EqualsAndHashCode
class Book{
	private String name;
	private String Author;
	private int price;
	private int edition;
}
