package com.nagarro.ds_algorithms;

import java.util.ArrayList;
import java.util.List;

public class KadaneAlgorithm {

	public static void main(String arg[]) {

		int[] arr = { 1, -6, 7, 5, -2 };

		List<Integer> maxSubArray = new ArrayList<>();
		int sum = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
		int maxValidArrSizes = arr.length-2;
		int possArrSizeInit = 0;
		for (int i = 0; i < arr.length; i++) {			
			sum = 0; // an identity element
			for (int j = 0; j < arr.length; j++) {
				 if(j<=possArrSizeInit) {
					 
				 }
			}
			possArrSizeInit++;
			System.out.println(sum);
		}

		System.out.println(ans);
		// System.out.println("Max sum:"+maxSumSubarray(arr,arr.length));
	}

	// Kadane's solution with assumtion that at least one element should be positive
	// in array { 1, -6, 7, 5, -2 }
	// Note: if all elements are negative, then need to return max of them
	public static int maxSumSubarray(int arr[], int n) {
		int ans = 0, sum = 0;
		// customized
		List<Integer> maxSubArr = new ArrayList<>();
		for (int i = 0; i < n; i++) {

			if (sum + arr[i] > 0) {
				sum += arr[i];
				// maxSubArr.add(arr[i]);
			} else {
				sum = 0;
				maxSubArr.clear();
			}
			ans = ans > sum ? ans : sum;
		}
		// System.out.println("Max Sub array:" + maxSubArr);
		return ans;
	}

}
