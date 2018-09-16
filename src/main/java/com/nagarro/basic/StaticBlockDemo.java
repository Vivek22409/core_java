package com.nagarro.basic;

public class StaticBlockDemo {
	
	private static String str = "vivek";
	
	static {
		str = "rohit";
	}

	public static void main(String arg[]) {
		System.out.println(new StaticBlockDemo().str);
	}
}
