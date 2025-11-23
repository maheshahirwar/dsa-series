package dsa.questions.minimum_window_substring;

import java.util.Arrays;

/**
 * Brute Force TC : O(N*N) SC : O(128)
 */
class Solution {
	public String minWindow(String s, String t) {

		int n = s.length(), m = t.length();
		int endIndex = n + 1, startIndex = 0;

		int[] tfreq = new int[128];

		for (int start = 0; start < n; start++) {

			/* Instead of int sum = 0 we have frequency array */

			for (char c : t.toCharArray())
				tfreq[c]++;
			int charsFound = 0;

			for (int end = start; end < n; end++) {

				if (tfreq[s.charAt(end)]-- > 0)
					charsFound++;
				if (charsFound == m) {
					// find minimum window
					if (endIndex - startIndex > end - start) {
						endIndex = end;
						startIndex = start;
					}
				}
			}
			Arrays.fill(tfreq, 0); // reset frequency array
		}
		return endIndex == n + 1 ? "" : s.substring(startIndex, endIndex + 1);
	}
}

/**
 * OptimizedSolution TC : O(N) SC : O(128)
 */
class OptimizedSolution extends Solution {
	public String minWindow(String s, String t) {
		int n = s.length(), m = t.length();
		int[] tfreq = new int[128];
		for (char c : t.toCharArray())
			tfreq[c]++;
		int start = 0, end = 0, startIndex = 0, endIndex = n + 1, charsFound = 0;

		while (end < n) {

			if (tfreq[s.charAt(end)]-- > 0) {
				charsFound++;
			}

			while (charsFound == m) {

				if (endIndex - startIndex > end - start) {
					startIndex = start;
					endIndex = end;
				}
				if (tfreq[s.charAt(start++)]++ >= 0) {
					charsFound--;
				}
			}

			end++;
		}
		return endIndex == n + 1 ? "" : s.substring(startIndex, endIndex + 1);

	}
}

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Brute Force Solution : " + solution.minWindow("ADOBECODEBANC", "ABC"));

		solution = new OptimizedSolution();
		System.out.println("Optimized Solution : " + solution.minWindow("ADOBECODEBANC", "ABC"));
	}

}
