package com.nagarro.ds_algorithms;

import java.util.Arrays;

public class QuicksortV3 {
	
	static int[] arr = {3,4,6,2,1,7};
	
	public static void main(String arg[]) {
		
		int l = 0;
		int h = arr.length-1;
		System.out.println(Arrays.toString(arr));
		quickSort(l,h);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void quickSort(int l, int h) {
		int i = l;
		int j = h;
		
		int p = arr[l+(h-l)/2];
		
		while(i<=j) {
			
			while(arr[i]<p) {
				i++;
			}

			while(arr[j]>p) {
				j--;
			}
			if(i<=j) {
				swap(i,j);
				i++;
				j--;
			}			
		}
		if(l<j)
			quickSort(l,j);
		if(i<h)
			quickSort(i,h);
	}
	public static void swap(int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
