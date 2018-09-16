package com.nagarro.ds_algorithms;

public class MyQuickSortVersion {
	static int[] a = {9,4,3,2,1};
	
	public static void main(String arg[]) {
		
		
		int lowerIndex = 0;
		int higherIndex=a.length-1;
		
		quicksort(lowerIndex,higherIndex);	
		
		for(int i:a) {
			System.out.print(i+" ");
		}
		
	}
	
	public static void quicksort(int lowerIndex, int  higherIndex) {
		int i = lowerIndex;
		int j=higherIndex;
		int pivot = a[lowerIndex+(higherIndex-lowerIndex)/2];
		
		
		while (i<=j) {
			
			while(a[i]<pivot) {
				i++;
			}
			while(a[j]>pivot) {
				j--;
			}
			if(i<=j) {
				swap(i,j);
				i++;
				j--;
			}			
		}	
		if(lowerIndex<j)
			quicksort(lowerIndex,j);
		if(i<higherIndex)
			quicksort(i, higherIndex);
	}
	
	public static void swap(int i,int j) {
		int tem = a[i];
		a[i]=a[j];
		a[j]=tem;
	}

}
