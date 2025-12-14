package dsa.questions.koko_eating_bananas;

import java.util.Arrays;

/**
 * Koko Eating Bananas Approach: Binary Search TC: O(n log m) SC: O(1) where n
 * is the number of piles and m is the maximum number of bananas in a pile
 */
class Solution {
	public int minEatingSpeed(int[] piles, int h) {
		int max = Arrays.stream(piles).max().getAsInt();

		int low = 1, high = max;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (canEatBananas(piles, mid, h)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low; // minimum eating speed
	}

	private boolean canEatBananas(int[] piles, int k, int h) {
		int hour = 0;
		for (int pile : piles) {
			hour += pile / k;
			hour += (pile % k != 0) ? 1 : 0;
		}
		return hour <= h;
	}
}

public class KokoEatingBananas {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		int minSpeed = solution.minEatingSpeed(piles, h);
		System.out.println("Minimum eating speed: " + minSpeed);

	}

}
