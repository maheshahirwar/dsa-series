package dsa.questions.aggressive_cows;

import java.util.Arrays;

/**
 * Aggressive Cows Problem TC - O(N log M) where N is the number of stalls and M
 * is the range of positions
 */
class Solution {
	public int aggressiveCows(int[] stalls, int k) {
		Arrays.sort(stalls); // Why? To apply binary search on distances, we need sorted stalls.
		int low = 1; // Minimum possible distance
		int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canPlaceCows(stalls, mid, k)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high; // high will be the largest minimum distance
	}

	private boolean canPlaceCows(int[] stalls, int minDist, int cows) {
		int cowsPlaced = 1;
		int lastPosition = stalls[0];

		for (int stall : stalls) {
			if (stall - lastPosition >= minDist) {
				cowsPlaced++;
				lastPosition = stall;
			}
		}
		return cowsPlaced >= cows; // true if we can place all cows with at least minDist apart
	}
}

public class AggressiveCows {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] stalls = { 1, 2, 4, 8, 9 };
		int k = 3;
		int result = sol.aggressiveCows(stalls, k);
		System.out.println("Largest minimum distance: " + result);
	}

}
