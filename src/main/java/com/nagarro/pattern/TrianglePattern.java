package com.nagarro.pattern;

public class TrianglePattern {

	public static void main(String arg[]) {

		/*
		 * for (int i = 0; i < 5; i++) { for (int j = 0; j <= i; j++) {
		 * System.out.print("*"); } System.out.println(); }
		 */
		/*
		 * for (int i = 0; i < 5; i++) { for (int j = 5; j>i ; j--) {
		 * System.out.print("*"); } System.out.println(); }
		 */

		for (int i = 0; i < 5; i++) {
			for (int j = 3; j > -2; j--) {
				if (j >= i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}

			for (int j = 0; j < i; j++) {

				System.out.print("*");

			}

			System.out.println();
		}

	}
}
