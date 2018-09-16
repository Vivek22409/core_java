package com.nagarro.basic;

import java.util.HashSet;
import java.util.Set;

public class FibRecursive {
	
	private static String str = "ABC";
	private StringBuffer sb = new StringBuffer();
	
	Set<String> s = new HashSet<>();
	
	private int fib(int n) {
		if(n==1)
			return 0;
		if(n==2)			
			return 1;
		return fib(n-1)+fib(n-2);
	}
	
	private void strComb(int start) {
		for(int i = start; i<str.length();i++) {
			sb.append(str.charAt(i));
			System.out.println(sb);			
			if(i<str.length()) {
 				strComb(i+1);
			}
			sb.setLength(sb.length()-1);
		}
	}
	
	private void strComb(String prefix, String str) {
		int  n = str.length();
		if(n==0) {
			s.add(prefix);
		} else {
			for(int i=0;i<str.length();i++) {
				strComb(prefix +str.charAt(i), str.substring(0,i)+str.substring(i+1,n));
			}
		}
	}
	
	
	public static void main(String arg[]) {
		
		FibRecursive fr = new FibRecursive();
		
		//for(int i =1; i<10; i++)		
		//System.out.println(fr.fib(i));"
		
		fr.strComb(0);
		System.out.println(fr.s);
	
	}

}
