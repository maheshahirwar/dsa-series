package dsa.questions.book_allocation;

import java.util.Arrays;

/**
 * Book Allocation Problem
 * 
 * Approach: Binary Search TC: O(n log m) SC: O(1) where n is the number of
 * books and m is the sum of all pages
 */
class Solution {
	public int findPages(int[] arr, int k) {
		if (arr.length < k)
			return -1;
		int sum = Arrays.stream(arr).sum();
		int max = Arrays.stream(arr).max().getAsInt();
		return binarySearch(arr, max, sum, k);
	}

	private int binarySearch(int[] arr, int low, int high, int totalStudents) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (canBeAllocatePages(arr, mid, totalStudents)) {
				high = mid; // possible answer mid
			} else {
				low = mid + 1;// mid not possible
			}
		}
		return low;// or return high both are same
	}

	private boolean canBeAllocatePages(int[] arr, int maximumPagesAllocateToAStudent, int totalStudents) {
		int allocatedPages = 0;
		for (int pages : arr) {
			allocatedPages += pages;
			if (allocatedPages > maximumPagesAllocateToAStudent) {
				allocatedPages = pages;
				totalStudents--;
			}
		}
		return totalStudents > 0;
	}
}

public class BookAllocationProblem {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = { 12, 34, 67, 90 };
		int k = 2;
		int result = solution.findPages(arr, k);
		System.out.println("Minimum number of pages: " + result);
	}

}
