package com.nagarro.basic;

import java.util.ArrayList;
import java.util.List;

class OddEvenNumber {
	List<Integer> l = new ArrayList<>();
	
	public void printOdd() throws InterruptedException {
		synchronized (this) {
			int i = 1;
			while(true) {
			//for (int i = 1; i <= 10; i++) {
				//if (i % 2 != 0) {
					l.add(i);				
					
					System.out.println("T1 Produces...message" + l.get(0));
					i++;
					notify();
					Thread.sleep(500);
					if(i==10)
						break;
					wait(1000);
				//}				
				
				//Thread.sleep(1000);
			}

		}
	}

	public void printEven() throws InterruptedException {
		// Thread.sleep(1000);
		synchronized (this) {
			int count =1;
			while(true) {
			//for (int i = 1; i <= 10; i++) {
				//if (i % 2 == 0) {
				if(count==10)
					break;
					count++;
					System.out.println("T2 Consumes..." + l.get(0));
					l.remove(0);
					notify();
					Thread.sleep(500);
					
					
						//break;
					wait(1000);

				//}
				
				//Thread.sleep(1000);
			}

		}
	}
}

public class PCDemo {

	public static void main(String arg[]) {
		OddEvenNumber oe = new OddEvenNumber();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					oe.printOdd();
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
					oe.printEven();
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
