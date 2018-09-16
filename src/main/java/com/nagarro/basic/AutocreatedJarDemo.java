package com.nagarro.basic;

import java.time.LocalDate;

import com.nagarro.demo.Person;

public class AutocreatedJarDemo {
	public static void main(String arg[]) {
		Person p = new Person("Vivek", LocalDate.of(1991, 11, 15));
		System.out.println(p);
		
		LocalDate l1 = LocalDate.now();
		LocalDate l2 = LocalDate.now();
		
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();
		
		
		System.out.println(l1==l2);
		
		System.out.println(r1==r2);
		
	}

}
