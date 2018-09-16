package com.nagarro.basic;

public class PatternDemo {
	public static void main(String arg[]){
		for(int i=0;i<5;i++){
			for(int j=5;j>i;--j){
				if(j>i){
					System.out.print("*");
				} else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	}
}
