package com.nagarro.multithreading;

import java.io.IOException;

public class AdderRunnerV2 {

	public static void main(String arg[]) throws IOException, InterruptedException {
		
		long startTime = System.currentTimeMillis();
		
		String[] inFiles = { "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\1.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\2.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\3.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\4.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\5.txt" };
		String[] outFiles = { "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\1_1.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\2_2.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\3_3.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\4_4.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\5_5.txt" };
		
		//kept thread out of the loop
		Thread[] threads = new Thread[inFiles.length];
		
		for (int i = 0; i < 5; i++) {
			AdderV2 addrV2 = new AdderV2(inFiles[i], outFiles[i]);
			threads[i] = new Thread(addrV2);
			threads[i].start();
		}
		long endTime = System.currentTimeMillis();
		
		//ensure my child threads complete first and then main
		for(Thread thread:threads)
			thread.join();
		
		System.out.println("Time elapse:" + (endTime - startTime));

	}

}
