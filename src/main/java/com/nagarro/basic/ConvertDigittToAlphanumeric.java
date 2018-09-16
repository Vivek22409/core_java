package com.nagarro.basic;

import java.util.HashMap;
import java.util.Map;

public class ConvertDigittToAlphanumeric {

	Map<Integer, String> map = new HashMap<>();
	char c;

	public String giveAlphaRepresentation(int num) {

		String result = "";
		String temp = String.valueOf(num);
		char[] cArr = temp.toCharArray();

		if (cArr.length == 1) {
			result = giveUnitthPlaceAplha(Integer.parseInt(String.valueOf(cArr[0])), result);
			return result;
		}

		if (cArr.length == 2) {
			result = giveTenthPlaceAplha(num, result, cArr);
			return result;
		}

		if (cArr.length == 3) {
			int reqNo = Integer.parseInt(String.valueOf(cArr));
			if (reqNo >= 100 && reqNo <= 900) {
				result = giveHundredthPlaceAplha(reqNo, result, cArr);
			}
		}
		return result;
	}

	public String giveTenthPlaceAplha(int num, String result, char[] cArr) {
		if (num >= 10 && num <= 19) {
			result = result + giveTeenthPlaceAplha(num, result);
		} else {

			int reqNo = Integer.parseInt("" + cArr[cArr.length - 2] + '0');
			if (reqNo >= 20 && reqNo <= 90) {

				map.put(20, "twenty");
				map.put(30, "thirty");
				map.put(40, "fourty");
				map.put(50, "fifty");
				map.put(60, "sixty");
				map.put(70, "seventy");
				map.put(80, "eighty");
				map.put(90, "ninety");

				result = result.concat(" " + map.get(reqNo));

				int reNo = Integer.parseInt("" + cArr[cArr.length - 1]);

				if (reNo <= 9 && reNo >= 0) {
					result = giveUnitthPlaceAplha(reNo, result);
				}
			}
		}

		return result;
	}

	public String giveTeenthPlaceAplha(int num, String result) {

		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(13, "thirteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");

		result = " " + map.get(num);

		return result;
	}

	public String giveUnitthPlaceAplha(int num, String result) {
		map.put(0, "");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");

		result = result.concat(" " + map.get(num));

		return result;
	}

	public String giveHundredthPlaceAplha(int num, String result, char[] cArr) {
		char tempChar = cArr[cArr.length - 3];
		int reqNo = Integer.parseInt(String.valueOf(tempChar).concat("00"));

		map.put(100, "one hundred");
		map.put(200, "two hundred");
		map.put(300, "three hundred");
		map.put(400, "four hundred");
		map.put(500, "five hundred");
		map.put(600, "six hundred");
		map.put(700, "seven hundred");
		map.put(800, "eight hundred");
		map.put(900, "nine hundred");

		result = " " + map.get(reqNo);
		//int reNo = Integer.parseInt("" + cArr[cArr.length - 2] + cArr[cArr.length - 1]);
		//char[] tempCArr = { cArr[cArr.length - 2], cArr[cArr.length - 1] };
		result = giveTenthPlaceAplha(num, result, cArr);

		return result;
	}

	public static void main(String[] args) {
		ConvertDigittToAlphanumeric c = new ConvertDigittToAlphanumeric();
		// for (int i = 100; i <= 199; i++) {
		System.out.println(c.giveAlphaRepresentation(102).trim());
		// }

	}

}
