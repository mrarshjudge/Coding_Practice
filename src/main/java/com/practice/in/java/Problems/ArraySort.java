package com.practice.in.java.Problems;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[]args) {
		int [] arr1 =new int[] {23,21,21,23,19,35,14,36,39,2};
		int [] arr2 =new int[] {239,241,221,293,619,735,114,836,329,22};
		int [] arr3=new int[] {273,211,221,233,190,359,146,3566,439,12};
		
		
		  bubbleSort(arr1); insertionSort(arr2); selectionSort(arr3);
		 
		int[] sorted = mergeSort(new int[]{5, 2, 8, 3, 1});
		System.out.println(Arrays.toString(sorted));
	}
	
	

	public static void bubbleSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("Bubble Sorting "+Arrays.toString(arr));
	}
	
	public static void insertionSort(int[]arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex = j;
				}
			}
			if(i!=minIndex) {
				int temp = arr[minIndex];
				arr[minIndex] =arr[i];
				arr[i] = temp;
			}
		}
		System.out.println("Insertion Sorting "+Arrays.toString(arr));
	}
	
	
	private static void selectionSort(int[] arr) {
	
		for(int i=0;i<arr.length;i++) {
			int j = i-1;
			int temp = arr[i];
			
			while(j>-1 && arr[j]>temp) {
				arr[j+1]=arr[j];
				arr[j] = temp;
				j--;
			}
		}
		System.out.println("Selection Sorting "+Arrays.toString(arr));
	}
	
	private static int[] mergeSort(int[]arr) {
		if(arr.length<=1)return arr;
		
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0,arr.length/2));
		int [] right = mergeSort(Arrays.copyOfRange(arr, arr.length/2,arr.length));
		return merge(left,right);
	}
	private static int[] merge(int[] left, int[] right) {
		int i=0, j=0,index=0;
		int[]  mergedArray = new int[left.length+right.length];
		
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				mergedArray[index++] = left[i++];
			}else {
				mergedArray[index++] = right[j++];
			}
		}
		while(i<left.length) {
			mergedArray[index++] = left[i++];
		}
		while(j<right.length) {
			mergedArray[index++] = right[j++];
		}
		return mergedArray;
	}
}
