package com.nagarro.multithreading;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AdderRunnerV3 {

	public static void main(String arg[]) throws IOException,InterruptedException {
		
		long startTime = System.currentTimeMillis();
		
		String[] inFiles = { "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\1.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\2.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\3.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\4.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\5.txt" };
		/*String[] outFiles = { "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\1_1.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\2_2.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\3_3.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\4_4.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\5_5.txt" };
		*/
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		Future[] future = new Future[inFiles.length];
		
		for (int i = 0; i < 5; i++) {
			AdderV3 addrV3 = new AdderV3(inFiles[i]);
			future[i]=es.submit(addrV3);
			//addrV1.doAdd();
		}
		long endTime = System.currentTimeMillis();
		
		es.shutdown();
		
		for(Future<Integer> f:future) {
			int n;
			try {
				n = f.get();
				System.out.println("Total: "+n);
			} catch (ExecutionException e) { //Exception raised in adder
				Throwable addrEx =e.getCause(); // get adder exception
				System.out.println(addrEx.toString());
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		es.awaitTermination(60,TimeUnit.SECONDS);
		
		System.out.println("Time elapse:" + (endTime - startTime));

	}

}
