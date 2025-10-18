package dsa.questions.maximum_product_subarray;

//Brute force solution
class Solution {
	public int maxProduct(int[] nums) {
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int prod = 1;
			for (int j = i; j >= 0; j--) {
				prod *= nums[j];
				ans = Math.max(ans, prod);
			}
		}
		return ans;
	}
}

//Optimized Solution
class OptimizedSolution extends Solution {
	@Override
	public int maxProduct(int[] nums) {
		int ans = Integer.MIN_VALUE, prevMin = 1, prevMax = 1;
		for (int i = 0; i < nums.length; i++) {
			int currMin = Math.min(nums[i], Math.min(prevMin * nums[i], prevMax * nums[i]));
			int currMax = Math.max(nums[i], Math.max(prevMin * nums[i], prevMax * nums[i]));
			ans = Math.max(ans, Math.max(currMax, currMin));
			prevMin = currMin;
			prevMax = currMax;
		}
		return ans;
	}

}

public class MaximumProductSubarray {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 2, 3, -2, 4 };
		int result = solution.maxProduct(nums);
		System.out.println("The maximum product of a contiguous subarray is: " + result); // 6
		solution = new OptimizedSolution();
		result = solution.maxProduct(nums);
		System.out.println("The maximum product of a contiguous subarray is: " + result); // 6
	}
}