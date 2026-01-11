package dsa.questions.reorganize_string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 767: Reorganize String Given a string s, rearrange the
 * characters of s so that any two adjacent characters are not the same. Return
 * any possible rearrangement of s or return "" if not possible. TC : O(n log k)
 * where n is the length of the string and k is the number of unique characters
 * SC : O(n) ~ O(26)
 */
class Solution {
	public String reorganizeString(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));

		for (char c : map.keySet())
			pq.offer(c);

		StringBuilder ans = new StringBuilder();

		while (pq.size() > 1) {
			char a = pq.poll();
			char b = pq.poll();

			ans.append(a).append(b);

			map.put(a, map.get(a) - 1);
			map.put(b, map.get(b) - 1);

			if (map.get(a) > 0)
				pq.offer(a);
			if (map.get(b) > 0)
				pq.offer(b);
		}

		if (!pq.isEmpty()) {
			if (map.get(pq.peek()) > 1)
				return "";
			ans.append(pq.peek());
		}
		return ans.toString();

	}
}

public class ReorganizeString {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "aab";
		String result = solution.reorganizeString(s);
		System.out.println("Reorganized string: " + result);
	}

}
