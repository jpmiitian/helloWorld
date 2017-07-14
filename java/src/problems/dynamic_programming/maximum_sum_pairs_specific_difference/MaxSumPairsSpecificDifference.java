package problems.dynamic_programming.maximum_sum_pairs_specific_difference;

import java.util.Arrays;

public class MaxSumPairsSpecificDifference {

	/**
	 * {@link http://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/}
	 */
	public static void main(String[] args) {

		int[] cost = { 3, 5, 10, 15, 17, 12, 9 };
		int k = 4;
		System.out.println("Max sum of pairs with diff k :" + findMaximumSumPairsWithDiff_K(cost, k));
	}

	private static int findMaximumSumPairsWithDiff_K(int[] A, int k) {
		int n = A.length;
		int dP [] = new int[n];

		Arrays.sort(A); // sort array of integers

		for (int i = 1; i < n; i++) {
			dP[i] = dP[i - 1];
			
			if (A[i] - A[i - 1] < k) { // if diff is less than k. check for addition to resultSum
				if (i >= 2) {
					dP[i] = Math.max( dP[i - 1], dP[i - 2] + A[i] + A[i - 1]);
				} else {
					dP[i] = Math.max( dP[i],  A[i] + A[i - 1] ) ;
				}

			}

		}

		return dP[n - 1];

	}

}