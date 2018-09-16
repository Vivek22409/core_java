package com.nagarro.basic;

interface Care {
	 public void takeCare();
}

class Parent implements Care{	
	private String name;
	
	
	public  Parent(String name) {
		super();
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void canDo() {
		System.out.println("can earn...");
	}
	
	public static void demo() {
		System.out.println("demo Parent...");
	}

	@Override
	public void takeCare() {
		System.out.println("Take care...");		
	}

}

class Child extends Parent {
	private String schoolName;

	public Child(String name, String schoolName) {
		super(name);
		this.schoolName = schoolName;
	}
	public static void demo() {
		System.out.println("demo child...");
	}
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public void canDo() {
		System.out.println("can learn...");
	}

}

class BestChild extends Child{

	public BestChild(String name, String schoolName) {
		super(name, schoolName);		
	}
	
}

public class UpcastingAndDowncastingInJava {

	public static void main(String[] args) {
		
		/*Child c = new Child("vivek","VNH");
		BestChild bc = new BestChild("rohan", "hM");
		
		bc.demo();*/
		
		Parent p1 = new Parent("james");
		Parent p2 = new Child("johny", "saint sebestian");
		p2.demo();
		

		/*Parent p1 = new Parent("james");

		Parent p2 = new Child("johny", "saint sebestian");

		Child c = new Child("drake", "amberland garden");

		p1.canDo();
		p2.canDo();*/

		//Parent p3 = c;
		
		//Child c1 = c;
		
		//c1.setSchoolName("");
		
		 //Care care = new Parent("Alester");
		
		/*if(c instanceof Parent) {
			System.out.println("true");
		}
		
		if(care instanceof Child) {
			System.out.println("true");
		}*/
		
		
		

	}

}
