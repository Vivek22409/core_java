package com.nagarro.serialization;

import java.io.Serializable;
class Object implements Serializable{
	private int objectId;
	public Object() {
		System.out.println("Inside Object...");
	}
}

class Item extends Object {
	private int itemId;
	
	public Item() {
		super();
		System.out.println("Inside Item");
	}
}

class Table extends Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private int length;
	private int width;
	private int legs;	

	public Table(int length, int width, int legs) {
		super();
		this.length = length;
		this.width = width;
		this.legs = legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}	

	@Override
	public String toString() {
		return "Table [length=" + length + ", width=" + width + ", madeOf=" + legs + "]";
	}

}

public class WoodenTable extends Table {

	private String madeOf;
	public static String statEg="abc";

	public WoodenTable(int length, int width, int legs, String madeOf) {
		super(length, width, legs);
		this.madeOf = madeOf;
	}
	
	

	public static String getStatEg() {
		return statEg;
	}



	public static void setStatEg(String statEg) {
		WoodenTable.statEg = statEg;
	}



	@Override
	public String toString() {
		return "WoodenTable [madeOf=" + madeOf + "]";
	}
	
	

}
