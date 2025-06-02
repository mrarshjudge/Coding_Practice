package com.practice.in.Algorithm_ProblemSolving;

import java.util.Arrays;


//Rotate Array Left or Right
public class Rotate_Left_Right_Array {
	public static void main(String[]args) {
		 System.out.println(Arrays.toString(rotateLeft_Right(new int[] {1, 2, 3, 4, 5}, 2, "left")));  // Left rotation
	     System.out.println(Arrays.toString(rotateLeft_Right(new int[] {1, 2, 3, 4, 5}, 2, "right"))); // Right rotation
	}
	
	public static int[] rotateLeft_Right(int[]arr, int n, String direction) {
		
		if(arr==null || arr.length==0 ||n==0) return arr;
		
		int length = arr.length;
		n = n%length;
		switch (direction.toLowerCase()) {
			case "left": 
				reverse(arr, 0, n-1);
				reverse(arr, n, length-1);
				reverse(arr, 0,length-1);
				break;
				
			case "right": 
				reverse(arr,0,length-1);
				reverse(arr,0,n-1);
				reverse(arr,n,length-1);
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + direction.toLowerCase());
		}
		return arr;
	}
	
	public static int[] reverse(int[]arr,int start, int end){
		int temp =0;
		while(start<end) {
			temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
		return arr;
	}

}
