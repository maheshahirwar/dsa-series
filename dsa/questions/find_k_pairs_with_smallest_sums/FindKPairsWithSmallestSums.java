package dsa.questions.find_k_pairs_with_smallest_sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find K Pairs with Smallest Sums TC: O(K log K) SC: O(K)
 */
class Solution {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.sum - p2.sum);

		for (int i = 0; i < nums2.length && i < k; i++) {
			int sum = nums1[0] + nums2[i];
			pq.offer(new Pair(sum, 0, i));
		}

		List<List<Integer>> ans = new ArrayList<>();

		while (k-- > 0 && !pq.isEmpty()) {
			Pair pair = pq.poll();
			List<Integer> list = new ArrayList<>();
			list.add(nums1[pair.i]);
			list.add(nums2[pair.j]);
			ans.add(list);

			int next = pair.i + 1;
			if (next == nums1.length)
				continue;

			pq.offer(new Pair((nums1[next] + nums2[pair.j]), next, pair.j));
		}

		return ans;

	}
}

class Pair {
	int sum, i, j;

	public Pair(int sum, int i, int j) {
		this.sum = sum;
		this.i = i;
		this.j = j;
	}
}

public class FindKPairsWithSmallestSums {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		int k = 3;
		List<List<Integer>> result = sol.kSmallestPairs(nums1, nums2, k);
		System.out.println("The " + k + " pairs with smallest sums are: " + result);

	}

}
