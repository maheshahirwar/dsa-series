package dsa.questions.sliding_window_median;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution class provides a method to find the median of each sliding window of
 * size k in an array of integers. It uses two heaps (a max-heap and a min-heap)
 * to efficiently maintain the elements in the current window and calculate the
 * median. TC - O(N log K) SC - O(K)
 */
class Solution {
	PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder()), minheap = new PriorityQueue<>();

	int maxheap_size = 0, minheap_size = 0;

	Map<Integer, Integer> removedCache = new HashMap<>();

	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		double[] ans = new double[n - k + 1];
		int i = 0;
		while (i < k)
			add(nums[i++]);
		ans[0] = getMedian(k);
		int resultIndex = 1;
		while (i < n) {
			add(nums[i]);
			remove(nums[i - k]);
			ans[resultIndex++] = getMedian(k);
			i++;
		}
		return ans;
	}

	private void add(int num) {
		if (maxheap.isEmpty() || num <= maxheap.peek()) {
			maxheap.offer(num);
			maxheap_size++;
		} else {
			minheap.offer(num);
			minheap_size++;
		}
		rebalance();
	}

	private void remove(int num) {

		removedCache.put(num, removedCache.getOrDefault(num, 0) + 1);

		if (num <= maxheap.peek()) {
			maxheap_size--;
			if (num == maxheap.peek())
				cleanup(maxheap);
		} else {
			minheap_size--;
			if (num == minheap.peek())
				cleanup(minheap);
		}
		rebalance();
	}

	private double getMedian(int windowSize) {
		if (windowSize % 2 == 1)
			return maxheap.peek();
		else
			return ((double) maxheap.peek() + (double) minheap.peek()) / 2.0;
	}

	private void rebalance() {
		if (maxheap_size > minheap_size + 1) {
			minheap.offer(maxheap.poll());
			maxheap_size--;
			minheap_size++;
			cleanup(maxheap); // because the top element might be from our removedCache
		} else if (minheap_size > maxheap_size) {
			maxheap.offer(minheap.poll());
			maxheap_size++;
			minheap_size--;
			cleanup(minheap);
		}
	}

	private void cleanup(PriorityQueue<Integer> heap) {
		while (!heap.isEmpty() && removedCache.getOrDefault(heap.peek(), 0) > 0) {
			removedCache.put(heap.peek(), removedCache.get(heap.peek()) - 1);
			heap.poll();
		}
	}
}

public class SlidingWindowMedian {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		double[] medians = solution.medianSlidingWindow(nums, k);
		for (double median : medians) {
			System.out.print(median + " ");
		}
	}

}
