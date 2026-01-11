package dsa.questions.find_median_from_data_stream;

import java.util.PriorityQueue;

/**
 * MedianFinder class maintains a data structure to find the median from a
 * stream of numbers. It uses two heaps: a max-heap for the lower half of
 * numbers and a min-heap for the upper half. The addNum method adds a number to
 * the data structure, and the findMedian method returns the current median.
 */
class MedianFinder {

	PriorityQueue<Integer> maxHeap; // Lower half
	PriorityQueue<Integer> minHeap; // Upper half

	public MedianFinder() {
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
		minHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}

		// Balance the heaps
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
	}
}

public class FindMedianFromDataStream {

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);
		medianFinder.addNum(2);
		System.out.println("Median: " + medianFinder.findMedian()); // Output: 1.5
		medianFinder.addNum(3);
		System.out.println("Median: " + medianFinder.findMedian()); // Output: 2.0

	}
}
