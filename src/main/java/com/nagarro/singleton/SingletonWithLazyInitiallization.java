package com.nagarro.singleton;

public class SingletonWithLazyInitiallization {

	private static volatile SingletonWithLazyInitiallization s;

	private SingletonWithLazyInitiallization() {
	}

	/*
	 * public static synchronized SingletonWithLazyInitiallization getInstance()
	 * throws InterruptedException { if(s==null) { Thread.sleep(1000); s = new
	 * SingletonWithLazyInitiallization(); } return s; }
	 */

	public static /*synchronized*/ SingletonWithLazyInitiallization getInstance() throws InterruptedException {
		if (s == null) {
			synchronized (SingletonWithLazyInitiallization.class) {
				if (s == null) {
					Thread.sleep(1000);
					s = new SingletonWithLazyInitiallization();
				}
			}
		}
		return s;
	}

}
