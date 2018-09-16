package com.nagarro.multithreading;

class OddEven {
	public void printOdd() throws InterruptedException {
		synchronized (this) {
			for (int i = 1; i < 10; i++) {
				if (i % 2 != 0) {
					System.out.println(i);
					wait();
				}
				
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public void printEven() throws InterruptedException {
		synchronized (this) {
			for (int i = 1; i < 10; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
					wait();
				}				
				notify();
				Thread.sleep(1000);
			}
		}
	}
}

class Oddtask implements Runnable {
	private OddEven oe;

	public Oddtask(OddEven oe) {
		this.oe = oe;
	}

	@Override
	public void run() {

		try {
			oe.printOdd();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class EvenTask implements Runnable {
	private OddEven oe;

	public EvenTask(OddEven oe) {
		this.oe = oe;
	}

	@Override
	public void run() {

		try {
			oe.printEven();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}

public class ThreadDemo {
	public static void main(String arg[]) {
		final OddEven oe = new OddEven();
		Thread oddTask = new Thread(new Oddtask(oe));
		Thread evenTask = new Thread(new EvenTask(oe));

		oddTask.start();
		evenTask.start();
	}
}
