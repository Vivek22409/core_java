package com.nagarro.basic;

public class RuntimeInformation {
	public static void main(String arg[]) {
		
		Runtime rt = Runtime.getRuntime();
		
		System.out.println(rt);
		
		rt.gc();
		
		Runtime rt1 = Runtime.getRuntime();
		
		System.out.println(rt1);
		
		if(rt==rt1)
			System.out.println("true");
		
		StringBuilder sb;
		
		
		/*System.out.println(Runtime.getRuntime().totalMemory());
		
		System.out.println(Runtime.getRuntime().maxMemory());
		
		System.out.println(Runtime.getRuntime().freeMemory() );
		
		
		
		System.out.println(Runtime.getRuntime().availableProcessors());*/
	}

}
