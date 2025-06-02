package com.practice.in.Algorithm_ProblemSolving;

import java.util.Arrays;

//Remove Duplicates from Sorted Array
public class Remove_Duplicate_Sorted_Unsorted_Array {
	public static void main(String[]args) {
		System.out.println(Arrays.toString(removeDuplicateSorted(new int[] {1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,4,5,6,6})));
		
	}
	public static int[] removeDuplicateUnsorted(int[]arr) {
		
		return Arrays.stream(arr).distinct().toArray();
		
		/*Set<Integer> set = new LinkedHashSet<>();
		for(int i:arr) {
			set.add(i);
		}
		return set.stream().mapToInt(Integer::intValue).toArray();*/
	}
	
	public static int[] removeDuplicateSorted(int[]arr) {
		int index =0;
		int[]result = new int[arr.length];
		if(arr.length>=1) {
			result[index++] = arr[0];
			for(int i=1;i<arr.length;i++) {
				if(arr[i-1]==arr[i]) {
					continue;
				}
				result[index++] = arr[i];
			}
			return Arrays.copyOf(result, index);
		}
		return arr;
	}

}
