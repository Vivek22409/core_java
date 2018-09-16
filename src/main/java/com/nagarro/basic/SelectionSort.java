package com.nagarro.basic;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String arg[]) {
		
		int[] arr = {1,4,5,3,2,-1,4};
		//Selection
		/*for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}*/
		
		//Bubble		
		/*for(int i=0;i<arr.length-1;i++) {
			for(int j=1;j<arr.length-i;j++) {
				if(arr[j-1]>arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}*/
		
		//insertion
		/*for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j>0;j--) {
				if(arr[j-1]>arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}*/
		
		
		
		System.out.println(Arrays.toString(arr));
		
	}

}

//Dry run for selection sort 
/*i=0 -> 1 7 4 5 3 2 
i=1 -> 1 2 7 5 4 3
i=2 -> 1 2 3 7 5 4
i=3 -> 1 2 3 4 7 5
i=4 -> 1 2 3 4 5 7*/