package com.nagarro.multithreading;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterDemo {
	
	public static void main(String arg[]) {
		System.out.println(arg[0]+" "+arg[1]);
		
		ExecutorService ex = Executors.newFixedThreadPool(1); 
		
		Runnable r = () -> {System.out.println(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d")); Thread.currentThread().getName();
		try {
			Runnable r1 = new Runnable() {

				@Override
				public void run() {
					System.out.println("Hello");
					
				}
				
			};
			new Thread(r1).start();
			
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}};
		ex.execute(r);
	}

}
