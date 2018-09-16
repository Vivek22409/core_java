package com.nagarro.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFileLineByLine {

	public static void main(String[] args) throws IOException {
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("C:\\Users\\vivekkumar02\\Desktop\\Xtra\\1.txt"))){
			for(int i=1;i<10000;i++) {
				bw.write(i);
				bw.newLine();
			}
		}
		System.out.println("Write done...");

	}

}
