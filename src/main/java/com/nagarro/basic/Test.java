package com.nagarro.basic;

public class Test {
	public static void main(String arg[]){
		System.out.println("Hello");
		int[] intArr = {-8,1,2,-6,3,-4,6,2,-1};
		int product=Integer.MIN_VALUE, temp=Integer.MIN_VALUE;

		//System.out.println(Integer.MIN_VALUE);
		for(int i=0;i<intArr.length;i++){
			for(int j=0;j<intArr.length;j++){
				if(i!=j){
					temp = intArr[i]*intArr[j];
					if(temp>product){
						product = temp;
					}
				}
			}
		}
		System.out.println(product);

	}
}
