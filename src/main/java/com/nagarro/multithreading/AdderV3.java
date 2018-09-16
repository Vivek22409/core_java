package com.nagarro.multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class AdderV3 implements Callable<Integer> {
	private String inFile;

	public AdderV3(String inFile) {
		this.inFile = inFile;

	}

	public int doAdd() throws IOException {

		int total = 0;
		String line = null;

		try (BufferedReader br = Files.newBufferedReader(Paths.get(inFile))) {
			while ((line = br.readLine()) != null) {
				total += Integer.parseInt(line);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return total;
	}

	@Override
	public Integer call() throws IOException {
		
		return doAdd();
	}

}
