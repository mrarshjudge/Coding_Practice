package com.practice.in.java.Collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Frequency Counter using HashMap
public class FrequencyCounter_String_Sorting {
	public static void main(String []args) {
		System.out.println(frequencyCounter("Arshhhaa "));
		
		//String Sorting
		String str1 = "A,S,E,D,C,Z";
		String str = "A,S,E,D,C,Z";
		
		str = str.replace(",", "");
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		
		StringBuilder sb = new StringBuilder();
		int i=0;
		for(char c : str1.toCharArray()) {
			if(c ==',') {
			sb.append(',');
			}
			else {
				sb.append(ch[i++]);
				
			}
		}
		System.out.println(sb);
	}
	public static String frequencyCounter(String str) {
		if(str.isEmpty())return str;
		str = str.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		for(char ch:str.toCharArray()) {
			//if(String.valueOf(ch).matches("[^A-Za-z]"))continue;//  if we dont want regex then use methods 
			if(!Character.isLetter(ch)) continue;
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		return map.toString();
	}
}