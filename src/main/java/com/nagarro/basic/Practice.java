package com.nagarro.basic;

import java.util.HashSet;
import java.util.Set;

public class Practice {
	
	//public static Set<String> s = new HashSet<>(); 
	static int[] arr = {-1,4,6,9,0,4,3};
	public static void main(String arg[]) {
		
		
		int li = 0;
		int hi = arr.length-1;

		quicksort(li,hi);
		for(int s:arr)
			System.out.println(s);
		
		
	}
	
	public static void quicksort(int li,int hi) {
		int i =li;
		int j=hi;
		int pivot = arr[li+(hi-li)/2];
		
		while(i<=j) {
			
			while(pivot>arr[i]) {
				i++;
			}
			while(pivot<arr[j]) {
				j--;
			}
			
			if(i<=j) {
				swap(i,j);
				i++;
				j--;
			}
			if(i<hi)
				quicksort(i,hi);
			if(j>li)
				quicksort(li,j);			
		}
	}
	
	public static void swap(int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	/*public static void permute(String prefix,String str) {
		int n = str.length();
		if(n==0) {
			s.add(prefix);
		} else {
			for(int i=0; i<str.length();i++) {
				permute(prefix+str.charAt(i),str.substring(0, i)+str.substring(i+1,n));
			}
		}
	}*/

}
