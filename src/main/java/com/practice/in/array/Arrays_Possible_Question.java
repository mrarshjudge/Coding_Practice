package com.practice.in.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//Find the Maximum and Minimum in an Array
public class Arrays_Possible_Question {
	public static void main(String[]args) {
		//int []arr = {12,10,12,9,0,1,23,12,54,10,12,21,23,54,43,12};
		/*//segregateEvenOdd(arr);
		
		System.out.println("Finding Duplicate "+findDuplicateNumber(arr));
		
		  int min = Arrays.stream(arr).min().getAsInt(); int max =
		  Arrays.stream(arr).max().getAsInt();
		  
		  System.out.println("Min is :"+min +"  max is: "+max);
		  System.out.println(Arrays.stream(arr).sorted().limit(3).boxed().toList());
		  System.out.println(Arrays.stream(arr).boxed().sorted((a,b)->Integer.compare(b
		  ,a)).limit(3).toList());
		  System.out.println(Arrays.stream(arr).boxed().sorted((a,b)->b.compareTo(a)).
		  limit(3).toList());
		  
		  //Arrays.stream(arr).mapToObj(Integer::valueOf).forEach(System.out::println);
		  //without java 8 int min1 = arr[0]; int max1 = arr[0]; for(int
		  i=1;i<arr.length;i++) { if(min1>arr[i]) min1=arr[i]; if(max1<arr[i]) max1 =
		  arr[i]; }
		  
		  System.out.println(min1 +"   "+max1);
		  
		  
		  
		  
		  
		  //Reverse an Array In-place 
		  int[] result = new int[arr.length]; 
		  int index=0;
		  
		  for(int i=arr.length-1;i>=0;i--) 
		  { result[index++] = arr[i]; }
		  System.out.println(Arrays.toString(result));
		  
		  int element = 0; 
		  int len = arr.length-1; 
		  for(int i=0;i<arr.length/2;i++) {
		  element = arr[i]; 
		  arr[i] = arr[len-i]; 
		  arr[len-i] =element; }
		  System.out.println("Arsh"+Arrays.toString(arr));
		 */ 
		  //
		  //System.out.println("Rotating the element "+Arrays.toString(rotateMe(arr,3,
		  //"Left")));
		  
		 /* System.out.println("Rotating the element "+Arrays.toString(rotateMe(arr,3,
		  "Right")));
		  
		  System.out.println(Arrays.toString(moveZerotoEnd(new int[]
		  {0,0,12,0,12,12})));
		  */
			//System.out.println("Finding Duplicate "+findDuplicateNumber(arr));
		//int []arr1 = {12,10,12,9,0,1,23,12,54,10,12,21,23,54,43,12};

			//findDuplicateNumbers(arr1);
			findMissingNumber();
		 
	}
	
	
	
	
	//Left Rotate and Right Rotate Array by N Positions
	public static int[] rotateMe(int[]arr, int n, String direction) {
		if(arr.length<=0 || n<=0) return arr;
		
		int len = arr.length;
		n =n%len;
		
		if(direction.equals("left" ) || direction.equals("right")) {
			if(direction.equals("right")) {
				n = len-n;
			}
			rotate(arr, 0,n-1);
			rotate(arr, n,len-1);
			rotate(arr, 0,len-1);
			
		}
		return arr;
		
		
	}
	
	public static void rotate(int[]arr,int start, int end) {
		int temp =0;
		while(start<end) {
			temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] =temp;
			
		}
	}
	
	//Move All Zeros to End of Array
	public static int[] moveZerotoEnd(int[]arr) {
		int index =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0)
				arr[index++] =arr[i];
		}
		while(index<arr.length) {
			arr[index++]=0;
		}
		
		
		// Using java 8 
		int[] result = Arrays.stream(arr).filter(i->i!=0).toArray();
		System.out.println(Arrays.toString(IntStream.concat(Arrays.stream(result), IntStream.generate(()->0).limit(10)).toArray()));
		return arr;
	}

	
	// Segregate Even and Odd Numbers in Array
	public static void segregateEvenOdd(int[]arr){
		// use grouping if 
		 System.out.println(Arrays.stream(arr).boxed().collect(Collectors.groupingBy(i->i%2==0?"even":"odd")));
	}
	
	//Duplicates find space in efficent
	public static Integer findDuplicateNumber(int[]arr) {
		//Brute Force simple oN;
		/*for(int i=0;i<arr.length;i++) {
			int val =arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(val==arr[j]) return val;
			}
		}*/
		arr = new int[]{1,1,2,4,3,1};
		int slow = arr[0];
		int fast = arr[0];
		
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		}while(slow!=fast);
		
		slow = arr[0];
		while(slow!=fast) {
			slow =arr[slow];
			fast = arr[fast];
		}
		return slow;
	}
	
	
	//Find All Duplicate Numbers (Space Efficient)
	public static void findDuplicateNumbers(int[]arr) {
		
		//using brute force
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					//System.out.println(arr[j]);
				}
			}
		}
		//using efficent space no brute force
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], map.getOrDefault(arr[i],0)+1);
		}
		//System.out.println(map);
		
		for(Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue()>1) {
				System.out.print(entry.getKey()+" ");
			}
		}
		
		 System.out.println("Duplicates: ");
			arr = new int[]{1,1,2,2,2,2,4,4,3,3,3,3,1};

		    for (int i = 0; i < arr.length; i++) {
		        int index = Math.abs(arr[i]) - 1; // FIXED: -1 to convert value to index

		        if (arr[index] < 0) {
		        	if(arr[index]!=Integer.MIN_VALUE) {
		        		System.out.println("Duplicate "+(index + 1) + " ");
		        		arr[index] = Integer.MIN_VALUE;
		        	}
		        } else {
		            // Mark as visited by negating the value
		            arr[index] = -arr[index];
		        }
		    }
		
		
	}
	
	
	public static void findMissingNumber() {
		int []arr = new int[]{1,8,14,17};
		
		arr = Arrays.stream(arr).distinct().sorted().toArray();
		int count=0;
		for(int i=1;i<arr.length;i++) {
			count += arr[i]-arr[i-1]-1;
		}

		System.out.println("count "+count);
		int index=0;
		int[] missingNumbers = new int[count];
		for(int i=1;i<arr.length;i++) {
			int start = arr[i-1]+1;
			while(start<arr[i]) {
				missingNumbers[index++] = start++;
			}
		}
		System.out.println(Arrays.toString(missingNumbers));
	}
	
	//Merge Overlapping Intervals (Array of Intervals)
	
	public static void mergeOverlapping(List<Integer[] >list) {
		
	}
	
}

