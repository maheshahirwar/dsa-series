package dsa.questions.kth_largest_element_in_array;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array TC: O(N log K) SC: O(K)
 */
class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : nums) {
			minHeap.offer(num);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}
}

public class KthLargestElementInArray {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		int result = sol.findKthLargest(nums, k);
		System.out.println("The " + k + "th largest element is: " + result);
	}

}
