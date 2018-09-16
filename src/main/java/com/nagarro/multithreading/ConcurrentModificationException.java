package com.nagarro.multithreading;

import java.util.HashMap;
import java.util.Map;

class CreateConcrntModfcExTask implements Runnable {

	Map<Integer,Character> map = new HashMap<>();

	@Override
	public void run() {
		try {
			int c=65;
			Thread.sleep(1000);
			for (int i = 1; i <=5; i++) {				
				Character ch = (char)c++;				
				
				//if("Thread-0".equals(Thread.currentThread().getName())) {
					map.remove(i);//System.out.println("sadk");
				//}else {
					map.put(i,ch);Thread.sleep(200);
				//}
				System.out.println(i+" "+ch+" ");
			}
			System.out.println(map);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}

public class ConcurrentModificationException {
	public static void main(String[] arg) {
		CreateConcrntModfcExTask cMEx = new CreateConcrntModfcExTask();
		new Thread(cMEx).start();
		new Thread(cMEx).start();	
		new Thread(cMEx).start();
		new Thread(cMEx).start();	
		new Thread(cMEx).start();
		new Thread(cMEx).start();	
		
			
	}
}
