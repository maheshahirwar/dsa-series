package dsa.questions.capacity_to_ship_packages_within_d_days;

import java.util.Arrays;

/**
 * Capacity To Ship Packages Within D Days Approach: Binary Search TC: O(n log
 * m) SC: O(1) where n is the number of packages and m is the sum of all package
 * weights
 */
class Solution {
	public int shipWithinDays(int[] weights, int days) {
		int low = Arrays.stream(weights).max().getAsInt(); // Minimum capacity must be at least the heaviest package
		int high = Arrays.stream(weights).sum(); // Maximum capacity is the sum of all packages

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (canShip(weights, mid, days)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low; // Minimum capacity to ship within D days

	}

	private boolean canShip(int[] weights, int capacity, int days) {
		int currentLoad = 0;
		int requiredDays = 1;

		for (int weight : weights) {
			currentLoad += weight;
			if (currentLoad > capacity) {
				requiredDays++;
				currentLoad = weight;
			}

		}
		return requiredDays <= days;
	}
}

public class CapacityToShipPackagesWithinDDays {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;
		int capacity = solution.shipWithinDays(weights, days);
		System.out.println("Minimum capacity to ship packages within " + days + " days: " + capacity);

	}

}
