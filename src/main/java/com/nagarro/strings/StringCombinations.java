package com.nagarro.strings;

import java.util.HashSet;
import java.util.Set;

public class StringCombinations {
	
	static Set<String> s = new HashSet<>();
	
	public static void main(String arg[]) {
		String str = "abc";
		
		strComb("",str);
		for(String st:s)
			System.out.println(st);
	}
	
	private static void strComb(String prefix, String str) {
		int  n = str.length();
		if(n==0) {
			s.add(prefix);
		} else {
			for(int i=0;i<str.length();i++) {
				strComb(prefix +str.charAt(i), str.substring(0,i)+str.substring(i+1,n));
			}
		}
	}
	
	

}
