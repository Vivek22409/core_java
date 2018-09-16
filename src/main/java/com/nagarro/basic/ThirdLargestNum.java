package com.nagarro.basic;

import java.util.Arrays;

public class ThirdLargestNum {
	public static void main(String arg[]){
		int a=2,b=7,c=11,max=0;
		if(a>b){
			max=a;
		} else if(c>b){
			max=c;
		} else {
			max = b;
		}
		System.out.println(max);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a+" "+b);

		int[] arr = {3,8,9,-1,6};
		int larg=Integer.MIN_VALUE,secLarg=Integer.MIN_VALUE,temp=0;
		for(int j=1;j<4;j++){
			for(int i=1;i<arr.length;i++){
				if(arr[i-1]<arr[i]){
					temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;					
				}				
			}			
		}
		/*int[] arr = {0,0,0};
		int larg=Integer.MIN_VALUE,secLarg=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>larg){
				secLarg=larg;
				larg=arr[i];				
			} else{
				if(secLarg<arr[i] && arr[i]!=larg)
					secLarg=arr[i];

			}
		}
*/
		System.out.println(arr[arr.length-3]+" "+arr[arr.length-2]+" "+arr[arr.length-1]);
	}
}
