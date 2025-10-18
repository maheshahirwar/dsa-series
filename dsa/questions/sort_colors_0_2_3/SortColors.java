package dsa.questions.sort_colors_0_2_3;

import java.util.Arrays;

//Couting Approach
class Solution {
	public void sortColors(int[] nums) {
		int zero = 0, one = 0;
		for (int num : nums) {
			if (num == 0) {
				zero++;
			} else if (num == 1) {
				one++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (zero > 0) {
				nums[i] = 0;
				zero--;
			} else if (one > 0) {
				nums[i] = 1;
				one--;
			} else {
				nums[i] = 2;
			}
		}
	}
}

//Ductch national flag algo
class OptimizedSolution extends Solution {
	@Override
	public void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(low++, mid++, nums);
			} else if (nums[mid] == 2) {
				swap(high--, mid, nums);
			} else {
				mid++;
			}
		}
	}

	private void swap(int i, int j, int[] arr) {
		arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
	}
}

public class SortColors {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		solution.sortColors(nums);
		System.out.println("Sorted colors using Counting Approach: " + Arrays.toString(nums));

		solution = new OptimizedSolution();
		int[] nums2 = { 2, 0, 2, 1, 1, 0 };
		solution.sortColors(nums2);
		System.out.print("Sorted colors using Dutch National Flag Algorithm: " + Arrays.toString(nums2));
	}
}
