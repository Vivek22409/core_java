package com.nagarro.genrics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*class MyList<String,Integer> implements List<String>{

}*/

public class GenericListDemo {

	public static void main(String[] args) {
		
		int[] arr = {1,1};
		int larg=Integer.MIN_VALUE, secLarg=Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>larg) {
				secLarg=larg;
				larg=arr[i];
			} else if(arr[i]>secLarg && arr[i]!=larg) {
					secLarg=arr[i];
			}					
		}
		
		System.out.println("SecondLargeNum: "+secLarg);
		

		List<String> strings = new ArrayList<>();

		strings.add("vivek");
		strings.add("rahul");
		strings.add("pinto");
		strings.add("johnu");

		List<Integer> numbers = new ArrayList<>();

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);

		show(strings);
		//show(numbers);

	}

	public static void show(List<?> objects) {
		
		// objects.add("abc");
		
		for (Object obj : objects) {
			System.out.println(obj);
		}
	}

}
