package dsa.questions.find_kth_smallest_pair_distance;

import java.util.Arrays;

/**
 * Find Kth Smallest Pair Distance Approach: Binary Search + Two Pointers TC:
 * O(n log m) where n is the number of elements and m is the range of distances
 * SC: O(1)
 */
class Solution {
	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int low = 0, high = nums[nums.length - 1] - nums[0];
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (canFormPairs(nums, mid, k)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low; // Kth smallest pair distance
	}

	/**
	 * Helper method to check if we can form at least totalPairs with distance less
	 * than or equal to minDistance Approach: Two Pointers (Sliding Window)
	 * 
	 * @param nums
	 * @param minDistance
	 * @param totalPairs
	 * @return
	 */
	private boolean canFormPairs(int[] nums, int minDistance, int totalPairs) {
		int start = 0, end = 0, countPairs = 0;
		while (end < nums.length) {
			while (start < end && nums[end] - nums[start] > minDistance) {
				start++;
			}
			countPairs += end - start;
			end++;
		}
		return countPairs >= totalPairs;
	}
}

public class FindKthSmallestPairDistance {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 6, 1 };
		int k = 3;
		int result = solution.smallestDistancePair(nums, k);
		System.out.println("Kth smallest pair distance: " + result);
	}

}
