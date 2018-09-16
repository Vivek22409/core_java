package com.nagarro.basic;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacterFromStrings {

	public static void main(String arg[]) {
		String str = "abc";
		System.out.println(reverse(str));
		/*Map<Character, Integer> m = new HashMap<>();
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (m.containsKey(c)) {
				m.put(c, m.get(c) + 1);
				if (m.get(c) == 2) {
					System.out.println(c);
				}
			} else {
				m.put(c, count);
			}
		}
*/
	}

	public static String reverse(String str) {
		if ((str == null) || (str.length() <= 1))
			return str;
		return reverse(str.substring(1)) + str.charAt(0);
	}

}
