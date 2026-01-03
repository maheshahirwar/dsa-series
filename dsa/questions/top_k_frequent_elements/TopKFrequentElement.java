package dsa.questions.top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent TC:
 * O(N log k) SC: O(N)
 */
class Solution {

	private PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		for (var entry : map.entrySet()) {
			pq.offer(new int[] { entry.getValue(), entry.getKey() });
			if (pq.size() > k)
				pq.poll();
		}
		int[] ans = new int[k];
		int i = 0;
		while (!pq.isEmpty())
			ans[i++] = pq.poll()[1];
		return ans;
	}
}

/**
 * Given an integer array nums and an integer k, return the k most frequent TC:
 * O(N) SC: O(N)
 */
class Solution2 {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxFreq = 0;
		for (int num : nums) {
			int freq = map.getOrDefault(num, 0) + 1;
			map.put(num, freq);
			maxFreq = Math.max(maxFreq, freq);
		}
		List<Integer>[] bucket = new ArrayList[maxFreq + 1];

		for (var entry : map.entrySet()) {
			int value = entry.getValue();
			if (bucket[value] == null)
				bucket[value] = new ArrayList<>();
			bucket[value].add(entry.getKey());
		}

		int[] ans = new int[k];
		for (int i = maxFreq; i > 0; i--) {
			if (bucket[i] == null)
				continue;

			for (int element : bucket[i]) {
				ans[--k] = element;
				if (k == 0)
					return ans;
			}
		}
		return ans;
	}
}

public class TopKFrequentElement {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] result = sol.topKFrequent(nums, k);
		System.out.print("The top " + k + " frequent elements are: ");
		for (int num : result) {
			System.out.print(num + " ");
		}

		Solution2 sol2 = new Solution2();
		int[] result2 = sol2.topKFrequent(nums, k);
		System.out.print("\nThe top " + k + " frequent elements are (using bucket sort): ");
		for (int num : result2) {
			System.out.print(num + " ");
		}

	}

}
