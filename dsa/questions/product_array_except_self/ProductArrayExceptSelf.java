package dsa.questions.product_array_except_self;

import java.util.Arrays;

class Solution {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		int prod = 1;
		ans[0] = prod;
		for (int i = 1; i < n; i++) {
			prod = prod * nums[i - 1];
			ans[i] = prod;
		}
		prod = 1;

		for (int i = n - 2; i >= 0; i--) {
			prod = prod * nums[i + 1];
			ans[i] *= prod;
		}
		return ans;
	}
}

public class ProductArrayExceptSelf {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 2, 3, 4 };
		int[] result = solution.productExceptSelf(nums);
		System.out.println("The product array except self is: " + Arrays.toString(result));// Output: 24 12 8 6
	}
}