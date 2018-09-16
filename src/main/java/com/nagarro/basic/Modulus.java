package com.nagarro.basic;

public class Modulus {
	public static void main(String arg[]){
		System.out.println(6%5);
		System.out.println(3%5);
		System.out.println(-106%-3);
		System.out.println(0%2);
		int a = -3, b =-106;
		if(a>0 && b>0 && b>a){
			System.out.println("Ist case:" + giveRemainderV1(a,b));
		} else if(a<0 & b<0 && b<a){
			String s1 = Integer.toString(a);
			String s2 = Integer.toString(b);
			System.out.println("2nd case:" + giveRemainderV2(Integer.parseInt(s2.replace("-","")),Integer.parseInt(s1.replace("-",""))));
		} else if(a>0 && b>0 && a>b){
			System.out.println("3rd case"+b);
		} else if(a<0 && b<0 && b>a){
			System.out.println("4th case"+b);	
		}
		/*System.out.println("*"+giveRemainder(-7, -2));
		System.out.println(-7%-2);

		Integer i1 = 400;
		Integer i2 = 400;

		Integer i5 = 40;
		Integer i6 = 40;
		System.out.println(i5==i6);

		int i3 = 400;
		int i4 = 400;
		System.out.println(i1.equals(i2));
*/
	}

	public static int giveRemainderV1(int dividend, int divisor){
		int temp = dividend, result = 0;
		while(temp>divisor){
			temp = temp-divisor;
			if(temp>=divisor)
				continue;
			else {
				result = temp;
			}
		}
		return result;
	}
	public static int giveRemainderV2(int dividend, int divisor){
		int temp = dividend, result = 0;
		while(temp>divisor){
			temp = temp-divisor;
			if(temp>=divisor)
				continue;
			else {
				result = temp;
			}
		}
		if(result==0){
			return result;
		}
		return Integer.parseInt("-"+result);
	}

}
