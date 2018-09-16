package com.nagarro.singleton;

public class BillPughSingleton {
	
	private BillPughSingleton() {}
	
	private static class BPSingletonHelper{
		private static final BillPughSingleton bps = new BillPughSingleton();
	}
	
	public static BillPughSingleton getSingleton() {
		return BPSingletonHelper.bps;
	}

}
