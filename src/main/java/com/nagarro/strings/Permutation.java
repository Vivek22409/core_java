package com.nagarro.strings;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Permutation {
	private static Set<String> set = new ConcurrentSkipListSet<String>();
	public static void main(String arg[]) {

		StringBuffer str = new StringBuffer("AB");
		//System.out.println(str.charAt(2));
		//int n = str.length();
		//Permutation permutation = new Permutation();
		//permutation.permute(str, 0, n - 1);
		//permutation("",str);
		/*for(String s:set)
			System.out.println(s);*/
		
	}

	private static void permutation(String prefix, StringBuffer str) {
		int n = str.length();
		if (n == 0) {
			set.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				System.out.println(prefix + str.charAt(i)+"-"+new StringBuffer(str.substring(0, i) + str.substring(i + 1, n)));
				permutation(prefix + str.charAt(i), new StringBuffer(str.substring(0, i) + str.substring(i + 1, n)));
			}
		}
	}

	/*private void permute(String str, int l, int r) {

		if (l == r)
			System.out.println(str);

		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}*/

}
