package com.nagarro.basic;

import java.lang.reflect.Method;
import java.util.Calendar;

public class ClassDemo {
	
	public static void main(String arg[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*Class c =  Class.forName("com.nagarro.basic.Parent1");
		Parent1 p1 = (Parent1) c.newInstance();
		
		Method[] m = c.getDeclaredMethods();
		
		for(Method method:m)
			System.out.println(method.getName());*/
		System.out.println(Calendar.getInstance());
		Thread t = new Thread() {
			private int i =1;
			public void display() {
				System.out.println("display..");
			}
			@Override
			public void run() {
				System.out.println("hello");
				display();
			}
		};
		t.start();
	}

}
