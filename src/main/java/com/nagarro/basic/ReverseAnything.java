package com.nagarro.basic;

public class ReverseAnything {

	public static void main(String[] args) {
		//System.out.println(getReverse(- 190945));
		
		//System.out.println(isPalindrome("abba"));
		
		System.out.println(toUppercase("strang"));
		char c = 97;
		//System.out.println(c);

	}
	
	public static String toUppercase(String str) {
		char[] cArr = str.toCharArray();
		for(int i=0;i<cArr.length;i++) {
			int j = cArr[i];
			
			j=j-32;
			cArr[i]=(char)j;
			
		}
		return String.valueOf(cArr);
	}
	
	
	public static boolean isPalindrome(String str) {
		if(str.length()==0) {
			return true;
		}
		char[] cArr = str.toCharArray();
		int i = 0, j = cArr.length-1;
		while(i<=j) {
			if(cArr[i]!=cArr[j]) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static String getReverse(int num) {
		
		int rev = 0, temp = 0, numDup = num;
		
		if(num==0) {
			return new Integer(0).toString();
		}
		
		if(num<0) {
			num = Math.abs(num);
		}		
		while(num>0) {
			temp = num%10;
			rev = temp + rev * 10;
			num = num/10;
		}
		if(numDup<0)
			return "-".concat(new Integer(rev).toString());
		
		return new Integer(rev).toString();
	}

}
