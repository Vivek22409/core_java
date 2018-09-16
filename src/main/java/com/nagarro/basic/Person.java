package com.nagarro.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Person implements Comparable<Person>, Comparator {

	private int id;
	private String name;
	private int age;

	public Person(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String arg[]) {
		Person p1 = new Person(1, "vivek", 29);
		Person p2 = new Person(1, "vivek", 50);
		Person p3 = new Person(2, "tarun", 26);
		Person p4 = new Person(1, "aruna", 27);
		Person p5 = new Person(1, "aruna", 46);

		/*
		 * List<String> l = new ArrayList<>();Arrays.asList("vivek","rohan");
		 * System.out.println(l.add("b"));
		 * 
		 * Set<String> s =new HashSet<>(); System.out.println(s.add("a"));
		 * System.out.println(s.add("a"));
		 */

		// System.out.println(p1.hashCode()+" "+p2.hashCode());
		Map<Person, Integer> p = new TreeMap<>();
		/*
		 * System.out.println(p.put(p1,1)); System.out.println(p.put(p1,1));
		 * System.out.println(p.put(p1,1));
		 */
		p.put(p1, 1);
		p.put(p2, 2);
		p.put(p3, 3);
		p.put(p4, 4);
		p.put(p5, 5);

		p.forEach((k, v) -> System.out.println(k + " " + v));

	}

	@Override
	public int compareTo(Person o) {
		return this.id - o.id != 0 ? this.id - o.id
				: this.name.compareTo(o.name) != 0 ? this.name.compareTo(o.name) : this.age - o.age;
	}

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}

	@Override
	public String toString() {
		return "[ Id: " + this.id + " Name: " + this.name + " Age: " + this.age + " ]";
	}
}
