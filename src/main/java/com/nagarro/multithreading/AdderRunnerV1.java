package com.nagarro.multithreading;

import java.io.IOException;

public class AdderRunnerV1 {

	public static void main(String arg[]) throws IOException {
		long startTime = System.currentTimeMillis();
		String[] inFiles = { "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\1.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\2.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\3.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\4.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\5.txt" };
		String[] outFiles = { "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\1_1.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\2_2.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\3_3.txt",
				"C:\\Users\\vivekkumar02\\Desktop\\Xtra\\4_4.txt", "C:\\Users\\vivekkumar02\\Desktop\\Xtra\\5_5.txt" };

		for (int i = 0; i < 5; i++) {
			AdderV1 addrV1 = new AdderV1(inFiles[i],outFiles[i]);
			Thread thread = new Thread(addrV1);
			thread.start();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time elapse:"+(endTime-startTime));

	}

}
