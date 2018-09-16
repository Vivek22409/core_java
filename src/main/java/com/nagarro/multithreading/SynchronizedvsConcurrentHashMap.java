package com.nagarro.multithreading;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ReadTask1 implements Runnable {

	private Map<String, Integer> map;
	

	public ReadTask1(Map<String, Integer> map) {
		super();
		this.map = map;
		new Thread(this,"Counter").start();;
	}

	@Override
	public void run() {
		map.put("One",1);	
		try {
			Thread.sleep(2000);
			System.out.println("Task one running...");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}

class ReadTask2 implements Runnable {

	private Map<String, Integer> map;
	

	public ReadTask2(Map<String, Integer> map) {
		super();
		this.map = map;
		new Thread(this,"Counter").start();;
	}

	@Override
	public void run() {
		map.put("Two",2);	
		try {
			Thread.sleep(2000);
			System.out.println("Task two running...");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}

class ReadTask3 implements Runnable {

	private Map<String, Integer> map;
	

	public ReadTask3(Map<String, Integer> map) {
		super();
		this.map = map;
		new Thread(this,"Counter").start();;
	}

	@Override
	public void run() {
		map.put("Three",3);	
		try {
			System.out.println("Task 3 running...");
			Thread.sleep(2000);			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}

public class SynchronizedvsConcurrentHashMap {
	public static void main(String arg[]) {
		Map<String,Integer> hashMap = new HashMap<String,Integer>();
		Map<String,Integer> syncMap = Collections.synchronizedMap(hashMap);
		
		ReadTask1 readTask1 = new ReadTask1(syncMap);
		ReadTask2 readTask2 = new ReadTask2(syncMap);
		ReadTask3 readTask3 = new ReadTask3(syncMap);
		//ReadTask readTask4 = new ReadTask(syncMap);
		//ReadTask readTask5 = new ReadTask(syncMap);
		
		for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}

		
		/*readTask1.start();
		readTask2.start();
		readTask3.start();
		readTask4.start();
		readTask5.start();*/	
		
		
	}

}
