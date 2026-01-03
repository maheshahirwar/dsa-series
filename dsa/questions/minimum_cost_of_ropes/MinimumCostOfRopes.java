package dsa.questions.minimum_cost_of_ropes;

import java.util.PriorityQueue;

/**
 * Minimum Cost of Ropes TC: O(N log N) SC: O(N)
 */
class Solution {
	public int minCost(int[] arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : arr) {
			minHeap.offer(num);
		}
		int totalCost = 0;
		while (minHeap.size() > 1) {
			int first = minHeap.poll();
			int second = minHeap.poll();
			int cost = first + second;
			totalCost += cost;
			minHeap.offer(cost);
		}
		return totalCost;
	}
}

public class MinimumCostOfRopes {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] ropes = { 4, 3, 2, 6 };
		int result = sol.minCost(ropes);
		System.out.println("The minimum cost to connect the ropes is: " + result);
	}

}
