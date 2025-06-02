package com.practice.in.Algorithm_ProblemSolving;

import java.util.Arrays;

//Find Missing Number in Array
public class findMissingNumber_Array {
	public static void main(String[]args) {
		System.out.println(Arrays.toString(findMissingNumbers(new int[] {1,3,7,10})));	
		System.out.println(missing1Number(new int[] {1,2,3,5,6,7}));	
	}
	public static int missing1Number(int[]arr) {
		if(arr==null || arr.length==0) return 0;
		
		arr=Arrays.stream(arr).distinct().sorted().toArray();
		int value = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]!=++value)
				return value;
		}
		return 0;
	}
	
	public static int[] findMissingNumbers(int[]arr) {
		if(arr==null || arr.length==0) return arr;
		
		arr=Arrays.stream(arr).distinct().sorted().toArray();
		int count=0,index =0;
		for(int i=1;i<arr.length;i++) {
			count+=arr[i]-arr[i-1]-1;
		}
		
		int[]result = new int[count];
		for(int i=1;i<arr.length;i++) {
			int start = arr[i-1]+1;
			
			while(start<arr[i]) {
				result[index++] = start++;
			}
		}
		return Arrays.copyOf(result, index);
			
	}
	
	
}


