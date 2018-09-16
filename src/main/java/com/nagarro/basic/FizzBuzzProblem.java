package com.nagarro.basic;

public class FizzBuzzProblem {

	public static void main(String[] args) {
		String s = "Hello";
		
		String s1 = new String("hello");
		String s3="hello";
		
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s3.hashCode());
		
		
		/*for(int i = 1;i<=25;i++) {
			if(i%3==0 && i%5==0)
				System.out.println(i+" "+"FIZZ_BUZZ");
			else if(i%3==0 && i%5!=0) {
				System.out.println(i+" "+"FIZZ");
			} else if(i%5==0 && i%3!=0) {
				System.out.println(i+" "+"BUZZ");
			}
		}*/

	}

}
