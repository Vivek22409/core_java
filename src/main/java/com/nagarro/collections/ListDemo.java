package com.nagarro.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	
	public static void main(String arg[]){
		
		Integer[] i = {2,3};
		List<Integer> l = Arrays.asList(i);
		l.set(1,4);
		
		
		System.out.println(l);
		
		/*//concept:1 https://www.journaldev.com/378/java-util-concurrentmodificationexception
		List<String> list = new ArrayList<>();
		
		list.add("vivek");
		list.add("rahul");
		list.add("pinto");
		list.add("johnu");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()){
			itr.remove();
			String s = itr.next();
			System.out.println(s);
			if(s.equals("rahul")){
				itr.remove();
			}
		}
		
		System.out.println(list);
		
		System.out.println(list.add("mithun"));
		System.out.println(list.add("mithun"));
		
		List<String> subList = list.subList(0, 2);
		
		System.out.println(list);
		System.out.println(subList);
		
		subList.set(0,"rohan");
		
		System.out.println(subList);
		
		//modifying backing list
		list.add("vinod");
		
		//accessing sublist after changing backing list
		//System.out.println(subList);
*/	}

}
