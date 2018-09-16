package com.nagarro.collections;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingQueuedemo {

	public static void main(String arg[]) {

		LinkedBlockingDeque<String> l = new LinkedBlockingDeque<>();

		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while (true) {
					String str = UUID.randomUUID().toString();
					try {
						System.out.println("Put data:" + str);
						l.put(str);
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						String str = l.take();
						System.out.println("Put data:" + str);
						//l.put(str);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		new Thread(r1).start();
		new Thread(r2).start();

	}

}
