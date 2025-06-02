package com.practice.in.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

//Group By with Collectors.groupingBy
public class GroupBy {
	
	public static void main(String[]args) {
		
		
		List<Order> orderList = Arrays.asList(
				new Order(101, "Phone", "Arsh"),
				new Order(111, "Phone", "Deep"),
				new Order(121, "Computer", "Arsh"),
				new Order(131, "Telephone", "Arsh"),
				new Order(141, "computer", "Deep"),
				new Order(121, "Telephone","Arsh"),
				new Order(151, "Telephone", "Arsh")
				);
		Map<String, Long> map =orderList.stream().collect(Collectors.groupingBy(Order::getCustomer,Collectors.counting()));
		System.out.println(map);
		
		// if you dont want to count , just wnat a  map 1 customer how many orders attached
		
		Map<String, List<Order>> mapOrder =orderList.stream().collect(Collectors.groupingBy(Order::getCustomer));
		mapOrder.forEach((k,v)->System.out.println(k+" "+v.stream().map(Order::getProduct).collect(Collectors.toList())));
	
	
		
	}

}


@Data
@AllArgsConstructor
@EqualsAndHashCode
class Order{
	private int orderId;
	private String product;
	private String customer;
}
