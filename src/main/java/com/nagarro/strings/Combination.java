package com.nagarro.strings;

import java.util.LinkedHashSet;
import java.util.Set;

public class Combination {
	private static Set<String> set = new LinkedHashSet<>();
	public static void main(String arg[]) {
		String str = "ABC";
		
		combine(str,new StringBuffer(),0);
		
		set.forEach(s->System.out.println(s));
	}
	
	 public static void combine(String instr, StringBuffer outstr, int index)
	{
	    for (int i = index; i < instr.length(); i++)
	    {
	        outstr.append(instr.charAt(i));
	        System.out.println(outstr);
	        combine(instr, outstr, i + 1);
	        outstr.deleteCharAt(outstr.length() - 1);
	    }
	} 

}
