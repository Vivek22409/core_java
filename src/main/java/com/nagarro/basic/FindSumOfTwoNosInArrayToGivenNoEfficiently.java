package com.nagarro.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindSumOfTwoNosInArrayToGivenNoEfficiently {
	
	
	public static void main(String arg[]) {
		int[] arr = new int[1000];
		
		//System.out.println((int)(Math.random()*1000));
		int i=0;
		while(i<arr.length)
			arr[i++] = (int)(Math.random()*1000);
		
		System.out.println(Arrays.toString(arr));
		
		int sum = arr[arr.length-1]+arr[arr.length-2];
		
		System.out.println("Required sum is: "+sum);
		
		/*long st = System.currentTimeMillis();
		int s=0,t=s+1;
		while(s<arr.length-1) {
			while(t<arr.length) {
				if(arr[s]+arr[t] == sum) {
					System.out.println("Sum of "+arr[s]+" and "+arr[t]+" is "+sum);
					break;
				}
				t++;
			}
			s++;
		}
		System.out.println("1st version: "+(System.currentTimeMillis()-st));*/
		
		/*long st1 = System.currentTimeMillis();
		
		Set<Integer> set = new HashSet<>();
		int count = 0;
		
		for(int k=0; k<arr.length; k++) {
			int comp = sum-arr[k];
			if(set.contains(comp)) {
				//System.out.println("Sum of "+arr[k]+" and "+comp+" is "+sum);
				count++;
			} else {
				set.add(arr[k]);
			}			
		}
		
		System.out.println(count+" 2nd version: "+(System.currentTimeMillis()-st1));*/
		
		int[] ar = {1, 3, 4, 2};
		int sum1=5;
		
		long st2 = System.currentTimeMillis();
		
		Map<Integer,Boolean> map = new HashMap<>();
		for(int h=0;h<9;h++)
			map.put(h, false);
		
		//System.out.println(map);
		int count1 =0;
		
		for(int k=0; k<ar.length; k++) {
			int comp = sum1-ar[k];
			if(comp>0 && map.get(comp)==true) {
				System.out.println("Sum of "+ar[k]+" and "+comp+" is "+sum1);
				count1++;
			} else {
				map.put(ar[k],true);
			}			
		}
		
		System.out.println(count1	+" 3rd version: "+(System.currentTimeMillis()-st2));
			
	}

}
