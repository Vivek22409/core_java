package com.nagarro.basic;

public class PassByvalueConcept {

	public static void displayIntegers(int a, int b) {
		a = a + 3;
		b = b + 2;
		System.out.println(a + " " + b);
	}
	
	public static void displayPerson(Person p) {
		p.setName("rahul");
		System.out.println("Inside method: "+p.getName());
	}
	
	public static void displayString(String s) {
		s.concat("venu");
		System.out.println("Inside method: "+s);
	}
	
	public static void displayStringBuffer(StringBuffer sb) {
		sb.append("venu");
		System.out.println("Inside method: "+sb);
	}

	public static void main(String[] args) {

		int a = 1, b = 1;
		displayIntegers(a, b);
		System.out.println("Inside main: "+a+" " + b);
		
		String s ="rohan";		
		displayString(s);		
		System.out.println("Inside main: "+s);
		
		StringBuffer sb = new StringBuffer("rohan");		
		displayStringBuffer(sb);		
		System.out.println("Inside main: "+sb);
		
		Person p =new Person(100,"vivek", 27);		
		displayPerson(p);		
		System.out.println("Inside main: "+p.getName());
	}

}
