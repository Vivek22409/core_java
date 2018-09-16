package com.nagarro.multithreading;

import java.util.concurrent.Semaphore;

class Producer3 implements Runnable {

	private Semaphore semaphore;
	private String message;

	public Producer3(Semaphore semaphore, String message) {
		this.semaphore = semaphore;
		this.message = message;
	}

	@Override
	public void run() {
		int count = 0;
		int i = Integer.parseInt(message);
		while (count < 5) {
			try {				
				semaphore.acquire();				
				System.out.println("Produces..." + i);
				i=i+2;
				count++;
				semaphore.release();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer3 implements Runnable {

	private Semaphore semaphore;
	private String message;

	public Consumer3(Semaphore semaphore, String message) {
		this.semaphore = semaphore;
		this.message = message;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		int count = 0;
		int i = Integer.parseInt(message)+1;
		
		while (count < 5) {
			try {
				semaphore.acquire();
				System.out.println("Consumes..." + i);
				i=i+2;
				count++;
				semaphore.release();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

public class ProducerConsumerwithSemaphores {

	public static void main(String arg[]) {
		Semaphore semaPhore = new Semaphore(1);
		String message = "1";

		Producer3 p = new Producer3(semaPhore, message);
		Consumer3 c = new Consumer3(semaPhore, message);

		new Thread(p).start();
		new Thread(c).start();

	}

}
