package com.nagarro.basic;

import java.util.Arrays;

public class Demo {

	static {
		System.out.println("hello");
	}

	public static void main(String arg[]) {
		
		int num = 123878567;
		int rev =0;
		for(int i=0;num>0;i++) {
			int tem = num%10;
			rev = rev*10+tem;
			num = num/10;
		}
		System.out.println(rev);
	}
		/*	String s = "a";

		switch (s) {
		
		case "a":
			System.out.println("a");
		default:
			System.out.println("default");
		case "b":
			System.out.println("b");
		case "c":
			System.out.println("c");
		

		}

		
		 * String str = "12389"; int result = 0; for(int i = 0 ;i<str.length();i++) {
		 * result =result*10 + str.charAt(i)-'0';
		 * 
		 * }
		 * 
		 * System.out.println(result);
		 */

		/*
		 * String str = "Welcome to Ericsson"; String[] words = str.split("\\s"); String
		 * result = ""; for(int i = words.length-1;i>=0;i--) { if(i==0) result =
		 * result.concat(words[i]); else result = result.concat(words[i]+" "); }
		 * System.out.println(result);
		 */

		// System.out.println(s.valueOf(true));
		/*
		 * String str = "ollot"; char[] cA = str.toCharArray(); int i =0,j=cA.length-1;
		 * while(i<=j) { char c = cA[i]; cA[i] = cA[j]; cA[j] = c; i++; j--; }
		 * while(i<=j) { if(cA[i]!=cA[j]) { System.out.println("No"); break; } i++; j--;
		 * 
		 * } //System.out.println(String.valueOf(cA));
		 * 
		 * int[] arr = { -3, -4, -1, -6, -2 }; int l = Integer.MIN_VALUE, sl =
		 * Integer.MIN_VALUE;
		 * 
		 * for (int i = 0; i < arr.length; i++) { if (arr[i] > l) { sl = l; l = arr[i];
		 * } else { if (arr[i] > sl && sl != l) { sl = arr[i]; } } }
		 * System.out.println(l*sl);
		
	} */


}
