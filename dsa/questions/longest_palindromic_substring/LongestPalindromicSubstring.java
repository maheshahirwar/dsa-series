package dsa.questions.longest_palindromic_substring;

/**
 * Recursion Solution : TC : O(2^N) SC : O(N*N)
 */
class Solution {

	public String longestPalindrome(String s) {
		int[] ans = solve(s, 0, s.length() - 1);
		return s.substring(ans[0], ans[1] + 1);
	}

	private int[] solve(String str, int left, int right) {
		if (isPalindrome(str, left, right)) {
			return new int[] { left, right };
		}

		int[] leftPal = solve(str, left + 1, right);
		int[] rightPal = solve(str, left, right - 1);

		return (leftPal[1] - leftPal[0]) > (rightPal[1] - rightPal[0]) ? leftPal : rightPal;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i <= j)
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		return true;
	}
}

/**
 * Brute Force TC : O(N^3) SC : O(1)
 */
class BruteForceSolution extends Solution {

	public String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}

		int maxLen = 1;
		int firstIndex = 0, lastIndex = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + maxLen; j <= s.length(); j++) {
				if (j - i > maxLen && isPalindrome(s, i, j - 1)) {
					maxLen = j - i;
					firstIndex = i;
					lastIndex = j;
				}
			}
		}

		return s.substring(firstIndex, lastIndex);
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i <= j)
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		return true;
	}
}

/**
 * ExpandAroundCenter Solution TC : O(N^2) SC : O(1)
 */
class ExpandAroundCenterApproach extends Solution {

	public String longestPalindrome(String s) {

		int firstIndex = 0, lastIndex = 0, index = 0;
		while (index < s.length()) {
			int oddLenth = expandFromCenter(s, index, index); // for odd length
			int evenLength = expandFromCenter(s, index, index + 1); // for even length

			int maxLength = Math.max(oddLenth, evenLength);

			// Check whether this is longest substring or not
			if (maxLength > (lastIndex - firstIndex)) {
				firstIndex = index - (maxLength - 1) / 2;
				lastIndex = index + maxLength / 2;
			}
			index++;
		}
		return s.substring(firstIndex, lastIndex + 1);
	}

	private int expandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}

/**
 * Manacher's Algorithms TC : O(N) SC : O(N)
 */
class ManachersAlgorithmSolution extends Solution {

	public String longestPalindrome(String s) {

		if (s == null || s.length() == 0)
			return "";

		// Step 1: Preprocess the string
		StringBuilder t = transformString(s);

		// Step 2: Expand around each center and compute palindrome radius in linear
		// time
		int[] dp = expandAroundCenterAndComputePalindromeRadius(t);

		// Step 3: Extract the actual substring (remove #)
		return longestPalindromicSubstring(dp, s);
	}

	private StringBuilder transformString(String s) {

		// Add boundaries (#) to handle even-length palindromes uniformly
		StringBuilder t = new StringBuilder();
		t.append("#");
		for (char ch : s.toCharArray())
			t.append(ch).append("#");
		return t;
	}

	private int[] expandAroundCenterAndComputePalindromeRadius(StringBuilder t) {

		int n = t.length();

		// Step 2.1 : Array to store palindrome radius at each position
		int[] dp = new int[n];
		int left = 0, right = 0; // current left and right boundary

		// Step 2.2: Expand around each center
		for (int i = 0; i < n; i++) {

			int palRadius = 0;

			// Step 2.2a: Initialize dp[i] using mirror value (if within current boundary)
			if (i < right) {
				palRadius = Math.min(right - i, dp[left + (right - i)]);
			}

			// Step 2.2b: Try to expand around center i
			palRadius = expandAroundCenter(t, i, palRadius, n);

			// Step 2.3: Update left and right boundary if palindrome expands beyond R
			if (i + palRadius > right) {
				left = i - palRadius;
				right = i + palRadius;
				dp[i] = palRadius;
			}
		}
		return dp;
	}

	private int expandAroundCenter(StringBuilder t, int currentIndex, int palRadius, int n) {

		// Step 2.2c: Find left and right index for expansion
		int r = currentIndex + (palRadius + 1), l = currentIndex - (palRadius + 1);

		while (r < n && l >= 0 && t.charAt(l) == t.charAt(r)) {
			r++;
			l--;
			palRadius++;
		}
		return palRadius;
	}

	private String longestPalindromicSubstring(int[] dp, String s) {

		int maxLen = 0, startIndex = 0, endIndex = 0; // to track result

		for (int i = 0; i < dp.length; i++) {

			// Track max palindrome length and its center index
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				startIndex = (i - dp[i]) / 2;
				endIndex = (i + dp[i]) / 2;
			}
		}
		return s.substring(startIndex, endIndex);
	}
}

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Recursion Solution :" + solution.longestPalindrome("babad"));

		solution = new BruteForceSolution();
		System.out.println("Brute Force :" + solution.longestPalindrome("babad"));
		solution = new ExpandAroundCenterApproach();
		System.out.println("ExpandAroundCenter :" + solution.longestPalindrome("babad"));

		solution = new ManachersAlgorithmSolution();
		System.out.println("Manacher's Algorithm :" + solution.longestPalindrome("abbab"));
	}

}
