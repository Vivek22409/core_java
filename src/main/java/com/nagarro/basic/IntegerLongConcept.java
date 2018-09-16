package com.nagarro.basic;

public class IntegerLongConcept {

	public static void main(String[] args) {
		/*int[] arr = {-3,1,0,-7,6,7,8};
		
		int sl=Integer.MIN_VALUE,l=Integer.MIN_VALUE;
		
		for(int i=0; i< arr.length;i++) {
			if(arr[i]>l) {
				sl=l;
				l=arr[i];
			} else if(sl<arr[i] && sl!=l) {				
				sl=arr[i];
			} 
		}
		
		System.out.println(sl);*/
		
		System.out.println("###############For Integer################# "); // has cached range - -128 to 127
		
		
		Integer i1 = 127;
		Integer i2 = 127;
		
		System.out.println("i1==i2: "+(i1==i2));
		
		Integer i3 = 407;
		Integer i4 = 407;
		
		System.out.println("i5==i6: "+(i3==i4));	
		
		Integer i5 = new Integer(40);
		Integer i6 = new Integer(40);
		
		System.out.println("i1==i2: "+(i5==i6));
		
		System.out.println("################For Long##################### "); // has cached range - -128 to 127
		
		Long l1 = 67l;
		Long l2 = 67l;
		
		System.out.println("l1==l2: "+(l1==l2));
		
		Long l3 = 407l;
		Long l4 = 407L;
		
		System.out.println("l3==l4: "+(l3==l4));
		
		System.out.println("################For Double##################### ");
		
		Double d1 = 12D;
		Double d2 = 12D;
		
		System.out.println("d1==d2: "+(d1==d2));
		
		Double d3 = 407D;
		Double d4 = 407D;
		
		System.out.println("d3==d4: "+(d3==d4));
		

	}

}
