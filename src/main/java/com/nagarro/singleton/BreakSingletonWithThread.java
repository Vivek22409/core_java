package com.nagarro.singleton;

import java.util.concurrent.Callable;

public class BreakSingletonWithThread implements Callable {
	SingletonWithLazyInitiallization swi;
	
	private SingletonWithLazyInitiallization doBreakSingleton() {
		try {
		swi = SingletonWithLazyInitiallization.getInstance();
		} catch(InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
		return swi;
	}
	
	@Override
	public SingletonWithLazyInitiallization call() {
		return doBreakSingleton();
	}

}
