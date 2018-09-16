package com.nagarro.strings;

public class StringPermutationVersion {
	public static void main(String arg[]) {
		String s= "ABC";
		String p = "";
		permute(p,s);
	}
	
	public static void permute(String p, String s) {
		int n=s.length();
		if(0==n)
			System.out.println(p);
		else 
			for(int i=0;i<s.length();i++)
				permute(p+s.charAt(i),s.substring(0,i)+s.substring(i+1,n));
	}
}
