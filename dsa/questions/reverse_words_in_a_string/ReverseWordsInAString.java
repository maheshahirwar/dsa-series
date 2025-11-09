package dsa.questions.reverse_words_in_a_string;

/**
 * Brute Force : TC : O(N) SC : O(N*N)
 */
class Solution {

	public String reverseWords(String s) {
		String[] words = s.split("\\s+");
		/*
		 * Collections.reverse(Arrays.asList(words)); return String.join(" ", words);
		 */

		/* Using StringBuilder */
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			if (i > 0)
				sb.append(words[i]).append(" ");
			else
				sb.append(words[i]);
		}
		return sb.toString();
	}
}

/**
 * Optimized Solution TC : O(N) SC : O(N)
 */
class OptimizedSolution extends Solution {
	private static final char SPACE = ' ';

	public String reverseWords(String s) {

		char[] chars = s.toCharArray(), res = new char[chars.length];
		int right = chars.length - 1, resIndex = 0;

		while (right >= 0) {
			if (chars[right] == SPACE) {
				right--;
				continue;
			}
			// Find left index for current word
			int left = right;
			while (left >= 0 && chars[left] != SPACE)
				left--;

			// Add one space between words, only if resultIndex > 0 and left < right
			if (resIndex > 0 && left < right)
				res[resIndex++] = SPACE;

			// Store current word in result
			int k = left + 1;
			while (k <= right)
				res[resIndex++] = chars[k++];

			// Now move right to left index and again follow same process until right>0
			right = left;
		}
		return new String(res, 0, resIndex);
	}
}

public class ReverseWordsInAString {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Brute Force :" + solution.reverseWords("The sky is blue"));

		solution = new OptimizedSolution();
		System.out.println("Optimized Solution :" + solution.reverseWords("   hello  world   "));
	}

}
