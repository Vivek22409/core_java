package com.nagarro.collections;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;


@SuppressWarnings("hiding")
class TwoGenrics<Integer,String>{
	Integer t;
	String v;
	
	TwoGenrics(Integer t,String v){
		this.t= t;
		this.v=v;
	}
	
	Integer getInteger() {
		return t;
	}
	
	String getString() {
		return v;
	}

	@Override
	public java.lang.String toString() {
		return "TwoGenrics [t=" + t + ", v=" + v + "]";
	}
	
	
}

public class StringIntegerSafeList{

	
	public static void main(String[] arg) {
		List<TwoGenrics> list = new ArrayList<>();
		list.add(new TwoGenrics(123,"vivek"));
		list.add(new TwoGenrics(124,"rahul"));
		list.add(new TwoGenrics(125,"sohan"));
		list.add(new TwoGenrics(new Person(12,"ghj"),"mohan"));
		list.add(new TwoGenrics("ajks","vinod"));
		
		System.out.println(list);
	}

}
