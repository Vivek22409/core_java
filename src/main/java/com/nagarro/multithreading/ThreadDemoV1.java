package com.nagarro.multithreading;

class EvenOddNoPrint {
	public void printOddNos() throws InterruptedException{
		synchronized(this){ 
			for(int i=1;i<=10;i++){
				if(i%2!=0){
					System.out.println("From Thread1:"+i);
					wait();
				}
				notify();
				Thread.sleep(500);
			}
		}
	}
	public void printEvenNos() throws InterruptedException{

		synchronized(this){
			for(int i=1;i<=10;i++){
				if(i%2==0){
					System.out.println("From Thread2:"+i);
					wait();
				}
				notify();
				Thread.sleep(500);
			}
		}
	}
}

public class ThreadDemoV1 {
	public static void main(String arg[]){
		EvenOddNoPrint evenOddtsk = new EvenOddNoPrint();

		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					evenOddtsk.printOddNos();
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}				
			}
		});

		Thread t2 = new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					evenOddtsk.printEvenNos();
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
