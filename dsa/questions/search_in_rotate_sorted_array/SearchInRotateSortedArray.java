package dsa.questions.search_in_rotate_sorted_array;

/**
 * Search in Rotated Sorted Array Approach: Modified Binary Search TC: O(log n)
 * SC: O(1)
 */
class Solution {
	public int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[low] == target)
				return low;
			if (nums[high] == target)
				return high;

			if (nums[low] <= nums[mid]) {
				// Left half is sorted nums[low] <= target < nums[mid]
				if (nums[low] < target && target < nums[mid])
					high = mid - 1;
				else
					low = mid + 1;
			} else {
				// Right half is sorted nums[mid] < target <= nums[high]
				if (nums[mid] < target && target < nums[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return -1;
	}
}

public class SearchInRotateSortedArray {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		int result = solution.search(nums, target);
		System.out.println("Index of target " + target + " is: " + result);
	}

}
