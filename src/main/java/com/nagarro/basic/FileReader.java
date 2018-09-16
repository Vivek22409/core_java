package com.nagarro.basic;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

	public static void main(String[] args) throws InterruptedException {
		List<String> lines = Collections.emptyList();
		Stream<String> stream = null;
		try {
		//lines = Files.readAllLines(Paths.get("C:\\Users\\vivekkumar02\\Desktop\\JavaInterview-20180716T112345Z-001\\JavaInterview\\Xtra\\a.txt"),StandardCharsets.UTF_8);
			stream = Files.lines(Paths.get("C:\\Users\\vivekkumar02\\Desktop\\JavaInterview-20180716T112345Z-001\\JavaInterview\\Xtra\\a.txt"));
		}catch(Exception e) {
			
		}
		/*stream.forEach(s -> {System.out.println(s);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});*/
		
		lines = stream.filter(line->line.startsWith("We")).map(String::toUpperCase).collect(Collectors.toList());
		
		for(String s:lines) {
			System.out.println(s);
			Thread.sleep(200);
		}

	}

}
