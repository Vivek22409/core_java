package com.nagarro.basic;

public class Recursion {
	public static void main(String arg[]) {
		//System.out.println(factorial(5));
		System.out.println(fib(5,0,1));
		//String s="";
		//char[] arr=s.toCharArray();
		//System.out.println(arr[0]);
	}
	public static int factorial(int n) {
		if(n==0 || n==1) 
			return 1;
		//System.out.println(n*factorial(n-1));

		return n*factorial(n-1);
			
	}
	
	public static int fib(int n, int a, int b) {
		if(n==1) 
			return a;
		return fib(n-1,b,a+b);		
	}
	

}
