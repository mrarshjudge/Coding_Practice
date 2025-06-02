package com.practice.in.java8;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Merge Two Lists using Stream.concat()
public class Merge_TwoLists_Stream_Concat {
	public static void main(String[]args) {
		List<String> list1 = new ArrayList<>( Arrays.asList("Arsh","Singh","Deep"));
		List<String> list2 = Arrays.asList("Arsh","Singh","Deep");
		
		List<String> list3 = Stream.concat(list1.stream(), list2.stream()).distinct().toList();
		System.out.println(list3);
		
		//Convert List of Strings to Uppercase using Stream  // and first letter upper case
		
		List<String> list5 = new ArrayList<>( Arrays.asList("arsh","singh","deep"));
		List<String> list4= list5.stream().map(i->i.toUpperCase()).toList();
		List<String> list6= list5.stream().map(i->i.substring(0,1).toUpperCase()+i.substring(1)).toList();
		List<String> list7= list5.stream().map(i->String.valueOf(Character.toUpperCase(i.charAt(0)))+i.substring(1)).toList();

		System.out.println(list4);
		System.out.println(list6);
		System.out.println(list7);
		
		
		//112. Find Duplicate Elements in a List using Stream
		
		List<String> list8 = Arrays.asList("Arsh","Singh","Deep","Arsh","Deep","Arsh","Arsh","J","J","Jud");
		List<String> list9 = list8.stream().collect(Collectors.toMap(str->str,str->1,Integer::sum,LinkedHashMap::new)).entrySet().stream().filter(i->i.getValue()>1).map(Map.Entry::getKey).toList();
		System.out.println(list9);
		
		
		// Sort a Map by Values using Stream
		Map<String, Integer> map = Map.of("Judge",101,"Deep",102,"Arsh",103,"Car",199);
		
		Map<String, Integer> map1 = map.entrySet().stream().sorted((a,b)-> a.getValue().compareTo(b.getValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue,Integer::sum,LinkedHashMap::new));
		System.out.println(map1);	
		
		//Count Occurrences of Words in a Sentence using Stream
		String str =  "My Name is name is name, we get , name nmae m , get, na me";
		str =str.replace(",", "");
		String[] s1 = str.split(" ");
		Map<String, Integer> map01 = Arrays.stream(s1).collect(Collectors.toMap(i->i.toLowerCase(), v->1,(v1,v2)->v1+v2));
		System.out.println("Map01 "+map01);
		System.out.println("Count OCcurances "+Arrays.stream(s1).collect(Collectors.groupingBy(i->i,Collectors.counting())));
		
		
		//Convert a List to a Map using Stream
		List<String> list18 = Arrays.asList("Arsh","Singh","Deep","Arsh","Deep","Arsh","Arsh","J","J","Jud");
		
		Map<String, Integer> mapMe = list18.stream().collect(Collectors.toMap(i->i, v->1,(v,d)->v+d,LinkedHashMap::new));
		System.out.println(mapMe);
		
		
		
		//Filter a List of Employees by Multiple Conditions
		
		List<EmployeeJi> listEmp = Arrays.asList(
				new EmployeeJi(12, "Arshdeep", "Feroepur, India", LocalDate.of(2000, 12, 12)),
				new EmployeeJi(101, "Arshdeep", "Feroepur, UK", LocalDate.of(2070, 12, 12)),
				new EmployeeJi(119, "aArshdeep", "Feroepur, Aus", LocalDate.of(1990, 12, 12)),
				new EmployeeJi(10, "Ars", "Feroepur, India", LocalDate.of(2010, 12, 12))
				);
		
		System.out.println("with id "+filterEmployee(listEmp, Value.ID));
		System.out.println("with name "+filterEmployee(listEmp, Value.NAME));
		System.out.println("with len "+filterEmployee(listEmp, Value.LENGTH));
		System.out.println("with address "+filterEmployee(listEmp, Value.ADDRESS));
		System.out.println("with dob "+filterEmployee(listEmp, Value.DOB));
		//System.out.println("with default "+filterEmployee(listEmp, "YO Yo"));
		
		
		List<Integer> list190 = Arrays.asList(2,3,4,5,6,7,8,9,10,12,14,16,19);
		partioningListEvenOdd(list190);
		//peek(list18);
	}
	//Partition a List into Even and Odd Numbers
	public static void partioningListEvenOdd(List<Integer> list) {
		Map<Boolean, List<Integer>> map=list.stream().collect(Collectors.partitioningBy((i->i%2==0 )));
		
		System.out.println("Even Numbers: "+map.get(true));
		System.out.println("ODD Numbers: "+map.get(false));
		
		
	}
	
	//Filter a List of Employees by Multiple Conditions
		public static List<EmployeeJi> filterEmployee(List<EmployeeJi> list, Value condition){
			
			switch (condition) {
			case ID: return list.stream().filter(i->i.getId()>100).collect(Collectors.toList());
			case NAME: return list.stream().filter(i->i.getName().startsWith("A")).collect(Collectors.toList());
			case LENGTH: return list.stream().filter(i->i.getName().length()>4).collect(Collectors.toList());
			case ADDRESS: return list.stream().filter(i->i.getAddress().contains("India")).collect(Collectors.toList());
			case DOB: return list.stream().filter(i->i.getDob().getYear()>2000).collect(Collectors.toList());
			
			default:
				throw new IllegalArgumentException("Unexpected Condition: " + condition);
			}
			
		}
		
	
	
	
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class EmployeeJi{
	private int id;
	private String name;
	private String address;
	private LocalDate dob;
}

enum Value{
	ID,NAME,LENGTH,ADDRESS,DOB;
}

