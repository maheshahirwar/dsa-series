package dsa.questions.reverse_words_in_a_string;

/**
 * Brute Force : TC : O(N) SC : O(N*N)
 */
class Solution {

	public String reverseWords(String s) {
		String[] words = s.split("\\s+"); // leadning or trailing or multiple spaces in between
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
 * Optimized Solution TC : O(N) SC : O(N), extra space for 'res'
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

/**
 * OptimizedSolution2 TC : O(N) SC : O(1) in-place
 */
class OptimizedSolution2 extends Solution {

	private static final char SPACE = ' ';

	public String reverseWords(String s) {

		char[] chars = s.toCharArray();

		// Step 1 : Remove spaces leading or traling
		int len = 0, i = 0;
		while (i < chars.length) {

			while (i < chars.length && chars[i] == SPACE)
				i++;

			if (i < chars.length && len > 0)
				chars[len++] = SPACE;

			while (i < chars.length && chars[i] != SPACE)
				chars[len++] = chars[i++];
		}
		// Step 2 : Reverse chars array
		reverse(chars, 0, len - 1);

		// Step 3 : Reverse word i.e. reverse array by each space
		int start = 0, end = 0;
		while (end < len) {
			if (chars[end] == SPACE) {
				reverse(chars, start, end - 1);
				start = end + 1;
			}
			end++;
		}
		reverse(chars, start, end - 1);
		return new String(chars, 0, len);
	}

	private void reverse(char[] chars, int i, int j) {
		while (i <= j) {
			char ch = chars[i];
			chars[i++] = chars[j];
			chars[j--] = ch;
		}
	}
}

public class ReverseWordsInAString {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Brute Force :" + solution.reverseWords("The sky is blue"));

		solution = new OptimizedSolution();
		System.out.println("Optimized Solution :" + solution.reverseWords("   hello  world   "));

		solution = new OptimizedSolution2();
		System.out.println("Optimized Solution2 :" + solution.reverseWords(" hello    world    "));
	}

}
