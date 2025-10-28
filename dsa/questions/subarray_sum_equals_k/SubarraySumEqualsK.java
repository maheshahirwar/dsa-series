package dsa.questions.subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * Brute force Solution TC : O(N^2) SC : O(1)
 */
class Solution {
	public int subarraySum(int[] nums, int k) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			int prefixSum = 0;
			for (int j = i; j >= 0; j--) {
				prefixSum += nums[j];
				if (prefixSum == k) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}
}

/**
 * Optimized Solution TC : O(N) SC : O(N)
 */
class OptimizedSolution extends Solution {
	public int subarraySum(int[] nums, int k) {

		Map<Integer, Integer> prefixSums = new HashMap<>();

		int prefixSum = 0, totalSubarray = 0;

		prefixSums.put(prefixSum, 1);

		for (int num : nums) {
			prefixSum += num;

			totalSubarray += prefixSums.containsKey(prefixSum - k) ? prefixSums.get(prefixSum - k) : 0;

			prefixSums.put(prefixSum, prefixSums.getOrDefault(prefixSum, 0) + 1);
		}
		return totalSubarray;
	}
}

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 2, 4, 8, 9, 5, 6, 12, 2, 5, 9 };
		System.out.println("Brute Force Solution :: totalSubarray : " + solution.subarraySum(nums, 14));

		solution = new OptimizedSolution();
		System.out.println("Optimized Solution :: totalSubarray : " + solution.subarraySum(nums, 14));

	}

}
