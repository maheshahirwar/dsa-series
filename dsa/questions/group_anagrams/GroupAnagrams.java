package dsa.questions.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Brute Force : TC - O(N^2 x M) : SC - O(N)
 */
class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		boolean[] visited = new boolean[strs.length];
		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (visited[i])
				continue;
			List<String> list = new ArrayList<>();
			list.add(strs[i]);
			visited[i] = true;
			for (int j = i + 1; j < strs.length; j++) {
				if (!visited[j]) {
					if (isAnagram(strs[i], strs[j])) {
						list.add(strs[j]);
						visited[j] = true;
					}

				}
			}
			ans.add(list);
		}
		return ans;
	}

	private boolean isAnagram(String str1, String str2) {
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];

		for (char ch : str1.toCharArray()) {
			freq1[ch - 'a']++;
		}

		for (char ch : str2.toCharArray()) {
			freq2[ch - 'a']++;
		}
		return Arrays.equals(freq1, freq2);
	}
}

/**
 * 
 * OptimizedSolution TC - O(N × M log M) : SC - O(N × M)
 */
class OptimizedSolution extends Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = sortKey(str);
			map.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
		}
		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		return ans;
	}

	private String sortKey(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars, 0, chars.length);
	}
}

/**
 * Optimized Solution : TC - O(N x M) : SC - O(N x M)
 */
class OptimizedSolution2 extends Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = sortKey(str);
			map.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
		}
		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		return ans;
	}

	private String sortKey(String str) {
		int[] freq = new int[26]; // counts for 'a' to 'z'

		// Step 1: Count frequency
		for (char ch : str.toCharArray())
			freq[ch - 'a']++;

		// Step 2: Rebuild sorted string
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < 26; i++)
			while (freq[i]-- > 0)
				sb.append((char) (i + 'a'));

		return sb.toString();
	}
}

public class GroupAnagrams {

	public static void main(String[] args) {

		Solution solution = new Solution();
		System.out.println("Brute Force : Group Anagrams = "
				+ solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

		solution = new OptimizedSolution();
		System.out.println("OptimizedSolution : Group Anagrams = "
				+ solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

		solution = new OptimizedSolution2();
		System.out.println("OptimizedSolution2 : Group Anagrams = "
				+ solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

}
