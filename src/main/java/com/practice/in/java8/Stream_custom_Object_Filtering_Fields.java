package com.practice.in.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Stream of Custom Objects and Filtering by Field
public class Stream_custom_Object_Filtering_Fields {
	public static void main(String[]args) {
		List<Infosys> teamOOT = Arrays.asList(
				new Infosys("Niel", 14,"Benglurubad"),
				new Infosys("Raj", 1264, "Aune"),
				new Infosys("Michael", 1134,"Cynderabad")
				);
		List<Infosys> teamEngineering = Arrays.asList(
				new Infosys("Sree", 1294,"Chandigarh"),
				new Infosys("Varun", 1224, "ySoreBad"),
				new Infosys("Mike", 1981,"Zohali")
				);
		List<List<Infosys>> listOFTeam = Arrays.asList(teamOOT,teamEngineering);
		
		List<Infosys> maxCap =  listOFTeam.stream().flatMap(List::stream).filter(i->i.getCapacity()>1250).toList();
		System.out.println(maxCap);
		System.out.println(listOFTeam.stream().flatMap(List::stream).filter(i->i.getCeoName().startsWith("M")).map(Infosys::getCeoName).toList());
		System.out.println(listOFTeam.stream().flatMap(List::stream).filter(i->i.getHeadQuarter().toLowerCase().endsWith("bad")).map(Infosys::getHeadQuarter).toList());
		System.out.println(listOFTeam.stream().flatMap(List::stream).sorted(Comparator.comparing(Infosys::getCapacity).reversed()).toList());
		System.out.println(listOFTeam.stream().flatMap(List::stream).sorted(Comparator.comparing(Infosys::getCapacity)).toList());
		System.out.println(listOFTeam.stream().flatMap(List::stream).sorted((a,b)->a.getHeadQuarter().compareTo(b.getHeadQuarter())).toList());
		System.out.println(listOFTeam.stream().flatMap(List::stream).sorted((a,b)->b.getHeadQuarter().compareTo(a.getHeadQuarter())).toList());
		System.out.println(listOFTeam.stream().flatMap(List::stream).max((a,b)->Integer.compare(a.getCapacity(),b.getCapacity())));
		System.out.println(listOFTeam.stream().flatMap(List::stream).min((a,b)->Integer.compare(a.getCapacity(),b.getCapacity())));
		System.out.println(listOFTeam.stream().flatMap(i->i.stream()).map(i->i.getHeadQuarter()).sorted().limit(2).toList());
		System.out.println(listOFTeam.stream().flatMap(i->i.stream()).map(i->i.getHeadQuarter().toLowerCase()).sorted((a,b)->b.compareTo(a)).limit(2).toList());		
		
		//Parallel Stream vs Stream
		flatMapVsMap(teamOOT,teamEngineering,listOFTeam);
		
		
	}
	
	public static void flatMapVsMap(List<Infosys> listA,List<Infosys>listB,List<List<Infosys>>listC) {
		System.out.println(Stream.of(listA,listB).flatMap(List::stream).toList());
		System.out.println("Here am "+Stream.concat(listA.stream(),listB.stream()).count());
		listC.stream().forEach(i->i.stream().forEach(System.out::println));
	
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class Infosys{
	private String ceoName;
	private int capacity;
	private String headQuarter; 
}
