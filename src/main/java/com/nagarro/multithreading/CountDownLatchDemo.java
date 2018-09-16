package com.nagarro.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable {
	private int delayTime;
	private CountDownLatch cdl;

	public Worker(int delayTime, CountDownLatch cdl) {
		this.delayTime = delayTime;
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+" started...");
			Thread.sleep(delayTime);
			cdl.countDown();
			System.out.println(cdl.getCount());	
			System.out.println(Thread.currentThread().getName()+" finished...");		
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}

public class CountDownLatchDemo {

	public static void main(String[] arg) throws InterruptedException {
		
		CountDownLatch cdl = new CountDownLatch(3);
		
		Worker[] workers = {new Worker(1000,cdl),new Worker(4000,cdl),new Worker(3000,cdl)};
		
		for(int i=0;i<workers.length;i++) {
			Thread t = new Thread(workers[i]);
			t.start();	
			//t.join();
		}
		
		cdl.await(60,TimeUnit.SECONDS);
		System.out.println("Now Maintask starts");		

	}

}
