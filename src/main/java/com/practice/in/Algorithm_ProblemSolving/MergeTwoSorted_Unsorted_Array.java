package com.practice.in.Algorithm_ProblemSolving;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Merge Two UnSorted Arrays
public class MergeTwoSorted_Unsorted_Array {
	public static void main(String[]args) {
		//System.out.println(Arrays.toString(mergeArray(new int[] {1,3,5,7}, new int[]{2,4,6,8})));
		System.out.println(Arrays.toString(mergeUnsortedArray(new int[] {1,3,5,7}, new int[]{2,4,6,8})));
	}
	
	public static int[] mergeUnsortedArray(int[]right, int[]left) {
		if(right==null || right.length==0) return left;
		if(left==null || left.length ==0) return right;
		
		List<Integer> list = Arrays.stream(left).boxed().collect(Collectors.toList());
		list.addAll(Arrays.stream(right).boxed().toList());
		Collections.sort(list);
		return list.stream().mapToInt(Integer::intValue).toArray();
        
	}
	
	
	
	
	
	
	public static int[] mergeArray(int[]left,int[]right) {
		
		if (left == null || left.length == 0) return right;
		 if (right == null || right.length == 0) return left;
		int x=0,y=0,i=0;
		int[] result = new int[left.length+right.length];
		
		while(x<left.length && y<right.length) {
			if(left[x]>right[y]) {
				result[i++] = right[y++];
			}else {
				result[i++] = left[x++];
			}
		}
		while(x<left.length)
			result[i++] = left[x++];
		while(y<right.length)
			result[i++] = right[y++];
		return result;
	}
}
