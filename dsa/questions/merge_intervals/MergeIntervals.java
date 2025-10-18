package dsa.questions.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Brute Force Solution TC : O(n^3) SC : O(n)
class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

		boolean merged = true;
		while (merged) {
			merged = false;
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					int[] a = list.get(i);
					int[] b = list.get(j);

					// Check overlap
					if (a[1] >= b[0]) {
						// Merge
						int start = Math.min(a[0], b[0]);
						int end = Math.max(a[1], b[1]);
						list.set(i, new int[] { start, end });
						list.remove(j);
						merged = true;
						break; // start again
					}
				}
				if (merged) {
					break;
				}
			}
		}

		return list.toArray(new int[list.size()][]);
	}
}

// Better Solution TC : O(n log n) SC : O(n)
class BetterSolution extends Solution {
	@Override
	public int[][] merge(int[][] intervals) {
		// base case
		if (null == intervals || intervals.length <= 1) {
			return intervals;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int[] interval : intervals) {
			pq.add(interval);
		}
		List<int[]> mergeIntervals = new ArrayList<>();
		int[] prev = pq.poll();
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			// overlap condition
			if (prev[1] >= curr[0]) {
				prev[1] = Math.max(prev[1], curr[1]);
			} else {
				mergeIntervals.add(prev);
				prev = curr;
			}
		}
		mergeIntervals.add(prev);
		return mergeIntervals.toArray(new int[mergeIntervals.size()][2]);
	}
}

// Optimized Solution TC : O(n log n) SC : O(n)
class OptimizedSolution extends Solution {
	@Override
	public int[][] merge(int[][] intervals) {
		// base case
		if (null == intervals || intervals.length <= 1) {
			return intervals;
		}
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> mergeIntervals = new ArrayList<>();
		int[] prev = intervals[0];
		int i = 1;
		while (i < intervals.length) {
			int[] curr = intervals[i];
			// overlap condition
			if (prev[1] >= curr[0]) {
				prev[1] = Math.max(prev[1], curr[1]);
			} else {
				mergeIntervals.add(prev);
				prev = curr;
			}
			i++;
		}
		mergeIntervals.add(prev);
		return mergeIntervals.toArray(new int[mergeIntervals.size()][2]);
	}
}

// Best Optimized Solution TC : O(n + k) SC : O(k) where k is the range of numbers in intervals
class BestOptimizedSolution extends Solution {
	@Override
	public int[][] merge(int[][] intervals) {
		int max = 0;
		for (int[] interval : intervals) {
			max = Math.max(max, interval[0]);
		}
		int[] map = new int[max + 1];
		for (int i = 0; i < intervals.length; i++) {
			int st = intervals[i][0];
			int end = intervals[i][1];
			map[st] = Math.max(map[st], end + 1);
		}
		List<int[]> mergeIntervals = new ArrayList<>();
		int intervalStart = -1, intervalEnd = -1;
		for (int i = 0; i <= max; i++) {
			if (map[i] != 0) {
				if (intervalStart == -1) {
					intervalStart = i;
				}
				intervalEnd = Math.max(intervalEnd, map[i] - 1);
			}
			if (intervalEnd == i) {
				mergeIntervals.add(new int[] { intervalStart, intervalEnd });
				intervalStart = -1;
				intervalEnd = -1;
			}
		}
		if (intervalStart != -1) {
			mergeIntervals.add(new int[] { intervalStart, intervalEnd });
		}
		return mergeIntervals.toArray(new int[mergeIntervals.size()][2]);
	}
}

public class MergeIntervals {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] intervals = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		int[][] mergedIntervals = solution.merge(intervals);
		System.out.println("Merged Intervals | Brute Force:" + Arrays.deepToString(mergedIntervals));

		solution = new BetterSolution();
		int[][] intervals2 = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		int[][] mergedIntervals2 = solution.merge(intervals2);
		System.out.println("Merged Intervals | Better Solution:" + Arrays.deepToString(mergedIntervals2));

		solution = new OptimizedSolution();
		int[][] intervals3 = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		int[][] mergedIntervals3 = solution.merge(intervals3);
		System.out.println("Merged Intervals | Optimized Solution:" + Arrays.deepToString(mergedIntervals3));

		solution = new BestOptimizedSolution();
		int[][] intervals4 = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		int[][] mergedIntervals4 = solution.merge(intervals4);
		System.out.println("Merged Intervals | Best Optimized Solution:" + Arrays.deepToString(mergedIntervals4));
	}

}
