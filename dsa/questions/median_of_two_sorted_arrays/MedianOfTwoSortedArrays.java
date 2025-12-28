package dsa.questions.median_of_two_sorted_arrays;

/**
 * Optimized Solution TC : O(log(min(n,m))) SC : O(1)
 */
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;

		if (n < m)
			return binarySearch(nums1, nums2, n, m);
		return binarySearch(nums2, nums1, m, n);
	}

	private double binarySearch(int[] nums1, int[] nums2, int n, int m) {
		// Step1 : Median
		int median = (n + m + 1) / 2;
		int low = 0, high = n; // Applied binarySearch on smallest array

		while (low <= high) {

			// Left side ke total elements = Right side ke total elements (ya almost equal)
			int mid = (low + high) / 2; // mid for nums1 array
			int mid1 = median - mid; // mid for nums2 array

			// Construct left array: L1 from nums1 and L2 from nums2
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			if (mid > 0)
				l1 = nums1[mid - 1];
			if (mid1 > 0)
				l2 = nums2[mid1 - 1];

			// Construct right array: R1 from nums1 and R2 from nums2
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			if (mid < n)
				r1 = nums1[mid];
			if (mid1 < m)
				r2 = nums2[mid1];

			// Left side ke saare elements ≤ Right side ke saare elements
			// (L1 L2) <= (R1 R2) e.g. (L1<=R2 && L2<=R1)
			// Why? because we know that L1 always less than R1 and similarly L2 always less
			// than R2
			if (l1 <= r2 && l2 <= r1) {

				// even length array
				if (isEvenLength(n, m)) {
					return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
				}
				// odd length array
				return Math.max(l1, l2);
			}
			// Binary Search Direction Decide Karna
			if (l1 > r2) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return 0.0;
	}

	private boolean isEvenLength(int n, int m) {
		return (n + m) % 2 == 0;
	}
}

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		double median = solution.findMedianSortedArrays(nums1, nums2);
		System.out.println("Median of Two Sorted Arrays: " + median);
	}

}
