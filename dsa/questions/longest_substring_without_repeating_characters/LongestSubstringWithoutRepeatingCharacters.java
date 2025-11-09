package dsa.questions.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Brute Force TC : O(N^3) SC : O(128) for all chars
 */
class Solution {
	public int lengthOfLongestSubstring(String s) {

		int maxLen = 1;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + maxLen; j <= s.length(); j++) {
				if (j - i > maxLen && isSubstringContainsAllUniqueChars(s, i, j - 1)) {
					maxLen = j - i;
				}
			}
		}
		return maxLen;
	}

	private boolean isSubstringContainsAllUniqueChars(String s, int i, int j) {
		Set<Character> set = new HashSet<>();
		while (i <= j) {

			if (!set.add(s.charAt(i++)))
				return false;
		}
		return true;
	}
}

/**
 * Better Solution TC : O(N^2) SC : O(128) for all chars
 */
class BetterSolution extends Solution {

	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0;
		Set<Character> set = new HashSet<>();
		int max = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (set.add(c)) {
				max = Math.max(max, right - left + 1);
				right++;
			} else {
				while (s.charAt(left) != c) {
					set.remove(s.charAt(left));
					left++;
				}
				set.remove(c);
				left++;
			}
		}
		return max;
	}
}

/**
 * OptimziedSolution TC : O(N) SC : O(128) for all chars
 */
class OptimizedSolution extends Solution {

	public int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0, n = s.length();
		int max = 0;
		while (right < n) {
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}
			map.put(s.charAt(right), right);
			max = Math.max(max, right - left + 1);
			right++;
		}
		return max;
	}
}

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Solution solution = new Solution();
		int result = solution.lengthOfLongestSubstring(
				"abcabcbbasljkfadskksdjFNKJdfnkjdsfdksgvkdSGVNKDSGKDSAGVNKSDLGVKDSGVKDSVGKDSGKDSAFKSDAVKSDVGKSDAFgdhshdcgvgrbybtbththbhgvcecghgiergcbobgobobrubcgbbgspbgpabgibrei");
		long endTime = System.currentTimeMillis();
		System.out.println("Brute Force : " + result + " Time taken : " + (endTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		solution = new BetterSolution();
		result = solution.lengthOfLongestSubstring(
				"abcabcbbasljkfadskksdjFNKJdfnkjdsfdksgvkdSGVNKDSGKDSAGVNKSDLGVKDSGVKDSVGKDSGKDSAFKSDAVKSDVGKSDAFgdhshdcgvgrbybtbththbhgvcecghgiergcbobgobobrubcgbbgspbgpabgibrei");
		endTime = System.currentTimeMillis();
		System.out.println("Better Solution : " + result + " Time taken : " + (endTime - startTime) + "ms");

		startTime = System.currentTimeMillis();
		solution = new OptimizedSolution();
		result = solution.lengthOfLongestSubstring(
				"abcabcbbasljkfadskksdjFNKJdfnkjdsfdksgvkdSGVNKDSGKDSAGVNKSDLGVKDSGVKDSVGKDSGKDSAFKSDAVKSDVGKSDAFgdhshdcgvgrbybtbththbhgvcecghgiergcbobgobobrubcgbbgspbgpabgibrei");
		endTime = System.currentTimeMillis();
		System.out.println("Optimized Solution : " + result + " Time taken : " + (endTime - startTime) + "ms");
	}

}
