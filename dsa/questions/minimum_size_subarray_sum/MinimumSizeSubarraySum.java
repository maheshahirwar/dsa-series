package dsa.questions.minimum_size_subarray_sum;

/**
 * Brute Force TC : O(N*N) SC : O(1)
 */
class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int minLen = nums.length + 1;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum >= target) {
					minLen = Math.min(minLen, j - i + 1);
					break;
				}
			}
		}
		return minLen == nums.length + 1 ? 0 : minLen;
	}
}

/**
 * Optimized Solution using Sliding Window TC : O(N) SC : O(1)
 */
class OptimizedSolution extends Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int n = nums.length, ans = n + 1, start = 0, end = 0, sum = 0;
		while (end < n) {
			sum += nums[end];
			while (sum >= target) {
				ans = Math.min(ans, end - start + 1);
				sum -= nums[start++];
			}
			end++;
		}
		return ans == n + 1 ? 0 : ans;
	}
}

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Brute Force Solution = " + solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		solution = new OptimizedSolution();
		System.out.println("Optimzied Solution = " + solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}

}
