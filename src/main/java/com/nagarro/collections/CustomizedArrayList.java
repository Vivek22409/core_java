package com.nagarro.collections;

import java.util.ArrayList;
import java.util.List;

class MyList<T> extends ArrayList<Object> {
	@Override
	public boolean add(Object o) {
		boolean result = true;
		if(o instanceof Integer || o instanceof String) {
			super.add(o);
			return result;
		} else {
			throw new IllegalStateException("Can't add element");
		}		
	}
}

public class CustomizedArrayList extends ArrayList{

	public static void main(String arg[]) {
		
		MyList<Object> li = new MyList<Object>();
		li.add(12);
		li.add("String");
		//li.add(new Long(45));
		
		System.out.println(li);
	}

}
