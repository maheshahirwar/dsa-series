package dsa.questions.find_in_infinite_sorted_array;

class Solution {
	public int searchInInfiniteArray(int[] arr, int target) {
		// Initialize the search bounds
		int low = 0;
		int high = 1;

		// Expand the bounds exponentially until the target is within range
		// Note that we assume arr has infinite length for this problem, So
		// IndexOutOfBounds is not handled here.
		while (arr[high] < target) {
			low = high;
			high = high * 2; // Double the high index
		}
		// Perform binary search within the identified bounds
		return binarySearch(arr, low, high, target);
	}

	private int binarySearch(int[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid; // Target found
			} else if (arr[mid] < target) {
				low = mid + 1; // Search in the right half
			} else {
				high = mid - 1; // Search in the left half
			}
		}
		return -1; // Target not found
	}
}

public class SearchInASortedInfiniteArray {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int target = 10;
		int result = solution.searchInInfiniteArray(arr, target);
		if (result != -1) {
			System.out.println("Element found at index: " + result);
		} else {
			System.out.println("Element not found in the array.");
		}

	}

}
