package com.nagarro.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class FileReaderDemo {

	
	public static void main(String arg[]) throws InterruptedException {
		Map<String,Integer> map = new HashMap<>();
		int count=1;
		try (FileReader fr = new FileReader(new File("C:\\Users\\vivekkumar02\\Desktop\\JavaInterview-20180716T112345Z-001\\JavaInterview\\Xtra\\a.txt"));
				BufferedReader br = new BufferedReader(fr);) {

			/*
			 * List<String> lines = Collections.emptyList(); try { lines =
			 * Files.readAllLines(Paths.get(
			 * "C:\\Users\\vivekkumar02\\Desktop\\JavaInterview-20180716T112345Z-001\\JavaInterview\\Xtra\\a.txt"
			 * ), StandardCharsets.UTF_8); } catch (Exception e) {
			 * 
			 * } for (String s : lines) { System.out.println(s); }
			

			Scanner sc = new Scanner(new File(
					"C:\\Users\\vivekkumar02\\Desktop\\JavaInterview-20180716T112345Z-001\\JavaInterview\\Xtra\\a.txt"));

			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
				Thread.sleep(200);
			}*/

			String str = "";
			while ((str = br.readLine()) != null) {
				String[] strArr=str.split("\\s");
				for(String s:strArr) {
					if(map.containsKey(s)) {
						map.put(s, map.get(s)+1);
					} else {
						map.put(s, count);
					}
				}
				strArr = null;
				str =null;
				//System.out.println(str);
				//Thread.sleep(200);
			}

			Set<Entry<String,Integer>> set = map.entrySet();
			List<Entry<String,Integer>> list = new ArrayList<>(set);
			
			Collections.sort(list,(mapEntry1,mapEntry2) -> { return mapEntry2.getValue().compareTo(mapEntry1.getValue()) ;});
			
			for(Map.Entry<String,Integer> entry:list) {
				System.out.println(entry.getKey()+"==="+entry.getValue());
			}

			/*
			 * 
			 * int i = 0, count = 0; while ((i = fr.read()) != -1) { System.out.print((char)
			 * i); count++; // Thread.sleep(200); } System.out.println(count);
			 */

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
