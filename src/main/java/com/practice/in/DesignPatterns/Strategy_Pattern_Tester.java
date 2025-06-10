package com.practice.in.DesignPatterns;

import java.util.Arrays;

public class Strategy_Pattern_Tester {
	public static void main(String[]args) {
		Sorting bubbleSort = new BubbleSort();
		Sorting selectionSort = new SelectionSort();
		Sorting insertionSort = new InsertionSort();
		Sorting mergerSort = new MergeSorting();
		
		int []arr = {12,45,11,56,23,9};
		System.out.println("   Bubble Sorting: "+Arrays.toString(bubbleSort.sort(arr)));
		
		int []arr1 = {12,45,11,56,23,9};
		System.out.println("Selection Sorting: "+Arrays.toString(selectionSort.sort(arr1)));
		
		int []arr2 = {12,45,11,56,23,9};
		System.out.println("Insertion Sorting: "+Arrays.toString(insertionSort.sort(arr2)));
		
		int []arr3 = {12,45,11,56,23,9};
		System.out.println("Merge Sorting: "+Arrays.toString(mergerSort.sort(arr3)));
		
		
	}

}
interface Sorting{
	public int[] sort(int[] arr);
}

class BubbleSort implements Sorting{
	
	@Override
	public int[] sort(int[]arr) {
		int temp=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
		return arr;
	}
	
}

class SelectionSort implements Sorting{

	@Override
	public int[] sort(int[]arr) {
		
		int temp =0;
		
		for(int i=0;i<arr.length;i++) {
			int minIndex =i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minIndex]>arr[j]) {
					minIndex = j;
				}
			}
			
		if(i!=minIndex) {
			temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		}
		return arr;
	}
}

class InsertionSort implements Sorting{

	@Override
	public int[] sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int j = i-1;
			int temp = arr[i];
			
			while(j>-1 && arr[j]>temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
		
		return arr;
	}
}
	
class MergeSorting implements Sorting{
	
	@Override 
	public int[] sort(int[]arr){
		
		if(arr.length==1)return arr;
		int[] left = sort(Arrays.copyOfRange(arr, 0, arr.length/2));
		int[] right = sort(Arrays.copyOfRange(arr, arr.length/2, arr.length));
		
		return merge(left,right);
	}
	
	public int[] merge(int[] left, int[] right) {
		int i=0,j=0,index=0;
		int [] resultArray =new int[left.length+right.length];
		
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) resultArray[index++] = left[i++];
			else resultArray[index++] = right[j++];
			
		}
		while(i<left.length)resultArray[index++] = left[i++];
		while(j<right.length)resultArray[index++] = right[j++];
		return resultArray;
	}
}

