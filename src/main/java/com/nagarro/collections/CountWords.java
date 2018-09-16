package com.nagarro.collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CountWords {
	public static void main(String arg[]){
		String str = "We live on the most beautiful planet, Earth which has very clean and attractive nature full of greenery. "
				+ "Nature is our best friend which provides us all the resources to live here. It gives us water to drink, pure air to breathe,"
				+ " food to eat, land to stay, animals, plants for our other uses, etc for our betterment."
				+ " We should fully enjoy the nature without disturbing its ecological balance. We should care our nature, make it peaceful, "
				+ "keep it clean and prevent it from the destruction so that we can enjoy our nature forever. Nature is a most precious gift given "
				+ "by the God to us to enjoy but not to harm.";
		Map<String,Integer> wordCounts = new HashMap<String,Integer>();

		try {
			File file = new File("C:\\Users\\vivekkumar02\\Desktop\\JavaInterview-20180716T112345Z-001\\JavaInterview\\Xtra\\a.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				str = line;
				String[] strArr = str.split("\\s");
				getMaxTenOccurencesOfWords(strArr,wordCounts);
				strArr =null;
				str =null;
				//stringBuffer.append(line);
				//stringBuffer.append("\n");
			}
			fileReader.close();
			//System.out.println("Contents of file:");
			//System.out.println(stringBuffer.toString());
			Set<Entry<String, Integer>> set = wordCounts.entrySet();
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
			Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
			{
				public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
				{
					return (o2.getValue()).compareTo( o1.getValue() );
				}
			} );
			int count = 0;
			for(Map.Entry<String, Integer> entry:list){
				count++;
				System.out.println(entry.getKey()+" ==== "+entry.getValue());
				if(count==10){
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}




	}

	public static void getMaxTenOccurencesOfWords(String[] strArr,Map<String,Integer> wordCounts){

		//Map<Integer,String> wordCountsInorder = new TreeMap<Integer,String>();
		int counter = 1;
		for(String s:strArr){
			if(wordCounts.containsKey(s)){
				int count = wordCounts.get(s)+1;
				wordCounts.put(s,count );
				//wordCountsInorder.put(count, s);
			} else {
				wordCounts.put(s, counter);
				//wordCountsInorder.put(counter, s);
			}
		}

		//wordCounts.forEach((k,v)->System.out.println(k+"-"+v));
		//wordCountsInorder.forEach((k,v)->System.out.println(k+"-"+v));
	}

}
