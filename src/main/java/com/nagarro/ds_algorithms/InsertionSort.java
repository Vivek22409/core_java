package com.nagarro.ds_algorithms;

import java.util.Arrays;

public class InsertionSort {
	
	private static int[] arr = {3,4,2,1,5,6,9,15};
	
	public static void main(String arg[]) {
		
		for(int i = 0; i<arr.length-1; i++) { 
			for(int j=i;j>=0;j--) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] =arr[j];
					arr[j] =temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
		
	}

}
