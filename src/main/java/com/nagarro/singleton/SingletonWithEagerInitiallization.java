package com.nagarro.singleton;

import java.io.Serializable;


public class SingletonWithEagerInitiallization extends SuperClass /*implements Cloneable*//* implements Serializable,*/{
	private static final SingletonWithEagerInitiallization s= new SingletonWithEagerInitiallization();
	
	//Another way to initialize singleton object and for handlin exception 
	/*static {
	 try {
		s=new SingletonWithEagerInitiallization();
	 } catch(Exception ex) {
		 throw new RuntimeException("Exception while creating object...");
	 }
	}*/	
	
	private SingletonWithEagerInitiallization() {}
	
	public static SingletonWithEagerInitiallization getInstance() {
		return s;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return s;
		//throw new CloneNotSupportedException();
	}
	
	/*protected Object readResolve() {
		return s;		
	}*/

}
