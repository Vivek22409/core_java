package com.nagarro.basic;

interface StringOrInteger<String,Integer>{
	Integer getInteger(String s); 
	String getString(Integer i);
}

public class CustomizedList<String,Integer> implements StringOrInteger<String,Integer> {
	
	

	@Override
	public Integer getInteger(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getString(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
