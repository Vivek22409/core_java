package com.nagarro.io;

import java.io.File;
import java.io.IOException;

public class FilesDemo {

	public static void main(String arg[]) throws IOException {
		File directory = new File("C:\\Users\\vivekkumar02\\Desktop\\JavaInterview");
		
		filesRecursiveTravel(directory);
		
	}

	public static void filesRecursiveTravel(File directory) throws IOException {
		
		File[] directories = directory.listFiles();

		for (File file : directories) {
			if (file.isDirectory()) {
				if(file.getName().contains("Forms"));
				System.out.println(file.getName());
				
				filesRecursiveTravel(file);
			}
			if(file.isFile()) {
				System.out.println("File: "+file.getPath());
			}
		}
	}

}
