package com.nagarro.ds_algorithms;

import java.util.Arrays;

public class BinarySearch {
	
	public static void main(String arg[]) {
		int[] arr = {2,3,4,5,6,7};
		int key = 4; 
		//binarySearch(key, arr);
		cyclicString("ghiabcdef");
	}
	
	public static void binarySearch(int key,int... arr) {
		int l = 0, h = arr.length-1;
		
		while(l<=h) {
			int mid = (l+h)/2;
			if(arr[mid]>key) {
				h = mid - 1; 
			} else if(arr[mid]<key) {
				l = mid+1;
			} else {
				System.out.println("Element found: "+arr[mid]);
				break;
			}
		}
	}
	
	public static void cyclicString(String str) {
		String givenStr = "abcdefghi";		
		int l = 0, h = givenStr.length();		
		for(int i=0, j=0; i<h;i++) {
			String temp = givenStr.substring(i)+givenStr.substring(j,i);
			if(temp.equals(str)) {
				System.out.println("Yes"); break;
			} 
		}
		
	}

}
