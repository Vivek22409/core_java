package com.nagarro.multithreading;

import java.util.ArrayList;
import java.util.List;

class ProdCon {

	List<Integer> l = new ArrayList<>();

	public void produce() throws InterruptedException {
		int value = 0, capacity=1;
		while (true) {
			synchronized (this) {
				while (l.size() == capacity)
					wait();
				System.out.println("Producer produces...."+value);
				l.add(value++);
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		int count=0;
		while (true) {
			synchronized (this) {
				while (l.size() == 0)
					wait();
				int value = l.get(0);
				l.clear();
				System.out.println("Consumer consumes...."+ value);
				notify();
				Thread.sleep(1000);
			}
		}
	}

}

public class ProducerConsumerDemoWithList {
	public static void main(String arg[]) {
		
		final ProdCon pc = new ProdCon();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.consume();
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
