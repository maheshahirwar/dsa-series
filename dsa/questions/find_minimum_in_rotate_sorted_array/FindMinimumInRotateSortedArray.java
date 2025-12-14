package dsa.questions.find_minimum_in_rotate_sorted_array;

/**
 * Find Minimum in Rotate Sorted Array Approach: Modified Binary Search TC:
 * O(log n) SC: O(1)
 */
class Solution {
	public int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		int ans = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[low] <= nums[mid]) {
				ans = Math.min(nums[low], ans);
				low = mid + 1;
			} else {
				ans = Math.min(ans, nums[mid]);
				high = mid - 1;
			}
		}
		return ans;
	}
}

public class FindMinimumInRotateSortedArray {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 3, 4, 5, 1, 2 };
		int result = solution.findMin(nums);
		System.out.println("Minimum element in rotated sorted array is: " + result);

	}

}
