package dsa.questions.count_and_say;

/**
 * Brute Force : TC - O(2^n)
 */
class Solution {
	public String countAndSay(int n) {
		StringBuilder ans = new StringBuilder("1");
		for (int i = 2; i <= n; i++)
			ans = count_and_say(ans);
		return ans.toString();
	}

	private StringBuilder count_and_say(StringBuilder str) {
		char prev_char = str.charAt(0);
		int i = 1, count = 1;
		StringBuilder ans = new StringBuilder();
		while (i < str.length()) {
			char curr_char = str.charAt(i);
			if (prev_char != curr_char) {
				ans.append(count).append(prev_char);
				count = 1;
				prev_char = curr_char;
			} else {
				count++;
			}
			i++;
		}
		ans.append(count).append(prev_char);
		return ans;
	}
}

public class CountAndSay {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("Count & Say : " + solution.countAndSay(10));

	}

}
