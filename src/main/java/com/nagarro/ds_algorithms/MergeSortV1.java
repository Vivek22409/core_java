package com.nagarro.ds_algorithms;

import java.util.Arrays;

public class MergeSortV1 {
	private static int[] arr = {3,4,2,1,5};
	private static int[] tempArr = new int[arr.length];
	
	public static void main(String arg[]) {
		int li = 0;
		int hi = arr.length-1;
		
		mergeSort(li,hi);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void mergeSort(int li, int hi) {		
		if(li<hi) {
			int mid = li+(hi-li)/2;
			mergeSort(li,mid);
			mergeSort(mid+1,hi);
			doMerge(li,mid,hi);
		}		
	}

	private static void doMerge(int li,int mid, int hi) {
		for(int i=li;i<=hi;i++) {
			tempArr[i] = arr[i];
		}
		int i = li;
		int j = mid+1;
		int k = li;		
		while(i<=mid && j<=hi) {
			if(tempArr[i]<=tempArr[j]) {
				arr[k] = tempArr[i];
				i++;
			} else {
				arr[k] = tempArr[j];
				j++;
			}
			k++;
		}
		while(i<=mid) {
			arr[k]=tempArr[i];
			i++;
			k++;
		}
		
	}

}
