package com.practice.in.java.Problems;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.OptionalInt;



class CoreJava{
	public static void main(String[]args) {
		
		System.out.println( numberToWord(28));
	}
	
	public static String  reverse(String str) {
		if(str.isBlank()) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static boolean isPalindrome(Object o) {
		if(o==null) return false;
		String s = o.toString().toLowerCase();
		int len = s.length()-1;
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(len-i))return false;
		}
		return true;
	}
	
	public static void findDuplicate(String str) {
		
		Map<Character, Integer> map = new HashMap<>();
		
		str = str.toLowerCase();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(Character.isWhitespace(ch)) continue;
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		for(Map.Entry<Character, Integer>entry : map.entrySet()) {
			if(entry.getValue()>1)
				System.out.println(entry.getKey() +" "+entry.getValue());	
		}
	}
	
	public static void fizzBuzz(int n) {
	
		for(int i=1;i<=n;i++) {
			if(i%3==0 && i%5==0) {
				System.out.println("FizzBuzz");
			}else if(i%3==0) {
				System.out.println("Fizz");
			}else if(i%5==0) {
				System.out.println("Buzz");
			}else {
				System.out.println(i);
			}
		}
	}
	//Find the Largest and Smallest Number in an Array
	public static void findLargestSmallest(int []arr) {
		OptionalInt min = Arrays.stream(arr).min();
		OptionalInt max = Arrays.stream(arr).max();
		
		if(min.isPresent() && max.isPresent()) {
			System.out.println("minimum value is:"+min.getAsInt()+" maximum value is:"+max.getAsInt());
		}else {
			System.out.println("Array is Empty");
		}
		
		
	}
	
	public static void findSL(int []arr) {
		int min =arr[0];
		int max = arr[0];
		
		for(int i:arr) {
			if(min>i)min =i;
			if(max<i)max = i;
		}
		System.out.println("Min value is:"+min+" max value is:"+max);
		Arrays.sort(arr);
	}
	
	public static boolean linearSearch(int[]arr,int target) {
		if( arr==null || arr.length<1) return false;
		for(int i:arr) {
			if(i==target) return true;
		}
		return false;
	}
	
	//Prime Number Check
	public static boolean isPrime(int n) {
		if(n<=1) return false;
		if(n==2)return true;
		if(n%2==0) return false;
		for(int i=3;i<=Math.sqrt(n);i+=2) {
			if(n%i==0)return false;
		}
		return true;
	}
	
	//Generate Prime Numbers up to N
	public static void generatePrime(int n) {
		if (n >= 2) System.out.println(2); 
		for(int i=3;i<=n;i+=2) {
			if(isPrime(i))System.out.println(i);
		}
	}
	//Count Digits in an Integer
	public static int countDigits(int n) {
		System.out.println(Integer.toString(n).toCharArray().length);
		System.out.println(String.valueOf(n).length());
		int count =0;
		if(n==0) System.out.println(1);
		while(n>0) {
			n=n/10;
			count++;
		}
		return count;
	}
	//Sum of Digits of a Number
	public static int sumDigits(int n) {
		
		/*  int sum =0;
		  while(n>0){ 
			  sum+=n%10; 
			  n=n/10; 
		}
		return sum;
		*/
		n = Math.abs(n);
		if(n==0) return n;
		return n%10 + sumDigits(n/10);
	
	}
	//Armstrong Number Check
	public static boolean armstrongCheck(int number) {
		int power = String.valueOf(number).length();
		int n = Math.abs(number);
		double result=0;
		while(n>0) {
			int digit = n%10;
			n =n/10;
			result +=Math.pow(digit, power);
		}
		
		return ((int)result==number);
	}
	
	//Perfect Number Check
	public static boolean perfectNumber(int number) {
		int result=0;
		int n = Math.abs(number);
		if(n==1) return false;
		
		for(int i=1;i<=Math.sqrt(n);i++) {
	        if (n % i == 0) {
	            result += i;  // Add the divisor
	            if (i != 1 && i != n / i) {  // Avoid adding the number itself and repeated divisors
	                result += n / i;  // Add the complementary divisor
	            }
	        }
	    }
		
		return result==number;
	}
	
	//Number to Words Conversion
	public static String numberToWord(int no) {
		Map<Integer, String> map = Map.of(0,"Zero",1,"One",2,"Two",3,"Three",4,"Four",5,"Five",6,"Six",7,"Seven",8,"Eight",9,"Nine");
		int n =0;
		List<String> list = new ArrayList<>();
		int number = Math.abs(no);
		if(number==0)return map.get(number);
		while(number>0) {
			n = number%10;
			number = number/10;
			list.add(map.get(n));
		}
		Collections.reverse(list);
		String result = String.join(" ", list);
		return no<0?"Minus "+result :result;
		
	}
}