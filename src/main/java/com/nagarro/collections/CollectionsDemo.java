package com.nagarro.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Student implements Comparable<Student>, Serializable{

	private int id;
	private String name;

	public Student(int id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int compareTo(Student stu) {
		return this.id-stu.id;
	}
	
}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		return stu1.getId()-stu2.getId();
	}	
}

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message){
		super(message);
	}

}

public class CollectionsDemo {
	public static void main(String[] arg) throws InvalidAgeException{
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"vivek"));
		list.add(new Student(3,"rahul"));
		list.add(new Student(2,"nitin"));
		
		//Collections.sort(list,new StudentComparator().n);
		
		list.forEach(content -> System.out.println(content));
		
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		System.out.println("***"+map.put(null, "vivek"));
		System.out.println("***"+map.put(null, "vivek"));
		System.out.println("***"+map.put(null, "vivek"));
		map.put(3, "rahul");
		map.put(2, "nitin");
		
		
		
		Iterator<Integer> itr1 = map.keySet().iterator();
		System.out.println("hello");
		while(itr1.hasNext()){
			Integer str = (Integer) itr1.next();
			System.out.println("#"+map.get(str));
			System.out.println("Hello");
		}
		
		map.forEach((k,v)->System.out.println(k+"*"+v));
		
		for(Map.Entry<Integer,String> entry:map.entrySet() ){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		Map<Student,String> map1 = new TreeMap<>();
		map1.put(new Student(1,"vivek"), "ABC");
		map1.put(new Student(3,"rahul"), "EFG");
		map1.put(new Student(3,"rahul"), "EFG");
		map1.put(new Student(2,"nitin"), "JKL");
		map1.put(new Student(2,"nitin"), "JKL");
		
		for(Map.Entry<Student,String> entry:map1.entrySet() ){
			System.out.println(entry.getKey().getId()+" "+entry.getValue());
		}
		
		for(Object obj : map1.keySet()){
			System.out.println(obj.toString()+"&"+map.get(obj.toString()));
		}
		
		CollectionsDemo cd = new CollectionsDemo();
		//cd.validateAge(17);
		
		Collections.sort(list,new StudentComparator());
		list.forEach(stu->System.out.println(stu.getId()));
	}
	
	public boolean validateAge(int age) throws InvalidAgeException{
		if(age<18){
			throw new InvalidAgeException("Invalid Age....!");
		}
		return true;
	}

}
