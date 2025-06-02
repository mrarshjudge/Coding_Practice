package com.practice.in.Algorithm_ProblemSolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



//Two Sum Problem, if array is sorted and unsorted

public class find2Index_Sorted_Unsorted_Array {
	public static void main(String[]a) {
		System.out.println(Arrays.toString(findSumSortedArray(new int[] {0,1,2,3,4}, 5)));
		System.out.println(Arrays.toString(findSumUnsorted(new int[] {1,2,3,4}, 4)));
	}
	
	
	//Sorted Array
	public static int[] findSumSortedArray(int[]arr,int target) {
		int val =0, left =0, right = arr.length-1;
		int[]result = {-1,-1};
		while(left<right) {
			val = arr[left]+arr[right];
			if(val>target) {
				right--;
			}else if(val<target){
				left++;
			}else {
				result[0]=left;
				result[1] = right;
				break;
			}
		}
		return result;
	}
	
	
	
	
	
	// UnSorted Array
	public static int[] findSumUnsorted(int[]arr, int target) {
		
		if (arr == null || arr.length < 2) {
            return new int[] {-1, -1};
        }
		int val =0;
		int [] result = {-1,-1};
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			val = target-arr[i];
			if(map.containsKey(val)) {
				result[0] = map.get(val);
				result[1] = i;
				break;
			}
			map.put(arr[i], i);
		}
		return result;
	}
}
