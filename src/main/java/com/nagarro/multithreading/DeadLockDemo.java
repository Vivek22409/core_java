package com.nagarro.multithreading;

class Deadlock{
	public void method1() {
		synchronized(Integer.class) {
			System.out.println("inside integer...");
			synchronized (String.class) {
				System.out.println("inside string...");
			}
		}
	}
	public void method2() {
		synchronized(String.class) {
			System.out.println("inside string...");
			synchronized (Integer.class) {
				System.out.println("inside intger...");
			}
		}
	}
}

public class DeadLockDemo {
	
	public static void main(String arg[]) {
		
		Deadlock d = new Deadlock();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				d.method1();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				d.method2();
			}
		};
		
		t1.start();
		t2.start();
		
	}

}
