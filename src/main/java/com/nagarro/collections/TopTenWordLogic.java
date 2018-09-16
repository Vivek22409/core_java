package com.nagarro.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TopTenWordLogic {
	
	public static void main(String arg[]) {
		Map<String,Integer> map = new HashMap<>();
		
		
		
		map.put("a",8);
		map.put("b",67);
		map.put("c",54);
		map.put("d",8);
		map.put("e",32);
		map.put("f",8);
		map.put("g",2);
		
		
		TreeMap<String,Integer> treeMap = new TreeMap<>(map);
		SortedMap<String,Integer> sortedHeadMap = treeMap.subMap("a", "c");// head/tailMap("c");
		System.out.println(sortedHeadMap);
		
		/*Set<Entry<String,Integer>> set = map.entrySet();
		
		List<Entry<String,Integer>> list = new ArrayList<>();
		
		for(Entry<String,Integer> e:set)
			list.add(e);
		
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
			@Override
			public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		Comparator<Map.Entry<String,Integer>> cmp = (o1,o2) ->  {return o2.getValue()-o1.getValue();};
		Collections.sort(list, cmp);
		
		
		for(Map.Entry<String,Integer> me:list) {
			System.out.println(me.getKey()+" "+me.getValue());
		}*/
		
	}

}
