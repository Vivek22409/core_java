package com.nagarro.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Either<A, B> {
	public Either() {
	}
}

class Left<A, B> extends Either<A, B> {
	public final A value;

	public Left(A value) {
		this.value = value;
	}
}

class Right<A, B> extends Either<A, B> {
	public final B value;

	public Right(B value) {
		this.value = value;
	}
}

public class Strings {

	public static void main(String arg[]) {

		
		  String str1 = "Hello"; String str2 = "Hello"; Integer int1 = 40; Integer int2=40;
		  System.out.println(str1.hashCode());
		 System.out.println(str2.hashCode()); System.out.println(int1.hashCode());
		 System.out.println(int2.hashCode()); System.out.println(str1==str2);
		 System.out.println(int1==int2);
		 

		/*String s = String.valueOf('v');
		System.out.println(s);
		System.out.println(Character.isLetter('Y'));
		Character c = 'g';
		char[] charArr = s.toCharArray();
		int[] i = { 2, 4, 3 };

		Integer t = 3;
		System.out.println(t.toString().matches("\\D"));
		String g = "";
		System.out.println(g instanceof String);

		List<Either<Integer,String>> li = new ArrayList<Either<Integer,String>>();*/
		/*List lis = Arrays.asList(1,"a",5,"g","a",1); 
		for (Either<Integer, String> either : lis) {
			if (either instanceof Left) {
				//Integer i = ((Left<Integer, String>) either).value;
				li.add(either);
			} else if (either instanceof Right) {
				//String string = ((Right<Integer, String>) either).value;
				li.add(either);
			}
		}*/
		
	}

}
