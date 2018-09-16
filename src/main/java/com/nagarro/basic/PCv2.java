package com.nagarro.basic;

import java.util.ArrayList;
import java.util.List;

class OddEven {
	public int produceOdd() {
		int num = 0;
		for (int i = 1; i < 10; i++)
			if (i % 2 != 0)
				num = i;
		return num;
	}

	public int produceEven() {
		int num = 0;
		for (int i = 1; i < 10; i++)
			if (i % 2 == 0)
				num = i;
		return num;
	}
}

public class PCv2 {

	// private static final OddEven oe = new OddEven();
	// private static final List l = new ArrayList<>();
	// private static final int capacity =1;

	public static void main(String arg[]) {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (this) {
						for (int i = 1; i < 10; i++)
							if (i % 2 != 0) {
								System.out.println("Thread0 : " + i);
								try {
									wait();
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								notify();
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}						

					}

				}
			}
		}

		);

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					synchronized (this) {
						synchronized (this) {
							for (int i = 1; i < 10; i++)
								if (i % 2 == 0) {
									System.out.println("Thread1 : " + i);
									try {
										wait();
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									notify();
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							
						}

					}

				}

			}
		}

		);

		t1.start();
		t2.start();
	}

}
