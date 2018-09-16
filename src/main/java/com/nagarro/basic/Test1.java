package com.nagarro.basic;

public class Test1 {
	
	public Test1() {
		System.out.println("Hello...");
	}

	static {

		System.out.println("Hello");
		//System.exit(1);
	}
	{
		System.out.println("abc");
	}
	
	public static void main(String arg[]) {
		System.out.println("j");
		Test1 t1 = new Test1();
		
		Integer i = new Integer(3);
		System.out.println(i.TYPE);
		System.out.println(i.toHexString(i));
	}

}
