package dsa.questions.find_peak_element;

/**
 * Find Peak Element Approach: Binary Search TC: O(log n) SC: O(1)
 */

class Solution {
	public int findPeakElement(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[mid + 1]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}

public class FindPeakElement {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
		int peakIndex = solution.findPeakElement(nums);
		System.out.println("Index of a peak element: " + peakIndex);
	}

}
