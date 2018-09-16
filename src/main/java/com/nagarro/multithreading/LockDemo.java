package com.nagarro.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Producer4 {
	private Lock l;

	public Producer4(Lock l) {
		this.l = l;
	}

	public void produce() throws InterruptedException {
		int i = 1;
		while (i <= 5) {
			l.lock();
			System.out.println("produce..." + i);
			i++;
			l.unlock();
			Thread.sleep(1000);
		}
	}

}

class Consumer4 {
	private Lock l;

	public Consumer4(Lock l) {
		this.l = l;
	}

	public void consume() throws InterruptedException {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		;
		int i = 1;
		while (i <= 5) {
			l.lock();
			System.out.println("consume..." + i);
			i++;
			l.unlock();
			Thread.sleep(1000);
		}
	}

}

public class LockDemo {

	public static void main(String arg[]) {
		Lock l = new ReentrantLock();
		Producer4 p = new Producer4(l);
		Consumer4 c = new Consumer4(l);

		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					p.produce();
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					c.consume();
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}				
			}
		};

		t1.start();
		t2.start();
	}

}
