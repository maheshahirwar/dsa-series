package dsa.questions.implement_strStr;

/**
 * Brute Force : TC - O(n*k) Implementation of indexOf method
 */
class Solution {
	public int strStr(String haystack, String needle) {
		int n = haystack.length(), k = needle.length();
		for (int i = 0; i <= n - k; i++) {
			if (equals(haystack, i, i + k, needle, 0, k))
				return i;
		}
		return -1;
	}

	private boolean equals(String source, int sourceStartIndex, int sourceEndIndex, String target, int targetStartIndex,
			int targetEndIndex) {
		while (sourceStartIndex < sourceEndIndex && targetStartIndex < targetEndIndex) {
			if (source.charAt(sourceStartIndex) != target.charAt(targetStartIndex))
				return false;
			sourceStartIndex++;
			targetStartIndex++;
		}
		return true;
	}
}

/**
 * Brute force : TC - O(n*k) Use contains and indexOf, But calls two times if
 * needle found
 */
class Solution2 extends Solution {
	public int strStr(String haystack, String needle) {
		if (haystack.contains(needle))
			return haystack.indexOf(needle);
		return -1;
	}
}

/**
 * Use indexOf TC - O(n*k)
 */
class Solution3 extends Solution {
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
}

public class ImplementStrStr {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Brute Force :  " + solution.strStr("sadbutsad", "sad"));
		solution = new Solution2();
		System.out.println("contains() + indexOf() :  " + solution.strStr("sadbutsad", "sad"));
		solution = new Solution3();
		System.out.println("indexOf() :  " + solution.strStr("sadbutsad", "sad"));
	}

}
