package com.nagarro.basic;

import java.util.HashSet;
import java.util.Set;

public class SortingDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int temp = 0;
		/*for(int i=0;i<arr.length;i++){
			for(int j=1;j<(arr.length-i);j++){
				if(arr[j-1]>arr[j]){
					temp = arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}*/
		/*for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[i]){
					temp = arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
					}
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}*/
		/*int low = 0, high = arr.length-1, mid = 0,key=3;
		while(low<=high){
			mid = ((low+high)/2);
			if(key<arr[mid]){
				high = mid-1;
			}else if(key>arr[mid]){
				low = mid+1;
			} else {
				System.out.println("Key found "+arr[mid]);
				break;
			}
		}
		String str = "ABCCDEF";
		char[] chArr = str.toCharArray();
		int count =0;
		for(Character c:chArr){
			if(c=='R'){
				count++;
			}
		}
		System.out.println(count);*/
		Set<Integer> s = new HashSet<Integer>();
		int sum = 5;
		for(int i=0;i<arr.length;++i ){
			int temp1 = sum - arr[i];
			if(temp1>=0 && s.contains(temp1)){
				System.out.println(temp1 +" "+arr[i]);
			}
			s.add(arr[i]);
		}
		
	}

}
