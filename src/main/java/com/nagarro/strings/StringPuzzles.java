package com.nagarro.strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringPuzzles {
	
	static {
		System.out.println("ABC");
	}
	
	public static void main(String arg[]) {
		String s = "Hello";
		String s1 = new String("Hello");
		s1.intern();
		System.out.println(s.hashCode()+" "+s1.hashCode());
		
		List<String> l = new ArrayList<>();
		l.add("ab");
		l.add("db");
		l.add("cb");
		l.add("ab");
		l.add("ab");
		l.add("bn");
		l.add("ab");
		l.add("jh");
		
		System.out.println(l);
		
		String s3="abgfjhabgfthyr";
		String r = s3.replaceAll("ab", "");
		System.out.println(r);
		
		Iterator<String> itr = l.listIterator();
		while(itr.hasNext()) {
			if(itr.next().equals("ab")) {
				itr.remove();
			}
		}
		
		System.out.println(l);
		
		
		
		
	}

}
