package com.nagarro.multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder {
	private String inFile, outFile;

	public Adder(String inFile, String outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}

	public void doAdd() throws IOException {
		
		int total = 0;
		String line  = null;
		
		try(BufferedReader br = Files.newBufferedReader(Paths.get(inFile))){
			while((line = br.readLine())!=null) {
				total +=Integer.parseInt(line);
			}
		}
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(outFile))){
			bw.write("Total: "+total);
		}
	}

}
