package com.nagarro.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class PC {

	private BlockingQueue lq;
	private int data=1;

	public PC(BlockingQueue lq) {
		this.lq = lq;
	}

	public void produce() throws InterruptedException {
		System.out.println("Produces..."+data);
		lq.add(data++);		
		Thread.sleep(1000);
	}

	public void cosume() throws InterruptedException {
		System.out.println("Consumes..."+lq.take());
		Thread.sleep(1000);
	}
}

class PCV1{
	private static final BlockingQueue bq = new LinkedBlockingQueue<>();
	private static final PC pc= new PC(bq);
	
	public static void main(String arg[]) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				 try {
					for(int i=1;i<5;i++)
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				 
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i=1;i<5;i++)
					pc.cosume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
	}
}