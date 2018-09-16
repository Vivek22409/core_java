package com.nagarro.strings;

public class StringConcepts {
	
	public static void main(String arg[]) {
		
		System.out.println("#######################For Stirng##########################");
		
		String s1 = "hello";
		String s2 = "hello";
		
		System.out.println("string literal s1==s2: "+(s1==s2));
		
		String s3 = new String("hello");
		String s4 = new String("hello");
		
		System.out.println(s3.hashCode()==s4.hashCode());
		
		System.out.println("string s3==s4: "+(s3==s4));
		
		s3.intern();
		s4.intern();
		
		System.out.println(s3.hashCode()==s4.hashCode());
		
		System.out.println("after intern() s3==s4: "+(s3==s4));
		
		s3=s3.intern();
		s4=s4.intern();
		
		System.out.println(s3.hashCode()==s3.hashCode());
		
		System.out.println("after intern() and assign s3==s4: "+(s3==s4));
		
		System.out.println("#######################For StirngBuffer##########################");
		
		StringBuffer sb1 = new StringBuffer("hello");
		StringBuffer sb2 = new StringBuffer("hello");
		
		System.out.println("sb1==sb2: "+(sb1==sb2));
		
		sb1.append(" world");
		sb2.append(" world");
		
		System.out.println(sb1.hashCode()==sb2.hashCode());
		
		System.out.println("after append() sb1==sb2: "+(sb1==sb2));
	}

}
