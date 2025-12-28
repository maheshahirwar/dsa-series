package dsa.questions.find_first_and_last_position_of_element_in_sorted_array;

/**
 * Find First and Last Position of Element in Sorted Array TC - O(log N)
 */
class Solution {
	public int[] searchRange(int[] nums, int target) {
		int firstPosition = lowerBound(nums, target);
		int lastPosition = upperBound(nums, target);
		return new int[] { firstPosition, lastPosition };
	}

	/**
	 * Finds the first position (lower bound) of the target in the sorted array.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private int lowerBound(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				result = mid;
				high = mid - 1; // Continue searching in the left half
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	/**
	 * Finds the last position (upper bound) of the target in the sorted array.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private int upperBound(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				result = mid;
				low = mid + 1; // Continue searching in the right half
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}
}

public class FirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] result = sol.searchRange(nums, target);
		System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
	}

}
