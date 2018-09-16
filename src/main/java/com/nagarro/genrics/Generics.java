package com.nagarro.genrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Container<T>{
	private T obj;
		
	public Container(T obj1) {
		super();
		this.obj = obj1;
	}	
	public T getObj1() {
		return obj;
	}
	public void setObj1(T obj1) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return ""+obj;
	}
	
}

public class Generics {
	public static void main(String arg[]){
		List<Container> list = new ArrayList<>();
		list.add(new Container("ABC"));
		list.add(new Container(12));
		System.out.println(getWordsCount(list));
	}
	public static Map<Container,Integer> getWordsCount(List<Container> list){
		Map<Container,Integer> countMap = new HashMap<Container,Integer>();
		int count=1;
		for(Container c:list){
			if(countMap.containsKey(c)){
				countMap.put(c,countMap.get(c)+1);
			} else {
				countMap.put(c,count);
			}
		}
		return countMap;
	}
}
