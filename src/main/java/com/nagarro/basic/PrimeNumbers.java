package com.nagarro.basic;

public class PrimeNumbers {

	private int limit;

	public PrimeNumbers(int limit) {
		this.limit = limit;
	}

	public void showPrimeNumbers() {
		int count = 1, num = 2;
	
		while (count <= limit) {
			int sqrtOfNum = (int) Math.sqrt(num);
			if (isPrime(num,sqrtOfNum)) {
				System.out.print(num+" ");
				count++;
			}
			num++;
		}
	}

	public boolean isPrime(int num,int sqrtOfNum) {
		int i= 2;
		if(num==2) {
			return true;
		}
		while(i<=sqrtOfNum) {			
			if(num%i==0)
				return false;
			i++;
		}
		return true;
	}
	
	public static void main(String arg[]) {
		long startTime = System.currentTimeMillis();
		PrimeNumbers p = new PrimeNumbers(25);
		p.showPrimeNumbers();
		//System.out.println(p.isPrime(1234534987));
		System.out.println();
		System.out.println(System.currentTimeMillis()-startTime);
	}

}
