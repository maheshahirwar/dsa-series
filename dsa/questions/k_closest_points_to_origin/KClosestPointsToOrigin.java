package dsa.questions.k_closest_points_to_origin;

import java.util.PriorityQueue;

/**
 * K Closest Points to Origin TC: O(N log K) SC: O(K)
 */
class Solution {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

		for (int[] point : points) {
			int distance = point[0] * point[0] + point[1] * point[1];
			pq.offer(new int[] { distance, point[0], point[1] }); // (p[1],p[2])

			if (pq.size() > k) {
				pq.poll();
			}
		}

		int[][] ans = new int[k][2];
		int i = 0;
		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			ans[i][0] = p[1];
			ans[i][1] = p[2];
			i++;
		}
		return ans;
	}
}

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] points = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
		int k = 2;
		int[][] result = sol.kClosest(points, k);
		System.out.println("The " + k + " closest points to the origin are: ");
		for (int[] point : result) {
			System.out.println("[" + point[0] + ", " + point[1] + "]");
		}
	}

}
