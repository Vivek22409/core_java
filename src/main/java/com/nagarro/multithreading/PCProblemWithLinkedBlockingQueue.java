package com.nagarro.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {

	private final BlockingQueue<Integer> bq;

	public Producer(BlockingQueue bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 11) {
			System.out.println("Producer produces: " + i);
			bq.add(i++);
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}

}

class Consumer implements Runnable {

	private final BlockingQueue<Integer> bq;

	public Consumer(BlockingQueue bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		int k=0;
		while (k < 11) {
			try {				
				int j = bq.take();
				System.out.println("Consumer consumes: " + j);
				k++;
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}

public class PCProblemWithLinkedBlockingQueue {

	public static void main(String arg[]) {

		BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>();
		new Thread(new Producer(bq)).start();
		;
		new Thread(new Consumer(bq)).start();
		;
	}
}
