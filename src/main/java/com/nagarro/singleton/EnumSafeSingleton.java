package com.nagarro.singleton;

public enum EnumSafeSingleton {
	
	INSTANCE;

	EnumSafeSingleton() {}

	public EnumSafeSingleton getInstance() {
		return EnumSafeSingleton.INSTANCE;
	}

}
