package dsa.questions.split_array_larget_sum;

import java.util.Arrays;

class Solution {
	public int splitArray(int[] nums, int k) {
		int low = Arrays.stream(nums).max().getAsInt();
		int high = Arrays.stream(nums).sum();

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (canSplit(nums, mid, k)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low; // Minimum largest sum among the subarrays
	}

	private boolean canSplit(int[] nums, int maxSum, int k) {
		int sum = 0;
		int cuts = 1;
		for (int num : nums) {
			sum += num;
			if (sum > maxSum) {
				cuts++;
				sum = num;
			}
		}
		return cuts <= k;
	}
}

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 7, 2, 5, 10, 8 };
		int k = 2;
		int result = solution.splitArray(nums, k);
		System.out.println("Largest sum among the subarrays: " + result);
	}

}
